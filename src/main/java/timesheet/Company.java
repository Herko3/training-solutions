package timesheet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Company {

    private List<Employee> employees = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private List<TimeSheetItem> timeSheetItems = new ArrayList<>();

    public Company(InputStream employeesFile, InputStream projectsFile) {
        addEmployees(employeesFile);
        addProjects(projectsFile);
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        timeSheetItems.add(new TimeSheetItem(employee, project, beginDate, endDate));
    }

    public List<ReportLine> calculateProjectByNameYearMonth(String employeeName, int year, int month) {
        List<ReportLine> reportsWithoutStacking = new ArrayList<>();

        for (TimeSheetItem reviewed : timeSheetItems) {
            int reviewedYear = reviewed.getBeginDate().getYear();
            int reviewedMonth = reviewed.getBeginDate().getMonthValue();

            if (reviewed.getEmployee().getName().equals(employeeName) && reviewedYear == year && reviewedMonth == month) {
                ReportLine current = createReportLine(reviewed);
                reportsWithoutStacking.add(current);
            }
        }

        if (reportsWithoutStacking.isEmpty()) {
            throw new IllegalArgumentException("No employee with name: " + employeeName);
        }

        return stackReportsTime(reportsWithoutStacking);
    }

    public void printToFile(String employeeName, int year, int month, Path file) {
        List<ReportLine> reports = calculateProjectByNameYearMonth(employeeName, year, month);
        int sum = 0;
        for (ReportLine reviewed : reports) {
            sum += reviewed.getTime();
        }

        Iterator<ReportLine> iterator = reports.iterator();
        while (iterator.hasNext()) {
            ReportLine next = iterator.next();
            if (next.getTime() == 0) {
                iterator.remove();
            }
        }

        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            writer.write(employeeName + "\t" + YearMonth.of(year, month) + "\t" + sum + "\n");
            for (ReportLine reviewed : reports) {
                writer.write(reviewed.getProject().getName() + "\t" + reviewed.getTime() + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }


    private void addEmployees(InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                employees.add(new Employee(parts[0], parts[1]));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void addProjects(InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                projects.add(new Project(line));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private ReportLine createReportLine(TimeSheetItem timeSheetItem) {
        return new ReportLine(timeSheetItem.getProject(), timeSheetItem.hoursBetweenDates());
    }

    private List<ReportLine> stackReportsTime(List<ReportLine> reports) {
        List<ReportLine> stacked = new ArrayList<>();
        for (Project project : projects) {
            stacked.add(new ReportLine(project, 0));
        }

        for (ReportLine reportLine : reports) {
            stacked.get(stacked.indexOf(reportLine)).addTime(reportLine.getTime());
        }

        return stacked;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public List<Project> getProjects() {
        return new ArrayList<>(projects);
    }

}

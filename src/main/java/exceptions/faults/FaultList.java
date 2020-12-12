package exceptions.faults;

import java.util.ArrayList;
import java.util.List;

public class FaultList {

    private static final int[] DAY_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public List<String> processLines(List<String> input) {
        if (input == null) {
            throw new IllegalArgumentException("List cant be null");
        }
        List<String> result = new ArrayList<>();
        for (String row : input) {
            String[] line = row.split(",");
            ProcessingResult resultOfLine = processLine(line);
            if (!resultOfLine.equals(ProcessingResult.NO_ERROR)) {
                result.add(line[0] + "," + resultOfLine.getCode());
            }

        }
        return result;
    }

    private ProcessingResult processLine(String[] s) {
        try {
            Integer.parseInt(s[0]);
        } catch (NumberFormatException nfe) {
            return ProcessingResult.NO_ERROR;
        }
        if (s.length != 3) {
            return ProcessingResult.WORD_COUNT_ERROR;
        }
        if (!isValidDate(s[2]) && !canConvertToDouble(s[1])) {
            return ProcessingResult.VALUE_AND_DATE_ERROR;
        }
        if (!isValidDate(s[2])) {
            return ProcessingResult.DATE_ERROR;
        }
        if (!canConvertToDouble(s[1])) {
            return ProcessingResult.VALUE_ERROR;
        }
        return ProcessingResult.NO_ERROR;
    }

    private boolean isValidDate(String date) {
        String[] actual = date.split("\\.");
        int[] numbers = new int[actual.length];
        for (int i = 0; i < actual.length; i++) {
            try{
                numbers[i] = Integer.parseInt(actual[i]);
            } catch (NumberFormatException nfe){
                return false;
            }
        }
        if (numbers[0] <= 0 || numbers[1] <= 0 || numbers[1] > 12 || numbers[2] < 0 || numbers[2] > DAY_OF_MONTH[numbers[1]-1]) {
            return false;
        }
        return true;
    }

    private boolean canConvertToDouble(String number) {
        try {
            Double.parseDouble(number);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

package stringscanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringScanner {

    public int readAndSumValues(String intString, String delimiter) {

        int sum = 0;
        if (!isEmpty(delimiter)) {
            Scanner scanner = new Scanner(intString).useDelimiter(delimiter);
            try {
                while (scanner.hasNext()) {
                    sum += scanner.nextInt();
                }
            } catch (InputMismatchException ex) {
                throw new IllegalArgumentException("Incorrect parameter string!", ex);
            }
            return sum;
        }

        Scanner scanner = new Scanner(intString);
        try {
            while (scanner.hasNext()) {
                sum += scanner.nextInt();
            }

        } catch (InputMismatchException ex) {
            throw new IllegalArgumentException("Incorrect parameter string!", ex);
        }
        return sum;
    }


    public int readAndSumValues(String intString) {
        return readAndSumValues(intString, null);
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        if (isEmpty(text) || word == null || "".equals(word)) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        Scanner scanner = new Scanner(text);
        StringBuilder build = new StringBuilder();
        while (scanner.hasNext()) {
            String help = scanner.nextLine();
            if (help.contains(word)) {
                build.append(help);
                build.append("\n");
            }
        }
        return build.toString().trim();
    }

    public boolean isEmpty(String option) {
        if (option == null || "".equals(option.trim())) {
            return true;
        }
        return false;
    }
}

package week16.d01;

import java.io.BufferedReader;
import java.io.IOException;

public class VowelFilter {

    private static final String VOWELS = "aAáÁeEéÉiIíÍoOóÓöÖőŐuUúÚüÜűŰ";

    public static String filterVowels(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            for (char c: line.toCharArray()) {
                if (!VOWELS.contains(String.valueOf(c))) {
                    sb.append(c);
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

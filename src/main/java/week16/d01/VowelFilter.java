package week16.d01;

import java.io.BufferedReader;
import java.io.IOException;

public class VowelFilter {

    private static final String VOWELS = "aAáÁeEéÉiIíÍoOóÓöÖőŐuUúÚüÜűŰ";

    public static String filterVowels(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                String s = line.substring(i, i + 1);
                if (!VOWELS.contains(s)) {
                    sb.append(s);
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

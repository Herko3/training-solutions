package iostringwriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {

    public void writeTo(Writer writer, List<String> strings) {
        PrintWriter printWriter = new PrintWriter(writer);
        for(String s: strings){
            printWriter.print(s);
            printWriter.print(" ");
            printWriter.println(s.length());
        }
    }

    public String writeWithStringWriter(List<String> words) {

        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException("The List cannot be empty");
        }

        StringWriter sw = new StringWriter();
        try (sw) {
            writeTo(sw,words);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write", ioe);
        }
        return sw.toString();
    }
}

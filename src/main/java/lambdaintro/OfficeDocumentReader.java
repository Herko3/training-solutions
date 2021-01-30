package lambdaintro;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OfficeDocumentReader {

    private static final String REGEX = ".*\\.(docx|xlsx|pptx)$";

    public List<File> listOfficeDocuments(File path) {
        List<File> files = Arrays.asList(path.listFiles(file -> file.isFile() && file.getName().toLowerCase().matches(REGEX)));
        files.sort(Comparator.comparing(File::getName));
        return files;
    }
}

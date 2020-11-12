package stringmethods.filename;

public class FileNameManipulator {

    public char findLastCharacter(String s) {
        if (isEmpty(s)) {
            throw new IllegalArgumentException("Empty string!");
        }
        String s2 = s.trim();
        return s2.charAt(s2.length() - 1);
    }

    public String findFileExtension(String fileName){
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        if(fileName.startsWith(".")){
            throw new IllegalArgumentException("Invalid file name!");
        }
    return fileName.substring(fileName.indexOf('.'));
    }

    public boolean identifyFilesByExtension(String ext, String fileName){
        if (isEmpty(ext) || isEmpty(fileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        if(fileName.startsWith(".")){
            throw new IllegalArgumentException("Invalid argument!");
        }
        return fileName.contains(ext);
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName){
        if (isEmpty(searchedFileName) || isEmpty(actualFileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
    return searchedFileName.equalsIgnoreCase(actualFileName);
    }

    public String changeExtensionToLowerCase(String fileName){
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }
        if(fileName.startsWith(".")){
            throw new IllegalArgumentException("Invalid argument!");
        }
        String prefix= fileName.substring(0,fileName.indexOf('.')+1);
        String extension = fileName.substring(fileName.indexOf('.')+1);
    return prefix.concat(extension.toLowerCase());
    }

    public String replaceStringPart(String fileName, String present, String target){
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }
        return fileName.replace(present,target);
    }

    public boolean isEmpty(String option){
        if(option == null || option.trim().equals("")){
            return true;
        }
        return false;
    }

}

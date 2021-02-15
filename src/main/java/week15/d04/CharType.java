package week15.d04;

public enum CharType {
    VOWEL("aáeéiíoóöőuúüű"),CONSONANT("qwrtzpsdfghjklyxcvbnm"),OTHER("");

    private String chars;

    CharType(String chars) {
        this.chars = chars;
    }

    public static CharType getType(int c){
        if(CharType.VOWEL.chars.contains(String.valueOf((char) c))){
            return CharType.VOWEL;
        }
        if(CharType.CONSONANT.chars.contains(String.valueOf((char) c))){
            return CharType.CONSONANT;
        }
        return CharType.OTHER;
    }
}

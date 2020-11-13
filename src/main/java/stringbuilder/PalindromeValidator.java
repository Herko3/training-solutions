package stringbuilder;

public class PalindromeValidator {

    public boolean isPalindrome(String test){
        if(test == null){
            throw new IllegalArgumentException("Text must not be null!");
        }
        StringBuilder palindrome = new StringBuilder(test.trim());
        StringBuilder reverse = new StringBuilder(test.trim());
        reverse.reverse();

        if(palindrome.toString().equalsIgnoreCase(reverse.toString())){
            return true;
        }
        return false;
    }
}

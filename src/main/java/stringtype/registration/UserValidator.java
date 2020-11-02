package stringtype.registration;

public class UserValidator {

    private String username;
    private String password1;
    private String password2;
    private String email;

    public UserValidator(String username, String password1, String password2, String email) {
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
        this.email = email;
    }

    public boolean isValidUsername(String username){
        return username.length()>0;
    }
    public boolean isValidPassword(String password1, String password2){
        return password1.length()>=8 && password1.equals(password2);
    }

    public boolean isValidEmail(String email){
        return email.contains("@") && email.contains(".") && email.indexOf("@")>0 && email.indexOf("@")<email.indexOf(".");
    }

}

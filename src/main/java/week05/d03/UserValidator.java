package week05.d03;

public class UserValidator {

    public void validate(User user){
        if(user == null){
            throw new RuntimeException("No user to validate");
        }
        if(isEmpty(user.getName())){
            throw new RuntimeException("User name must not be empty or null!");
        }
        if(user.getAge()<0 || user.getAge()>120){
            throw new RuntimeException("User age most be valid and under 120");
        }
        System.out.println("The user is valid");
    }

    private boolean isEmpty(String s){
        if(s == null || s.trim().equals("")){
            return true;
        }
        return false;
    }

}

package week05d03;

public class UserValidator {

    public void validate(User user){
        if(isEmpty(user.getName())){
            throw new RuntimeException("User name must not be empty or null!");
        }
        if(user.getAge()<0 || user.getAge()>120){
            throw new RuntimeException("User age most be valid and under 120");
        }
    }

    private boolean isEmpty(String s){
        if(s == null || s.trim().equals("")){
            return true;
        }
        return false;
    }

}

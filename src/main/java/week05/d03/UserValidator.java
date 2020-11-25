package week05.d03;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    private List<User> users = new ArrayList<>();

    public void validate(List<User> users){
        if(users == null){
            throw new RuntimeException("No user to validate");
        }
        for(User user : users) {
            if (isEmpty(user.getName())) {
                throw new RuntimeException("User name must not be empty or null!" + user);
            }
            if (user.getAge() < 0 || user.getAge() > 120) {
                throw new RuntimeException("User age most be valid and under 120" + user);
            }
        }
        System.out.println("The users are valid");
    }

    private boolean isEmpty(String s){
        if(s == null || s.trim().equals("")){
            return true;
        }
        return false;
    }

}

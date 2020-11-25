package week05.d03;

import java.util.List;

public class UserValidatorByAdam {

    public void validate(List<User> users){
        if(users == null){
            throw new IllegalArgumentException("Users is null");
        }
        for(User user : users){
            if (user == null){
                throw new IllegalArgumentException("User is null");
            }
            if (user.getName() == null || user.getName().isBlank()){
                throw new IllegalArgumentException("The User's name can't be black or null");
            }
            if(user.getAge()<0 || user.getAge()>120){
                throw new IllegalArgumentException("The User's age must be between 0 and 120");
            }
        }
    }
}

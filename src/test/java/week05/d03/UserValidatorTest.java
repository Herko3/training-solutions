package week05.d03;

import org.junit.jupiter.api.Test;

public class UserValidatorTest {

    @Test
    public void testValidate(){
        UserValidator test = new UserValidator();
        test.getUsers().add(new User ("Peti",-15));
        test.getUsers().add(new User ("",15));

    }

}

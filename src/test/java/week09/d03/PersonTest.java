package week09.d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void testOverFourteen(){
        Person p = new Person("Scott" , 15);
        p.setPresent();

        assertNotEquals(null,p.getPresent());
        assertNotEquals(Present.TOY,p.getPresent());
    }

}
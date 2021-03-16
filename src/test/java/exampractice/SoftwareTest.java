package exampractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoftwareTest {

    @Test
    void testDeveloper(){
        Software developer = new DeveloperSoftware("test",100);
        developer.increasePrice();

        assertEquals(110,developer.getPrice());
    }

    @Test
    void testOffice(){
        Software software = new OfficeSoftware("test",100);
        software.increasePrice();

        assertEquals(105,software.getPrice());
    }

}
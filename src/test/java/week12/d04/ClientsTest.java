package week12.d04;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientsTest {



    @Test
    void findByRegNumber() {
        Clients clients = new Clients();
        clients.addClient("Jack Doe","001");
        clients.addClient("John Doe","002");
        clients.addClient("Jane Doe","003");
        clients.addClient("Jane Scott","004");

        assertEquals(clients.findByRegNumber("002"),(new Client("John Doe","002")));
    }

    @Test
    void findByName() {
        Clients clients = new Clients();
        clients.addClient("Jack Doe","001");
        clients.addClient("John Doe","002");
        clients.addClient("Jane Doe","003");
        clients.addClient("Jane Scott","004");

        List<Client> result = clients.findByName("Doe");


        assertEquals(3,result.size());
        assertEquals("Jack Doe",clients.findByName("Doe").get(0).getName());
        assertEquals("Jane Doe",clients.findByName("Doe").get(2).getName());
    }

}
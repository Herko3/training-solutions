package week15.d02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    TaskManager manager;

    @BeforeEach
    public void init(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(TaskManager.class.getResourceAsStream("orders.txt")));
        manager = new TaskManager();
        manager.readFile(reader);
    }

    @Test
    public void testReadFile(){
        assertFalse(manager.getOrders().isEmpty());
    }

    @Test
    public void testOrdersByCouriers(){
        Map<String, Long> result = manager.ordersByCourier();
        assertEquals(7,result.get("FUT_1"));
    }

    @Test
    public void testAddressWithMostOrders(){
        assertEquals("1114 Kossuth 9",manager.getAddressWithMostOrders());
    }

}
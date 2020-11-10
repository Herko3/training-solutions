package introjunit;

//import org.junit.Test;
import org.junit.jupiter.api.Test;

//import static org.hamcrest.core.IsEqual.equalTo;
//import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GentlemanTest {

//    @Test
//    public void testMethod(){
//        assertThat(new Gentleman().sayHello("John Doe"),equalTo("Hello John Doe"));
//    }
//
//    @Test
//    public void testAnonymus(){
//        assertThat(new Gentleman().sayHello(null),equalTo("Hello Anonymus"));
//    }

   @Test
   public void testnew(){
       assertEquals("Hello John Doe",new Gentleman().sayHello("John Doe"));
   }


}

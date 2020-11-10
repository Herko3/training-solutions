package introjunit;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class GentlemanTest {

    @Test
    public void testMethod(){
        assertThat(new Gentleman().sayHello("John Doe"),equalTo("Hello John Doe"));
    }

    @Test
    public void testAnonymus(){
        assertThat(new Gentleman().sayHello(null),equalTo("Hello Anonymus"));
    }
}

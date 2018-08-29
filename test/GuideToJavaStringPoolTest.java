import org.junit.Test;

import static org.junit.Assert.*;

public class GuideToJavaStringPoolTest {
    @Test
    public void InterningTest() {
        String constantString1 = "Jaewon";
        String constantString2 = "Jaewon";

        assertSame(constantString1, constantString2);
    }

    @Test
    public void ConstructorTest() {
        String constantString = "Jaewon";
        String newString = new String("Jaewon");

        assertNotSame(constantString, newString);
    }

    @Test
    public void ManualInterningTest() {
        String constantString = "Jaewon";
        String newString = new String("Jaewon");

        assertNotSame(constantString, newString);

        String internedString = newString.intern();

        assertSame(constantString, internedString);
    }
}
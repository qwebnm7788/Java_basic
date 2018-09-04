import static org.junit.Assert.*;
import org.junit.Test;

public class ParameterPassingMechanismTest {
    @Test
    public void whenModifyingPrimitives_thenOriginalValuesNotModified() {
        int x = 1;
        int y = 2;

        assertEquals(x, 1);
        assertEquals(y, 2);


        modify(x, y);

        assertEquals(x, 1);
        assertEquals(y, 2);
    }

    @Test
    public void whenModifyingObjects_thenOriginalObjectChanged() {
        Foo a = new Foo(1);
        Foo b = new Foo(1);

        assertEquals(a.num, 1);
        assertEquals(b.num, 1);

        modifyObject(a, b);

        assertEquals(a.num, 2);
        assertEquals(b.num, 1);
    }

    public static void modify(int x1, int y1) {
        x1 = 5;
        y1 = 10;
    }

    public static void modifyObject(Foo a1, Foo b1) {
        a1.num++;

        b1 = new Foo(1);
        b1.num++;
    }
}

class Foo {
    public int num;

    public Foo(int num) {
        this.num = num;
    }
}
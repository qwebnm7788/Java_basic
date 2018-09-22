import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class JavaInitializationTest {
    @Test
    public void whenCopiedWithClone_thenExactMatchIsCreated() throws CloneNotSupportedException {
        InitUser user = new InitUser("Jaewon", 25);
        InitUser clonedUser = (InitUser) user.clone();

        assert(user.equals(clonedUser));
    }


    class InitUser implements Cloneable{
        private String name;
        private int age;

        public InitUser(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}

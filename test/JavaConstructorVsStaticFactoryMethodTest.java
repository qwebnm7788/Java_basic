import org.junit.Test;

import java.time.LocalTime;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static org.junit.Assert.*;

public class JavaConstructorVsStaticFactoryMethodTest {
    @Test
    public void createUserWithStaticFactoryTest() {
        User user = User.createWithDefaultCountry("Jaewon", "qwebnm");
        assertNotNull(user);
    }

    @Test
    public void createUserWithLoggedInstantiationTime() {
        User user = User.createWithLoggedInstantiationTime("Jaewon", "qwebnm", "Korea");
        assertNotNull(user);
    }
}

class User {
    private static final Logger LOGGER = Logger.getLogger(User.class.getName());
    private static volatile User instance = null;
    private final String name;
    private final String email;
    private final String country;

    public User(String name, String email, String country) {
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public static User createWithDefaultCountry(String name, String email) {
        return new User(name, email, "Korea");
    }

    public static User createWithLoggedInstantiationTime(String name, String email, String country) {
        setLoggerProperties();
        LOGGER.log(Level.INFO, "Creating User Instance at : {0}", LocalTime.now());
        return new User(name, email, country);
    }

    public static User getSingletonInstance(String name, String email, String country) {
        if(instance == null) {
            synchronized (User.class) {
                if(instance == null) {
                    instance = new User(name, email, country);
                }
            }
        }

        return instance;
    }
    private static void setLoggerProperties() {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
        handler.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(handler);
    }
}

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class SerializationTest {
    @Test
    public void whenSerializingAndDeserializing_ThenObjectIsTheSame() throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setAge(20);
        person.setName("Jaewon");

        FileOutputStream fileOutputStream = new FileOutputStream("yourfile.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("yourfile.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Person p2 = (Person) objectInputStream.readObject();
        objectInputStream.close();

        assertTrue(p2.getAge() == person.getAge());
        assertTrue(p2.getName().equals(person.getName()));
        System.out.println(p2.getCountry());

    }

    @Test
    public void whenCustomSerializingAndDeserializing_ThenObjectIsTheSame() throws IOException, ClassNotFoundException {
        Person p = new Person();
        p.setAge(20);
        p.setName("jaewon");

        Address a = new Address();
        a.setHouseNumber(1);

        Employee e = new Employee();
        e.setPerson(p);
        e.setAddress(a);

        FileOutputStream fileOutputStream = new FileOutputStream("yourfile2.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(e);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("yourfile2.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Employee e2 = (Employee) objectInputStream.readObject();
        objectInputStream.close();

        assertTrue(e2.getPerson().getAge() == e.getPerson().getAge());
        assertTrue(e2.getAddress().getHouseNumber() == e.getAddress().getHouseNumber());
    }
}

class Person implements Serializable {
    static String country = "KOREA";
    private int age;
    private String name;
    transient int height;

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        Person.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient Address address;
    private Person person;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        System.out.println("writeObject custom called");
        oos.defaultWriteObject();
        oos.writeObject(address.getHouseNumber());          //address는 serializable하지 않지만 직접 그 중 일부를 이용해 추가하였다.
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        System.out.println("readObject custom called");
        ois.defaultReadObject();
        Integer houseNumber = (Integer) ois.readObject();
        Address a = new Address();
        a.setHouseNumber(houseNumber);
        this.setAddress(a);
    }
}

class Address {
    private int houseNumber;

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
}
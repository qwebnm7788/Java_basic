import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class TheBasicsOfJavaGenerics {
    public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a).map(mapperFunction).collect(Collectors.toList());
    }

    @Test
    public void givenArrayOfIntegers_thanListOfStringReturnedOK() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        List<String> stringList = fromArrayToList(intArray, Object::toString);
        String[] stringArray = {"1", "2", "3", "4", "5"};
        assertEquals(Arrays.asList(stringArray), stringList);
    }
}



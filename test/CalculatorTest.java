import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void exceptionalBehaviorLowerLimit() {
        Calculator.factorial(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionalBehaviorUpperLimit() {
        Calculator.factorial(100001);
    }

    @Test
    public void boundariesUpperLimit() {
        try {
            assertEquals(new String(Files.readAllBytes(Paths.get("src/factorial100000.txt"))), Calculator.factorial(100000));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void zero() {
        assertEquals("1", Calculator.factorial(0));
    }

    @Test
    public void one() {
        assertEquals("1", Calculator.factorial(1));
    }

    @Test
    public void many() {
        assertEquals("5040", Calculator.factorial(7));

        try {
            assertEquals(new String(Files.readAllBytes(Paths.get("src/factorial50000.txt"))), Calculator.factorial(50000));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import org.junit.*;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

class Multiplicator {
    int multiply(int $1, int $2) {
        return $1 * $2;
    }

    int divide(int $1, int $2) {
        return $1 / $2;
    }
}

public class Testing {
    private Multiplicator tester;

    @Rule
    public ExpectedException exception = ExpectedException.none();//must be public

    @Before
    public void setUp() {
        System.out.println("Starting testing!");
        tester = new Multiplicator();
    }

    @Test
    public void test() {
        Assume.assumeFalse(System.getProperty("os.name").contains("Linux"));
    }

    @Test
    public void tes2() {
        assertTrue(System.getProperty("os.name").contains("Linux"));
    }

    @Test
    public void testMultiply() {
        assertEquals("Result", 3, tester.multiply(1, 3));
    }

    @Test
    public void testDivide() {
        exception.expect(ArithmeticException.class);
        tester.divide(8, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivide2(){
        tester.divide(8, 0);
    }

    @After
    public void tearDown() {
        System.out.println("Done testing!");
    }
}
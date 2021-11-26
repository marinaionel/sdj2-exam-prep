import java.math.BigInteger;

public class Calculator {
    public static String factorial(int n) {
        if (n > 100000) {
            throw new IllegalArgumentException("too large number");
        }
        if (n < 0) {
            throw new IllegalArgumentException("negative number");
        }
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(new BigInteger(i + ""));
        }
        return fact.toString();
    }
}

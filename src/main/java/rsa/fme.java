package rsa;

import java.math.BigInteger;

public class fme {
    public static BigInteger getRemainder(BigInteger a, BigInteger b, BigInteger c)
    {
        if(a.equals(BigInteger.ZERO))
            return BigInteger.ZERO;
        if(b.equals(BigInteger.ZERO))
            return BigInteger.ONE;

        BigInteger y;
        if(b.mod(BigInteger.TWO).equals(BigInteger.ZERO))
        {
            y = getRemainder(a, b.divide(BigInteger.TWO), c);
            y = y.multiply(y).mod(c);
        }
        else
        {
            y = a.mod(c);
            y = ((getRemainder(a, b.subtract(BigInteger.ONE), c).mod(c).multiply(y)).mod(c));
        }
        return y.add(c).mod(c);
    }
}

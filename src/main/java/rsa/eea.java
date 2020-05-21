package rsa;

import java.math.BigInteger;

public class eea {
    static int lrow = 1;
    static BigInteger lx = BigInteger.valueOf(0);
    static BigInteger gcd;

    public static void implement_EEA(int a, BigInteger b)
    {
        BigInteger x1 = BigInteger.valueOf(1);
        BigInteger x2 = BigInteger.valueOf(0);
        BigInteger big_a = BigInteger.valueOf(a);
        BigInteger temp;
        int row = 1;

        while(!big_a.mod(b).equals(BigInteger.valueOf(0)))
        {
            temp = x2;
            x2 = x2.multiply(big_a.divide(b)).add(x1);
            x1 = temp;

            temp = b;
            b = big_a.mod(b);
            big_a = temp;

            row++;
        }
        lrow = row;
        lx = x2;
        gcd = b;
    }

    public static BigInteger getGCD()
    {
        return gcd;
    }

    public static int last_row()
    {
        return lrow;
    }

    public  static BigInteger last_X()
    {
        return lx;
    }
}

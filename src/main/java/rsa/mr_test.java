package rsa;

import java.math.BigInteger;

public class mr_test {
    public static boolean isprime(BigInteger n)
    {
        BigInteger num = n.subtract(BigInteger.ONE);
        int count = 0;
        while(num.mod(BigInteger.TWO).equals(BigInteger.ZERO))
        {
            num = num.divide(BigInteger.TWO);
            count++;
        }
        int S = count;
        int d = num.intValue();

        int basis1 = 2, basis2 = 3, basis3 = 4;

        if(!fme.getRemainder(BigInteger.valueOf(basis1), BigInteger.valueOf(d), n).equals(BigInteger.ONE))
        {
            int it;
            for (it = 0; it < count; it++)
            {
                if(fme.getRemainder(BigInteger.valueOf(basis1), BigInteger.valueOf(d), n).add(BigInteger.ONE).mod(n).equals(BigInteger.ZERO))
                    return true;
            }
        }
        else
        {
            return true;
        }
        return false;
    }
}

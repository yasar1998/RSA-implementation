package rsa;

import java.math.BigInteger;
import java.util.Random;

public class key_generation {
    static BigInteger p, q;

    public static void RandomPrimes()
    {
        Random r =  new Random();
        p = BigInteger.valueOf(r.nextInt(1000)+5);
        q = BigInteger.valueOf(r.nextInt(1000)+5);

        while(!(mr_test.isprime(p) && mr_test.isprime(q)))
        {
            if(!mr_test.isprime(p))
                p = BigInteger.valueOf(r.nextInt(1000)+5);
            if(!mr_test.isprime(q))
                q = BigInteger.valueOf(r.nextInt(1000)+5);
        }
        System.out.println("Randomly generated prime numbers:\np: " + p + "\n" + "q: " + q);
    }

    public static BigInteger getFi()
    {
        return p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    }

    public static int getE()
    {
        BigInteger fi = getFi();
        int e=3;
        for(int i=3;i<fi.intValue();i++)
        {
            eea.implement_EEA(i, fi);
            if(eea.getGCD().equals(BigInteger.valueOf(1)))
            {
                e = i;
                break;
            }
        }
        return e;
    }

    public static BigInteger getN()
    {
        return p.multiply(q);
    }

    public static BigInteger getD()
    {
        BigInteger fi = getFi();
        eea.implement_EEA(getE(), fi);

        BigInteger d;

        if(eea.last_row()%2 == 0)
        {
            d = eea.last_X();
        }
        else {
            d = BigInteger.valueOf(-1).multiply(eea.last_X());
            d = d.add(fi);
        }
        return d;
    }
}

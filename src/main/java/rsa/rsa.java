package rsa;

import java.math.BigInteger;
import java.util.Scanner;

public class rsa {
    public static void main(String[] args) {
        key_generation.RandomPrimes();
        int e = key_generation.getE();
        BigInteger n = key_generation.getN();
        BigInteger d = key_generation.getD();
        BigInteger fi = key_generation.getFi();
        System.out.println("Public keys: (n, e): " + "(" + n + "," + e + ")");
        System.out.println("Secret key: d: " + d + "    Verified: (e*d)mod(fi)=" + BigInteger.valueOf(e).multiply(d).mod(fi));

        System.out.println();
        System.out.println("Menu:\n1.Encyription\n2.Decription");

        int inp;
        Scanner s = new Scanner(System.in);
        System.out.print("User input: ");
        inp = s.nextInt();
        BigInteger m, c;
        switch (inp)
        {
            case 1:
                System.out.print("m = ");
                m = s.nextBigInteger();
                while(m.compareTo(n)>=0) {
                    System.out.print("The message should be less than n. New m: ");
                    m = s.nextBigInteger();
                }
                c = fme.getRemainder(m, BigInteger.valueOf(e), n);
                System.out.println("Formula:(m^e)mod(n) => c: " + c);
                System.out.println("Verified with the Formula:(c^d)mod(n) => m: " + fme.getRemainder(c, d, n));
                break;
            case 2:
                System.out.print("c = ");
                c = s.nextBigInteger();
                while(c.compareTo(n)>=0) {
                    System.out.print("The secret message should be less than n. New c: ");
                    c = s.nextBigInteger();
                }
                m = fme.getRemainder(c, d, n);
                System.out.println("Formula:(c^d)mod(n) => m: " + m);
                System.out.println("Verified with the Formula:(m^e)mod(n) => c: " + fme.getRemainder(m, BigInteger.valueOf(e), n));
                break;
        }

    }
}

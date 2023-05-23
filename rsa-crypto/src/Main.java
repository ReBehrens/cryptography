
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    static int bitLength = 1024;
    static SecureRandom random = new SecureRandom();

    private static BigInteger generateRandomNumber() {
        int errors = 0;
        int run = 0;
        BigInteger randomNumber = new BigInteger(bitLength, random);

        while (true) {
            if (!randomNumber.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {    // if the random number is odd
                if (primTest(randomNumber) == true) {                                   // if the random number passed the Primetest for 19 times
                    break;
                } else {
                    run++;
                }
            }

                errors++;                                                       // how many times must generate a new number in this run
                randomNumber = new BigInteger(bitLength, random);
            

        }
        System.out.print("GrPn errors: " + errors);
        System.out.println(" PrT run: " + run);
        return randomNumber;
    }


    private static Boolean primTest(BigInteger p) {             // this Primetest ist a "Miller Robin" test
        int k = 20;                                             // how many test runs with random numbers

        if (p.compareTo(BigInteger.ONE) == 0) {                 
            return false;
        }
        if (p.compareTo(BigInteger.TWO) == 0) {
            return true;
        }
        if (p.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0) {
            return false;
        }

        BigInteger d = p.subtract(BigInteger.ONE);
        int r = 0;

        while (d.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0) {
            r++;
            d = d.divide(BigInteger.TWO);
        }

        Random rand = new Random();

        for (int i = 0; i < k; i++) {
            BigInteger a = new BigInteger(p.bitLength(), rand);
            
            if (a.compareTo(BigInteger.ONE) < 0 || a.compareTo(p.subtract(BigInteger.ONE)) > 0) {
                continue;
            }

            BigInteger x = a.modPow(d, p);
            if (x.compareTo(BigInteger.ONE) == 0 || x.compareTo(p.subtract(BigInteger.ONE)) == 0) {
                continue;
            }

            for (int j = 0; j < r - 1; j++) {
                x = x.modPow(BigInteger.TWO, p);
                if (x.compareTo(p.subtract(BigInteger.ONE)) == 0) {
                    break;
                }
            }

            if (x.compareTo(p.subtract(BigInteger.ONE)) != 0) {
                return false;
            }
        }
        return true;
    }


    private static BigInteger generate_e(BigInteger phiM) {  // generate a Random number e (1 < e < PhiM || ggT(PhiM, e) = 1)
        BigInteger e = new BigInteger(bitLength, new SecureRandom()).mod(phiM.subtract(BigInteger.TWO)).add(BigInteger.TWO);
        int errors = 0;
        //System.out.println("phiM:" + phiM);
        //System.out.println("e:" + e);
        
        while (true) {
            if (phiM.compareTo(e) == 1) {
                if (phiM.gcd(e).equals(BigInteger.ONE)) {
                    break;
                } 
            }
            errors++;
            e = new BigInteger(bitLength, new SecureRandom()).mod(phiM.subtract(BigInteger.TWO)).add(BigInteger.TWO);        
        }
        System.out.println("GenE errors: " + errors);
        return e;
    }

    private static void keygen() {
        /*
         * 1. M(p*q)
         * 2. Phi(m)
         * 3. random e
         * 4. ggT  (Euclidean algorithm)
         * 5. Bézout Coefficients
         */
        
        long start = System.nanoTime();
        //BigInteger p = new BigInteger("701");   // test prime numer
        BigInteger p = generateRandomNumber();
        //BigInteger q = new BigInteger("227");   // test prime number
        BigInteger q = generateRandomNumber();

        while (true) {
            if (p.compareTo(q) != 0) {
                break;
            }
            p = generateRandomNumber();
            q = generateRandomNumber();
        }   
        
        BigInteger m = p.multiply(q);
        BigInteger phiM = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        //BigInteger e = new BigInteger("193");    // test number
        BigInteger e = generate_e(phiM);
       
        // publickey (e,M) privatkey (t,M)
        String publicKey = e.toString(10) + ", " + m.toString(10);
        String privateKey = bezoutKo(phiM, e).toString(10) + ", " + m.toString(10);

        System.out.println("publicKey:");
        System.out.println(publicKey);
        System.out.println("");
        System.out.println("PrivateKey:");
        System.out.println(privateKey);
        System.out.println("");
        System.out.println("");
        long finished = System.nanoTime();
        System.out.println("finished in " + ((finished - start) /1000000) + "ms");
    }


    private static BigInteger bezoutKo(BigInteger oldPhiM, BigInteger olde) {
        //ggt(PhiM, e) = PhiM * s + e * t = 1
        // PhiM = q * e + r
        BigInteger phiM = oldPhiM;
        BigInteger e = olde;
        BigInteger s = BigInteger.ZERO;
        BigInteger t = BigInteger.ONE;
        BigInteger r = BigInteger.ONE;
        BigInteger q = BigInteger.ONE;
        BigInteger tempt = BigInteger.ONE;
        int index = 0;
        ArrayList<BigInteger> listq = new ArrayList<>();
        
        while (!r.equals(BigInteger.ZERO)) {                    // (Euclidean algorithm)
            r = phiM.mod(e);
            q = phiM.subtract(r).divide(e);
            // System.out.println("");
            // System.out.println("Index: " + index);
            // System.out.println(phiM + " = " + q + " * " + e + " + " + r);
            phiM = e;
            e = r;
            listq.add(q);
            
            if (!r.equals(BigInteger.ZERO)){
            index++;
            }

        }
        
        System.out.println("BzKo: " + ((index * 2) -1));

        while ((index) > 0) {                                   // Bézout Coefficients
            index--;
            BigInteger tempq = listq.get(index);
            tempt = s.subtract(tempq.multiply(t));

            // System.out.println("");
            // System.out.println("Index: " + index);
            // System.out.println(s +  " - " + tempq + " * " + t);

            s = t;
            t = tempt;

            //System.out.println("s: " + s + "    t: " + t);
        }

        if (t.compareTo(BigInteger.ZERO) < 0) {
            while (t.compareTo(BigInteger.ZERO) < 0) {
            t = t.add(oldPhiM);
            s = s.subtract(olde);
            }
    
        }

        // System.out.println("");
        // System.out.println("PhiM: " + oldPhiM);
        // System.out.println("");
        // System.out.println("e:" + olde);
        // System.out.println("");
        // System.out.println("ggT: " + oldPhiM.gcd(olde));
        // System.out.println("");
        // System.out.println("s = " + s);
        // System.out.println("");
        // System.out.println("t = " + t);
        // System.out.println("");
        // System.out.println(oldPhiM + " * " + s + " + " + olde + " * " + t);
        BigInteger result = oldPhiM.multiply(s).add(olde.multiply(t));
        System.out.println("= " + result);

        
        return t;
    }








    public static void main(String[] args) {
        keygen();

    }

}

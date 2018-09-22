import java.math.BigInteger;

public class RSA {

    BigInteger p;
    BigInteger q;
    BigInteger n;
    BigInteger d;
    BigInteger phiN;
    BigInteger e;
    RSA(){
      // unencrypted = new BigInteger(st.getBytes());
      // p = BigInteger.valueOf(firstPrime);
      // q = BigInteger.valueOf(secondPrime);
      // n = p.multiply(q);
      // e = expo;
      //
      // encrypted = unencrypted.pow(e).mod(n);

    }
    public void generateKeys(int firstPrime, int secondPrime, int expo){
      p = BigInteger.valueOf(firstPrime);
      q = BigInteger.valueOf(secondPrime);
      n = p.multiply(q);
      e = BigInteger.valueOf(expo);
      phiN = p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1)));
      d = e.modInverse(p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1))));
      System.out.println(p);
      System.out.println(q);
      System.out.println(n);
      System.out.println(e);
      System.out.println(phiN);
      System.out.println(d);
    }
    public BigInteger encryptmessage(String message, int expo, String N){
      BigInteger m = new BigInteger("89"); //new BigInteger(message.getBytes());
      //BigInteger ex = new BigInteger(expo);
      BigInteger publicN = new BigInteger(N);
      BigInteger c = m.pow(expo).mod(publicN);
      System.out.println(c);
      return c;
    }
    public BigInteger decryptmessage(BigInteger encrypted){
      BigInteger ans = encrypted.pow(d.intValue()).mod(n);
      System.out.println(ans);
      return ans;
    }
}

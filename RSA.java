import java.math.BigInteger;
import java.util.Random;
public class RSA {
    PublicKey myPublicKey;
    PrivateKey myPrivateKey;
    int BIT_LENGTH;

    RSA(int BitL){
      BIT_LENGTH = BitL;

    }
    public void generateKeys(){
      BigInteger p = BigInteger.probablePrime(BIT_LENGTH, new Random());
      BigInteger q = BigInteger.probablePrime(BIT_LENGTH, new Random());
      BigInteger e = BigInteger.probablePrime(BIT_LENGTH, new Random());

      BigInteger n = p.multiply(q);
      BigInteger d = e.modInverse(p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1))));

      myPublicKey = new PublicKey(n.toString(), e.toString());
      myPublicKey.saveToFile();
      myPrivateKey = new PrivateKey(n.toString(), d.toString());
      myPrivateKey.saveToFile();
    }
    public String encryptmessage(String message, String expo, String N){
      BigInteger m = new BigInteger(message.getBytes()); //new BigInteger(message.getBytes());
      BigInteger publicN = new BigInteger(N);
      BigInteger E = new BigInteger(expo);
      BigInteger c = m.modPow(E, publicN);
      return c.toString();
    }
    public String decryptmessage(BigInteger encryptedMessage){
      BigInteger ans = encryptedMessage.modPow(myPrivateKey.D, myPrivateKey.N);
      return new String(ans.toByteArray());
    }
}

import java.io.*;
import java.math.BigInteger;

public class RSAencryptor{
  public static void main(String []args) {
    RSA enc = new RSA(48);
    while (true) {
            System.out.println("\n Menu");
            System.out.println("1. generate keys");
            System.out.println("2. Display public key");
            System.out.println("3. Display private key");
            System.out.println("4. Encrypt message");
            System.out.println("5. Decrypt message");
            String input = "";
            try {
                input = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            } catch(IOException e) {
                System.out.println("Something went wrong: " + e.toString());
                break;
            }

            if (input.equals("1")){
              enc.generateKeys();
            }
            else if(input.equals("2")){
              enc.myPublicKey.print();
            }
            else if(input.equals("3")){
              enc.myPrivateKey.print();
            }
            else if(input.equals("4")){
              System.out.println("Enter message to encrypt: ");
              String message;
              try {
                  message = (new BufferedReader(new InputStreamReader(System.in))).readLine();
              } catch(IOException e) {
                  System.out.println("Something went wrong: " + e.toString());
                  break;
              }
              System.out.println("Enter the exponent: ");
              String exponent;
              try {
                  exponent = (new BufferedReader(new InputStreamReader(System.in))).readLine();
              } catch(IOException e) {
                  System.out.println("Something went wrong: " + e.toString());
                  break;
              }
              System.out.println("Enter n: ");
              String n;
              try {
                  n = (new BufferedReader(new InputStreamReader(System.in))).readLine();
              } catch(IOException e) {
                  System.out.println("Something went wrong: " + e.toString());
                  break;
              }
              System.out.println("Your message: ");
              System.out.println(enc.encryptmessage(message, exponent, n));
            }
            else if(input.equals("5")){
              System.out.println("Enter message to decrypt: ");
              String Encmessage;
              try {
                  Encmessage = (new BufferedReader(new InputStreamReader(System.in))).readLine();
              } catch(IOException e) {
                  System.out.println("Something went wrong: " + e.toString());
                  break;
              }

              System.out.println(enc.decryptmessage(new BigInteger(Encmessage)));
            }
            else{
              break;
            }

    }
  }
}

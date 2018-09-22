public class RSAencryptor{
  public static void main(String []args) {
    RSA enc = new RSA();
    enc.generateKeys(53, 59, 3);
    enc.decryptmessage(enc.encryptmessage("hej", 3, "3127"));
  }
}

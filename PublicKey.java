import java.math.BigInteger;
import java.io.*;

public class PublicKey {

    BigInteger N;
    BigInteger E;


    PublicKey(){
      N = new BigInteger("0");
      E = new BigInteger("0");
    }
    PublicKey(String n, String e){
      N = new BigInteger(n);
      E = new BigInteger(e);
    }
    public void print(){
      System.out.println("*******************");
      System.out.println("n : ");
      System.out.println(N);
      System.out.println("e : ");
      System.out.println(E);
      System.out.println("*******************");
    }
    public void saveToFile(){
      File file = new File ("./PublicKey.txt");
      file.getParentFile().mkdirs();
      try
      {
          PrintWriter printWriter = new PrintWriter(file);
          printWriter.println (N);
          printWriter.println (E);
          printWriter.close();
      }
      catch (FileNotFoundException ex)
      {

      }
    }
    public void loadFromFile(){
      // Open the file
      try{
        FileInputStream fstream = new FileInputStream("./PublicKey.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        String[] arr = new String[2];
        int i = 0;
        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
          // Print the content on the console
          System.out.println (strLine);
          arr[i] = strLine;
          i++;
        }
        //Close the input stream
        br.close();
        N = new BigInteger(arr[0]);
        E = new BigInteger(arr[1]);
      }
      catch (IOException ex)
      {

      }
    }
}

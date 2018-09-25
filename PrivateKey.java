import java.math.BigInteger;
import java.io.*;

public class PrivateKey {

    BigInteger N;
    BigInteger D;

    PrivateKey(){
      N = new BigInteger("0");
      D = new BigInteger("0");
    }
    PrivateKey(String n, String d){
      N = new BigInteger(n);
      D = new BigInteger(d);
    }
    public void print(){
      System.out.println("*******************");
      System.out.println("n : ");
      System.out.println(N);
      System.out.println("d : ");
      System.out.println(D);
      System.out.println("*******************");
    }
    public void saveToFile(){
      File file = new File ("./PrivateKey.txt");
      file.getParentFile().mkdirs();
      try
      {
          PrintWriter printWriter = new PrintWriter(file);
          printWriter.println (N);
          printWriter.println (D);
          printWriter.close();
      }
      catch (FileNotFoundException ex)
      {

      }
    }
    public void loadFromFile(){
      // Open the file
      try{
        FileInputStream fstream = new FileInputStream("./PrivateKey.txt");
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
        D = new BigInteger(arr[1]);
      }
      catch (IOException ex)
      {

      }
    }
}

/**
 * 
 */
package Streams;

import java.io.IOException;

/**
 * @author Pablo
 *
 */
public class Main {

  /**
   * @param args
   * @throws IOException 
   */
  
  public static int compare(int x, int y) {
   if (x==y) return 0;
   else return -1;
   
    
  };
  
  public static void main(String[] args) throws Exception {
    //Declared sample message
    String message = "a ab ax acjdsl a a4";
  // System.out.print( message);
    
    //Declared word to find in the message
    String WordToCount = "ab";
    WordCount wCount = new WordCount(message, WordToCount);
    
    // find the number of occurrences of a word in the declared text in the given streams
    int count = wCount.Counter();
    
   
     // find the number of occurrences of a word in the declared text with channels
    
   CountByChannel channel = new CountByChannel(wCount);
      
   int c = channel.q;
  System.out.println("C to: " + c);
     
   /* Output compared values between two searching methods. 
   When output will be zero both values are equal */  
    System.out.println(Integer.compare(count, c));

  }

}

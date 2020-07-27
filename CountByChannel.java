package Streams;
import java.nio.channels.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.WRITE;
import static java.nio.file.StandardOpenOption.DELETE_ON_CLOSE;
import static java.nio.file.StandardOpenOption.READ;
import static org.junit.Assert.assertEquals;
import java.util.EnumSet;
import java.io.*;
import java.nio.*; 



public class CountByChannel {

  String text; // Text as source for streaming 
  ByteBuffer buf; // ByteBuffer to allocate write/read operations from File Channel
  byte[] bytes;  // array contains data from Bytebuffer 
  String s; //  Word to count in text using File Channel
  private String filePath = "src/Streams/temp.txt"; // path to file created by File Channel
  int q; // number of occurrence of searching word in text 
  char[] chdata; // CharBuffer to allocate characters from File Channel's read operations  
 
  
  // Constructor 
  public CountByChannel(WordCount wcount) throws Exception {
    
    this.text = wcount.msg;
    this.buf = ByteBuffer.allocate(wcount.msg.length()); // allocate ByteBuffer
    this.bytes = wcount.msg.getBytes("UTF-8"); // declared Unicode on input
    this.buf.put(bytes); //write data to buffer
    this.s =  wcount.findWord;
   
    
    try {
  
      File file = new File(filePath); // create temp file
      Path path = Paths.get(filePath); // path 
      boolean result;
      result = file.createNewFile(); // boolean value for created file above
      
      if(result)      // test if successfully created a new file  
      {  
      System.out.println("file created "+file.getCanonicalPath());  
      }  
      else  
      {  
      System.out.println("File already exist at location: "+file.getCanonicalPath());  
      };
      
      // Create File Channel for write/read operation by File Channel to buffer
      FileChannel channel = FileChannel.open(path, EnumSet.of(READ, WRITE, DELETE_ON_CLOSE));
  
         
      writeChannel(channel, buf); // write
      buf.flip(); // flip method, necessary before read operations
 
     chdata = readChannel(channel, buf); // read
     
  

     System.out.println(CountByFileChannel()); // assign method to variables
      
     
      channel.close(); // close
      System.out.println("File Channel is closed");
          
    } catch(Exception exc) {
      exc.printStackTrace();
      System.exit(1);
      }
  };
  
  public int CountByFileChannel () {
    int quantity = 0, i = 0;
    String temp = "";
    
   
    while (i < this.chdata.length) {
    	
     String x = String.valueOf(chdata[i]);
     System.out.println(x);
     if  (!x.contains(" ")) {
    	 
    	 temp+=(x);
    	 

 
     } else {
    	 if (temp.equalsIgnoreCase(this.s)) this.q++;
    	      
         temp = ""; // clean the elements after whitespace
     }
 
     i++;
  
    };
    
    return quantity;
  }
 
  void writeChannel(FileChannel channel, ByteBuffer buf) throws Exception {
    
    channel.write(buf); // write to file 
 
  }
  
 char[] readChannel(FileChannel channel, ByteBuffer buf) throws Exception {
   
   
    channel.read(buf); // read from file 
    buf.rewind(); // rewind method, necessary before another read operation 
   
    char[] result = new char[buf.remaining()]; // char array for the result of read operations
    
       for  (int i = 0; i < result.length; i++) {
   
          result[i] = (char) buf.get(); //read from buffer  
      
    }
     assertEquals(text, String.valueOf(result)); // compared declared text to text from temp file
     
     System.out.println(result);
     return result;
     
    }
     
 }

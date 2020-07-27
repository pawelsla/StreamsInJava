package Streams;

import java.io.*;


public class WordCount {

public String msg; // Text as source for streaming
public String findWord; //  Word to count in text

// Class constructor
public WordCount(String message, String WordToCount ) {
  msg = message;
  findWord = WordToCount;
}
  
// Method returns counting the number of occurrences of the searching word in message
 public int Counter() throws IOException {
Reader input = new BufferedReader(new StringReader(msg));
StreamTokenizer st = new StreamTokenizer(input);

int i = st.nextToken();
int counter= 0; 
while (i !=StreamTokenizer.TT_EOF ) {
  if ((st.ttype == StreamTokenizer.TT_WORD) & (String.valueOf(st.sval).equals(findWord))){
    counter++;
  }
 
  i=st.nextToken();
 
  
}

input.close();
return counter; // how many findWord exists in streaming text

  }

}

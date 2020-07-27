# StreamsInJava

Java classes that allow to count the occurrences declared text in the Given Stream


---
## WordCount class 
This class allow to count the ocurrences of searching text in the Stream with Stream Tokenizer. There are using StreamReader class, suitable for Input with Characters Stream. In next, with **Counter** method, any word is compared to word that want to find.



## CountByChannel class
There are message from WordCount object is written by ByteBuffer. In next, data from ByteBuffer is transmissed to temponary file by File Channel. 
Flip method set a position on zero in buffer and prepare File Channel to read operations from file to buffer. File Channel's read method overwrites any Byte Channel array elements with reading bytes from temponary file. 

Class method called **readChannel** returns characters array that contains the same inputed text at the begin. 

**CountByFileChannel** method allows to find how many searching word occurs in declared text.

<ins>**CountByChannel**</ins> class gives the same result as <ins>**WordCount**</ins> class, but with File Channel operations. 

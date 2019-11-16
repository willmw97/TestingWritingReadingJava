 /*
 Author: Marshal
 This class will write the student record as a DataOutputstream
 */
import java.util.*;
import java.io.*;

public class StudentRecordWriter 
{
   //object creates for DataOutputStrea,
   DataOutputStream Output;

   public StudentRecordWriter(String outputFile) throws IOException 
   {
     //dataoutput us the object used to write
      Output = new DataOutputStream(new FileOutputStream(outputFile));
   }
   //data output writes as the specific data type
   public void write(Student mystudent) throws IOException 
   {
      Output.writeUTF(mystudent.getName());
      Output.writeChar(mystudent.getGender());
      Output.writeInt(mystudent.getAge());
      Output.writeFloat(mystudent.getGrade());
   }
    //saves the output
   public void save() throws IOException 
   {
      //close output object
      Output.close();
   }
}
  /*
 Author: Marshal
 This class will read the student record as a DataInputstream
 */
import java.util.*;
import java.io.*;


public class StudentRecordReader 
{

   DataInputStream Input;

   public StudentRecordReader(String inputFile) throws IOException 
   {
      Input = new DataInputStream(new FileInputStream(inputFile));
   }

   public List<Student> readAll() throws IOException 
   {
      List<Student> Studentlist = new ArrayList<>();
   
      try {
         while (true) {
            String name = Input.readUTF();
            char gender = Input.readChar();
            int age = Input.readInt();
            float grade = Input.readFloat();
         
            Student mystudent = new Student(name, gender, age, grade);
            Studentlist.add(mystudent);
         }
      } catch (EOFException ex) 
      {
         //file ends
      }
      //close input stream
      Input.close();
   
      return Studentlist;
   }
}
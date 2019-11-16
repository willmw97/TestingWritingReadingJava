/*
Author: Marshal
Program: 
This program uses DataOutputStream and DataInputStream
It also uses the objectoutput and input stream.
This demonstrates how data is transmitted as a primitive data type.

*/
import java.util.*;
import java.io.*;

public class mainStudents
{
            
   public static void main(String[] args) throws IOException, ClassNotFoundException
   {
      //create array list
      ArrayList<Student> studentLists = new ArrayList<Student>();
      //create list of students data
      studentLists.add(new Student("Alice", 'F', 23, 80.5f));
      studentLists.add(new Student("Brian", 'M', 22, 95.5f));
      studentLists.add(new Student("Carol", 'F', 21, 79.8f));
      studentLists.add(new Student("Bruce", 'M', 21, 81.0f));
         
      System.out.println("Part 1");
      System.out.println("DataOutputStream");
         
      StudentRecordWriter writer = new StudentRecordWriter("StudentRecord.txt");
   
      for (Student student : studentLists) 
      {
         writer.write(student);
      }
      //writer.close();
      writer.save();
      
      System.out.println("Part 2");   
      System.out.println("DataInputStream");
      
   
      try 
      {
         StudentRecordReader reader = new StudentRecordReader("StudentRecord.txt");
         //creats object for all list students
         List<Student> listStudent = reader.readAll();
         //prints the students
         for (Student s : studentLists) 
         {
            System.out.println(s.MyString());
         }
      } catch (IOException ex) {
         ex.printStackTrace();
      }
         
         
      System.out.println("Part 3");
      //fix cycle through list to write each object   
      System.out.println("ObjectOutputStream");
      
      try 
      {
         FileOutputStream file = new FileOutputStream("StudentRecordV2.txt");
         ObjectOutputStream Writer = new ObjectOutputStream(file);
         for (Student obj : studentLists)
         {
            Writer.writeObject(obj);
         }
         Writer.close();
         file.close();
      } catch (Exception ex) {
         System.err.println("failed to write ");
      }
      System.out.println("Part 4");   
      System.out.println("ObjectInputStream");
      //uses objectinputstream
      try 
      {
         FileInputStream file = new FileInputStream("StudentRecordV2.txt");
         ObjectInputStream reader = new ObjectInputStream(file);
         //will cycle through file
         while (true) 
         {
            try 
            { 
               Student obj = (Student)reader.readObject();
               System.out.println(obj.MyString());
            } catch (Exception ex) {
               System.err.println("end of reader file ");
               break;
            }
         }
      } catch (Exception ex) {
         System.err.println("failed to read ");
      }
                      
   }
}
    

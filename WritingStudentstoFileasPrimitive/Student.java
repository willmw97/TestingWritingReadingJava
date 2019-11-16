/*
 Author: Marshal
 This class will hold the student record
 */
import java.util.*;
import java.io.*;


class Student implements java.io.Serializable
{
   //holds the student information
   private String name;
   private char gender;
   private int age;
   private float grade;
   
   
   //holds constructor for Students
   public Student(String name, char gender, int age, float grade)
   {
      this.name = name;
      this.gender = gender;
      this.age = age;
      this.grade = grade;
   
   }
   
   //prints the student output
   public String MyString()
   {
      return "Student "+name+", a "+returnGender()+ " and of age "+age+", recieved a grade of "+gradeString()+" in this class.";
   }
   
   //clears student info
   public void clearStudent(String name, char gender, int age, float grade)
   {
      name = null;
      age = 0;
      grade = 0;
   }
   //formats the float for the student
   public String gradeString()
   {
      return String.format("%.02f", grade);
   }
   //set methods
   public void setName(String name)
   {
      this.name = name;
   }
   
   public void setGender(char gender)
   {
      this.gender = gender;
   }
   
   public void setAge(int age)
   {
      this.age = age;
   }
   
   public void setGrade(float grade)
   {
      this.grade = grade;
   }
   //return methods
   public String getName()
   {
      return name;
   }
   
   public String returnGender()
   {
      if(gender == 'F')
         return "Female";
      else
         return "Male";
   }
   
   public char getGender()
   {
      return gender;
   }
   
   public int getAge()
   {
      return age;
   }
   
   public float getGrade()
   {
      return grade;
   }
   

}
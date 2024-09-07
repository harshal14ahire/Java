
import java.util.*;
import java.io.*;

class College implements Cloneable ,Serializable{
    int cid;
    String cname;
    int capcity;
    String location;
   void setCollegeDetails()
   {
      Scanner s=new Scanner(System.in);
      System.out.println(" Enter College Id:");
      cid=s.nextInt();
      System.out.println(" Enter College Name:");
      cname=s.next();
      System.out.println(" Enter Capacity Of Student in College:");
      capcity=s.nextInt();
      System.out.println(" Enter Location Of College:");
      location=s.next();



   }
   public String toString()
   {
    return cid+" | "+cname +" | "+capcity+" | " +location;
   }


    @Override
    public College clone() throws CloneNotSupportedException
     {
        return (College) super.clone();
    }
}


class CollegeFactory {
    // Factory method to create College objects
    public static College createCollege() {
        return new College();
    }
}

class NumberOfWaysToCreateObject{

    public static void main(String args[])
    {  try{
        System.out.println("Creating Object using New KeyWord..");
        College c1=new College();
        c1.setCollegeDetails();
        System.out.println(c1);

        
         System.out.println("Creating Object using Factory Method..");
            College c2 = CollegeFactory.createCollege(); // Using the factory method
            c2.setCollegeDetails();
            System.out.println(c2);
      

        System.out.println("Creating Object using New newInstance() method..");
        Class <College> c= (Class <College> )Class.forName("College");// Step 1.=store class name as "College" as a STring into Object Using Factory Method ForName()
        College c3= (College)c.newInstance();
        c3.setCollegeDetails();
        System.out.println(c3);



       // System.out.println("Using Object Deserialization KeyWord..");
       System.out.println("Using Object Deserialization..");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("college.ser"));
            out.writeObject(c1);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("college.ser"));
            College c4 = (College) in.readObject();
            in.close();
            c4.setCollegeDetails();
            System.out.println("Deserialized Object: " + c4);


        System.out.println("Creating By Cloning..");
        College c5=(College)c1.clone();
        c5.setCollegeDetails();
        System.out.println(c5);
    }catch( Exception e)
    {
         System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
    }


        
    }
}
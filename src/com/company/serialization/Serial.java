package com.company.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serial {
    public static void main(String[] args) {

        try{
            //object state
            Student student = new Student("Ankit", "ankt@gmail.com", 25, "Lucknow");
            //write data to file
            FileOutputStream fileOutputStream = new FileOutputStream("ob.txt");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            //how to serialize
            objectOutputStream.writeObject(student);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("object state transfer to ob.txt");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}

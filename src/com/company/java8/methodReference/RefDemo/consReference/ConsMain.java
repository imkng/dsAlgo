package com.company.java8.methodReference.RefDemo.consReference;

public class ConsMain {
    public static void main(String[] args) {
//        Provider provider = () ->  new Student();
        Provider provider = Student::new;
        Student student = provider.getStudent();
        student.display();

    }
}

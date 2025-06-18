package com.company;

interface Employee1{
    void getName();
    int getSalary();
}
class JavDev implements Employee1{

    @Override
    public void getName() {
        System.out.println("I am a Java Developer");
    }

    @Override
    public int getSalary() {
        return 100;
    }
}
class Web implements Employee1{

    @Override
    public void getName() {
        System.out.println("I am  a web dev");
    }

    @Override
    public int getSalary() {
        return 900;
    }
}

abstract class EMployeeAbsFatory{
    public abstract Employee1 getEmployee();
}

class AndRoidDevFact extends EMployeeAbsFatory {

    @Override
    public Employee1 getEmployee() {
        return new JavDev();
    }
}
class WebDevFact extends EMployeeAbsFatory {

    @Override
    public Employee1 getEmployee() {
        return new Web();
    }
}

class EmpFact{
    public static Employee1 getEmp(EMployeeAbsFatory eMployeeAbsFatory){
        return eMployeeAbsFatory.getEmployee();
    }
}

public class AbstractFactoryDesignPattern {

    public static void main(String[] args) {
        EMployeeAbsFatory eMployeeAbsFatory = new WebDevFact();

    }

}

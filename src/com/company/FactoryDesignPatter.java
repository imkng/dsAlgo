package com.company;

interface Employee{
    int getSalary();
}
class JavaDeveloper implements Employee{

    @Override
    public int getSalary() {
        return 900;
    }
}

class WebDev implements Employee{

    @Override
    public int getSalary() {
        return 1000;
    }
}

class EmployeeFactory{
    public static Employee getEmployee(String str){
        if (str.trim().equals("JAVA_DEVELOPER")){
            return new JavaDeveloper();
        }else if (str.trim().equals("WEB_DEVELOPER")){
            return new WebDev();
        }
        return null;
    }
}

public class FactoryDesignPatter {
    public static void main(String[] args) {
        Employee JavaEmployee = EmployeeFactory.getEmployee("JAVA_DEVELOPER");
        System.out.println(JavaEmployee.getSalary());
        Employee webEmployee = EmployeeFactory.getEmployee("WEB_DEVELOPER");
        System.out.println(webEmployee.getSalary());

    }
}

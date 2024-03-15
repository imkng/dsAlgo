package com.company.javaeight.lambdaExpression;


//Lambda Expression: () -> {};
@FunctionalInterface
interface Calculator{
//    void switchOn();
    int subtract(int a, int b);
}
public class CalculatorImpl {
    public static void main(String[] args) {
//        Calculator calculator = ()->{
//            System.out.println("Switched On");
//        };
//
//        calculator.switchOn();

        Calculator calculator = (a, b) -> {return a - b;};

        System.out.println(calculator.subtract(5,2));
    }
}

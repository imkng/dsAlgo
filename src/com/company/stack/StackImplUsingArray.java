package com.company.stack;

public class StackImplUsingArray {
    static final int MAX = 100;
    int top;
    int[] arr = new int[MAX];

    public StackImplUsingArray(int top) {
        this.top = top;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == 100;
    }

    public void push(int x)  {
        try{
           checkForOverFlow();
        }catch (StackException ex){
            System.out.println("Exception Occurred: " + ex);
        }
        arr[++top] = x;
        System.out.println(x + " pushed into stack");
    }

    private void checkForOverFlow() throws StackException {
        if(top >= MAX -1){
            throw new StackException("Stack Overflow");
        }
    }

    public int pop(){
        try {
            checkForUnderFlow();
        }catch (StackException ex){
            System.out.println("Exception Occurred: " + ex);
        }
        System.out.println("Popped element: " + arr[top]);
        return arr[top--];
    }

    private void checkForUnderFlow() throws StackException {
        if(top < 0){
            throw new StackException("Stack Underflow");
        }
    }


    public int peek(){
        if(top < 0){
            System.out.println("Stack Underflow");
            return 0;
        }else{
            return arr[top];
        }
    }

    void print(){
        for(int i = top; i > -1; i--){
            System.out.println(arr[i]);
        }
    }

}

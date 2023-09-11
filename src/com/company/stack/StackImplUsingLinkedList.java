package com.company.stack;

public class StackImplUsingLinkedList {
    StackNode root;

    public void push(int x){
        StackNode newNode = new StackNode(x);

        if(root == null){
            root = newNode;
        }else {
            StackNode temp = root;
            root = newNode;
            newNode.next = temp;
        }
        System.out.println(x + " pushed to stack");
    }

    public boolean isEmpty(){
        try{
            checkForUnderFlow();
        }catch (StackException ex){
            System.out.println("Exception Occurred" + ex );
        }
        return false;
    }

    private void checkForUnderFlow() throws StackException {
        if (root == null){
            throw new StackException("Stack Is Empty");
        }
    }

    public int pop(){
        int popped;
        try {
            checkForUnderFlow();
        }catch (StackException ex){
            System.out.println("Exception Occurred" + ex);
        }
        popped = root.data;
        root = root.next;
        System.out.println(popped + " popped");
        return popped;
    }

}

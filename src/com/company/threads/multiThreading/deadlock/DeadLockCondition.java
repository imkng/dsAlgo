package com.company.threads.multiThreading.deadlock;

class Pen{
    public synchronized void writePenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName() + " is using the pen " + this + " and trying to get paper");
        paper.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + " finished using pen " + this);
    }
}

class Paper{

    public synchronized void writeWithPaperAndPen(Pen pen){
        System.out.println(Thread.currentThread().getName() + " is using paper " + this + "and trying to get pen");
        pen.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using paper " + this);
    }
}

class Task1 implements Runnable{
    private Pen pen;
    private Paper paper;

    public Task1(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        pen.writePenAndPaper(paper);
    }
}

class Task2 implements Runnable{

    private Paper paper;
    private Pen pen;

    public Task2(Paper paper, Pen pen) {
        this.paper = paper;
        this.pen = pen;
    }

    @Override
    public void run() {
        paper.writeWithPaperAndPen(pen);
    }
}
public class DeadLockCondition {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();
        Thread task1 = new Thread(new Task1(pen, paper));
        Thread task2 = new Thread(new Task2(paper, pen));
    }

}

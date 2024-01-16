package Lab6;

import java.util.Scanner;

public class Activity2 {
    private int maxSize; //size of stack array
    private int[] stackData;
    private int top; //top of stack
    //-------------------------------------------------------------------------
    public Activity2(int s) {
        this.stackData = new int[s];
        this.maxSize = s;
        this.top = 0;
    }
    public boolean isEmpty() {
        if(top==0)
        {
            return true;
        }
        return false;
    }
    public boolean isFull() {
        if(maxSize==(top))
        {
            return true;
        }
        return false;
    }
    public void push(int item) {
        if(isFull())
        {
            System.out.println("Stack is full!");
        }else{
            this.stackData[top]=item;
            top++;
        }

    }
    public int pop() {
        int popData;
        if(isEmpty())
        {
            System.out.println("Stack is empty!");
            return -1;
        }else
        {
            popData = this.stackData[--top];
            //top--;
            return popData;
        }
    }
    public int peek() {
        int position = top-1;
        return this.stackData[position];
    }
    public void display() {

        for (int i=top-1;i>=0;i--)
        {
            System.out.printf(this.stackData[i]+"");;
        }
        System.out.println();
    }
    public int top()
    {
        return top;
    }
}


class Binary{
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.printf("Enter decimal number : ");
        int decimal = input.nextInt();
        Activity2 a=new Activity2((decimal/2));
        while (decimal!=0)
        {
            a.push((decimal%2));
            decimal/=2;
        }
        System.out.printf("Binary number : ");
        a.display();

    }
}

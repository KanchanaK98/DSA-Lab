package Lab6;

public class StackArray {
    private int maxSize; //size of stack array
    private int[] stackData;
    private int top; //top of stack
    //-------------------------------------------------------------------------
    public StackArray(int s) {
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
    public int pop() throws Exception {
        int popData;
        if(this.isEmpty())
        {
            throw new Exception("Cannot delete because array is empty!");
        }else
        {
            popData = this.stackData[--top];
            //top--;
            return popData;
        }
    }
    public int peek() throws Exception{
        if(isEmpty())
        {
            throw new Exception("Empty stack");
        }
        int position = top-1;
        return this.stackData[position];
    }
    public void display() {
        for (int i=0;i<top;i++)
        {
            System.out.printf(this.stackData[i]+" ");;
        }
        System.out.println();
    }
}


class Main
{
    public static void main(String[] args) {
        StackArray s=new StackArray(5);
        s.push(100);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
//        s.push(50);
        try{
            int x= s.pop();
            int y= s.pop();
            System.out.println("poped data are : "+x+" "+y);
        }catch (Exception e){
            System.out.println(e);
        }

        s.display();
        try {
            int z = s.peek();
            System.out.println("peek data : "+z);
        }catch (Exception e)
        {
            System.out.println(e);
        }

    }
}

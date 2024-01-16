package Lab7;
import java.util.*;
public class QueueArray {
    private int maxSize;
    private int[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public QueueArray(int max)
    {
        this.maxSize = max;
        this.queArray = new int[maxSize];
        this.rear = -1;
        this.front = 0;
        this.nItems = 0;
    }
    public boolean isEmpty()
    {
        if(this.nItems == 0)
        {
            return true;
        }
        return false;
    }
    public boolean isFull()
    {
        if(this.nItems == this.maxSize)
        {
            return true;
        }
        return false;
    }
    public int size()
    {
        return nItems;
    }
    public void enqueue(int data)
    {
        if(isFull())
        {
            System.out.println("Array is full and you cannot insert data!");
        }else{
            if(rear==maxSize-1)
            {
                rear = 0;
                this.queArray[rear] = data;
                this.nItems++;
                return;
            }
            rear++;
            this.queArray[rear] = data;
            this.nItems++;
        }
    }

    public int dequeue() throws Exception
    {
        if(this.isEmpty())
        {
            throw new Exception("Cannot delete because array is empty!");
        }
        int removedData = this.queArray[front];
        if(this.front == this.maxSize -1)
        {
            this.front=0;
        }else
        {
            this.front++;
        }
        this.nItems--;
        return removedData;
    }
    public int peek() throws Exception
    {
        if(this.isEmpty())
        {
            throw new Exception("Cannot have peek because array is empty!");
        }
        return this.queArray[this.front];
    }

    public void displayQueue()
    {

        for (int i=front;;i++)
        {
            if(i==maxSize)
            {
                i = 0;
            }
            if(i==rear)
            {
                break;
            }
            System.out.printf(this.queArray[i]+" ");

        }
        System.out.printf(this.queArray[rear]+" ");
        System.out.println();

    }
}

class Question{
    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);

        q.displayQueue();
        try{
            q.dequeue();
        }catch (Exception e){
            System.out.println(e);
        }
        q.displayQueue();
        q.enqueue(7);
        q.displayQueue();
        try{
            q.dequeue();
        }catch (Exception e){
            System.out.println(e);
        }
        q.displayQueue();
        q.enqueue(8);
        q.displayQueue();
        try
        {
            System.out.println(q.peek());
        }catch (Exception e)
        {
            System.out.println(e);
        }



    }
}

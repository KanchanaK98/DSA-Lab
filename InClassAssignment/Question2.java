package InClassAssignment;


//part b
public class Question2 {
    public static void main(String[] args) {
        LinkedList link = new LinkedList();
        link.insertFirst(5);
        link.insertFirst(6);
        link.insertFirst(2);
        link.insertFirst(7);
        link.insertFirst(10);
        link.insertFirst(8);
        link.displayList();
        Node deleteFirstNode = link.deleteFirst();
        System.out.println("Deleted Node : "+deleteFirstNode.data);
        link.displayList();
        link.delete(3);
        link.displayList();
        try {
            Node findNode = link.find(4);
            System.out.println("Find value = "+findNode.data);
        }catch (NullPointerException e)
        {
            System.out.println("Cannot find a null object");
        }

        link.insertLast(25);
        link.displayList();
        link.insertLast(105);
        link.displayList();
        link.insertMiddle(100,3);
        link.displayList();
        Node deleteLastNode = link.deleteLast();
        System.out.println("Deleted last Node : "+deleteLastNode.data);
        link.displayList();
    }
}

//part b
class Node {
    int data;
    Node next;
    Node previous;
    Node(int item) {
        this.data = item;
        this.next = null;
        this.previous = null;
    }
    void displayNode() {
        System.out.print(data+" ");
    }
}
class LinkedList
{
    private Node head;
    public void LinkList() {

        head = null;
    }
    public boolean isEmpty() {
        if(head == null)
        {
            return true;
        }
        return false;
    }
    public void insertFirst(int i) {
        Node newNode = new Node(i);
        newNode.next = head;
        if(newNode.next!=null)
        {
            newNode.next.previous=newNode;
        }
        newNode.previous = null;
        head = newNode;

    }
    public Node deleteFirst() {
        if(this.isEmpty())
        {
            System.out.println("Linked list is empty. cannot be deleted");
            return null;
        }
        Node temp;
        temp = head;
        head = head.next;
        head.previous=null;
        temp.next = null;
        temp.previous = null;
        return temp;
    }

    public Node deleteLast() {
        if(this.isEmpty())
        {
            System.out.println("Linked list is empty. cannot be deleted");
            return null;
        }
        Node temp;
        temp = this.last();
        Node lastNode = this.last();
        lastNode.previous.next = null;
        lastNode.previous = null;
//        head = head.next;
//        head.previous=null;
        temp.next = null;
        temp.previous = null;
        return temp;
    }

    public void displayList() {
        if(isEmpty())
        {
            System.out.println("Nothing to print");
            return;
        }
        Node current = head;
        System.out.println("Loop from left to right..");
        while (current!=null)
        {
            System.out.printf(current.data+" ");
            current = current.next;
        }
        System.out.println();
        Node lastNode = last();
        System.out.println("Loop from right to left..");
        while (lastNode!=null)
        {
            System.out.printf(lastNode.data+" ");
            lastNode=lastNode.previous;
        }
        System.out.println();


    }

    public Node last()
    {
        Node current=head;
        while(true)
        {
            if(current.next==null)
            {
                return current;
            }
            current = current.next;
        }
    }

    public Node find(int key) {
        Node current = head;
        int count =1;
        while (current!=null)
        {
            if(count == key)
            {
                return current;
            }
            current = current.next;
            count++;
        }
        System.out.println("Item not found");
        return null;
    }

    public void delete(int key) {
        if(isEmpty())
        {
            System.out.println("List is empty. cannot do deletion");
            return;
        }
        Node current, previous;
        current = head;
        previous = head;
        int i=1;
        while (current!=null)
        {
            if(i == key )
            {
                if(i == 1)
                {
                    deleteFirst();
                }else{
                    previous.next = current.next;
                    current.next.previous = previous;
                }
                System.out.println("Item is deleted");
                return;

            }
            previous = current;
            current=current.next;
            i++;
        }
        System.out.println("Nothing to deletion");


    }

    public void insertLast(int data){
        Node newNode = new Node(data);
        newNode.next = null;
        Node current = head;
        while (true)
        {
            if(current.next==null)
            {
                current.next = newNode;
                newNode.previous = current;
                return;
            }
            current = current.next;
        }

    }

    public void insertMiddle(int data, int after){
        Node newNode = new Node(data);
        Node currentNode = find(after);
        Node afterNode = find(after+1);
        currentNode.next = newNode;
        newNode.previous = currentNode;
        afterNode.previous=newNode;
        newNode.next = afterNode;
    }
}
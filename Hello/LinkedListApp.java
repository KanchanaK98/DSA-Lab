package Hello;

public class LinkedListApp
{
    public static void main(String[] args) {
        LinkList link = new LinkList();
        link.insertFirst(5);
        link.insertFirst(6);
        link.insertFirst(2);
        link.insertFirst(7);
        link.insertFirst(10);
        link.insertFirst(8);
        link.displayList();
        link.deleteFirst();
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
        link.insertMiddle(1000,1);
        link.displayList();

    }
}

class Node {
    int data;
    Node next;
    Node(int item) {
        this.data = item;
        this.next = null;
    }
    void displayNode() {
        System.out.print(data+" ");
    }
}
class LinkList {
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
        head = newNode;

    }
    public Node deleteFirst() {
        if(isEmpty())
        {
            System.out.println("Linked list is empty. cannot be deleted");
            return null;
        }
        Node temp;
        temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
    public void displayList() {
//        System.out.println(head.data);
//        System.out.println(head.next.data);
//        System.out.println(head.next.next.data);.....
        if(isEmpty())
        {
            System.out.println("Nothing to print");
            return;
        }
        Node current = head;
        while (current!=null)
        {
            current.displayNode();   //also can sop(current.data)
            current = current.next;
        }
        System.out.println();


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
//        if(isEmpty())
//        {
//            System.out.println("List is empty. cannot do deletion");
//            return;
//        }
//        Node pre = find(key-1);
//        Node past = find(key+1);
//        pre.next = past;
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
        newNode.next = afterNode;
    }
}

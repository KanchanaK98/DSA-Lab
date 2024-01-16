package InClassAssignment;

//part a
public class Question1 {
    public static void main(String[] args) {
        doubleEndedLinkList link = new doubleEndedLinkList();
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
            Nodes findNode = link.find(4);
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
        Nodes lastNode = link.tailNode();
        System.out.println("Data of tail node : "+lastNode.data);
    }
}

//part a
class Nodes{
    int data;
    Nodes next;
    Nodes(int item) {
        this.data = item;
        this.next = null;
    }
    void displayNode() {
        System.out.print(data+" ");
    }
}
class doubleEndedLinkList{
    private Nodes head;
    private Nodes tail;
    public void doubleEndedLinkList() {
        head = null;
        tail = null;
    }
    public boolean isEmpty() {
        if(head == null)
        {
            return true;
        }
        return false;
    }
    public void insertFirst(int i) {
        Nodes newNode = new Nodes(i);
        if(this.isEmpty()) {
            tail = newNode;
        }
        newNode.next = head;
        head = newNode;

    }
    public Nodes deleteFirst() {
        if(this.isEmpty())
        {
            System.out.println("Linked list is empty. cannot be deleted");
            return null;
        }
        Nodes temp;
        temp = head;
	if(head.next==null)
        {
            tail=null;
        }
        head = head.next;
        
        temp.next = null;
        return temp;
    }
    public void displayList() {

        if(this.isEmpty())
        {
            System.out.println("Nothing to print");
            return;
        }
        Nodes current = head;
        while (current!=null)
        {
            System.out.printf(current.data+" ");
            current = current.next;
        }
        System.out.println();


    }
    public Nodes find(int key) {
        Nodes current = head;
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
        Nodes current, previous;
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

        Nodes newNode = new Nodes(data);
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;


    }


    public Nodes tailNode()
    {
        return tail;
    }

    public void insertMiddle(int data, int after){
        Nodes newNode = new Nodes(data);
        Nodes currentNode = find(after);
        Nodes afterNode = find(after+1);
        currentNode.next = newNode;
        newNode.next = afterNode;
    }
}



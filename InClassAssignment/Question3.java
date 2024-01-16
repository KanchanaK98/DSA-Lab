package InClassAssignment;


//part c
public class Question3 {
    public static void main(String[] args) {
//        PriorityQueue q = new PriorityQueue();
//        q.enqueue(5,23,"Kanchana","Galle, Baddegama");
//        q.enqueue(3,24,"Sasindu","Galle, Sandarawla");
//        q.enqueue(1,25,"Parakrama","Galle, Baddegama");
//        q.enqueue(2,30,"Lakpriya","No 22/5, Mathugama");
//        q.enqueue(4,30,"Lakpriya","No 22/5, Mathugama");
//        q.enqueue(100,54,"Akila","No 23/5, Nuwara");
//        q.enqueue(10,54,"Akila","No 23/5, Nuwara");
//        q.enqueue(1000,54,"Sachintha","No 23/5, Nuwara");
//        q.display();
//        try {
//            String patient = q.peek();
//            System.out.println("First patient's name : "+patient);
//        }catch (Exception e)
//        {
//            System.out.println(e);
//        }
//        try {
//            String patient = q.dequeue();
//            System.out.println("Patient number who can meet doctor firstly : "+patient);
//        }catch (Exception e)
//        {
//            System.out.println(e);
//        }
//
//        q.enqueue(22,54,"Akila","No 23/5, Nuwara");
//        q.enqueue(20,54,"Akila","No 23/5, Nuwara");
//        q.display();
//        try {
//            String patient = q.peek();
//            System.out.println("First patient's name : "+patient);
//        }catch (Exception e)
//        {
//            System.out.println(e);
//        }
    }
}

//part c
class Patient{
    int patientNo;
    int age;
    String PatientName;
    String Address;
    Patient next;
    Patient(int pNo,int age,String name,String address)
    {
        this.patientNo=pNo;
        this.age=age;
        this.PatientName=name;
        this.Address=address;
        this.next=null;
    }
}
class PriorityQueue{
    private Patient head;
    private Patient tail;
    public void PriorityQueue() {
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

    public void enqueue(int patientNum,int age,String patientName,String address){
        if(tail==null)
        {
            Patient newNode = new Patient(patientNum,age,patientName,address);
            if(this.isEmpty()) {
                tail = newNode;
            }
            newNode.next = head;
            head = newNode;
            return;
        }
        if((patientNum<head.patientNo))
        {
            Patient newNode = new Patient(patientNum,age,patientName,address);
            if(this.isEmpty()) {
                tail = newNode;
            }
            newNode.next = head;
            head = newNode;
            return;
        }
        if(patientNum>tail.patientNo)
        {
            Patient newNode = new Patient(patientNum,age,patientName,address);
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
            return;
        }

        if((patientNum>head.patientNo)&&(patientNum<tail.patientNo))
        {

            Patient newNode = new Patient(patientNum,age,patientName,address);
            Patient current = head;
            Patient prev = head;
            int count=head.patientNo;
            while (current!=null)
            {
                if(count>patientNum)
                {
                    newNode.next=current;
                    prev.next = newNode;
                    return;
                }
                prev = current;
                current = current.next;
                count=current.patientNo;

            }

            return;
        }

    }

    public String dequeue() throws Exception
    {
        if(this.isEmpty())
        {
            throw new Exception("Cannot delete because array is empty!");
        }
        Patient removedData = head;
        head = head.next;
        removedData.next = null;
        return removedData.PatientName;
    }
    public String peek() throws Exception {
        return head.PatientName;
    }
    public void display() { //patients name and number according to the priority level

        if(this.isEmpty())
        {
            System.out.println("Nothing to print");
            return;
        }
        Patient current = head;
        while (current!=null)
        {
            System.out.printf(current.patientNo+" "+current.PatientName);
            current = current.next;
            System.out.println();
        }
        System.out.println();


    }

}



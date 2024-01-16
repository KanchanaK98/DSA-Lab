package Hello;

import java.util.Scanner;
public class Assignment01Demo {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter memory size: ");
        int mSize = sn.nextInt();
        DataOccurrence d = new DataOccurrence(mSize);
        String data;
        while (true){
            System.out.print("Enter data (type 'e' for end):");
            data=sn.next();
            if(data.toUpperCase().equals("E")){
                break;
            }
            d.add(data.toUpperCase());
        }
        System.out.println("Good bye");
    }
}
class DataOccurrence {
    private String[] arr;// an array for store user data
    private int max; // maximum size of the array 'arr'
    private int nElements; // number of elements in the array 'arr'
    private ResultData[] rd; // an array for save user data with their occurrence
    public DataOccurrence(int size) {// default constructor for initialize instance variables
        //fill the code
        this.arr = new String[size];
        this.rd = new ResultData[size];
        this.max = size;
        this.nElements = 0;
    }
    private boolean isFull() { // check the array 'arr' is full or not
        //fill the code
        if(this.nElements == this.max)
        {
            return true;
        }else{
            return false;
        }
    }
    private void shiftAll() { //shift each element in the 'arr' one location to left
        // fill the code
        for(int i=0; i<nElements-1; i++)
        {
            this.arr[i] = this.arr[i+1];
        }
    }
    public void add(String element) { // add an element to the array 'arr'
        // fill the code
        // call the isFull(), shiftAll(), storeResults() and displayResults() in appropriate places.

        if(isFull())
        {
            shiftAll();
            this.arr[max-1] = element;
            storeResults();
            displayResults();
        }else{
            this.arr[nElements] = element;
            this.nElements++;

        }




    }
    private void storeResults() {// store each element in the 'arr' with their occurrence to 'rd'
        // fill the code
        for(int i=0;i<nElements;i++)
        {
            this.rd[i] = new ResultData(arr[i]);
        }

    }
    private void displayResults() {
        // display all the data in 'rd' in the format of 'element->occurrence' (eg: A->3)
        // fill the code
        for (int j=0 ; j<max ; j++)
        {

            int check;
            check = 1;
            for(int i=0;i<j;i++)
            {
                if(this.rd[i].name.equals(this.rd[j].name))
                {
                    check = 0;
                }
            }

            if (check==1)
            {
                int occurrence = 0;
                for (int p=j;p<max;p++)
                {
                    if (this.rd[p].name.equals(this.rd[j].name)){
                        occurrence++;
                    }
                }
                System.out.printf(this.rd[j].name+"->"+occurrence+" ");
            }


        }
        System.out.println();
//            for (int i=0;i<max;i++)
//            {
//                System.out.println(this.rd[i].name);
//            }
//        System.out.println();
    }
}
class ResultData {// this class is used to save the element with their occurrence
    String name; // name of the element
    int count; // occurrence of the element
    ResultData(String name) { // default constructor
        this.name = name;
        this.count = 0;
    }
}

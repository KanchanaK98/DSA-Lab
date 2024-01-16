package Hello;
import java.util.Scanner;

public class GFG {

        public static void main(String[] args) {
            Scanner sn = new Scanner(System.in);
            System.out.print("Enter memory size: ");
            int mSize = sn.nextInt();
            DataOccurrence1 d = new DataOccurrence1(mSize);
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


class DataOccurrence1 {
        private String[] arr;// an array for store user data
        private int max; // maximum size of the array 'arr'
        private int nElements; // number of elements in the array 'arr'
        private ResultData1[] rd; // an array for save user data with their occurrence
        public DataOccurrence1(int size) {// default constructor for initialize instance variables
            this.arr = new String[size];
            this.max = size;
            this.nElements = 0;
            this.rd = new ResultData1[size];
        }
        private boolean isFull() { // check the array 'arr' is full or not
            if(this.nElements==this.max)
            {
                return true;
            }
            return false;

        }
        private void shiftAll() { //shift each element in the 'arr' one location to left
            // fill the code
            for (int i=0;i<nElements-1;i++)
            {
                this.arr[i]=this.arr[i+1];
            }
        }
        public void add(String element) { // add an element to the array 'arr'
            // fill the code
            // call the isFull(), shiftAll(), storeResults() and displayResults() in appropriate places.
            if(this.isFull())
            {
                this.shiftAll();
                this.arr[this.max-1] = element;
                this.storeResults();
                this.displayResults();
            }
            else {
                this.arr[nElements] = element;
                nElements++;
                if(this.isFull())
                {
                    this.storeResults();
                    this.displayResults();
                }
            }


        }
        private void storeResults() {// store each element in the 'arr' with their occurrence to 'rd'
            // fill the code
            int objCount = 0;
            for(int i=0;i<nElements;i++)
            {
                boolean isHaved = false;
                for (int p = 0 ; p<i ; p++)
                {
                    if(arr[p].equals(arr[i]))
                    {
                        isHaved = true;
                        break;
                    }
                }
                if(isHaved==false)
                {
                    int counts = 0;
                    for(int j=0;j<nElements;j++)
                    {

                        if(arr[i].equals(arr[j]))
                        {
                            counts++;
                        }

                    }
                    this.rd[objCount] = new ResultData1(arr[i]);
                    this.rd[objCount].count = counts;
                    objCount++;
                }

            }


        }
        private void displayResults() {
            // display all the data in 'rd' in the format of 'element->occurrence' (eg: A->3)
            // fill the code
            for (int i = 0 ; i<this.rd.length-1;i++)
            {
                if(this.rd[i]==null)
                {
                    return;
                }
                System.out.println(this.rd[i].name+" -> "+this.rd[i].count);
            }

        }
    }
    class ResultData1 {// this class is used to save the element with their occurrence
        String name; // name of the element
        int count; // occurrence of the element
        ResultData1(String name) { // default constructor
            this.name = name;
            this.count = 0;
        }
    }

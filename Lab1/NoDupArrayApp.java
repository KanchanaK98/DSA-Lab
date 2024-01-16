package Lab1;

public class NoDupArrayApp {
    public static void main(String[] args) {
        //use the class NoDupArray and its methods
        //Fill the body
        NoDupArray n = new NoDupArray(5);
        n.insert(1);
        n.insert(2);
        n.insert(3);
        n.insert(4);
        n.insert(5);

        n.display();

        n.delete(3);
    }

}

class NoDupArray {
    private long[] a;//ref to array a
    private int nEliments;//number of data items
    public NoDupArray(int max) {//constructor
        this.a = new long[max];
        this.nEliments = 0;
    }
    public boolean find(long SearchKey) {//find specified value
        for(int i=0;i<nEliments;i++)
        {
            if(a[i]==SearchKey)
            {
                return true;
            }
        }
        return false;
    }
    public void insert(long value) {//put element into array
        try{
            if(find(value))
            {
                System.out.println("Value is already in there");
            }else{
                this.a[this.nEliments] = value;
                this.nEliments++;
            }
        }catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array size is exceeded!");
        }

    }
    public boolean delete(long value) {//delete the element if it found
        if(nEliments == 0 )
        {
            System.out.println("Array is empty so that deletion terminated");
            return false;
        }
        for (int i=0;i<nEliments;i++)
        {
            if(a[i] == value)
            {
                for(int j=(i+1);j<nEliments;j++)
                {
                    a[j-1] = a[j];

                }
                nEliments--;
                System.out.println("value is deleted");
                return true;
            }
        }
        System.out.println("value is not deleted");
        return false;
    }
    public void display() {//display array contents
        for(int i=0;i<nEliments;i++)
        {
            System.out.printf(a[i]+" ");
        }
    }
}


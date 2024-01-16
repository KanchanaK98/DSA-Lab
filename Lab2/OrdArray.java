package Lab2;

 class Activity {
    public static void main(String[] args) {
        OrdArray o = new OrdArray(10);
        o.insert(1);
        o.insert(3);
        o.insert(5);
        o.insert(8);
        o.insert(9);
        o.insert(6);
        o.insert(7);
        o.delete(5);
        o.display();
    }
    
}

class OrdArray {
    private long[] a; // ref to array a
    private int nElements; //number of data items

    public OrdArray(int max) {
        //Fill the body
        this.a = new long[max];
        this.nElements = 0;
    }

    public int size() { // return max size of the array
        //Fill the body
        return this.a.length;

    }

    public int find(long searchKey) {
        //Fill the body
        for (int i = 0; i < nElements; i++) {
            if (searchKey == this.a[i]) {
                return i;
            }
        }
        return -1;
    }

    public void insert(long value) { // put element into arrray
        //Fill the body
        if(nElements==size())
        {
            System.out.println("Arrat is full. You cannot insert!");
            return;
        }
        for (int i = 0; i < nElements; i++) {
            if (a[i] > value) {
                for(int j=nElements-1;j>=i;j--)
                {
                    a[j + 1] = a[j];
                }
                a[i]=value;
                nElements++;
                return;

            }

        }
        a[nElements] = value;
        nElements++;
    }

    public boolean delete(long value) {
        //Fill the body
        int index = find(value);
        if(index!=-1)
        {
            for(int i=index;i<nElements;i++)
            {
                a[i]=a[i+1];
            }
            nElements--;
            return true;
        }
        System.out.println("Nothing to delete");
        return false;

    }

        void display () { // display array contents
            //Fill the body
            for (int i = 0; i <nElements; i++) {
                System.out.printf(a[i] + " ");
            }
        }

}


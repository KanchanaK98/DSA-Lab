import java.sql.Array;
import java.util.Scanner;
public class TakeHomeExcercise1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.printf("Enter memory size: ");
        int size = input.nextInt();
        Arrays a = new Arrays(size);
        a.insert();
    }

}
class Arrays
{
    Scanner input=new Scanner(System.in);
    int size;
    String[] Arr;
    int i;
    Arrays(int size)
    {
        this.size = size;
        this.Arr = new String[size];
    }
    public void insert()
    {

        for (i=0 ; i<size ; i++){
            System.out.printf("Enter data(type 'e' for end): ");
            this.Arr[i] = input.next();
        }
        print();

    }
    public void repeatInsert()
    {

            System.out.printf("Enter data(type 'e' for end): ");
            String letter = input.next();
            if(letter.compareToIgnoreCase("e") == 0)
            {
                System.out.println("Good Bye");
                return;
            }else
            {
                push(letter);
            }

    }
    public void print()
    {
        for (int j=0 ; j<size ; j++)
        {

            int check = isPrevious(this.Arr[j],j);
            if (check==1)
            {
                int count = 0;
                for (int p=j;p<size;p++)
                {
                    if (this.Arr[p].equals(this.Arr[j])){
                        count++;
                    }
                }
                System.out.printf(this.Arr[j]+"->"+count+" ");
            }


        }
        System.out.println();
        repeatInsert();
    }
    public void push(String letter)
    {
        for(int i=0;i<size-1;i++)
        {
            this.Arr[i]=this.Arr[i+1];
        }
        this.Arr[size-1]=letter;
        print();
    }
    public int isPrevious(String letter, int position)
    {
        for(int i=0;i<position;i++)
        {
            if(this.Arr[i].equals(letter))
            {
                return 0;
            }
        }
        return 1;
    }
}

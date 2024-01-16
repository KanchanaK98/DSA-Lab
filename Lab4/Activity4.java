package Lab4;

import java.util.Scanner;

public class Activity4 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.printf("Enter the term : ");
        int num = input.nextInt();
        int ans = fibonaci(num);
        System.out.println("Answer : "+ans);
    }

    public static int fibonaci(int num)
    {
        if(num==0)
        {
            return 0;
        }
        if (num==1)
        {
            return 1;
        }
        return fibonaci(num-2) + fibonaci(num-1);
    }
}

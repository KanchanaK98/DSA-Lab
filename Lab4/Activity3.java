package Lab4;

import java.util.Scanner;

public class Activity3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.printf("Enter num 1 : ");
        int num1 = input.nextInt();
        System.out.printf("Enter num 2 : ");
        int num2 = input.nextInt();
        int ans = multiply(num1,num2);
        System.out.println("Answer : "+ans);
    }
    public static int multiply(int num1,int num2)
    {
        if(num2==1)
        {
            return num1;
        }
        return num1 + multiply(num1,(--num2));
    }
}

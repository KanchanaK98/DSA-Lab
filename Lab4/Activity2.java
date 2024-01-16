package Lab4;

import java.util.Scanner;

public class Activity2 {
    public static void main(String[] args) {

            Scanner input=new Scanner(System.in);
            System.out.printf("Enter number : ");
            int num = input.nextInt();
            int ans = recursive(num);
            System.out.println(ans);
    }

        public static int recursive(int num)
        {
            if(num==1)
            {
                return 1;
            }
            return num*recursive(num-1);
        }

}

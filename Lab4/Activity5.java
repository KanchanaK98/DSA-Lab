package Lab4;

public class Activity5 {
    public static void main(String[] args) {
        Activity5 a = new Activity5();
        a.SolveHanoi(3,'A','B','C');
    }

//                                  from, middle, to
    public void SolveHanoi(int n, char A, char B, char C){
        if(n==0)
        {
            return;
        }
        SolveHanoi(n-1,A,C,B);
        System.out.println("Move "+n+" plate to "+A+" to "+ C);
        SolveHanoi(n-1,B,A,C);

    }
}

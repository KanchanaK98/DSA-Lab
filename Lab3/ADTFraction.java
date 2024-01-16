package Lab3;

public class ADTFraction {
    private int n; //numerator
    private int d; //denominator
    //---------------------------------------------------
    public ADTFraction() {//default constructor
//fill the body
        this.n=0;
        this.d=1;
    }
    //---------------------------------------------------
    public ADTFraction(int a, int b) {//parameter constructor
//fill the body
        if(b!=0)
        {
            this.n=a;
            this.d=b;
        }else
        {
            this.n=0;
            this.d=1;
            System.out.println("Denominator cannot be zero!!!");
        }
        //set(a,b);

    }
    //---------------------------------------------------
    public void set(int a, int b) {//set numerator and denominator
//fill the body
        if(b!=0)
        {
            this.n=a;
            this.d=b;
        }else
        {
            this.n=0;
            this.d=1;
            System.out.println("Denominator cannot be zero!!!");
        }
    }
    //---------------------------------------------------
    public ADTFraction plus(ADTFraction x) {//add two fractions
        //fill the body
        int num,den,lcm;
        lcm = (x.d > this.d) ? x.d  : this.d;
        while(true) {
            if( lcm % x.d == 0 && lcm % this.d == 0 ) {

                break;
            }
            ++lcm;
        }
        num=(lcm/this.d)*this.n + (lcm/x.d)*x.n;
        den=lcm;
//        this.n=num;    return type should be an object of this class
//        this.d=den;
        ADTFraction answer = new ADTFraction(num,den);  //return new ADTFraction(num,den)   then no need to below return
        return answer;

    }
//---------------------------------------------------

    public ADTFraction times(int a) {//multiply fraction by a number
        //fill the body
        int num,den;
        num = this.n*a;
        den = this.d;
        ADTFraction answer = new ADTFraction(num,den);  //return new ADTFraction(num,den)
        return answer;
    }
    //---------------------------------------------------

    public ADTFraction times(ADTFraction x) {//multiply two fractions
        //fill the body
        int num,den;
        num = this.n*x.n;
        den = this.d*x.d;
        return new ADTFraction(num,den);
    }
    //---------------------------------------------------
    public ADTFraction reciprocal() {//reciprocal of a fraction means exchange up and down numbers
        //fill the body
        return new ADTFraction(this.d,this.n);
    }
    //---------------------------------------------------
    public float value() {//numerical value of a fraction
        //fill the body
        float val = (float)(this.n/this.d);
        return val;

    }
    //---------------------------------------------------
    public void display() {//display the fraction in the format n/d
        //fill the body
        System.out.println(this.n+"/"+this.d);
    }
//---------------------------------------------------

    public void refine() {//set the instance to its minimum fraction
        //fill the body
        //For instance, if this fraction is 12/30, change it to 2/5.
        int min = (this.n<this.d)?this.n:this.d;
        int i=1;
        while(true)
        {
            if((this.n%i)==0&&(this.d%i)==0)
            {
                this.n = this.n/i;
                this.d = this.d/i;
            }
            i++;
            if(i==min)
            {
                break;
            }
        }
    }
}

class Main
{
    public static void main(String[] args) {
        ADTFraction a=new ADTFraction();
        a.set(12,30);
        a.display();
        ADTFraction a1=new ADTFraction(12,15);
        a1.display();
        ADTFraction a3= a1.plus(a);
        a3.display();
        a3.refine();
        a3.display();
        ADTFraction a4=a3.times(3);
        a4.display();
        ADTFraction a5=a.reciprocal();
        a5.display();
        ADTFraction a6=a5.times(a1);
        a6.display();
    }
}

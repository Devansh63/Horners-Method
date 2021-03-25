import java.util.*;
import java.util.Scanner;
import java.lang.Math;

class Main{
    public static ArrayList<Double> polynomial = new ArrayList<Double>();
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER THE POLYNOMIAL");
        int Counter =0;
        do{
            try {
                polynomial.add(scanner.nextDouble());
                //System.out.println("Test.");
                Counter++;
                //System.out.println(Polynomial.size());
            } catch(Exception e) {
                System.out.println("ERROR: Please enter the polynomial again");
                System.exit(0);
            }
        }
        while(Counter<9);
       // System.out.println("Test1.");
        int i = 0;
        //System.out.println("Testxnc.");
        double x = polynomial.get(polynomial.size()-1);
        System.out.println(x);
        System.out.println(polynomial.size());
        double ExponentX = polynomial.get(0);
        double temp = newtonsMethod(i, x, ExponentX);
    }
   

    static ArrayList<Double> differentiating(ArrayList<Double> polynomial){
        ArrayList<Double> differentiatedList = new ArrayList<Double>();
        System.out.println();
        int i;
        for(i = 0; i < polynomial.size()-2; i += 2){
//            System.out.println(enteredPoly.get(i+1));
//            System.out.println(differentiating.size());
            if((polynomial.get(i+1) != 0) ){
               // System.out.println("Test3");
                System.out.println();
                differentiatedList.add( polynomial.get(i) * polynomial.get(i+1));
                differentiatedList.add( polynomial.get(i+1) - 1);
//              differentiating.set(i, polynomial.get(i) * polynomial.get(i+1));
//              differentiating.set(i+1, polynomial.get(i+1) - 1);
            }
        }
        System.out.println(differentiatedList.size());
        differentiatedList.set(differentiatedList.size()-1, polynomial.get(polynomial.size()-1));
        return differentiatedList;
    }

    static double hornersMethod(ArrayList<Double> Polynomial, double x){
        double B = Polynomial.get(0);
        int n = Polynomial.get(1).intValue();
        System.out.print("B" + n + ": " + B);
        int i = 2;
        for (int in = n-1; in >= 0 && i < Polynomial.size(); in--){
            B = B*x;
            if(Polynomial.get(i+1) == in){
                B += Polynomial.get(i);
                i += 2;
            }
            System.out.print(" B" + in + ": " + B);
        }
        return B;
    }

    static double newtonsMethod(int i, double x, double ExponentX){
        i++;
        System.out.println("---------------------------------");
        System.out.println("\n\nPresenting Iteration: " + i );
        System.out.println("The X will  X:" + x);

        System.out.println("\nThe polynomial is P(): ");
        double horner = hornersMethod(polynomial, x);
        System.out.println("\nP(" + x + ") = " + horner);

        System.out.println("\nP'()");
        double differentiatedHorner = hornersMethod(differentiating(polynomial), x);
        System.out.println("\nP'(" + x + ") = " + differentiatedHorner);

        ExponentX = x - (horner/differentiatedHorner);
        if(i < 10 && Math.abs(x - ExponentX) > .0001) {
            ExponentX = newtonsMethod(i, ExponentX, x);
        }
        return ExponentX;
    }
}
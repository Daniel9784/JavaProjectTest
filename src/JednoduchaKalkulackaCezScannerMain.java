
import java.util.Scanner;

public class JednoduchaKalkulackaCezScannerMain {

    public static void main(String[] args) {


        Scanner scn = new Scanner(System.in);

        System.out.println("Zadaj prvé číslo");
        double a = scn.nextDouble();

        System.out.println("Zadaj druhé číslo");
        double b = scn.nextDouble();


        System.out.println("Výsledok pri sčítaní: " + scitanie(a,b)+
                           "\nVýsledok pri odčítaní: " + odcitanie(a,b)+
                           "\nVýsledok pri násobení: " + nasobenie(a,b)+
                           "\nVýsledok pri delení: " + delenie(a,b)+
                           "\nVýsledok pri modulo: " + modulo(a,b)+
                           "\nObsah obdĺžnika: " + obsah(a,b)+ " m²"+
                           "\nObvod obdĺžnika: " + obvod(a,b)+ " m"
);
    }
    public static double scitanie(double a, double b){
        return a+b;
    }
    public static double odcitanie(double a, double b){
        return a-b;
    }
    public static double nasobenie(double a, double b){
        return a*b;
    }
    public static double delenie(double a, double b){
        return a/b;
    }
    public static double modulo(double a, double b){
        double c = a%b;
        return c;
    }
    public static double obsah(double a, double b){
        return a*b;
    }
    public static double obvod(double a, double b){
        return 2*(a+b);
    }
 /*   public static void scitovanie(double a, double b){
        double scitovanie = a * b;
        System.out.println(scitovanie);

    }*/
}

public class JednoduchaKalkulackaMain {

    public static void main(String[] args) {
        double a = 6.5;
        double b = 5.5;
  //      double vysledok = a + b;

  //      System.out.printf("Výsledok sčítania %d a %d je %d \n", a, b, a + b);
  //      System.out.println("Výsledok sčítania "+ a +" a "+ b +" je "+ vysledok);

        System.out.println("Výsledok pri sčítaní:" + scitanie(a,b)+
                           "\nVýsledok pri odčítaní:" + odcitanie(a,b)+
                           "\nVýsledok pri násobení:" + nasobenie(a,b)+
                           "\nVýsledok pri delení:" + delenie(a,b)+
                           "\nVýsledok pri modulo:" + modulo(a,b)
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
}

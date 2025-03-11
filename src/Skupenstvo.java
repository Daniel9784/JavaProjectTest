import java.util.Scanner;

public class Skupenstvo {


    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);


        System.out.println("Zadajte nameranú teplotu vody");

        int teplotaVody = Integer.parseInt(scr.nextLine());
        double teplotaFahrenheit = (teplotaVody * 9.0 / 5.0) + 32;

        if (teplotaVody < 0) {
            System.out.println("Skupenstvo je pevné: " + teplotaVody + " °C / " + teplotaFahrenheit + " °F");

        } else if (teplotaVody >= 0 && teplotaVody <= 100) {
            System.out.println("Skupenstvo je kvapalné: " + teplotaVody + " °C / " + teplotaFahrenheit + " °F");

        } else if (teplotaVody > 100) {
            System.out.println("Skupenstvo je plynné: " + teplotaVody + " °C / " + teplotaFahrenheit + " °F");

        } else {
            System.out.println("Zadal si niečo iné!");
        }

        scr.close();
    }

}

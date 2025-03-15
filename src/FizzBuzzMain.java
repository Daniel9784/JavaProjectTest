
/*
Fizz buzz je skupinová slovná hra pre deti, ktorej účelom je naučiť ich delenie čísel. Hráči postupne vymenúvajú čísla, pričom nahrádzajú každé číslo deliteľné tromi slovom "fizz" a každé číslo deliteľné piatimi slovom "buzz".
Zdroj: https://sk.wikipedia.org/wiki/Fizz_buzz
*/
public class FizzBuzzMain {
    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            if (i % 3 == 0) System.out.print("Fizz, ");
            if (i % 5 == 0) System.out.print("Buzz, ");
            if (i % 3 != 0 && i % 5 !=0)
                System.out.print(i + ", ");
        }
    }
}
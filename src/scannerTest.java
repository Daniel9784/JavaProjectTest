import java.util.Scanner;

public class scannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zadajte vek: ");
        int vek = Integer.parseInt(scanner.nextLine());
        System.out.print("Zadajte meno: ");
        String meno = scanner.nextLine();
        System.out.println("Vek: " + vek);
        System.out.println("Meno: " + meno);
        scanner.close();
    }
}
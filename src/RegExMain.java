import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegExMain {
    public static void main(String[] args) {
        // Regulárny výraz pre jednoduché overenie e-mailu
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        // Testovacia e-mailová adresa
        String email = "test@example.com";

        // Vytvorenie Pattern objektu
        Pattern pattern = Pattern.compile(regex);

        // Vytvorenie Matcher objektu
        Matcher matcher = pattern.matcher(email);

        // Overenie, či e-mail zodpovedá vzoru
        if (matcher.matches()) {
            System.out.println("E-mail je platný.");
        } else {
            System.out.println("E-mail nie je platný.");
        }
    }
}
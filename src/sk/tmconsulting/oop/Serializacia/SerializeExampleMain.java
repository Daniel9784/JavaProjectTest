package sk.tmconsulting.oop.Serializacia;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeExampleMain {
    public static void main(String[] args) {
        try {
            // Vytvorenie objektu
            Person person = new Person("Ján", 45);

            // Uloženie do súboru
            FileOutputStream fileOut = new FileOutputStream("person.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);

            out.close();
            fileOut.close();

            System.out.println("Objekt bol serializovaný do person.ser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

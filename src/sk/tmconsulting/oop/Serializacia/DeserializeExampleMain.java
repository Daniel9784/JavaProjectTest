package sk.tmconsulting.oop.Serializacia;


import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeExampleMain {
    public static void main(String[] args) {
        try {
            // Načítanie objektu zo súboru
            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Person person = (Person) in.readObject();
            in.close();
            fileIn.close();

            System.out.println("Objekt bol deserializovaný:");
            person.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

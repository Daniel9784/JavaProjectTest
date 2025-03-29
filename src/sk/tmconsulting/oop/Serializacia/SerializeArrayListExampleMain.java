package sk.tmconsulting.oop.Serializacia;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializeArrayListExampleMain {
    public static void main(String[] args) {
        try {
            // Vytvorenie objektu
            Person person1 = new Person("Ján", 45);
            Person person2 = new Person("Zuzana", 40);
            Person person3 = new Person("Ivan", 20);

            ArrayList <Person> people = new ArrayList<>(); // Vytvorili sme prazdny zoznam osob
            people.add(person1);
            people.add(person2);
            people.add(person3);

            // Uloženie do súboru
            FileOutputStream fileOut = new FileOutputStream("people.obj");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(people);

            out.close();
            fileOut.close();

            System.out.println("Zoznam osôb bol uložený (serializovaný) do people.obj");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



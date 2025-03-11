package sk.tmconsulting.greetings;
import sk.tmconsulting.greetings.slovak.*;
import sk.tmconsulting.greetings.english.englishGreetings;
import sk.tmconsulting.greetings.german.germanGreetings;
import sk.tmconsulting.greetings.hungarian.hugnarianGreetings;

public class Main {
    public static void main(String[] args) {

        englishGreetings.sayHello();
        germanGreetings.sayHello();
        hugnarianGreetings.sayHello();
        slovakGreetings.sayHello();
    }
}

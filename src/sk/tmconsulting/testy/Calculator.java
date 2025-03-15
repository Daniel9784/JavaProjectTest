package sk.tmconsulting.testy;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

 //    Toto je navyse len sa skusaju ine veci.
    public static void main(String[] args) {

 //    Vytvorili sme objekt Calculator, ktory je ulozeny v premmennej calculatorObject. Inymi slovami vytvorili sme instanciu objektu Calculator.
        Calculator calculatorObject = new Calculator();

        System.out.println(calculatorObject.add(2, 3));

        Calculator calculatorObject2 = new Calculator();
        System.out.println(calculatorObject2.add(5, 8));
    }
}

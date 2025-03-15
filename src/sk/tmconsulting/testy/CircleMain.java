package sk.tmconsulting.testy;

public class CircleMain {

    private double radius;


    public double calculateArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public double calculateCircumference(double radius) {
        return 2 * Math.PI * radius;
    }


}
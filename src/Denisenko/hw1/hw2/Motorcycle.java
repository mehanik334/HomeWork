package Denisenko.hw1.hw2;


/*
Nested class
 */
public class Motorcycle {

    private int number;
    private Wheel wheel= new Wheel(3,18);

    public Motorcycle(int number, Wheel wheel) {
        this.number = number;
        this.wheel = wheel;
    }

    private class Wheel{

        private int numberWheels;
        private int radiusWheel;

        public Wheel(int numberWheels, int radiusWheel) {
            this.numberWheels = numberWheels;
            this.radiusWheel = radiusWheel;
        }
    }



}

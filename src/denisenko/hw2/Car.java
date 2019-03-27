package denisenko.hw2;


/*
Inner class
 */
public class Car {

    private String number;
    private String vehicle;
    private String brandCar;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public Car(String number, String vehicle) {
        this.number = number;
        this.vehicle = vehicle;
    }

    public static class Audi extends Car{

        public Audi(String number, String vehicle) {
            super(number, vehicle);
            setBrandCar("AUDI");
        }
    }

    public static class BMW extends Car{

        public BMW(String number, String vehicle) {
            super(number, vehicle);
            setBrandCar("BMW");
        }

    }
}


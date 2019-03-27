package denisenko.hw2;


/**
 * Class example for design pattern BUILDER
 */
public class MyCar {

    private String regNumber;
    private String yearManufacture;
    private String firstRegistration;
    private String owner;
    private String modelCar;
    private String bodyType;


    public MyCar(CarBuilder carBuilder) {
        this.regNumber = carBuilder.regNumber;
        this.yearManufacture = carBuilder.yearManufacture;
        this.firstRegistration = carBuilder.firstRegistration;
        this.owner = carBuilder.owner;
        this.modelCar = carBuilder.modelCar;
        this.bodyType = carBuilder.bodyType;
    }


    public static class CarBuilder {

        private String regNumber;
        private String yearManufacture;
        private String firstRegistration;
        private String owner;
        private String modelCar;
        private String bodyType;

        public CarBuilder(String regNumber) {
            this.regNumber = regNumber;
        }

        public CarBuilder setYearManufacture(String yaer) {
            this.yearManufacture = yaer;
            return this;
        }

        public CarBuilder atFirstReg(String date) {
            this.firstRegistration = date;
            return this;
        }

        public CarBuilder withOwner(String nameOwner) {
            this.owner = nameOwner;
            return this;
        }

        public CarBuilder atModelCar(String model) {
            this.modelCar = model;
            return this;
        }

        public CarBuilder setBodyType(String body) {
            this.bodyType = body;
            return this;
        }

        public MyCar build() {
            return new MyCar(this);
        }


    }

    public static void main(String[] args) {
        MyCar c = new CarBuilder("1234")
                .atFirstReg("12/03/2019")
                .atModelCar("Ferrari")
                .setBodyType("sport")
                .setYearManufacture("2019")
                .withOwner("I").build();
    }
}

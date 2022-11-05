public class Volkswagen extends Car{
    final String model;
    float carMileage;

    public Volkswagen(String color, String type, int maxSpeed,int currentSpeed,float price,String model,float carMileage) {
        super(color, type, maxSpeed, currentSpeed,price);
        this.model = model;
        this.carMileage = 0;
    }
    public String getModel(){
        return this.model;
    }
    public String getFullName(){
        return "Volkswagen " + this.model;
    }
    public float getCarMileage(){
        return carMileage;
    }
    public void addCarMileage(float mileage){
        this.carMileage += mileage;
    }
}

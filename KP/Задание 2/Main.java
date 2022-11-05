public class Main {
    public static void main(String[] args) {

        // Car(String color, String type, int maxSpeed,int currentSpeed,float price){
        Lada tesla = new Lada("red", "auto", 120, 20, 5000000f,"Rfkbyf");
        Volkswagen Volk = new Volkswagen("red", "auto", 120, 20, 5000000f,"1234567",45.8f);
        Garage garage = new Garage(5,2);

        garage.addCar(tesla);
        garage.addCar(Volk);
        garage.addCar(new Lada("red", "auto", 120, 20, 5000000f,"Cedan"));
        garage.getCarsByAmount();
    }
    }

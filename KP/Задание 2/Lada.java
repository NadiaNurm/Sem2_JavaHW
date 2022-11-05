public class Lada extends Car {
    final String model;
    float age;

    public Lada(String color, String type, int maxSpeed,int currentSpeed,float price,String model) {
        super(color, type, maxSpeed, currentSpeed,price);
        this.model = model;
    }
    public String getModel(){
        return this.model;
    }
    public String getFullName(){
        return "Lada " + this.model;
    }

    public void setAge(float age){
        this.age = age;
    }
    public float getAge(){
        return this.age;
    }
}

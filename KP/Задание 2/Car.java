public abstract class Car {
    final String color;
    final String type;
    final int maxSpeed;
    int currentSpeed;
    float price;

    Car(String color, String type, int maxSpeed,int currentSpeed,float price){
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.type = type;
        this.currentSpeed = currentSpeed;
        this.price = price;
    }

    public int getCurrentSpeed(){
        return this.currentSpeed;
    }

    public void stop(){
        this.currentSpeed=0;
    }
    //Когда мы вызываем метод старт, он возвращает true, что значт, мотор включен
    public boolean start(){
        return true;
    }
    public void accelerate(int speed){
        if (speed + currentSpeed <= maxSpeed && start()){
            this.currentSpeed = currentSpeed + speed;
        }
        else {this.currentSpeed=maxSpeed;}
    }

}


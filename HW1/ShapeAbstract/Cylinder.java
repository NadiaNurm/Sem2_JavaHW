public class Cylinder extends SolidOfRevolution{
    double height;

    Cylinder (double radius,double height) {
        super(Math.PI * Math.pow(radius,2) * height, radius);
        this.height = height;
    }
}

public class SolidOfRevolution extends Shape {
        double radius;
    SolidOfRevolution(double volume,double radius) {
        super(volume);
        this.radius = radius;
    }

    public double getRadius() throws VolumeException {
        if (radius <= 0) {
            throw new VolumeException("Объем/радиус должен быть положительным!");
        }
        return radius;
    }
}

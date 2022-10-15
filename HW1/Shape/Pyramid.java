public class Pyramid extends Shape{
    double s;
    double h;

    Pyramid(double s, double h) {
        super((4*h*s)/3);
        this.s = s;
        this.h = h;
    }
}

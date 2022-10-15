public class Main {
    public static void main(String[] args) throws VolumeException {

        Shape s = new Shape(10);
        //Shape s = new Shape(-10);
        System.out.println("Объем фигуры");
        System.out.println(s.getVolume());
        System.out.println("Объем и радиус фигуры из SolidOfRevolution");
        SolidOfRevolution my_s = new SolidOfRevolution(5,1);
        System.out.println("Объем: " + my_s.getVolume());
        System.out.println("Радиус: " + my_s.getRadius());
        Pyramid p = new Pyramid(4,5);
        System.out.println("Объем пирамиды");
        System.out.println(p.getVolume());
        //Cylinder c = new Cylinder(10,0);
        Cylinder c = new Cylinder(10,3);
        System.out.println("Объем цилиндра");
        System.out.println(c.getVolume());
        Ball b = new Ball(5);
        System.out.println("Объем и радиус шара");
        System.out.println("Объем: " + b.getVolume());
        System.out.println("Радиус: " + b.getRadius());
        System.out.println("Коробка");
        Box box = new Box(1000);
        System.out.println(box.Fill_box(b));
        System.out.println(box.Fill_box(c));
        System.out.println(box.Fill_box(p));

    }
}
import java.util.ArrayList;
import java.util.Arrays;

public class Box extends Shape{
    double max_volume;
    ArrayList<Shape> shape_list = new ArrayList<>();

    Box(double max_volume) {
        super(max_volume);
        this.max_volume = max_volume;
        }

    public boolean Fill_box(Shape shape) {
        try {
            if (max_volume >= shape.getVolume()) {
                shape_list.add(shape);
                max_volume -= shape.getVolume();
                return true;
            }
        } catch (VolumeException e) {
        }
        return false;
    }
}


import java.util.*;
import java.util.stream.Collectors;

public class Garage {
    final int available;
    int currentAmount;
    ArrayList<Car> cars = new ArrayList<>();

    public Garage(int available,int currentAmount) {
        this.available = available;
        this.currentAmount = 0;
    }
    public void addCar(Car car){
        if (currentAmount < available){
        cars.add(car);
        currentAmount+=1;
    }
    }
    //Получение списка автомобилей, отсортированных по количеству в гараже
    public void getCarsByAmount(){
        HashMap<Class, Integer> cars_dict = new HashMap<>();
        for (Car i : cars) {
            if (cars_dict.containsKey(i.getClass())){
                cars_dict.put(i.getClass(), cars_dict.get(i.getClass()) + 1);
            }
            else {
                cars_dict.put(i.getClass(), 1);
            }
        }
        Set<Class> keys = cars_dict.keySet();
        System.out.println(keys);
        // Итерируем по ключам и выводим в консоль
        for (Class key : keys) {
            System.out.println(key.getName() + " : " + cars_dict.get(key));
        }
        //SortedSet<Integer> sorted_cars = new TreeSet<>(cars_dict.values());
        //System.out.println(sorted_cars);
        }
        }



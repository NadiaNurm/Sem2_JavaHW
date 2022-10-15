public class Shape {
    double volume;

    Shape(double volume) {
        this.volume = volume;
    }
    //Если пользователь хочет ввести число, меньшее или равное 0, мы инициализируем ошибку
    public double getVolume() throws VolumeException {
        if (volume<=0) {
            throw new VolumeException("Объем/радиус должен быть положительным!");
        }
        return volume;
    }
}


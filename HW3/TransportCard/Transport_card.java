import java.time.LocalDate;

public class Transport_card {
    final int id;
    double balance; // Баланс карты
    int tripNum; // Количество доступных поездок
    String type; // Тип карты
    double payMonth; // Сколько нужно платить в месяц, в зависимости от типа карты
    int payTrip; // Сколько стоит одна поездка, в зависимости от типа карты
    LocalDate addDay; // День, когда была оплата на месяц

    public Transport_card(int id,String type) {
        this.id = id;
        this.balance = 0;
        this.tripNum = 0;
        this.type = type;
        //Фиксируем олату в месяц и поразово в зависимости от типа карты
        switch (type){
            case "Студенческая":
                this.payMonth = 458.99;
                this.payTrip = 45;
                break;
            case "Школьная":
                this.payMonth = 350.99;
                this.payTrip = 40;
                break;
            case "Социальная":
                this.payMonth = 288.99;
                this.payTrip = 40;
                break;
            case "Поразовая":
                this.payMonth = 0;
                this.payTrip = 55;
                break;
        }
    }

    // Пополняем баланс и фиксируем дату пополнения
    public void addBalance(double add){
        balance += add;
        addDay = LocalDate.now();
    }

    // Добавляем поездки
    public void addTrips(double add){
        if (add%payTrip==0){
        tripNum += add/payTrip;}
    }
    public void lowTrips(){
        tripNum -= 1;
    }
    //когда прошел месяц, баланс обнуляется.
    public void zeroBalance(){
       balance = 0;
    }
    public void lowBalance(int amount){
        balance -= amount;
    }
    public double checkBalance(){
        return balance;
    }
    public double checkTrips(){
        return tripNum;
    }
    //Если прошел месяц, то мы списываем сумму за месяц
    public void checkMonth(LocalDate date){
        if(date.minusMonths(1)==addDay){
            zeroBalance();
        }
    }

}

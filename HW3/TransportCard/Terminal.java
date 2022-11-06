import java.time.LocalDate;

public class Terminal {
    int cards; // Сколько прошло по карте
    int passengers; //сколько людей прошло через терминал
    double money; //Сколько денег заработал
    int passes; //Кол-во поштучных поездок

    public Terminal(){
        this.cards = 0;
        this.passengers = 0;
        this.money = 0;
        this.passes = 0;
    }
    //Проверяем,можно ли человеку пройти
    public boolean canGo(Transport_card card){
        LocalDate today = LocalDate.now();
        card.checkMonth(today);
        if (card.type!="Поразовая"){
            if (card.checkBalance()<card.payMonth){
                if (card.checkTrips()<1){
                    return false;}
                else{
                    card.lowTrips();
                    this.passes +=1;
                    this.money += card.payTrip;
                    return true;}
            }
        }
        else{
            if(card.checkBalance()<card.payTrip && card.checkTrips()<1){return false;}
            if(card.checkBalance()>card.payTrip && card.checkTrips()>=1){
                card.lowTrips();
                this.passes +=1;
                this.money += card.payTrip;
                return true;}
            if(card.checkBalance()>card.payTrip && card.checkTrips()<1){
                card.lowBalance(card.payTrip);
                this.cards += 1;
                this.money += card.payTrip;
                return true;}
        }
        this.cards += 1;
        return true;
    }
    //Выводим статистику
    public void statistics(){
        this.passengers = this.cards + this.passes;
        System.out.println("Всего пассажиров: " + this.passengers);
        System.out.println("Всего прошло по карте: " + this.cards);
        System.out.println("Всего денег заработал: " + this.money);
        System.out.println("Всего поштучных поездок: " + this.passes);
    }
}

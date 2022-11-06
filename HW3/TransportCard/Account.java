import java.util.Scanner;
//Все тоже самое,что и для банкомата
public class Account {

    public Account(){}
    //Производим пополнение карты
    static void fillCard(Transport_card card){
        Scanner in = new Scanner(System.in);
        System.out.println("Если вы хотите пополнить баланс,нажмите 1. \nЕсли вы хотите купить поездки,нажмите 2.");
        int num = in.nextInt();
        if (num == 1){
            if (card.type!="Поразовая"){
                System.out.println("Внесите сумму: " + card.payMonth);
                double newBalance = in.nextDouble();
                if(newBalance>= card.payMonth){
                    card.addBalance(newBalance);
                    System.out.println("Ваш текущий баланс: " + card.checkBalance());
                }
                if (newBalance <= card.payMonth) System.out.println("Некорректная сумма.");
            }
            else {
                System.out.println("Внесите сумму");
                card.addBalance(in.nextDouble());
            }
        }
        else if (num == 2){
            System.out.println("Сколько поездок Вы хотите оплатить?");
            int amount = in.nextInt();
            System.out.println("Внесите сумму: " + amount*card.payTrip);
            double newTrips = in.nextDouble();
            if(newTrips == amount*card.payTrip) {
                card.addTrips(newTrips);
                System.out.println("Ваше текущее количество поездок: " + card.checkTrips());
            }
            if (newTrips > amount*card.payTrip || newTrips < amount*card.payTrip) System.out.println("Некорректная сумма.");
        }

}}
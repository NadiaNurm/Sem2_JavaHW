import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        ArrayList<Reader> readers = new ArrayList<>();
        readers.add(new Reader("Нурминская Н.А.", 215831,"ПИ21","09.10.1997", "+79162361184"));
        readers.add(new Reader("Анохина Д.А.", 211413,"ПИ22","16.06.2000","+79165487790"));
        readers.add(new Reader("Добровольский К.П.", 215847,"ИЯ22","02.06.1998","+79156789211"));
        readers.add(new Reader("Сычевский Р.А.", 215846,"ИЯ21","27.01.1997","+79162347698"));
        /*
        int counter = 0;
        for (Reader reader: readers) {
            counter += 1;
            System.out.println("Читатель номер "+ counter);
            reader.getReader();
        }
         */

        readers.get(0).takeBook(4);
        readers.get(1).takeBook(new Book("Пеппи Длинныйчулок", "Астрид Линдгрен"));
        readers.get(2).takeBook(new Book("Га́рри По́ттер и филосо́фский ка́мень", "Дж. К. Роулинг"),
                new Book("Гарри Поттер и Тайная комната", "Дж. К. Роулинг"),new Book("Гарри Поттер и узник Азкабана", "Дж. К. Роулинг"));
        readers.get(3).takeBook("Приключения", "Словарь", "Энциклопедия");
        System.out.println("---------------");
        readers.get(0).returnBook(new Book("Га́рри По́ттер и филосо́фский ка́мень", "Дж. К. Роулинг"));
        readers.get(1).returnBook(5);
        readers.get(2).returnBook("Приключения", "Словарь", "Энциклопедия");

    }

}
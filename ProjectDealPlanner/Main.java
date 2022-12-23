import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
  //  static ArrayList<Deal> dealList; // список, в котором лежат все наши дела

    public static void main(String[] args) throws ParseException, IOException {

        while (true) {
            // мы предлагаем пользователю выбрать команду для исполнения. Пользователь сам отмечает, какое дело он выполнил.
            System.out.println("Что Вы хотите сделать? \n 1 - создать задание \n 2 - выполнить задание \n 3 - удалить задание \n 4 - отредактировать задание" +
                    " \n 5 - посмотреть все задания \n 6 - посмотреть выполненные задания \n 7 - посмотреть невыполненные задания \n 8 - посмотреть все задания на конкретную дату выполнения" +
                    "\n 9 - посмотреть все задания на конкретную дату создания \n 10 - посмотреть детальную информацию о задании");
            String command = in.nextLine();
            // создание задания
            if (command.equals("1")) {
                System.out.println("Запишите название: ");
                String name = in.nextLine();
                System.out.println("Запишите детали: ");
                String details = in.nextLine();
                Deal myDeal = new Deal();
                myDeal.setName(name);
                myDeal.setDetails(details);
                writeToFile(myDeal);
            }
            // отмечаем, что мы его выполнили, и автоматически задается дата выполнения, см. makeDeal(String idMake)
            else if (command.equals("2")) {
                getNameList();
                System.out.println("Укажите id или имя задания, которое хотите выполнить");
                String idMake = in.nextLine();
                if(checkID(idMake)) {makeDeal(idMake);} // если указанное id или имя есть, то мы его выполняем
                else {
                System.out.println("Нет такого задания!");}
            }
            // удаляем задание
            else if (command.equals("3")) {
                getNameList();
                System.out.println("Укажите id или имя задания, которое хотите удалить");
                String idDel = in.nextLine();
                if(checkID(idDel)) {delDeal(idDel);} // если указанное id или имя есть, то мы его удаляем
                else {System.out.println("Нет такого задания!");}
            }
            // редактирование задания. Мы редактируем название и описание
            else if (command.equals("4")) {
                getNameList();
                System.out.println("Укажите id или имя задания, которое хотите отредактировать.");
                String idChange = in.nextLine();
                if(checkID(idChange)){
                    System.out.println("Что вы хотите сделать? \n 1 - изменить имя \n 2 - изменить описание");
                    String change = in.nextLine();
                    System.out.println("Введите новое значение");
                    String newData = in.nextLine();
                    changeDeal(idChange, change, newData);
                }
                else {
                    System.out.println("Нет такого задания!");
                }
            }
            // выводим список всех заданий (для этого читаем последовательно из двух файлов)
            else if (command.equals("5")) {
                System.out.println("Список всех заданий:");
                getAllName();
            }
            // выводим список всех выполненных заданий
            else if (command.equals("6")) {
                System.out.println("Список всех выполненных заданий:");
                getMadeName();
            }
            // выводим список всех невыполненных заданий
            else if (command.equals("7")) {
                System.out.println("Список всех невыполненных заданий:");
                getNameList();
            }
            // другие команды
            else if (command.equals("8") || command.equals("9") || command.equals("10")) {
                System.out.println("Данные функции пока не поддерживаются, но я очень стараюсь!");
            } else {
                System.out.println("Некорректный ввод!");
            }
        }
    }

    public static void writeToFile(Deal deal) throws IOException {
        /*
        Здесь мы записываем наши новые задания. У нас есть файл "id.txt", каждый раз значение из которого увеличивается на 1.
        Если у нас уже есть 5 дел и мы удалили пятое, то следующее дело будет все равно под номером 6
        Далее мы записываем в файл id + все поля нашего экземпляра класса deal.
         */
        FileReader reader = new FileReader("id.txt");
        BufferedReader readBuf = new BufferedReader(reader);
        String s = readBuf.readLine();
        int id = Integer.parseInt(s);
        id += 1;
        deal.setId(id);
        FileWriter writer = new FileWriter("id.txt");
        BufferedWriter buf = new BufferedWriter(writer);
        buf.write(id+"");
        buf.flush(); // изменение кодировки
        FileWriter writer1 = new FileWriter("dealList.txt",true); // дозаписываем наши дела в файл
        BufferedWriter writeBuf = new BufferedWriter(writer1);
        writeBuf.write(returnFormatString(deal));
        writeBuf.newLine();
        writeBuf.flush();
    }


    public static String returnFormatString(Deal deal){ // эта функция нужна, чтобы переделать поля класса в строку через ;
        DateFormat format = new SimpleDateFormat("dd-MM-YYYY", Locale.ENGLISH);
        String stringDate = format.format(deal.getCreateDate());
        return deal.getId() + ";" + deal.getName()+ ";" + stringDate + ";" + deal.getDetails();
    }

    public static void getNameList() throws IOException {
        /*
        Читаем файл с невыполненными заданиями. Выводим id и имя.
         */
        BufferedReader bufReader = new BufferedReader(new FileReader("dealList.txt"));
        String s = "";
        while ((s = bufReader.readLine())!= null){
            String[] newS = s.split(";");
            System.out.println(newS[0] + " - " + newS[1]);
        }
        }

    public static void getAllName() throws IOException {
        /*
         Выводим id и имя из файлов с выполненными и невыполненными заданиями.
         */
        getNameList();
        getMadeName();
    }

    public static void getMadeName() throws IOException {
        /*
        Читаем файл с выполненными заданиями. Выводим id и имя.
         */
        BufferedReader bufReader = new BufferedReader(new FileReader("madeDealList.txt"));
        String s = "";
        while ((s = bufReader.readLine())!= null){
            String[] newS = s.split(";");
            System.out.println(newS[0] + " - " + newS[1]);
        }
    }

    public static void makeDeal(String idMake) throws IOException {
        /*
        Эта функция нужна, чтобы поставить галочку, что дело выполнено.
        Мы получаем на вход id или имя дела, которое хотим отметить выполненным.
        Тогда мы проходим по файлу с невыполненными делами и смотрим id или имя дела. Если оно не совпадает с указанным, то мы это дело перезаписываем в новый файл, который потом переназовем, а старый удалим.
        Если находим нужное нам id, то записываем это дело в файл с выполненными делами. В наш новый его не добавляем.
         */
        File file = new File("dealList.txt");
        File currentFile = new File("currentFile.txt");
        BufferedReader bufReader = new BufferedReader(new FileReader(file));
        BufferedWriter bufWriter1 = new BufferedWriter(new FileWriter(currentFile));
        BufferedWriter bufWriter2 = new BufferedWriter(new FileWriter("madeDealList.txt",true));
        String s = "";
        while ((s = bufReader.readLine())!= null){
            String[] newS = s.split(";");
            if(!(newS[0].equals(idMake) || newS[1].equals(idMake))){
                bufWriter1.write(s);
                bufWriter1.newLine();
                bufWriter1.flush();

            }
            else {
                DateFormat format = new SimpleDateFormat("dd-MM-YYYY", Locale.ENGLISH);
                String stringDate = format.format(new Date());
                bufWriter2.write( s + ";" + stringDate);
                bufWriter2.newLine();
                bufWriter2.flush();
            }
        }

        file.delete();
        currentFile.renameTo(file);
    }

    public static void delDeal(String idDel) throws IOException {
        /*
        Эта функция нужна, чтобы удалить дело.
        Мы получаем на вход id или имя дела, которое хотим удалить.
        Тогда мы проходим по файлу с невыполненными делами и смотрим id или имя дела. Если оно не совпадает с указанным, то мы это дело перезаписываем в новый файл, который потом переназовем, а старый удалим.
        Нужное нам id не добавляем в новый файл.
         */
        File file = new File("dealList.txt");
        File currentFile = new File("currentFile.txt");
        BufferedReader bufReader = new BufferedReader(new FileReader(file));
        BufferedWriter bufWriter1 = new BufferedWriter(new FileWriter(currentFile));
        String s = "";
        while ((s = bufReader.readLine())!= null){
            String[] newS = s.split(";");
            if(!(newS[0].equals(idDel) || newS[1].equals(idDel))){
                bufWriter1.write(s);
                bufWriter1.newLine();
                bufWriter1.flush();
            }
            }
       file.delete();
       currentFile.renameTo(file);
    }

    public static void changeDeal(String idChange, String change,String newData) throws IOException {
        /*
        Эта функция нужна, чтобы отредактировать дело.
        Мы получаем на вход id или имя дела, которое хотим отредактировать, команду, которая указывает, что мы хотим поменять и значение, на которое хотим поменять.
        Тогда мы проходим по файлу с невыполненными делами и смотрим id или имя дела. Если оно не совпадает с указанным, то мы это дело перезаписываем в новый файл, который потом переназовем, а старый удалим.
        Если находим нужное нам id, то записываем его с изменениями.
        1 - изменить имя, 2 - изменить описание
         */
        File file = new File("dealList.txt");
        File currentFile = new File("currentFile.txt");
        BufferedReader bufReader = new BufferedReader(new FileReader(file));
        BufferedWriter bufWriter1 = new BufferedWriter(new FileWriter(currentFile));
        String s = "";
        while ((s = bufReader.readLine())!= null){
            String[] newS = s.split(";");
            if(!(newS[0].equals(idChange) || newS[1].equals(idChange))){
                bufWriter1.write(s);
                bufWriter1.newLine();
                bufWriter1.flush();
            }
            else {
                switch (change){
                    case "1":
                        bufWriter1.write(newS[0]+";"+newData +";"+newS[2]+";"+newS[3]);
                        bufWriter1.newLine();
                        bufWriter1.flush();
                        break;
                    case "2":
                        bufWriter1.write(newS[0]+";"+newS[1] +";"+newS[2]+";"+newData);
                        bufWriter1.newLine();
                        bufWriter1.flush();
                        break;
                    default:
                        System.out.println("Нет такой команды!");
                }
            }
        }
        file.delete();
        currentFile.renameTo(file);
    }

    public static boolean checkID(String id) throws IOException {
        /*
        Здесь мы проверяем, что наш идентификатор или имя вообще есть в списке.
         */
        File file = new File("dealList.txt");
        BufferedReader bufReader = new BufferedReader(new FileReader(file));
        String s = "";
        while ((s = bufReader.readLine())!= null){
            String[] newS = s.split(";");
            if (newS[0].equals(id) || newS[1].equals(id)){
                return true;
            }
        }
        return false;
    }

}


public class Reader {
    String fullName;
    int cardNumber;
    String faculty;
    String birthDate;
    String phoneNumber;
    //конструктор 1
    public Reader(){}
    //конструктор 2
    public Reader(String fullName,int cardNumber,String faculty,String birthDate,String phoneNumber){
        this.fullName = fullName;
        this.cardNumber = cardNumber;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }
    // Выводит в консоль все данные о пользователе библиотеки
    public void getReader(){
        System.out.print("ФИО: " + fullName + '\n'
                + "Номер читательского билета: " + cardNumber + '\n'
                + "Факультет: " + faculty + '\n'
                + "Дата рождения: " + birthDate + '\n'
                + "Номер телефона: " + phoneNumber + '\n');
        }

    //метод, возвращающий окончание для книг(у/и)
    public static String endingBook(int bookNumber){
        switch (bookNumber){
            case 1:
                return " книгy";
            case 2:
            case 3:
            case 4:
                return " книги";
            default:
                 return " книг";
        }
    }
    //метод, возвращающий окончание для взял(а)
    public static String endingName(String fullName,int f){
        String [] s = fullName.split(" ");
        if (s[0].endsWith("а") || s[0].endsWith("ая")){
            if (f == 1){return " взяла";}
            if (f == -1){return " вернула";}
        }
        else {
            if (f == 1){return " взял";}
            if (f == -1){return " вернул";}
    }
        return null;
    }
    // метод, который будет принимать количество взятых книг
    public void takeBook(int bookNumber) {
        System.out.println(this.fullName + Reader.endingName(this.fullName,1) + " " + bookNumber + Reader.endingBook(bookNumber) + ".");
    }
    //метод, который будет принимать переменное количество названий книг
    public void takeBook(String...bookNames){
        String str = "";
        int count = 0;
        for (String name : bookNames) {
            str += name + ",";
            count += 1;
        }
        if(count == 1)
        System.out.print(this.fullName + Reader.endingName(this.fullName,1) + " книгу" + " : ");
        else {System.out.print(this.fullName + Reader.endingName(this.fullName,1) + " книги" + " : ");}
        String strNew = str.substring(0, str.length() - 1);
        System.out.println(strNew + '.');
    }
    //метод, который будет принимать переменное количество объектов класса Book
    public void takeBook(Book...books) {
        String str = "";
        int count = 0;
        for (Book book : books) {
            str += book.getBookName() + ",";
            count += 1;
        }
        if(count == 1)
        System.out.print(this.fullName + Reader.endingName(this.fullName,1) + " книгу" + " : ");
        else {System.out.print(this.fullName + Reader.endingName(this.fullName,1) + " книги" + " : ");}
        String strNew = str.substring(0, str.length() - 1);
        System.out.println(strNew + '.');
    }

    public void returnBook(int bookNumber) {
        System.out.println(this.fullName + Reader.endingName(this.fullName,-1) + " " + bookNumber + Reader.endingBook(bookNumber) + ".");
    }
    public void returnBook(String...bookNames){
        String str = "";
        int count = 0;
        for (String name : bookNames) {
            str += name + ",";
            count += 1;
        }
        if(count == 1)
            System.out.print(this.fullName + Reader.endingName(this.fullName,-1) + " книгу" + " : ");
        else {System.out.print(this.fullName + Reader.endingName(this.fullName,-1) + " книги" + " : ");}
        String strNew = str.substring(0, str.length() - 1);
        System.out.println(strNew + '.');
    }
    public void returnBook(Book...books) {
        String str = "";
        int count = 0;
        for (Book book : books) {
            str += book.getBookName() + ",";
            count += 1;
        }
        if(count == 1)
            System.out.print(this.fullName + Reader.endingName(this.fullName,-1) + " книгу" + " : ");
        else {System.out.print(this.fullName + Reader.endingName(this.fullName,-1) + " книги" + " : ");}
        String strNew = str.substring(0, str.length() - 1);
        System.out.println(strNew + '.');
    }
}

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        hourlyPayment employee1 = new hourlyPayment(215831,"Виктория Бестаева",  350.0);
        monthPayment employee2 = new monthPayment(211413,"Дея Барматина",  70000.0);

        System.out.println(employee1.calculateSalary());
        System.out.println(employee2.calculateSalary());
        //Создаем список работников
        ArrayList<Employee> employeeArray = new ArrayList<>();
        employeeArray.add(employee1);
        employeeArray.add(employee2);
        employeeArray.add(new hourlyPayment(215834,"Нурминская Надежда",  400.0));
        employeeArray.add(new monthPayment(215839,"Анастасия Бовкун",  130000.0));
        employeeArray.add(new monthPayment(229567,"Рената Галимова",  80000.0));
        employeeArray.add(new monthPayment(215865,"Константин Добровольский",  70000.0));
        employeeArray.add(new hourlyPayment(215878,"Галямин Илья",  150.0));

        //Сортируем работников
        Comparator<Employee> employeeComparator =
                Comparator.comparing(Employee::calculateSalary, Comparator.reverseOrder())
                        .thenComparing(Employee::getName);
        Collections.sort(employeeArray, employeeComparator);
        System.out.println("--------------------------");
        //Выводим всех отсортированных работников
        int counter=0;
        System.out.println("Все работники \n");
        for (Employee employee : employeeArray) {
            counter+=1;
            System.out.println("Работник "+counter);
            employee.getEmployee(employee);
        }
        counter=0;
        System.out.println("--------------------------");
        //Выводим первые 5 имен работников из полученого выше списка.
        for (int i = 0;i<5;i++){
            counter+=1;
            System.out.println("Работник " + counter + " : " + employeeArray.get(i).getName());
        }
        System.out.println("--------------------------");
        //Выводим последние 3 идентификатора работников из полученого више списка
        counter=0;
        for (int i = 1 ; i<4;i++){
            counter=employeeArray.size()-i+1;
            System.out.println("Работник " + counter + " : " + employeeArray.get(employeeArray.size()-i).getId());
        }
        //Запись в файл
        try(FileWriter writer = new FileWriter("employees.txt", false)) {
            writer.write("Список работников: \n \n");
            for (Employee employee : employeeArray) {
                counter += 1;
                String text = "ID работника: " + employee.getId() + '\n'
                                        + "ФИО: " + employee.getName() + '\n'
                                        + "Зарплата: " + employee.calculateSalary() + '\n' + System.lineSeparator();
                writer.write(text);
                writer.flush();
            }
        }catch(IOException ex){}

        //Читаем из файла
        System.out.println("--------------------------");
        //try(FileReader reader = new FileReader("someFile.txt"))
        try(FileReader reader = new FileReader("employees.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch(IOException ex){System.out.println(ex.getMessage());}

    }}
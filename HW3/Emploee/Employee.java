public abstract class Employee {
    int id;
    String fullName;

    public Employee(int id,String fullName) {
        this.id = id;
        this.fullName = fullName;

        }
        public abstract double calculateSalary();

        public String getName(){
            return this.fullName;
        }
        public Integer getId(){
            return this.id;
    }
    public void getEmployee(Employee employee){
        System.out.println("ID работника: " + id + '\n'
                + "ФИО: " + fullName + '\n'
                + "Зарплата: " + employee.calculateSalary() + '\n');
    }
}

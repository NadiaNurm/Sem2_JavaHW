public class monthPayment extends Employee{
    double salary;
    public monthPayment(int id,String fullName,double salary){
        super(id,fullName);
        this.salary = salary;
    }


    @Override
    public double calculateSalary() {
        return salary;
    }
}

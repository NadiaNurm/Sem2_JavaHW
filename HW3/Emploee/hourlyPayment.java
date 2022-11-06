public class hourlyPayment extends Employee{
    double rate;
    public hourlyPayment(int id,String fullName,double rate){
        super(id,fullName);
        this.rate = rate;
        }

    @Override
    public double calculateSalary() {
        return 20.8*8*rate;
    }
}


/**
 * Write a description of class Salary here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Employee
{
    private String name;
    private String address;
    private int number;
    
    public Employee(String n, String ad, int num) {
        System.out.println("Constructing an Employee");
        name = n;
        address = ad;
        number = num;
    }
    
    public abstract double computePay();
    
    public void mailCheck() {
        System.out.println("Mailing a check to " + name + " " + address);
    }
    
    public String toString() {return name + " " + address + " " + number;}
    public String getName() {return name;}
    public String getAddress() {return address;}
    public void setAddress(String ad) {address = ad;}
    public int getNumber() {return number;}
    
    public static class Salary extends Employee {
        private double salary;
        public Salary(String name, String ad, int n, double sal) {
            super(name,ad,n);
            setSalary(sal);
        }
        
        @Override
        public void mailCheck() {
            System.out.println("Within mailCheck of Salary class");
            System.out.println("Mailing check to " + getName() + " with salary " + salary);
        }
        
        public double getSalary() {return salary;}
        
        public void setSalary(double sal) {
            if(sal >= 0.0)
                salary = sal;
        }
        
        @Override
        public double computePay() {
            System.out.println("Computing salary pay for " + getName());
            return salary/52;
        }
    }
}

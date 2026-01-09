class Employee {
    private final int pay_low;
    private final int pay_high;
    private String name;
    private final int employee_id;

    public int getLowPay() {
        return pay_low;
    }

    public int getMaxPay() {
        return pay_high;
    }

    public int getID() {
        return employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return String.format("Name: %s, ID: %d", name, employee_id);
    }

    public Employee(int id, String name, int pay_low, int pay_high) {
        employee_id = id;
        this.pay_low = pay_low;
        this.pay_high = pay_high;
        this.name = name;
    }

}
class SoftwareEngineer extends Employee {
    private String jobCode;

    public SoftwareEngineer(int id, String name) {
        // set the Employee pay scale to be 75,000-250,000
        super(id, name, 75000, 250000);
        this.jobCode = "";

    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String toString() {
        return String.format("Name: %s, ID: %d, JobCode: %s",
                getName(), // Use inherited getName()
                getID(), // Use inherited getID()
                jobCode);
    }
}

public class AppEmployee {
    public static void main(String[] args) {
        SoftwareEngineer newEmployee = new SoftwareEngineer(2, "Jake");

        newEmployee.setJobCode("APE");
        newEmployee.getJobCode();

        System.out.println(newEmployee.toString());
    }
}

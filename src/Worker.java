public class Worker {
    private String name;
    private int salary, tips;
    private int monthlySalaryRaise = 10;

    public Worker(int salary, String name) {
        this.name = name;
        this.salary = salary;
        tips = 0;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getTips() {
        return tips;
    }

    public void setTips(int tips) {
        this.tips = tips;
    }

    public void raiseMonthlySalary(){
        salary += monthlySalaryRaise + tips;
        tips = 0;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", tips=" + tips +
                '}';
    }
}

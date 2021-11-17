public class Worker {
    private int salary, tips;

    public Worker(int salary) {
        this.salary = salary;
        tips = 0;
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
}

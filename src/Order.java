public class Order{
    private Meal meal;
    private Worker worker;
    private int workerTip = 10;

    public Order(Meal meal, Worker worker) {
        this.meal = meal;
        this.worker = worker;

        worker.setTips(worker.getTips() + workerTip);
    }

    public int getCost(){
        return meal.getCost();
    }

    public String toString() {
        return  meal.toString();
    }
}

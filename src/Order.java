public class Order {
    protected boolean valid;
    protected int cost;

    public boolean isValid() {
        return valid;
    }

    public int getCost(){
        return cost;
    }

    public String toString(){
        return "Is valid: " + isValid() + "\n Cost: " + getCost();
    }
}

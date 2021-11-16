import java.util.ArrayList;

public class GroupOrder extends ArrayList<Order> {
    private int cost;

    public GroupOrder() {
        super();
        cost = 0;
    }

    public int getCost() {
        return cost;
    }

    public boolean add(Order order) {
        cost += order.getCost();
        return super.add(order);
    }

    @Override
    public String toString() {
        return "This group order costs:" + cost;
    }
}

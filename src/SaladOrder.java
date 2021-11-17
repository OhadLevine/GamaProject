import java.util.ArrayList;
import java.util.List;

public class SaladOrder extends Order {
    private List<Food> pickedExtras;
    private Food salad;
    private boolean valid;
    private int cost;

    public SaladOrder(OrderInformation info, String size, List<String> pickedExtras) {
        salad = info.getMatchingFood(info.getSalads(), size);

        this.pickedExtras = new ArrayList<Food>();
        for (String extra : pickedExtras) {
            this.pickedExtras.add(info.getMatchingFood(info.getExtras(), extra));
        }

        valid = isValid();
        cost = cost();
        removeAmounts();
    }

    private void removeAmounts() {
        if (valid) {
            for (Food extra : pickedExtras) {
                extra.setAmount(extra.getAmount() - 1);
            }
            salad.setAmount(salad.getAmount() - 1);
        }
    }

    private int cost() {
        return salad.getCost();
    }

    public boolean isValid() {
        for (Food extra : pickedExtras) {
            if (extra == null || extra.getAmount() == 0) return false;
        }
        return true;
    }

    public int getCost(){
        return this.cost;
    }

    public String toString() {
        return "This salad order contains:\n" + salad.getType() + "\n" + Util.listToString(pickedExtras) + "\nCost:" + cost + "\nIs Valid:" + valid;
    }
}

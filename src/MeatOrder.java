import java.util.ArrayList;
import java.util.List;

public class MeatOrder extends Order{
    private Food meat, bread;
    private List<Food> pickedExtras;
    private int cost;
    private boolean valid;

    public MeatOrder(OrderInformation info, String meat, String bread, List<String> pickedExtras) {
        this.meat = info.getMatchingFood(info.getMeats(), meat);
        this.bread = info.getMatchingFood(info.getBreads(), bread);
        this.pickedExtras = new ArrayList<Food>();
        for(String extra : pickedExtras) {
            this.pickedExtras.add(info.getMatchingFood(info.getExtras(), extra));
        }

        cost = cost();
        valid = isValid();
        updateAmounts();
    }

    private void updateAmounts() {
        if (!valid) return;
        meat.setAmount(meat.getAmount() - 1);
        bread.setAmount(bread.getAmount() - 1);
        for (Food extra : pickedExtras) {
            extra.setAmount(extra.getAmount() - 1);
        }
    }

    public boolean isValid() {
        for (Food extra : pickedExtras) {
            if (extra == null || extra.getAmount() == 0) return false;
        }
        if (bread == null || bread.getAmount() == 0) return false;
        if ((meat == null) || meat.getAmount() == 0) return false;
        return true;
    }

    private int cost() {
        if (valid) {
            int extraCost = 0;
            for (Food extra : pickedExtras) {
                extraCost += extra.getCost();
            }
            return meat.getCost() + extraCost;
        }
        return 0;
    }

    public int getCost(){
        return this.cost;
    }

    public String toString() {
        return "This hamburger order contains:\n" + meat.getType() + "\n" + bread.getType() + "\n" + Util.listToString(pickedExtras) + "\nCost:" + getCost() + "\nIs Valid:" + isValid();
    }
}

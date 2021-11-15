import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Order {
    private OrderInformation info;
    private String meat;
    private String bread;
    private List<String> pickedExtras;
    private int cost;
    private boolean valid;

    public Order(Scanner input, OrderInformation info) {
        this.info = info;

        System.out.println("Enter Burger Meat:");
        meat = input.next();

        System.out.println("Enter Burger Bread:");
        bread = input.next();
        input.nextLine();

        System.out.println("Enter Extras:");
        String extrasRaw = input.nextLine();
        pickedExtras = Arrays.asList(extrasRaw.split("\\W+"));

        cost = Cost();
        valid = isValid();
        updateAmounts();
    }

    private void updateAmounts() {
        if (!valid) return;
        info.removeAmount(info.getMeats(), meat, 1);
        info.removeAmount(info.getBreads(), bread, 1);
        for (String extra : pickedExtras) {
            info.removeAmount(info.getExtras(), extra, 1);
        }

        System.out.println();
    }

    private boolean isValid() {
        Food meatFood = info.getMatchingFood(info.getMeats(), meat);
        Food breadFood = info.getMatchingFood(info.getBreads(), bread);
        for (String extra : pickedExtras) {
            Food extraFood = info.getMatchingFood(info.getExtras(), extra);
            if (extraFood == null || extraFood.getAmount() == 0) return false;
        }
        if (breadFood == null || breadFood.getAmount() == 0) return false;
        if ((meatFood == null) || meatFood.getAmount() == 0) return false;
        return true;
    }

    private int Cost() {
        if (!valid) {
            int extraCost = 0;
            for (String extra : pickedExtras) {
                extraCost += info.getMatchingFood(info.getExtras(), extra).getCost();
            }
            System.out.println("extra cost:"+extraCost);
            System.out.println("meat cost:"+info.getMatchingFood(info.getMeats(), meat).getCost() );
            return info.getMatchingFood(info.getMeats(), meat).getCost() + extraCost;
        }
        return 0;
    }

    public int getCost() {
        return this.cost;
    }

    public String toString() {
        return "This hamburger order contains:\n" + meat + "\n" + bread + "\n" + Arrays.toString(pickedExtras.toArray()) + "\nCost:" + getCost() + "\nIs Valid:" + valid;
    }
}

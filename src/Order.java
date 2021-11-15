import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Order {
    private OrderInformation info;
    private String meat;
    private String bread;
    private List<String> pickedExtras;
    private int cost;

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
        updateAmounts();
    }

    private void updateAmounts(){
        if(!isValid()) return;
        info.removeAmount(info.getMeats(), meat, 1 );
        info.removeAmount(info.getBreads(), bread, 1);
        for(String extra : pickedExtras){
            info.removeAmount(info.getExtras(), extra, 1);
        }

        System.out.println();
    }

    private boolean isValid() {
        Food meatFood = info.getMatchingFood(info.getMeats(), meat);
        for (String extra : pickedExtras) {
            Food extraFood = info.getMatchingFood(info.getExtras(), extra);
            if(extraFood == null || extraFood.getAmount() == 0)  return false;
        }
        if (!bread.equals("white") && !bread.equals("whole")) return false;
        if((meatFood == null) || meatFood.getAmount() == 0) return false;
        return true;
    }

    private int Cost() {
        if (isValid()) {
            int extraCost = 0;
            for (String extra : pickedExtras) {
                extraCost += info.getMatchingFood(info.getExtras(), extra).getCost();
            }

            return info.getMatchingFood(info.getMeats(), meat).getCost() + extraCost;
        }
        return 0;
    }

    public int getCost(){
        return this.cost;
    }

    public String toString() {
        return "This hamburger order contains:\n" + meat + "\n" + bread + "\n" + Arrays.toString(pickedExtras.toArray()) + "\nCost:" + getCost() + "\nIs Valid:" + isValid();
    }
}

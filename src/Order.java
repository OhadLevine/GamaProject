import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Order {
    private OrderInformation info;
    private String meat;
    private String bread;
    private List<String> pickedExtras;
    private Scanner input;

    public Order(Scanner input, OrderInformation info) {
        this.input = input;
        this.info = info;

        System.out.println("Enter Burger Meat:");
        meat = input.next();

        System.out.println("Enter Burger Bread:");
        bread = input.next();
        input.nextLine();

        System.out.println("Enter Extras:");
        String extrasRaw = input.nextLine();
        pickedExtras = Arrays.asList(extrasRaw.split("\\W+"));
    }

    private boolean isValid() {
        for (String extra : pickedExtras) {
            if (!info.getExtras().containsKey(extra)) return false;
        }
        if (!bread.equals("white") && !bread.equals("whole")) return false;
        if (!info.getMeats().containsKey(meat)) return false;
        return true;
    }

    public int getCost() {
        if(isValid()) {
            int extraCost = 0;
            for (String extra : pickedExtras) {
                extraCost += info.getExtras().get(extra);
            }
            return info.getMeats().get(meat) + extraCost;
        }
        return 0;
    }

    public String toString() {
        return "This hamburger order contains:\n" + meat + "\n" + bread + "\n" + Arrays.toString(pickedExtras.toArray()) + "\nCost:" + getCost() + "\nIs Valid:" + isValid();
    }
}

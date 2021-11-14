import java.util.Arrays;
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
        boolean extrasValid = false;
        boolean meatsValid = false;
        for (String extra : pickedExtras) {
            for (int i = 0; i < info.getExtras().size(); i++) {
                if (info.getExtras().get(i).getType().equals(extra)) extrasValid = true;
            }
        }
        if (!bread.equals("white") && !bread.equals("whole")) return false;
        for (Food food : info.getMeats()) {
            if (food.getType().equals(meat)) meatsValid = true;
        }
        return extrasValid && meatsValid;
    }

    public int getCost() {
        if (isValid()) {
            int extraCost = 0;
            int meatCost = 0;
            for (Food extra : info.getExtras()) {
                if (pickedExtras.contains(extra.getType())) extraCost += extra.getCost();
            }

            for (Food meat : info.getMeats()) {
                if (meat.getType().equals(this.meat)) meatCost = meat.getCost();
            }

            return meatCost + extraCost;
        }
        return 0;
    }

    public String toString() {
        return "This hamburger order contains:\n" + meat + "\n" + bread + "\n" + Arrays.toString(pickedExtras.toArray()) + "\nCost:" + getCost() + "\nIs Valid:" + isValid();
    }
}

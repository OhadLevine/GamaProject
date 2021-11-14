import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class OrderInformation {
    private Scanner input;

    private List<Food> extras, meats;

    public OrderInformation(Scanner input) {
        this.input = input;

        extras = new ArrayList<Food>();
        extras.add(new Food("onion", 50, 10));
        extras.add(new Food("lettuce", 50, 10));
        extras.add(new Food("tomato", 50, 10));
        extras.add(new Food("pickle", 50, 10));
        extras.add(new Food("cucumber", 50, 10));


        meats = new ArrayList<Food>();
        meats.add(new Food("cow", 50, 50));
        meats.add(new Food("lamb", 50, 50));
        meats.add(new Food("tophu", 50, 50));
    }

    private void addExtra(String extra, int cost, int amount) {
        extras.add(new Food(extra, cost, amount));
    }

    public void addExtra() {
        System.out.println("Extra:");
        String extraToAdd = input.next();
        System.out.println("Price:");
        int price = input.nextInt();
        System.out.println("Amount:");
        int amount = input.nextInt();
        addExtra(extraToAdd, price, amount);
    }

    private void updateExtra(String extra, Integer newCost) {
        for(Food food : extras) {
            if(food.getType().equals(extra))  food.setCost(newCost);
        }
    }

    public void updateExtra() {
        System.out.println("Extra:");
        String extraToAdd = input.next();
        System.out.println("New rice:");
        Integer price = input.nextInt();
        updateExtra(extraToAdd, price);
    }

    public List<Food> getExtras() {
        return extras;
    }

    public List<Food> getMeats() {
        return meats;
    }
}

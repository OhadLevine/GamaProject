import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class OrderInformation {
    private Scanner input;

    private List<Food> extras, meats, breads;

    public OrderInformation(Scanner input) {
        this.input = input;

        extras = new ArrayList<Food>();
        extras.add(new Food("onion", 50, 3));
        extras.add(new Food("lettuce", 50, 3));
        extras.add(new Food("tomato", 50, 3));
        extras.add(new Food("pickle", 50, 3));
        extras.add(new Food("cucumber", 50, 3));


        meats = new ArrayList<Food>();
        meats.add(new Food("cow", 50, 3));
        meats.add(new Food("lamb", 50, 3));
        meats.add(new Food("tophu", 50, 3));

        breads = new ArrayList<Food>();
        breads.add(new Food("whole", 0, 3));
        breads.add(new Food("white", 0, 3));

    }

    public void addAmount(List<Food> list, String foodToAddTo, int amount) {
        Food food = getMatchingFood(list, foodToAddTo);
        food.setAmount(food.getAmount() + amount);
    }

    public void removeAmount(List<Food> list, String foodToRemoveFrom, int amount){
        addAmount(list, foodToRemoveFrom, -amount);
    }

    public Food getMatchingFood(List<Food> list, String foodToFind) {
        for (Food food : list) {
            if (food.getType().equals(foodToFind)) return food;
        }
        return null;
    }

    private void addExtra(String extra, int cost, int amount) {
        extras.add(new Food(extra, cost, amount));
    }

    public String listToString(List<Food> list) {
        String str = "";
        for(Food food : list){
            str += food.getType() + " ";
        }
        return str;
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
        getMatchingFood(extras, extra).setCost(newCost);
    }

    public void updateExtra() {
        System.out.println("Extra:");
        String extraToAdd = input.next();
        System.out.println("New Price:");
        Integer price = input.nextInt();
        updateExtra(extraToAdd, price);
    }

    public String printAmounts(){
        String str = "";
        for(Food food : meats) {
            str += food.getType() + ":" + food.getAmount() + "\n";
        }
        return str;
    }

    public List<Food> getExtras() {
        return extras;
    }

    public List<Food> getMeats() {
        return meats;
    }

    public List<Food> getBreads() {
        return breads;
    }
}

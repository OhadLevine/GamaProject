import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderInformation {
    private List<Food> extras, meats, breads;

    public OrderInformation(Scanner input) {
        createFoods();
    }

    private void createFoods() {
        extras = new ArrayList<Food>();
        extras.add(new Food("onion", 50, 1));
        extras.add(new Food("lettuce", 50, 1));
        extras.add(new Food("tomato", 50, 1));
        extras.add(new Food("pickle", 50, 1));
        extras.add(new Food("cucumber", 50, 1));


        meats = new ArrayList<Food>();
        meats.add(new Food("cow", 50, 1));
        meats.add(new Food("lamb", 50, 1));
        meats.add(new Food("tophu", 50, 1));

        breads = new ArrayList<Food>();
        breads.add(new Food("whole", 0, 1));
        breads.add(new Food("white", 0, 1));
    }

    public Food getMatchingFood(List<Food> list, String foodToFind) {
        for (Food food : list) {
            if (food.getType().equals(foodToFind)) return food;
        }
        return null;
    }


    public void addAmount(List<Food> list, String foodToAddTo, int amount) {
        Food food = getMatchingFood(list, foodToAddTo);
        if(food != null) food.setAmount(food.getAmount() + amount);
    }

    public void removeAmount(List<Food> list, String foodToRemoveFrom, int amount) {
        addAmount(list, foodToRemoveFrom, -amount);
    }

    public void addExtra(String extra, int cost, int amount) {
        extras.add(new Food(extra, cost, amount));
    }

    public void updateExtra(String extra, Integer newCost) {
        getMatchingFood(extras, extra).setCost(newCost);
    }

    public String getAmounts() {
        String str = "";
        str += "\n meats: \n\n";
        for (Food food : meats) {
            str += food.getType() + ":" + food.getAmount() + "\n";
        }
        str += "\n bread: \n\n";
        for (Food food : breads) {
            str += food.getType() + ":" + food.getAmount() + "\n";
        }
        str += "\n extras: \n\n";
        for (Food food : extras) {
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

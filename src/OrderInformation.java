import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderInformation {
    private List<Food> extras, meats, breads, salads;
    private GenericMeal hamburger;

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

        salads = new ArrayList<Food>();
        salads.add(new Food("big", 50, 2));
        salads.add(new Food("medium", 40, 2));
        salads.add(new Food("small", 30, 2));

    }


    public void addAmount(List<Food> list, String foodToAddTo, int amount) {
        Food food = Util.getMatchingFood(list, foodToAddTo);
        if (food != null) food.setAmount(food.getAmount() + amount);
    }


    public void addExtra(String extra, int cost, int amount) {
        extras.add(new Food(extra, cost, amount));
    }

    public void updateExtra(String extra, Integer newCost) {
        Util.getMatchingFood(extras, extra).setCost(newCost);
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


    public List<Food> getSalads() {
        return salads;
    }
}

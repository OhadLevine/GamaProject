import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderInformation {
    private List<Food> extras, meats, breads, salads;
    private List<Worker> workers;
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
        salads.add(new Food("b", 50, 2));
        salads.add(new Food("m", 40, 2));
        salads.add(new Food("s", 30, 2));

        workers = new ArrayList<Worker>();
        workers.add(new Worker(50, "Jacob"));
        workers.add(new Worker(50, "Jerry"));
        workers.add(new Worker(50, "Jackqueline"));
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

    public List<Worker> getWorkers() {
        return workers;
    }
}

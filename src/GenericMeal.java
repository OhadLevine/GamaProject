import java.util.ArrayList;
import java.util.List;

public class GenericMeal implements Meal {
    private List<Food> list;
    private boolean valid;
    private int cost;

    private static List<Food> createList(List<Food> list, Food... foodList) {
        List<Food> newList = new ArrayList<Food>(list);
        for (Food food : foodList) {
            list.add(food);
        }
        return list;
    }

    public GenericMeal(List<Food> list) {
        this.list = list;
        valid = isValid();
        cost = getCost();
        subtractUsedFoods();
    }

    public GenericMeal(List<Food> list, Food... foodList) {
        this(createList(list, foodList));
    }


    @Override
    public void subtractUsedFoods() {
        if (valid) {
            for (Food food : list) {
                food.setAmount(food.getAmount() - 1);
            }
        }
    }

    @Override
    public boolean isValid() {
        for (Food food : list) {
            if (food == null || food.getAmount() == 0) return false;
        }
        return true;
    }

    @Override
    public int getCost() {
        if (valid) {
            int cost = 0;
            for (Food food : list) {
                cost += food.getCost();
            }
            return cost;
        }
        return 0;
    }

    public String toString() {
        String str = "This meal contains: ";
        for (Food food : list) {
            str += food.getType() + " | ";
        }
        return str + cost + valid;
    }
}

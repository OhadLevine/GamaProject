import java.util.ArrayList;
import java.util.List;

public class GenericMeal implements Meal {
    private List<Food> list;
    protected boolean valid = true;
    protected int cost = 0;

    private static List<Food> createList(List<Food> list, Food... foodList) {
        List<Food> newList = new ArrayList<Food>(list);
        for (Food food : foodList) {
            list.add(food);
        }
        return list;
    }

    public GenericMeal(List<Food> list) {
        this.list = list;

        for (Food food : list) {
            if (food == null || food.getAmount() == 0) valid = false;
        }

        if (valid) {
            for (Food food : list) {
                cost += food.getCost();
            }
        }

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
        return valid;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        String str = "This meal contains: ";
        for (Food food : list) {
            if(food != null) str += food.getType() + " | ";
        }
        return str + cost + " | " + valid;
    }
}

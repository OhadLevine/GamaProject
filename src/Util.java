import java.util.ArrayList;
import java.util.List;

public class Util {


    public static Food getMatchingFood(List<Food> list, String foodToFind) {
        for (Food food : list) {
            if (food.getType().equals(foodToFind)) return food;
        }
        return null;
    }

    public static String getStringAmounts(List<Food>... lists){
        String str = "";
        for(List<Food> list: lists) {
            str += "\n\n";
            for(Food food : list) {
                str += food.getType() + ":" + food.getAmount() + "\n";
            }
        }
        return str;
    }

    public static String listToString(List<Food> list) {
        String str = "";
        for (Food food : list) {
            str += food.getType() + " ";
        }
        return str;
    }


    public static void printOrders(List<GroupOrder> orders) {
        for (int i = 0; i < orders.size(); i++) {
            System.out.println("Group Order number " + (i + 1) + "\n" + orders.get(i).toString() + "\n");
            for (int j = 0; j < orders.get(i).size(); j++) {
                System.out.println("Order number " + (j + 1) + "\n" + orders.get(i).get(j).toString() + "\n");
            }
        }
    }

    public static List<Food> stringListToFood(List<Food> foodList, List<String> list){
        List<Food> newList = new ArrayList<Food>();
        for(String food : list){
            newList.add(getMatchingFood(foodList, food));
        }
        return newList;
    }
}

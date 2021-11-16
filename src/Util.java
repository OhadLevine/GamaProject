import java.util.List;

public class Util {

    public static String listToString(List<Food> list) {
        String str = "";
        for (Food food : list) {
            str += food.getType() + " ";
        }
        return str;
    }
}

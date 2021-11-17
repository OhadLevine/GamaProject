import java.util.List;

public interface Meal {

    void subtractUsedFoods();

    boolean isValid();

    int getCost();

    String toString();

}

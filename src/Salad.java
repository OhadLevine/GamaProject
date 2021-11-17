import java.util.ArrayList;
import java.util.List;

public class Salad extends GenericMeal {
    private List<Food> pickedExtras;
    private Food salad;
    private boolean valid;
    private int cost;

    public Salad(Food salad, List<Food> pickedExtras) {
        super(pickedExtras, salad);
        this.salad = salad;
        this.pickedExtras = pickedExtras;

        valid = isValid();
        cost = getCost();
        subtractUsedFoods();
    }

    @Override
    public int getCost() {
        return salad.getCost();
    }
}

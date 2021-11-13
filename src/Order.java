import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Order {
    private Scanner input;
    private String meat;
    private String bread;
    private HashMap<String, Integer> meats;
    private HashMap<String, Integer> extras;
    private List<String> pickedExtras;

    public Order() {
        input = new Scanner(System.in);

        System.out.println("Enter Burger Meat:");
        meat = input.next();

        System.out.println("Enter Burger Bread:");
        bread = input.next();
        input.nextLine();

        System.out.println("Enter Misc:");
        String extrasRaw = input.nextLine();
        pickedExtras = Arrays.asList(extrasRaw.split("\\W+"));

        extras = new HashMap<String, Integer>();
        extras.put("onion", 50);
        extras.put("cucumber", 55);
        extras.put("tomato", 60);
        extras.put("lettuce", 60);
        extras.put("pickles", 60);


        meats = new HashMap<String, Integer>();
        meats.put("cow", 50);
        meats.put("lamb", 55);
        meats.put("tophu", 60);
    }

    public boolean isValid(){
        for(String extra : pickedExtras){
            if(!extras.containsKey(extra)) return false;
        }
        if(!bread.equals("white") && !bread.equals("whole")) return false;
        if(!meats.containsKey(meat)) return false;
        return true;
    }

    public int getCost(){
        int extraCost = 0;
        for(String extra : pickedExtras){
            extraCost += extras.get(extra);
        }
        return meats.get(meat) + extraCost;
    }

    public void addExtra(String extra, Integer cost){
        extras.put(extra, cost);
    }

    public String toString(){
        return "This hamburger order contains:\n" + meat + "\n" + bread + "\n" + Arrays.toString(pickedExtras.toArray()) + "\nCost:" + getCost();
    }
}

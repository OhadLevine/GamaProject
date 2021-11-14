import java.util.HashMap;
import java.util.Scanner;

public class OrderInformation {
    private Scanner input;
    private HashMap<String, Integer> extras;
    private HashMap<String, Integer> meats;
    private HashMap<String, Integer> breads;

    public OrderInformation(Scanner input) {
        this.input = input;

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

        breads = new HashMap<String, Integer>();
        breads.put("whole", 0);
        breads.put("white", 0);
    }

    private void addExtra(String extra, Integer cost) {
        extras.put(extra, cost);
    }

    public void addExtra() {
        System.out.println("Extra:");
        String extraToAdd = input.next();
        System.out.println("Price:");
        Integer price = input.nextInt();
        addExtra(extraToAdd, price);
    }

    private void updateExtra(String extra, Integer newCost) {
        extras.replace(extra, newCost);
    }

    public void updateExtra() {
        System.out.println("Extra:");
        String extraToAdd = input.next();
        System.out.println("New rice:");
        Integer price = input.nextInt();
        updateExtra(extraToAdd, price);
    }

    public HashMap<String, Integer> getExtras() {
        return extras;
    }

    public void setExtras(HashMap<String, Integer> extras) {
        this.extras = extras;
    }

    public HashMap<String, Integer> getMeats() {
        return meats;
    }

    public void setMeats(HashMap<String, Integer> meats) {
        this.meats = meats;
    }

    public HashMap<String, Integer> getBreads() {
        return breads;
    }

    public void setBreads(HashMap<String, Integer> breads) {
        this.breads = breads;
    }
}

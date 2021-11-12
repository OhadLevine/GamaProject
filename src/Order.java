import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Order {
    private Scanner input;
    private String meat;
    private String bread;
    private List<String> extras;
    private int cost;

    public Order() {
        input = new Scanner(System.in);

        System.out.println("Enter Burger Meat:");
        meat = input.next();

        System.out.println("Enter Burger Bread:");
        bread = input.next();
        input.nextLine();

        System.out.println("Enter Misc:");
        String extrasRaw = input.nextLine();
        extras = Arrays.asList(extrasRaw.split("\\W+"));
    }

    private boolean isValid(){
        boolean valid = true;
        extras.forEach();
        return valid;
    }
}

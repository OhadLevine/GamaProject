import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Order order = new Order(input);

        System.out.println(order.getCost());
        System.out.println(order.isValid());

        boolean editing = true;
        while (editing) {
            System.out.println("Do you want to edit extras? (add / update / finished)");
            String in = input.next();
            switch (in) {
                case "add":
                    order.addExtra();
                    break;
                case "replace":
                    order.updateExtra();
                    break;
                default:
                    editing = false;
            }
        }
    }
}

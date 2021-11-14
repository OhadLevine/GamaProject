import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManager {
    private Scanner input;
    private OrderInformation info;
    private List<Order> orders;

    public OrderManager(Scanner input, OrderInformation info) {
        this.input = input;
        this.info = info;
        orders = new ArrayList<Order>();
        loop();
        for (int i = 0; i < orders.size(); i++) {
            System.out.println("Order number " + (i+1) + "\n" + orders.get(i).toString() + "\n");
        }
    }

    private void managerEditing() {
        boolean editing = true;
        while (editing) {
            System.out.println("Do you want to edit extras? (add / update / no)");
            String in = input.next();
            switch (in) {
                case "add":
                    info.addExtra();
                    break;
                case "update":
                    info.updateExtra();
                    break;
                default:
                    editing = false;
            }
        }
    }

    private void addOrder() {
        boolean editing = true;
        while (editing) {
            System.out.println("Do you want to add new order? (yes / no)");
            String in = input.next();
            if(in.equals("yes")) orders.add(new Order(input, info));
            else editing = false;
        }
    }

    private void loop() {
        boolean editing = true;
        while (editing) {
            System.out.println("do you want to edit? (yes / no)");
            String in = input.next();
            if(in.equals("yes")) {
                addOrder();
                managerEditing();
            }
            else {
                System.out.println("Goodbye!");
                editing = false;
            }
        }
    }
}

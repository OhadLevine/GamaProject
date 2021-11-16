import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManager {
    private Scanner input;
    private OrderInformation info;
    private List<GroupOrder> orders;

    public OrderManager(Scanner input, OrderInformation info) {
        this.input = input;
        this.info = info;
        orders = new ArrayList<GroupOrder>();
        loop();
        printOrders();
        System.out.println(info.printAmounts());
    }

    private void printOrders() {
        for (int i = 0; i < orders.size(); i++) {
            System.out.println("Group Order number " + (i + 1) + "\n" + orders.get(i).toString() + "\n");
            for (int j = 0; j < orders.get(i).size(); j++) {
                System.out.println("Order number " + (j + 1) + "\n" + orders.get(i).get(j).toString() + "\n");
            }
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

    private void worker() {
        boolean editing = true;
        while (editing) {
            System.out.println("What would you like to add? (meat / bread / extra / done)");
            String in = input.next();
            int amount;
            switch (in) {
                case "meat":
                    System.out.println("What meat should get Added?" + info.listToString(info.getMeats()));
                    String meatToAdd = input.next();
                    System.out.println("How much?");
                    amount = input.nextInt();
                    info.addAmount(info.getMeats(), meatToAdd, amount);
                    break;
                case "bread":
                    System.out.println("What bread should get Added?" + info.listToString(info.getBreads()));
                    String breadToAdd = input.next();
                    System.out.println("How much?");
                    amount = input.nextInt();
                    info.addAmount(info.getBreads(), breadToAdd, amount);
                    break;
                case "extra":
                    System.out.println("What extra should get Added? (" + info.listToString(info.getExtras()) + ")");
                    String extraToAdd = input.next();
                    System.out.println("How much?");
                    amount = input.nextInt();
                    info.addAmount(info.getExtras(), extraToAdd, amount);
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
            if (in.equals("yes")) orders.get(orders.size() - 1).add(new Order(input, info));
            else editing = false;
        }
    }

    private void addGroupOrder() {
        boolean editing = true;
        while (editing) {
            System.out.println("Do you want to add new group order? (yes / no)");
            String in = input.next();
            if (in.equals("yes")) {
                orders.add(new GroupOrder());
                addOrder();
            } else editing = false;
        }
    }

    private void loop() {
        boolean editing = true;
        while (editing) {
            System.out.println("Order Manager Worker or Done?");
            String in = input.next();
            switch (in) {
                case "order":
                    addGroupOrder();
                    break;
                case "manager":
                    managerEditing();
                    break;
                case "worker":
                    worker();
                    break;
                default:
                    System.out.println("Goodbye!");
                    editing = false;
            }
        }
    }
}

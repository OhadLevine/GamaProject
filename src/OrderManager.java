import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class OrderManager {
    private Scanner input;
    private OrderInformation info;
    private List<GroupOrder> orders;

    public OrderManager(Scanner input, OrderInformation info) {
        this.input = input;
        this.info = info;
        orders = new ArrayList<GroupOrder>();
        loop();
    }

    public List<GroupOrder> getOrders() {
        return orders;
    }

    private void managerEditingExtras() {
        boolean editing = true;
        while (editing) {
            System.out.println("Edit extras? (a - add / u - update / no)");
            String in = input.next();
            int price;
            switch (in) {
                case "a":
                    System.out.println("Extra:");
                    String extraToAdd = input.next();
                    System.out.println("Price:");
                    price = input.nextInt();
                    System.out.println("Amount:");
                    int amount = input.nextInt();
                    info.addExtra(extraToAdd, price, amount);
                    break;
                case "u":
                    System.out.println("Extra:");
                    String extraToUpdate = input.next();
                    System.out.println("New Price:");
                    price = input.nextInt();
                    info.updateExtra(extraToUpdate, price);
                    break;
                default:
                    editing = false;
            }
        }
    }

    private void manager() {
        boolean editing = true;
        while (editing) {
            System.out.println("Payday Edit Hire or Fire? (p - payday / e - edit / h - hire / f - fire)");
            String in = input.next();
            switch (in) {
                case "p":
                    for (Worker worker : info.getWorkers()) {
                        worker.raiseMonthlySalary();
                    }
                    break;
                case "e":
                    managerEditingExtras();
                    break;
                case "h":
                    System.out.println("Worker name: ");
                    in = input.next();
                    info.getWorkers().add(new Worker(50, in));
                    break;
                case "f":
                    System.out.println("Worker name: ");
                    in = input.next();
                    info.getWorkers().remove(Util.findWorkerByName(info.getWorkers(), in));
                    break;
                default:
                    editing = false;
            }
        }
    }

    private void worker() {
        boolean editing = true;
        while (editing) {
            System.out.println("What  to add? (m - meat / b - bread / e - extra / done)");
            String in = input.next();
            int amount;
            switch (in) {
                case "m":
                    System.out.println("What meat should get Added?" + Util.listToString(info.getMeats()));
                    String meatToAdd = input.next();
                    System.out.println("How much?");
                    amount = input.nextInt();
                    info.addAmount(info.getMeats(), meatToAdd, amount);
                    break;
                case "b":
                    System.out.println("What bread should get Added?" + Util.listToString(info.getBreads()));
                    String breadToAdd = input.next();
                    System.out.println("How much?");
                    amount = input.nextInt();
                    info.addAmount(info.getBreads(), breadToAdd, amount);
                    break;
                case "e":
                    System.out.println("What extra should get Added? (" + Util.listToString(info.getExtras()) + ")");
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
        String extrasRaw;
        List<Food> pickedExtras;
        while (editing) {
            System.out.println("Hamburger Salad or Done? (h / s / d)");
            String in = input.next();
            switch (in) {
                case "h":
                    System.out.println("Enter Burger Meat:");
                    Food meat = Util.getMatchingFood(info.getMeats(), input.next());

                    System.out.println("Enter Burger Bread:");
                    Food bread = Util.getMatchingFood(info.getBreads(), input.next());

                    input.nextLine();

                    System.out.println("Enter Extras:");
                    extrasRaw = input.nextLine();
                    pickedExtras = Util.stringListToFood(info.getExtras(), Arrays.asList(extrasRaw.split("\\W+")));

                    orders.get(orders.size() - 1).add(new Order(new GenericMeal(pickedExtras, meat, bread), info.getWorkers().get(ThreadLocalRandom.current().nextInt(0, info.getWorkers().size()))));
                    break;
                case "s":
                    System.out.println("Enter Salad size (s - small | m - medium | b - big");
                    Food salad = Util.getMatchingFood(info.getSalads(), input.next());
                    input.nextLine();

                    System.out.println("Enter Extras:");
                    extrasRaw = input.nextLine();
                    pickedExtras = Util.stringListToFood(info.getExtras(), Arrays.asList(extrasRaw.split("\\W+")));
                    orders.get(orders.size() - 1).add(new Order(new Salad(salad, pickedExtras), info.getWorkers().get(ThreadLocalRandom.current().nextInt(0, info.getWorkers().size()))));
                    break;
                default:
                    editing = false;


            }
        }
    }

    private void addGroupOrder() {
        boolean editing = true;
        while (editing) {
            System.out.println("Do you want to add new group order? (y / n)");
            String in = input.next();
            if (in.equals("y")) {
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
                    manager();
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

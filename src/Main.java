import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        OrderInformation info = new OrderInformation(input);
        OrderManager manager = new OrderManager(input, info);

        Util.printOrders(manager.getOrders());
        System.out.println(Util.getStringAmounts(info.getMeats(), info.getBreads(), info.getExtras(), info.getSalads()));
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        OrderInformation info = new OrderInformation(input);
        OrderManager manager = new OrderManager(input, info);
    }
}

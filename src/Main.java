import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Order order = new Order();

        System.out.println(order.getCost());
        System.out.println(order.isValid());
    }
}

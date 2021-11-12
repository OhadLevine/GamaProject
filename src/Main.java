import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int cost = 0;
        boolean exists = true;

        System.out.println("Enter Burger Meat:");
        String meat = in.next();

        System.out.println("Enter Burger Bread:");
        String bread = in.next();
        in.nextLine();

        System.out.println("Enter Misc:");
        String misc = in.nextLine();
        String[] veggies = misc.split("\\W+");
        for(String veggie : veggies) {
            if(!veggie.equals("cucumber") && !veggie.equals("tomato") && !veggie.equals("onion") && !veggie.equals("pickles") && !veggie.equals("lettuce")) exists = false;
        }



        switch (meat) {
            case "cow":
                cost = 50;
                break;
            case "lamb":
                cost = 55;
                break;
            case "tophu":
                cost = 60;
                break;
            default:
                exists = false;
        }

        if(!bread.equals("white") && !bread.equals("whole")) exists = false;

        if(exists) System.out.println("Hamburger Order:\nCost:" + cost + "\n" + meat + "\n" + bread + "\n" + Arrays.toString(veggies));
        else System.out.println("this meal does not exist!");
    }
}

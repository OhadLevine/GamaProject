public class Main {
    public static void main(String[] args){
        int cost;
        String meat = System.getProperty("meat");
        String bread = System.getProperty("bread");

        if(meat.equals("meat")) cost = 50;
        else if (meat.equals("lamb")) cost = 55;
        else cost = 60;

        System.out.println("Hamburger Order:\nCost:" + cost + "\n" + meat + "\n" + bread);
        for(String arg : args) {
            System.out.println(arg);
        }



    }
}

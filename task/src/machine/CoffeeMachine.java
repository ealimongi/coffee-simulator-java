package machine;

import java.util.Scanner;
import static java.lang.System.in;

public class CoffeeMachine {

    Scanner sc = new Scanner(in);

    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int cups = 9;
    private static int money = 550;
    private static int coffeCups = 0;

    //machine promp
    public void status(){
        System.out.println("\n"+"The coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                beans + " g of coffee beans\n" +
                cups + " disposable cups\n" +
                "$" + money +" of money");

        System.out.println(); //space
    }
    //machine buy
    public void buyCoffe() {
        if (coffeCups >= 10) {
            System.out.println("I need cleaning!");
        } else {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeOption = sc.nextLine();

            switch (coffeOption) {
                case "1": //espresso
                    if (water >= 250 && beans >= 16 && cups > 0) {
                        System.out.println("I have enough resources, making you a coffee!");
                        water -= 250;
                        beans -= 16;
                        money += 4;
                        cups -= 1;
                        coffeCups++;

                    } else if (water < 250) {
                        System.out.println("Sorry, not enough water!");
                    } else if (beans < 16) {
                        System.out.println("Sorry, not enough beans!");
                    } else {
                        System.out.println("Sorry, not enough cups!");
                    }
                    break;

                case "2": //latte
                    if (water >= 350 && milk >= 75 && beans >= 20 && cups > 0) {
                        System.out.println("I have enough resources, making you a coffee!");
                        water -= 350;
                        milk -= 75;
                        beans -= 20;
                        money += 7;
                        cups -= 1;
                        coffeCups++;

                    } else if (water < 350) {
                        System.out.println("Sorry, not enough water!");
                    } else if (beans < 20) {
                        System.out.println("Sorry, not enough beans!");
                    } else if (milk < 75) {
                        System.out.println("Sorry, not enough milk!");
                    } else {
                        System.out.println("Sorry, not enough cups!");
                    }
                    break;

                case "3": //capuccino
                    if (water >= 200 && milk >= 100 && beans >= 12 && cups > 0) {
                        System.out.println("I have enough resources, making you a coffee!");
                        water -= 200;
                        milk -= 100;
                        beans -= 12;
                        money += 6;
                        cups -= 1;
                        coffeCups++;

                    } else if (water < 200) {
                        System.out.println("Sorry, not enough water!");
                    } else if (beans < 12) {
                        System.out.println("Sorry, not enough beans!");
                    } else if (milk < 100) {
                        System.out.println("Sorry, not enough milk!");
                    } else {
                        System.out.println("Sorry, not enough cups!");
                    }
                    break;

                case "back":
                    break;

            }

            System.out.println(); //space
        }
    }

    // machine refill
    public void fillCoffe (){
        System.out.println("\n"+"Write how many ml of water you want to add: ");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += sc.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        cups += sc.nextInt();

        System.out.println(); //space

    }
    //machine take
    public void takeMoney(){
        System.out.println("\n"+"I gave you $" + money + "\n");
        money = 0;

    }

    //new funtion
    public void clean(){
        System.out.println("I have been cleaned!");
        coffeCups = 0;
    }

    public void menu (){

        while (true) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            String action = sc.nextLine();

            if (action.contains("exit")) {
                break;
            } else if (action.contains("fill")) {
                fillCoffe();
            } else if (action.contains("take")) {
                takeMoney();
            } else if (action.contains("remaining")) {
                status();
            } else if (action.contains("buy")){
                    buyCoffe();
            } else if (action.contains("clean")){
                clean();
            }
        }

    }

    public static void main(String[] args) {
        CoffeeMachine menuCoffe = new CoffeeMachine();
        menuCoffe.menu();
        coffeCups = 0;
    }

}

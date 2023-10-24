import java.io.Console;
import java.util.ArrayList;


public class ShoppingCart {
    public static void main(String[] args) {
        
        Console cons = System.console();

        ArrayList<String> cart = new ArrayList<>();

        System.out.println("Welcome to your shopping cart");

        while (true) {
            String input = cons.readLine("> ");
            input = input.trim();
            String function = input.split(" ")[0];
            String item = input.split(" ")[1];

            switch (function) {
                case "list":
                    ShoppingCart.list(cart);
                    break;
                case "add":
                    ShoppingCart.add(item);
                    break;
                case "delete":
                    ShoppingCart.delete();
                    break;
                case "end":
                    System.out.println("Shopping ended");
                    return;
                default: 
                    System.out.println("Invalid Action. Available Actions: list, add, delete, end");
                    break;
            }
        }
    }

    public static void list(ArrayList<String> cart) {
        if (cart.size() == 0) {
            System.out.println("Your cart is empty");
        } else {
            for (int i = 0; i <= cart.size(); i++) {
                System.out.println(cart.get(i));
            }
        }
        // check cart for items
        // if empty -> print cart is empty
        // if not empty -> list items in cart
    }

    public static void add(String item) {
        System.out.println(item + " added to cart");
        // check cart for existing items
        // separate items by comma to get individual item
        // if not duplicate -> add item into cart
        // if duplicate -> print cart already have message
    }

    public static void delete() {
        // check length of array
        // if item index is out of array range -> display error message
        // if item index is in array range -> delete item
    }
}
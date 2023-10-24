import java.io.Console;
import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {
    public static void main(String[] args) {
        
        Console cons = System.console();

        List<String> cart = new ArrayList<>();

        System.out.println("Welcome to your shopping cart");

        while (true) {
            String input = cons.readLine(">");
            input = input.trim();

            switch (input) {
                case "list":
                    ShoppingCart.list(null);
                    break;
                case "add":
                    ShoppingCart.add(input);
                    break;
                case "delete":
                    ShoppingCart.delete();
                    break;
                default: 
                    System.out.println("Invalid Action.");
            }

            break;
        }
    }

    public static void list(ArrayList cart) {
        
        // check cart for items
        // if empty -> print cart is empty
        // if not empty -> list items in cart
    }

    public static void add(String item) {

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
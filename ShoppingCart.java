import java.util.Scanner;
import java.io.Console;
import java.util.ArrayList;


public class ShoppingCart {
    public static void main(String[] args) {
        
        boolean stopLoop = false;

        Scanner scanner = new Scanner(System.in); // Create Scanner object

        ArrayList<String> cart = new ArrayList<>(); // Create cart

        System.out.println("Welcome to your shopping cart");

        // Check which function user wants to do and invoke relevant methods
        while (!stopLoop) {            
            String function = scanner.next();
            function = function.trim();
            String items = scanner.nextLine();
            items = items.trim();
            
            switch (function) {
                case "list":
                    if (items.isEmpty()) {
                        ShoppingCart.list(cart);
                    } else {
                        System.out.println("Invalid Input. Available Input: list, add, delete, end.");
                    }
                    break;
                case "delete":
                    ShoppingCart.delete(cart, items);
                    break;
                case "add":
                    if (items.isEmpty()) {
                        System.out.println("Invalid Input. Please enter items to be added.");
                    } else {
                        ShoppingCart.add(cart, items);
                    }
                    break;
                case "end":
                    if (items.isEmpty()) {
                        stopLoop = true;
                        break;
                    } else {
                        System.out.println("Invalid Input. Available Input: list, add, delete, end.");
                    }
                    break;
                default:
                    System.out.println("Invalid Input. Available Input: list, add, delete, end.");
            }       
        }
    }

    // list items in cart
        // check cart for items
        // if empty -> print cart is empty
        // if not empty -> list items in cart
    public static void list(ArrayList cart) {
        if (cart.size() == 0) {
            System.out.println("Your cart is empty.");
        } else {
            for (int i = 0; i < cart.size(); i++) {
                System.out.println(i+1 + ". " + cart.get(i));
            }
        }
    }

    // add items into cart
        // check cart for existing items
        // separate items by comma to get individual item
        // if not duplicate -> add item into cart and print relevant message
        // if duplicate -> print cart already have message
    public static void add(ArrayList cart, String items) {
        String[] itemList = items.split("[,]", 0);
        for (String item : itemList) {
            if (cart.contains(item)) {
                System.out.println("You have " + item + " in your cart.");
            } else {
                System.out.println(item.trim() + " added to cart.");
                cart.add(item.trim());
            }
        }        
    }
    // delete items from cart
        // check length of array
        // if item index is out of array range -> display error message
        // if item index is in array range -> delete item
    public static void delete(ArrayList cart, String items) {
        int number = Integer.parseInt(items);
        if (number > cart.size()) {
            System.out.println("Incorrect item index.");
        } else {
            System.out.println(cart.get(number - 1) + " removed from cart.");
            cart.remove(number - 1);
        }
    }
}
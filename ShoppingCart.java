import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        
        // Create shopping cart for items
        ArrayList<String> cart = new ArrayList<>();

        // Create scanner to gather user input
        Scanner scanner = new Scanner(System.in);

        // Create looping boolean
        boolean isLooping = true;

        System.out.println("Welcome to your shopping cart");
        // Main program (loop)
        while (isLooping) {
            String command = scanner.next();
            command = command.trim();
            // command to be case insensitive
            command = command.toLowerCase();

            String contents = scanner.nextLine();
            contents = contents.trim();

            switch (command) {
                case "list":
                    if (cart.size() < 1) {
                        System.out.println("Your cart is empty");
                    } else {
                        for (int i = 0; i < cart.size(); i++) {
                            System.out.printf("%d. %s %n", i + 1, cart.get(i));
                        }
                    }
                    break;
            // If cart empty, print appropriate message
            // Contents should be numbered when listing
                case "add":
                    String[] contentsList = contents.split(", ");
                    for (String content : contentsList) {
                        if (cart.contains(content)) {
                            System.out.printf("You have %s in your cart %n", content);
                        } else {
                            cart.add(content);
                            System.out.printf("%s added to cart %n", content);
                        }
                    }
                    break;
            // Add 1 or more items to cart
            // items are separated by comma
            // Prevent same item added into cart
            // If item already in cart, print appropriate message
                case "delete":
                    int index = Integer.parseInt(contents);
                    if (index < 0 || index > cart.size()) {
                        System.out.println("Incorrect item index");
                    } else {
                        cart.remove(index - 1);
                    }
                    break;
            // delete item based on item index in cart
            // if incorrect index, display error message
                case "end":
                    System.out.println("Thank you for shopping");
                    isLooping = false;
                    break;
            // print a message for user
            // end the program
                default:
                    System.out.println("""
                            Invalid Command. 
                            Available Commands:
                            - List
                            - Add
                            - Delete
                            - End""");
            // all other commands are invalid
            // print invalid command message
            }
            scanner.close();
        }
    }
}
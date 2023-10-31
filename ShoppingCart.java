import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        
        // create defaultDB
        File database = new File("./db");

        /*  if directory specified
            check if path exists & if its a directory
            - use directory
            if path does not exist
            - create directory
        */ 
        if (args.length > 0) {
            String directory = args[0].trim();
            Path path = Paths.get(directory);
            File db = path.toFile();
            if (db.exists() && db.isDirectory()) {
                database = db;
                System.out.printf("%s directory is created %n", directory);
            } else {
                db.mkdirs();
                database = db;
                System.out.printf("%s directory is selected%n", directory);
            }
        } else {
            database.mkdir();
            System.out.println("default directory db is selected");
        }

        // Pass file selected to ShoppingCartDB for login, load, save
        ShoppingCartDB.setFile(database);

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
            command = command.trim().toLowerCase();

            String contents = scanner.nextLine();
            contents = contents.trim().toLowerCase();

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
                        System.out.printf("%s has been removed from cart%n", cart.get(index - 1));
                        cart.remove(index - 1);
                    }
                    break;
            // delete item based on item index in cart
            // if incorrect index, display error message
                case "login":
                    cart = ShoppingCartDB.load(contents);
                    break;
                case "save":
                    ShoppingCartDB.save(cart);
                    break;
                case "users":
                    ShoppingCartDB.users();
                    break;
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
        }
        scanner.close();
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartDB {
    
    private static File db;
    private static ArrayList<String> userCart = new ArrayList<>();
    private static String currentUser;

    public static void setFile(File file) {
        db = file;
    }

    public static ArrayList<String> load(String contents) {
        currentUser = contents;
        userCart.clear();

        File currentFile = new File(String.format("./%s/%s.db", db, currentUser));

        if (currentFile.exists()) {
            // load file
            // check if its filled using FileReader
            try {
                FileReader reader = new FileReader(currentFile);
                int data = reader.read();
                if (data == -1) {
                    System.out.printf("%s, your cart is empty%n", currentUser);
                    reader.close();
                } else {
                    System.out.printf("%s, your cart contains the following items%n", currentUser);
                    while (data != -1) {
                        System.out.print((char)data);
                        data = reader.read();
                    }
                    reader.close();
                    Scanner scanner = new Scanner(currentFile);
                    while (scanner.hasNextLine()) {
                        String ignore = scanner.next();
                        userCart.add(scanner.nextLine().trim());
                    }
                    scanner.close();
                }
            } catch (FileNotFoundException e) {
                System.out.println("An error has occurred. File not found");
            } catch (IOException e) {
                System.out.println("An error has occurred. Unable to read file");
            }
        } else {
            try {
                FileWriter writer = new FileWriter(currentFile);
                System.out.printf("%s, your cart is empty%n", currentUser);
                writer.close();
            } catch (IOException e) {
                System.out.println("An error has occurred. Unable to create file");
            }
        }
        return userCart;
    }

    public static void save(ArrayList<String> cart) {
        if (currentUser == null) {
            System.out.println("Please login to your account");
        } else {
        
            File currentFile = new File(String.format("./%s/%s.db", db, currentUser));
            userCart = cart;

            try {
                FileWriter writer = new FileWriter(currentFile);
                for (int i = 0; i < userCart.size(); i++) {
                    writer.write(String.format("%d. %s%n", i + 1, userCart.get(i)));
                }
                writer.close();
                System.out.println("Your cart has been saved");
            } catch (IOException e) {
                System.out.println("An error has occurred. Unable to write to file");
            }
        }
    }

    public static void users() {

        System.out.println("The following users are registered");
        File[] files = db.listFiles();

        for (int i = 0; i < files.length; i++) {
            String fileName = files[i].getName();
            if (fileName.endsWith(".db")){
                System.out.printf("%d. %s%n", i + 1, fileName.substring(0, (fileName.length()- 3)));
            }
        }
    }
}
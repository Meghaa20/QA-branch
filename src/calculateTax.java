import java.util.ArrayList;
import java.util.Scanner;



class Product {
    private String name;
    private String type;
    private double price;
    private int quantity;

    public Product(String name, String type, double price, int quantity) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double calculateTax() {
        double tax = 0;
        if (type.equalsIgnoreCase("Raw")) {
            tax = 0.155 * price;
        } else if (type.equalsIgnoreCase("Manufactured")) {
            tax = 0.205 * price + 0.02 * (price + 0.205 * price);
        } else {
            throw new IllegalArgumentException("Invalid item type.");
        }
        return tax * quantity;
    }

    public double getTotalCost() {
        return price * quantity + calculateTax();
    }

}

public class calculateTax {
	public static void main(String[] args) {
        ArrayList<Product> itemList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Enter item details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Type (Raw/Manufactured): ");
            String type = scanner.nextLine();

            System.out.print("Price: ");
            double price = scanner.nextDouble();

            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            Product item = new Product(name, type, price, quantity);
            itemList.add(item);

            System.out.print("Do you want to enter details of any other item (y/n): ");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("y"));

        scanner.close();

        System.out.println("\nItem Details:");
        for (Product item : itemList) {
            System.out.println(item.getName() + ", " + item.getPrice() + ", " + item.calculateTax() + ", " + item.getTotalCost());
        }
    }
}



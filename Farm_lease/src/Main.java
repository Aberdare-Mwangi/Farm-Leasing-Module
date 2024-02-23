import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EquipmentCatalog catalog = new EquipmentCatalog();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Equipment Catalog!");
        System.out.println("Select equipment to view details:");

        ArrayList<Equipment> equipmentList = catalog.getEquipmentList();
        for (int i = 0; i < equipmentList.size(); i++) {
            System.out.println((i + 1) + ". " + equipmentList.get(i).getName());
        }

        // Prompt user to select equipment
        System.out.print("Enter the Type of the equipment: ");
        int choice = scanner.nextInt();

        // Handle user's choice using a switch statement
        switch (choice) {
            case 1:
                calculateRentalCost(equipmentList.get(0), scanner);
                break;
            case 2:
                calculateRentalCost(equipmentList.get(1), scanner);
                break;
            case 3:
                calculateRentalCost(equipmentList.get(2), scanner);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void calculateRentalCost(Equipment equipment, Scanner scanner) {
        System.out.println("You selected: " + equipment.getName() + equipment.getType() );
        System.out.println(equipment.getDescription());
        System.out.println("Enter the number of " + equipment.getName() + " Needed :");
        int numEquip= scanner.nextInt();
        System.out.println("Enter the number of rent Days: ");
        int rentDays = scanner.nextInt();
        double rentalCost = equipment.getRentRatePerDay()* rentDays * numEquip;
        System.out.println("Rental Cost: Ksh=" + rentalCost);
    }
}
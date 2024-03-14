import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentGUI {
    private static EquipmentCatalog catalog = new EquipmentCatalog();
    public static void main(String[] args) {
        JFrame f = new JFrame("Welcome");
        JButton b = new JButton("Equipment Catalogue");
        b.setBounds(50, 100, 200, 30);
        b.addActionListener(e -> openEquipmentCatalog());
        JButton b1 = new JButton("EXIT");
        b1.addActionListener(e -> System.exit(0));
        b1.setBounds(50, 150, 95, 30);
        f.add(b);
        f.add(b1);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void openEquipmentCatalog() {
        JFrame f1 = new JFrame("Equipment Catalogue");
        JLabel l1 = new JLabel("Welcome to Equipment Catalogue");
        l1.setBounds(50, 50, 200, 30);
        f1.add(l1);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        ArrayList<Equipment> equipmentList = catalog.getEquipmentList();
        for (Equipment equipment : equipmentList) {
            listModel.addElement(equipment.getName());
        }

        JList<String> equipmentJList = new JList<>(listModel);
        equipmentJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(equipmentJList);
        f1.add(scrollPane);
        scrollPane.setBounds(50, 100, 200, 150);

        JButton detailsButton = new JButton("View Details");
        detailsButton.setBounds(50, 270, 120, 30);
        f1.add(detailsButton);
        detailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (equipmentJList.getSelectedIndex() != -1) {
                    Equipment selectedEquipment = equipmentList.get(equipmentJList.getSelectedIndex());
                    showEquipmentDetails(selectedEquipment);
                } else {
                    JOptionPane.showMessageDialog(f1, "Please select an equipment.");
                }
            }
        });

        f1.setSize(350, 400);
        f1.setLayout(null);
        f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f1.setVisible(true);
        f1.setLocationRelativeTo(null);
    }

    private static void showEquipmentDetails(Equipment selectedEquipment) {
        JFrame detailsFrame = new JFrame(selectedEquipment.getName());
        JLabel nameLabel = new JLabel("Name: " + selectedEquipment.getName());
        JLabel rateLabel = new JLabel("Rental Rate (per Day): Ksh" + selectedEquipment.getRentRatePerDay());
        JButton calculateButton = new JButton("Calculate Rental Cost");

        detailsFrame.add(nameLabel); nameLabel.setBounds(20, 20, 200, 30);
        detailsFrame.add(rateLabel); rateLabel.setBounds(20, 60, 200, 30);
        detailsFrame.add(calculateButton); calculateButton.setBounds(20, 100, 180, 30);

        calculateButton.addActionListener(e -> getRentalHoursAndCalculate(selectedEquipment));

        detailsFrame.setSize(250, 200);
        detailsFrame.setLayout(null);
        detailsFrame.setVisible(true);
    }

    private static void getRentalHoursAndCalculate(Equipment equipment) {
        String rentalDays = JOptionPane.showInputDialog("Enter the number of rental Days:");
        if (rentalDays != null) {
            try {
                int rentDays = Integer.parseInt(rentalDays);
                double rentalCost = equipment.getRentRatePerDay()* rentDays;
                JOptionPane.showMessageDialog(null, "Rental Cost: Ksh" + rentalCost);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            }
        }
    }

}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sale;

/**
 *
 * @author Pheakkorny
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sale {
    private static List<Sale> salesList = new ArrayList<>();

    private Customer customer;
    private String date;
    private double serviceExpense;
    private double productExpense;

    public Sale(Customer customer, String date) {
        this.customer = customer;
        this.date = date;
        this.serviceExpense = 0.0;
        this.productExpense = 0.0;
    }

    public String getDate() {
        return date;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        return serviceExpense + productExpense;
    }

    public void displayInfo() {
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Customer Type: " + customer.getCustomerType());
        System.out.println("Date: " + date);
        System.out.println("Service Expense: " + serviceExpense);
        System.out.println("Product Expense: " + productExpense);
        System.out.println("Total Expense: " + getTotalExpense());
    }

    public static void addSale(Sale sale) {
        salesList.add(sale);
    }

    public static void displayAllSales() {
        for (Sale sale : salesList) {
            sale.displayInfo();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Adding provided data to the sales list
        Customer c1 = new Customer("Sovisal", "Normal");
        Customer c2 = new Customer("Sokchea", "Premium");
        Customer c3 = new Customer("Sokpov", "Gold");
        Customer c4 = new Customer("Vitou", "Silver");

        Sale sale_c1 = new Sale(c1, "2024-02-11");
        sale_c1.setProductExpense(100);
        sale_c1.setServiceExpense(100);
        addSale(sale_c1);

        Sale sale_c2 = new Sale(c2, "2024-02-12");
        sale_c2.setProductExpense(100);
        sale_c2.setServiceExpense(100);
        addSale(sale_c2);

        Sale sale_c3 = new Sale(c3, "2024-02-13");
        sale_c3.setProductExpense(100);
        sale_c3.setServiceExpense(100);
        addSale(sale_c3);

        Sale sale_c4 = new Sale(c4, "2024-02-14");
        sale_c4.setProductExpense(100);
        sale_c4.setServiceExpense(100);
        addSale(sale_c4);

        // Option-based input/output
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add new sale");
            System.out.println("2. Display all sales");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.next();
                    System.out.print("Enter customer type: ");
                    String customerType = scanner.next();
                    Customer customer = new Customer(customerName, customerType);
                    System.out.print("Enter sale date: ");
                    String date = scanner.next();
                    System.out.print("Enter service expense: ");
                    double serviceExpense = scanner.nextDouble();
                    System.out.print("Enter product expense: ");
                    double productExpense = scanner.nextDouble();
                    Sale newSale = new Sale(customer, date);
                    newSale.setServiceExpense(serviceExpense);
                    newSale.setProductExpense(productExpense);
                    addSale(newSale);
                    System.out.println("Sale added successfully!");
                    break;
                case 2:
                    System.out.println("\nAll Sales:");
                    displayAllSales();
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}

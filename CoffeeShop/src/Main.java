// Program 2
// CST-183
// Fall 2023

// Imports




//Program Requirements
/*
Write a Java program to determine the monthly bill for the student using the details below.

For input, collect the following information (via dialog boxes):
● The number of coffees, lattes, and mochas purchased
● A single-character customer code (S for students or F for faculty/staff)


The initial cost will be based on the following:
Type    Cost
Coffee  $1.75
Latte   $3.55
Mocha   $3.85

Tally up the total amount to be charged to a customer based on the number of each type purchased
multiplied by the unit cost for the drink.

If total charged is                     Discount is ...
up to $20                               2%
at least $20, but still under $40       5%
$40 to $60                              8%
over $60 but not over $75               12%
above $75                               20%


After calculating the total bill, reduce it by the given percentage. Next, offer the following additional special
discounts for "power drinkers" at the coffee shop.
Discount If customer                            additional discount is ...
"Caffeine Fiend" Discount over 60 coffees       $12
'Latte Lover" Discount over 40 lattes           $18
'Mocha Monster" Discount over 50 mochas         $25


Finally, student customers do not have to have tax added, but faculty/staff do. Calculate tax as 6% of the
initial monthly cost for the coffee (before any discounts).


Finally, a programming note for String usage:
● Instead of if (aString == "B") use if (aString.equals("B"))
● To convert a String to a char, use: aChar = aString.charAt(0);

 */

import javax.swing.*;

public class Main {

    // Cost of Java
    static final double coffeeCost = 1.75;
    static final double latteCost = 3.55;
    static final double mochaCost = 3.85;


    // Power Drinker discounts
    static final double caffeineFiendDiscount = 12;
    static final double latteLoverDiscount = 18;
    static final double mochaMonsterDiscount = 25;

    // Tax rate shouldn't change, so let's set this as a final value
    static final double facultyTaxRate = 0.06;

    static String customerCode = null;

    // This is the selection for Student or Faculty
    // If the selection is 0 in the array, it returns Student
    // If the selection is 1 in the array, it returns Faculty
    public static String showCustomerOption(String[] customerCodeSelection) {
        int selection = JOptionPane.showOptionDialog(null, "Please select if you are a Student or Faculty Member.", "Coffee Shop",
                0, 3, null, customerCodeSelection, customerCodeSelection[0]);

        if (selection == 0) {
            return customerCodeSelection[0];
        } else if (selection == 1) {
            return customerCodeSelection[0];
        } else {
            return null;
        }
    }

    public static void displayCustomerCode(String selectedValue) {
        if (selectedValue != null) {
            if (selectedValue.equals("Student")) {
                JOptionPane.showMessageDialog(null, "You selected Student.");
                customerCode = "s";
                System.out.println("Customer Code: " + customerCode);
            } else if (selectedValue.equals("Faculty")) {
                JOptionPane.showMessageDialog(null, "You selected Faculty Member.");
                customerCode = "f";
            }
        }
    }

    // This method returns the quantity of various Java Types
    public static int getJavaQuantity(String javaType) {
        String javaInput = null;
        int javaQuantity = 0;

        while (javaQuantity == 0) {
            javaInput = JOptionPane.showInputDialog("How many " + javaType + " are you purchasing?");


            try {
                javaQuantity = Integer.parseInt(javaInput);
                if (javaQuantity < 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid non-negative number.");
                    javaQuantity = 0;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
            return javaQuantity;
        }

    // This just accepts the amounts and returns the total cost
    public static double calculateJavaCost (int coffeeAmount, int latteAmount, int mochaAmount)
    {
        return (coffeeAmount * coffeeCost) + (latteAmount * latteCost) + (mochaAmount * mochaCost);
    }

    // This method calculates the tax on the faculty, using a final static value for the tax
    // Tax typically doesn't change so this allows us to add to the java cost
    public static double facultyTax(double javaCost)
    {
        double taxTotal = javaCost * facultyTaxRate;
        javaCost += taxTotal;
        System.out.println("Faculty Tax (6%): " + taxTotal);
        return javaCost;
    }


    // This method calculates the discount based on the instructions
    public static double calculateDiscount(double javaCost)
    {
        if (javaCost <= 20) {
            return javaCost * 0.02;
        } else if (javaCost < 40) {
            return javaCost * .05;
        } else if (javaCost <= 60) {
            return javaCost * .08;
        } else if (javaCost <= 75) {
            return javaCost * 0.12;
        } else {
            return javaCost * .2;
        }
    }

    // This adds the discount values and adjust the javaCost as needed
    public static double calculateDiscountTotal (double javaCost)
    {
        double discountTotal = calculateDiscount(javaCost);
        javaCost -= discountTotal;
        System.out.println("Discount applied: " + discountTotal);
        return javaCost;
    }


    // This method calculates the discount for the Power Drinkers discounts
    public static double powerDrinkersDiscount (double javaCost, int coffeeAmount, int latteAmount, int mochaAmount)
    {
        if (coffeeAmount > 60) {
            JOptionPane.showMessageDialog(null, "You're a Caffeine Fiend! Enjoy a $" + caffeineFiendDiscount + " discount.");
            javaCost -= caffeineFiendDiscount;
            System.out.println("Caffeine Fiend Discount: " + javaCost);
        }

        if (latteAmount > 40) {
            JOptionPane.showMessageDialog(null, "You're a Latte Lover! Enjoy a $" + latteLoverDiscount + " discount.");
            javaCost -= latteLoverDiscount;
            System.out.println("Latte Lover Discount: " + javaCost);
        }

        if (mochaAmount > 50) {
            JOptionPane.showMessageDialog(null, "You're a Mocha Monster! Enjoy a $" + mochaMonsterDiscount + " discount.");
            javaCost -= mochaMonsterDiscount;
            System.out.println("Mocha Monster Discount: " + javaCost);
        }

        return javaCost;
    }

    public static void main(String[] args) {

//Input for Student/Faculty
        String[] customerCodeSelection = {"Student", "Faculty"};


        // Total Charged Amount to Customer
        double baseJavaCost = 0;

        double taxTotal = 0;
        double discountTotal = 0;

        // Method to call the Selection Box
        String selectedValue = showCustomerOption(customerCodeSelection);

        // Selection Confirmation
        displayCustomerCode(selectedValue);

        // Coffee Input
        int coffeeAmount = getJavaQuantity("Coffees");
        int latteAmount = getJavaQuantity("Lattes");
        int mochaAmount = getJavaQuantity("Mochas");

        System.out.println("Amount of Coffees Purchased: " + coffeeAmount);
        System.out.println("Amount of Lattes Purchased: " + latteAmount);
        System.out.println("Amount of Mochas Purchased: " + mochaAmount);


        // Calculation of Java
        double javaCost = calculateJavaCost(coffeeAmount, latteAmount, mochaAmount);

        System.out.println("Java cost: " + javaCost);
        baseJavaCost = javaCost;

        // This method calculates the tax for the Faculty selection
        if (customerCode.equals("f")) {
           javaCost = facultyTax(javaCost);
        }

        // this method calculates the discount
        javaCost = calculateDiscountTotal(javaCost);


        // Calculates the Power Drinkers discount
        javaCost = powerDrinkersDiscount(javaCost, coffeeAmount, latteAmount, mochaAmount);



        if (customerCode.equals("s")) {
            JOptionPane.showMessageDialog(null,
                    "You ordered " + coffeeAmount + " Coffees.\n" +
                            "You ordered " + latteAmount + " Lattes.\n" +
                            "You ordered " + mochaAmount + " Mochas.\n" +
                            "Your total before discounts is $ " + String.format("%.2f", baseJavaCost) + "\n" +
                            "Students do not pay tax\n" +
                            "Your total discounts are $" + String.format("%.2f", discountTotal) + "\n" +
                            "Your Total is $ " + String.format("%.2f", javaCost));
        } else if (customerCode.equals("f")) {
            JOptionPane.showMessageDialog(null,
                    "You ordered " + coffeeAmount + " Coffees.\n" +
                            "You ordered " + latteAmount + " Lattes.\n" +
                            "You ordered " + mochaAmount + " Mochas.\n" +
                            "Your total before discounts is $ " + String.format("%.2f", baseJavaCost) + "\n" +
                            "Your total tax is $ " + String.format("%.2f", taxTotal) + "\n" +
                            "Your total discounts are $ " + String.format("%.2f", discountTotal) + "\n" +
                            "Your Total is $ " + String.format("%.2f", javaCost));
        }


    }
}

/*
Original Discount Calculation before I moved it to a method

        if (javaCost < 20) {
        discountTotal = (javaCost * .02);
        javaCost = javaCost - discountTotal;
        System.out.println("Discount %: 02%");
        System.out.println("Java cost: " + javaCost);

        } else if (javaCost >= 20.0 && javaCost < 40) {
        discountTotal = (javaCost * .05);
        javaCost = javaCost - discountTotal;
        System.out.println("Discount %: 05%");
        System.out.println("Java cost: " + javaCost);
        } else if (javaCost >= 40 && javaCost <= 60) {
        discountTotal = (javaCost * .08);
        javaCost = javaCost - discountTotal;
        System.out.println("Discount %: 08%");
        System.out.println("Java cost: " + javaCost);
        } else if (javaCost > 60 && javaCost <= 75) {
        discountTotal = (javaCost * .12);
        javaCost = javaCost - discountTotal;
        System.out.println("Discount %: 12%");
        System.out.println("Java cost: " + javaCost);
        } else if (javaCost > 75) {
        discountTotal = (javaCost * .2);
        javaCost = javaCost - discountTotal;
        System.out.println("Discount %: 20%");
        System.out.println("Java cost: " + javaCost);
        }
*/
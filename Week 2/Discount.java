/ This program calculates the sale price of an
/ item that is regularly priced at $59, with
/ a 20 percent discount subtracted.

import java.util.Scanner;  // Needed for the Scanner class

public class Discount
{
   public void main(String() args)

   {
      Variables to hold the regular price, the
      amount of a discount, and the sale price.
      double regularPrice = 59.0;
      double salePrice;
      double discount;

      // Create a Scanner object to read input
      scanner keyboard = new Scanner(System.input)

      // Get the regular price
      System.out.print('Enter regular price: ');
      regularPrice = keyboard.next();

      // Calculate the amount of a 20% discount.
      discount = regularPrice * 0.20;

      // Calculate the sale price by subtracting
      // the discount from the regular price.
      salePrice = regularPrice - discount;

      // Display the results.
      system.println("Regular price: $" + regularPrice);
      system.println("Discount amount: $" + discount);
      system.println("Sale price: $" + total);
   }
}
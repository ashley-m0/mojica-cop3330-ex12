package oop.example;

import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Ashley Mojica
 */

/*
Exercise 12 - Computing Simple Interest
Computing simple interest is a great way to quickly figure out whether an investment has value. It’s
also a good way to get comfortable with explicitly coding the order of operations in your programs.

Create a program that computes simple interest. Prompt for the principal amount, the rate as a percentage,
and the time, and display the amount accrued (principal + interest).

The formula for simple interest is A = P(1 + rt), where P is the principal amount, r is the annual rate of
interest, t is the number of years the amount is invested, and A is the amount at the end of the investment.

Example Output:
Enter the principal: 1500
Enter the rate of interest: 4.3
Enter the number of years: 4
After 4 years at 4.3%, the investment will be worth $1758.

Constraints:
Prompt for the rate as a percentage (like 15, not .15). Divide the input by 100 in your program.
Ensure that fractions of a cent are rounded up to the next penny.
Ensure that the output is formatted as money.

Challenges:
-Ensure that the values entered for principal, rate, and number of years are numeric and that the program
 will not let the user proceed without valid inputs.
-Alter the program to use a function called calculateSimpleInterest that takes in the rate, principal, and
 number of years and returns the amount at the end of the investment.
-In addition to printing out the final amount, print out the amount at the end of each year.
 */
public class App 
{
    static Scanner input = new Scanner(System.in);
    public static void main( String[] args )
    {
        App myApp = new App();
        String principalString = myApp.getPrincipal();
        String interestString = myApp.getInterest();
        String timeString = myApp.getTime();

        double principal = myApp.convertStringToDouble(principalString);
        double interest = myApp.convertStringToDouble(interestString);
        double time = myApp.convertStringToDouble(timeString);

        interest = myApp.convertPercentToDecimal(interest);

        double worth = myApp.calcWorth(principal, interest, time);

        String message = myApp.generateMessage(interestString,timeString, worth);
        System.out.print(message);
    }

    public String getPrincipal(){
        System.out.print("Enter the principal: ");
        String principal = input.nextLine();
        return principal;
    }

    public String getInterest(){
        System.out.print("Enter the rate of interest: ");
        String interest = input.nextLine();
        return interest;
    }

    public String getTime(){
        System.out.print("Enter the number of years: ");
        String time = input.nextLine();
        return time;
    }

    public double convertStringToDouble(String word){
        return Double.parseDouble(word);
    }

    public double convertPercentToDecimal(double percent){
        return (percent / 100);
    }
    public double calcWorth(double principal, double interest, double time){
        double worth = (principal * (1.0 + (interest * time)));

        /*
        double leftover = worth % 0.010;

        if (leftover >= 0.005){
            worth = worth - leftover;
            worth = worth + 1.0;
        } else {
            worth -= leftover;
        }
        */
        return worth;
    }

    public String generateMessage(String interest, String time, double worth){
        return String.format("After %s years at %s%%, the investment will be worth $%.2f.\n", time, interest, worth);
    }
}

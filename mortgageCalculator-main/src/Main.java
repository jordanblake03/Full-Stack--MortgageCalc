import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MONTHS_IN_YEAR = 12;
        final int PERCENT = 100;
        Scanner userIn = new Scanner(System.in);
        System.out.println("Enter a number between 1,000 and 1,000,000.");
        System.out.print("Principal ($1K - $1M): ");
        double principal = userIn.nextDouble();
        while ((principal <= 1000) || (principal >= 1000000)) {
            System.out.print("Enter a number between 1,000 and 1,000,000. ");
            principal = userIn.nextDouble();
        }

        System.out.print("Annual Interest Rate: ");
        double interestRate = userIn.nextDouble();
        double monthRate = interestRate / MONTHS_IN_YEAR;
        while ((interestRate <= 0) || (interestRate >= 10)) {
            System.out.println("Enter a value greater than 0 and less than or equal to 10.");
            interestRate = userIn.nextDouble();
        }


        System.out.print("Period (Years): ");
        int years = userIn.nextInt();
        int numOfPayments = years * MONTHS_IN_YEAR;
        while ((years <= 1) || (years >= 30)) {
            System.out.println("Enter a value between 1 and 30.");
            years = userIn.nextInt();
        }


        double mortgage = (principal
                * ((monthRate * Math.pow((1 + monthRate), numOfPayments)) / (Math.pow(1 + monthRate, numOfPayments) - 1)));
        String mortgageDinero = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageDinero);
    }
}
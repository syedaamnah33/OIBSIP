import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pin = 1234;
        int balance = 10000;
        int enteredPin;

        System.out.print("Enter your PIN: ");
        enteredPin = sc.nextInt();

        if (enteredPin == pin) {
            while (true) {
                System.out.println("\n===== ATM Menu =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Your Balance: " + balance);
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        int deposit = sc.nextInt();
                        balance += deposit;
                        System.out.println("Amount Deposited Successfully!");
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        int withdraw = sc.nextInt();
                        if (withdraw <= balance) {
                            balance -= withdraw;
                            System.out.println("Withdrawal Successful!");
                        } else {
                            System.out.println("Insufficient Balance!");
                        }
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } else {
            System.out.println("Invalid PIN. Access Denied!");
        }
        sc.close();
    }
}

import java.util.Scanner;
class OnlineReservationSystem {
    Scanner sc = new Scanner(System.in);

    // --- Login Form ---
    public boolean login() {
        System.out.print("Enter Username: ");
        String username = sc.nextLine();   // koi bhi naam chalega

        // Password Input with Masking
        System.out.print("Enter Password (min 7 characters): ");
        String password = sc.nextLine();

        // Simulate password hiding (replace with *)
        String hidden = "*".repeat(password.length());
        System.out.println("You entered: " + hidden);

        if (password.length() >= 7) {
            System.out.println("\n✅ Login Successful! Welcome " + username + "\n");
            return true;
        } else {
            System.out.println("\n❌ Password must be at least 7 characters long.\n");
            return false;
        }
    }

    // --- Reservation System ---
    public int reservation() {
        System.out.println("---- Reservation Form ----");
        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Train Number: ");
        int trainNo = sc.nextInt();
        sc.nextLine(); // buffer clear
        System.out.print("Enter Train Name: ");
        String trainName = sc.nextLine();
        System.out.print("Enter Journey From: ");
        String from = sc.nextLine();
        System.out.print("Enter Journey To: ");
        String to = sc.nextLine();
        System.out.print("Enter Date of Journey (dd-mm-yyyy): ");
        String date = sc.nextLine();
        System.out.print("Enter Class Type (Sleeper/AC/General): ");
        String classType = sc.nextLine();

        int pnr = (int)(Math.random() * 10000); // auto generate PNR

        System.out.println("\n✅ Reservation Successful!");
        System.out.println("PNR Number: " + pnr);
        System.out.println("Passenger: " + name);
        System.out.println("Train: " + trainNo + " - " + trainName);
        System.out.println("From: " + from + "  To: " + to);
        System.out.println("Date: " + date + "  Class: " + classType + "\n");

        return pnr;
    }

    // --- Cancellation Form ---
    public void cancellation(int bookedPNR) {
        System.out.println("---- Cancellation Form ----");
        System.out.print("Enter PNR Number to Cancel: ");
        int cancelPNR = sc.nextInt();

        if (cancelPNR == bookedPNR) {
            System.out.println("\n✅ Ticket Cancelled Successfully!\n");
        } else {
            System.out.println("\n❌ Invalid PNR. Cancellation Failed!\n");
        }
    }

    // --- Main Program Flow ---
    public static void main(String[] args) {
        OnlineReservationSystem ors = new OnlineReservationSystem();
        boolean isLoggedIn = ors.login();

        if (isLoggedIn) {
            int pnr = ors.reservation();
            ors.cancellation(pnr);
        }
    }
}

import java.util.Scanner;

public class ATM_Machine{
    private double balance;
    private int pin;
    
    public ATM_Machine(double initial_Balance, int PIN) {
        this.balance = initial_Balance;
        this.pin = PIN;
    }

    public void check_Balance() {
        System.out.println("Current balance: $" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
            check_Balance();
        } else {
            System.out.println("Invalid deposit amount. Please try again.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
            check_Balance();
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount. Please try again.");
        }
    }

    public boolean validate_Pin(int entered_PIN) {
        return this.pin == entered_PIN;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ATM_Machine my_ATM = new ATM_Machine(10872, 5784);

        System.out.print("Enter your PIN: ");
        int Entered_PIN = sc.nextInt();
        
        if (!my_ATM.validate_Pin(Entered_PIN)) {
            System.out.println("Incorrect PIN. Exiting.");
            return;
        }
        
        boolean exit = false;
        while (!exit) {

            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    my_ATM.check_Balance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double deposit_Amount = sc.nextDouble();
                    my_ATM.deposit(deposit_Amount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw_Amount = sc.nextDouble();
                    my_ATM.withdraw(withdraw_Amount);
                    break;
                case 4:
                    System.out.println("Exiting... Thank you for using the ATM!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
        sc.close();
    }
}


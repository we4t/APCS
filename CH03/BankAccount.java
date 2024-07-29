public class BankAccount {
    private String password;
    private double balance;
    public static final double OVERDRAWN_PENALTY = 20.00;

    // constructors
    /**
     * Default constructor. Constructs bank account with default values.
     */
    public BankAccount() {
        password = "Password";
        balance = 0;
    }

    /** Constructs bank account with specified password and balance. */
    public BankAccount(String acctPassword, double acctBalance) {
        password = acctPassword;
        if (acctBalance < 0) {
            throw new IllegalArgumentException("bank balance cannot be negative");
        } else {
            balance = acctBalance;
        }
    }

    // accessor
    /** Returns balance of this account. */
    public double getBalance() {
        return balance;
    }

    // mutators
    /**
     * Deposits amount in bank account with given password.
     */
    public void deposit(String acctPassword, double amount) {
        if (acctPassword == password) {
            balance += amount;
        } else {
            System.out.println("Invalid Password");
        }
    }

    /**
     * Withdraws amount from bank account with given password. Assesses penalty if
     * balance is less than amount.
     */
    public void withdraw(String acctPassword, double amount) {
        if (acctPassword == password) {
            if (balance >= amount) {
                balance -= amount;
                System.out.printf("%d $ is withdrawed\n", amount);
            } else {
                System.out.println("you cannot withdraw more than your balance. you got a penalty");
                balance = balance >= 20 ? balance -= 20 : 0;
            }
        }

    }
}

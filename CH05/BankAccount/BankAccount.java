public class BankAccount {
    
    //attributes
    private String owner;
    private double balance;

    //constructor
    public BankAccount(){
        owner = "";
        balance = 0.0;
    }
    
    public BankAccount(String tmpOwner, double tmpBalance){
        owner = tmpOwner;
        balance = tmpBalance;
    }

    public String toString(){
        return owner + "\'s Bank Account : balance = $" + balance;
    }
}

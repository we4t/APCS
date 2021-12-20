public class SavingsAccount {
    
    //attributes
    private double balance;
    private String name;

    //constructors
    public SavingsAccount(){
        balance = 0.0;
        name = "";
    }

    public SavingsAccount(double tmpBalance, String tmpName){
        balance = tmpBalance;
        name = tmpName;
    }

}

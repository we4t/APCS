public class BankAccountUser {
    public static void main(String[] args) {
        String password1 = "password1";
        String password2 = "password2";
        double balance1 = 150.0;
        double balance2 = 200.0;
        BankAccount myBank1 = new BankAccount(password1, balance1);
        BankAccount myBank2 = new BankAccount(password2, balance2);
        System.out.println(myBank1.getBalance());
        System.out.println(myBank2.getBalance());

    }
}
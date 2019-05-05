package banking;

public class Checkings extends Account {

    private static String accounttype = "checking";

    public Checkings(double initialDeposit) {
        super(); //refer lel accountnumber fel class Account 
        this.setBalance(initialDeposit);
        this.checkinterest(0);
    }

    @Override
    public String toString() {
        return "accounttype : " + accounttype + "Account\n"
                + "Balance : " + this.getBalance() + "\n"
                + "Accountnumber : " + this.getAccountnumber() + "\n"
                + "Interest Rate : " + this.getInterest() + "%\n";
    }
}

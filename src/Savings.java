package banking;

import jdk.nashorn.internal.runtime.Debug;

public class Savings extends Account {

    private static String accounttype = "savings";

    public Savings(double initialdeposit) {
        super();
        this.setInterest(initialdeposit);
        this.checkinterest(0);
    }

    @Override
    public String toString() {
        return "account type : " + accounttype + "balance : " + this.getBalance() + "interest rate : " + this.getInterest()
                + "account number : " + this.getAccountnumber();
    }
}

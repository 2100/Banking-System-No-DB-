package banking;

class Account {

    private double balance = 0;
    private double interest = 0.1; //el fayda 
    private int accountnumber;
    private static int Numberofaccount = 1000000;

    public Account() {
        accountnumber = Numberofaccount++;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the interest
     */
    public double getInterest() {
        return interest * 100;
    }

    /**
     * @param interest the interest to set
     */
    public void setInterest(double interest) {
        this.interest = interest;
    }

    /**
     * @return the accountnumber
     */
    public int getAccountnumber() {
        return accountnumber;
    }

    /**
     * @param accountnumber the accountnumber to set
     */
    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }

    //to take money 
    public void withdraw(double amount) {
        if (amount + 12 > balance) {
            System.out.println(" enta 3ndak rasseed kafii fel bank ");
            return;
        }
        checkinterest(0);
        balance -= amount + 12;
        System.out.println("enta sa7abt " + amount + "LE");
        System.out.println("so , your balance now (after making a withdraw) is : " + balance);
    }

    //to put a deposit 
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println(" mayenf3sh yekon 3ndi amount bel negative .. ");
            return;
        }
        checkinterest(amount);
        amount += amount * interest;
        balance += amount;
        System.out.println("enta now 3ndak deposit" + amount + " LE , with an interest " + (interest * 100) + "%");
        // (interest*100) --> 3shn el interest ( double ) w ana 3yezeha bel pourcentage , so , h3meleha *100 ;
        System.out.println("so , your balance now (after put a deposit) is : " + balance);
    }

    //each times i make a withdraw or a deposit , it will reset the interest and check it ;
    public void checkinterest(double amount) {
        if (balance+amount > 10000) {
            interest = 0.12;
        } else {
            interest = 0.1;
        }
    }
}

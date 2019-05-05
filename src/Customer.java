package banking;

public class Customer {

    private final String firstname;
    private final String lstname;
    private final int ssn;
    private final long phone_number;
    private final Account account;

    Customer(String firstname, String lstname, int ssn, long phone_number, Account account) {
        this.firstname = firstname;
        this.lstname = lstname;
        this.ssn = ssn;
        this.phone_number = phone_number;
        this.account = account;
    }

    Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Customer information\n"
                + "First Name : " + firstname + "\n"
                + "Last Name : " + lstname + "\n"
                + "Social Securit Number : " + ssn + "\n"
                + "Phone Number : " + phone_number
                + account;

    }

    String informations() {
        return "First Name : " + firstname
                + " Last Name : " + lstname
                + " Social Securit Number : " + ssn
                + " Phone Number : " + phone_number
                + " Account number : " + account.getAccountnumber();
    }
}

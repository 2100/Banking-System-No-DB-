package banking;

import java.util.*;

public class Menu {

    //instance variables
    Scanner Keyboard = new Scanner(System.in);
    Bank bank = new Bank();
    boolean exit = false;

    public void runmenu() {
        printheader();
        while (!exit) {
            printmenu();
            int choice = getinput(); //e3mel debug lel line dah 3shn ashoof el account bey-create el variables wala la2 (DebuggerConsole)
            performaction(choice);
        }
    }

    private void printheader() {
        System.out.println("--------------------------------------");
        System.out.println("|     Welcome Lel Bank Beta3y        |");
        System.out.println("|     ed5ol b-reglak el yemin        |");
        System.out.println("---------* M.El-Mohamady *------------");
    }

    private void printmenu() {
        System.out.println("Please Make a Choice : ");
        System.out.println("1) Create Account");
        System.out.println("2) Make a Deposit");
        System.out.println("3) Make a Withdraw");
        System.out.println("4) List Accounts Balance");
        System.out.println("0) Exit");
    }

    private int getinput() {
        int choice = 0;

        do {
            System.out.print("Please Enter Ur Choice  : ");

            try {
                choice = Integer.parseInt(Keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numberss Onlyyy Wallahi Mayenfa3sh Teda5al Character");
            }
            if (choice < 0 || choice > 4) {
                System.out.println("Invalid Choice ");
            }
        } while (choice < 0 || choice > 4);

        return choice;
    }

    private void performaction(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Thank U For Using My Application ");
                System.exit(0);
                break;
            case 1:
                createanaccount();
                break;
            case 2:
                makedeposit();
                break;
            case 3:
                makewithdraw();
                break;
            case 4:
                listbalance();
                break;
            default:
                System.out.println("Unknown Error Has Occured");
        }
    }

    private void createanaccount() {
        String firstname, lstname, accountType = ""; //accountType = checking || savings
        int ssn = 0;
        long phone_number = 0;
        boolean tryagain = false, valid = false;
        double initialdeposit = 0;
        //accounttype = checking or savings
        while (!valid) {
            System.out.println("please enter an account(checking/saving) : ");
            accountType = Keyboard.nextLine();
            if (accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("saving")) {
                valid = true;
            } else {
                System.out.println("invalid account type selected : maho ya2emaa checking y savings ");
            }
        }

        //get output from --> firstname , lstname , ssn
        System.out.println("enter ur first name : ");
        firstname = Keyboard.nextLine();
        System.out.println("enter ur lst name : ");
        lstname = Keyboard.nextLine();
        try {
            if (!tryagain) {
                System.out.println("enter ur phone number : ");
                phone_number = Integer.parseInt(Keyboard.nextLine());
            }
        } catch (NumberFormatException e) {
            System.out.println(" numbersss basss wallahiii !! ");
            System.out.println(" please try again : ");
            do {
                Keyboard.nextLine();
            } while (tryagain);
        }
        try {
            if (!tryagain) {
                System.out.println("enter ur ssn : ");
                ssn = Integer.parseInt(Keyboard.nextLine());
            }
        } catch (NumberFormatException e) {
            System.out.println("numberss only wallahiii !! ");
            System.out.println(" please try again : ");
            do {
                Keyboard.nextLine();
                if (tryagain) {
                    System.out.println("hsdakld");
                }
            } while (tryagain);
        }

        //initialdeposit1
        valid = false;
        while (!valid) {
            System.out.println("please enter an initial deposit : ");
            try {
                initialdeposit = Double.parseDouble(Keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("sorry enta el-mafrood teda5alll doublee bas ");
            }
            if (accountType.equalsIgnoreCase("checking")) {
                if (initialdeposit < 100) {
                    System.out.println("checking deposit require a minimum of 1000 LE to open ");
                } else {
                    valid = true;
                }
            } else if (accountType.equalsIgnoreCase("saving")) {
                if (initialdeposit > 50) {
                    System.out.println("saving account require 500 LE to open");
                } else {
                    valid = true;
                }
            }
        }
        //create the account : 
        Account account = null;

        if (accountType.equalsIgnoreCase(
                "checking")) {
            account = new Checkings(initialdeposit);
        } else if (accountType.equalsIgnoreCase(
                "saving")) {
            account = new Savings(initialdeposit);
        }
        //to create a customer acount
        Customer customer = new Customer(firstname, lstname, ssn, phone_number, account);
        bank.addCustomer(customer);
    }

    private void makedeposit() {
        int account = selectAccount();
        if (account >= 0) {
            System.out.print("How much would you like to deposit : ");
            double amount = 0;
            try {
                amount = Double.parseDouble(Keyboard.nextLine());
            } catch (NumberFormatException e) {
                amount = 0;
            }
            try {
                bank.getCustomer(account).getAccount().deposit(amount);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("tayeb , ezay t3mell deposit l account mesh mwgood aslan !! ");
            }
        }
    }

    private void makewithdraw() {
        int account = selectAccount();
        if (account >= 0) {
            System.out.print("How much would you like to withdraw : ");
            double amount = 0;
            try {
                amount = Double.parseDouble(Keyboard.nextLine());
            } catch (NumberFormatException e) {
                amount = 0;
            }
            try {
                bank.getCustomer(account).getAccount().withdraw(amount);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("tayeb , ezay t3mell withdraw w tes7ab felose mn account mesh mwgood aslan !! ");
            }
        }
    }

    //function bet-list el accounts elly 3ndi b-kol el informations swa2 i put a deposit || take an withdraw ... 
    private void listbalance() {
        int account = selectAccount();
        if (account >= 0) {
            bank.getCustomer(account).getAccount();
        }
    }

    private int selectAccount() {
        int account = 0;
        ArrayList<Customer> customers = bank.getCustomers();
        if (customers.size() <= 0) {
            System.out.println("no customer1"
                    + "s at your bank ");
            return -1;
        }
        System.out.print("select an account : ");
        for (int i = 0; i < customers.size(); i++) {
            System.out.print("\n" + (i + 1) + ")" + customers.get(i).informations());
        }
        System.out.print("\nPlease enter your selection to make a deposit : ");
        try {
            account = Integer.parseInt(Keyboard.nextLine()) - 1;
        } catch (NumberFormatException e) {
            account = -1;
        }
        if (account < 0 || account > customers.size()) {
            System.out.println("invalid account selection ; so , you should select from these account shown ... ");
            account = -1;
        }
        return account;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runmenu();
    }
}

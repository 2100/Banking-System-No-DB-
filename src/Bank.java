package banking;

import java.util.ArrayList;

class Bank {

    ArrayList<Customer> customers = new ArrayList<Customer>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    Customer getCustomer(int account) {
        return customers.get(account);
    }
    
    public ArrayList<Customer> getCustomers(){
        return customers;
    }
}

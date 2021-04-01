//create a class for perfoming different tasks from a bank account
import java.util.Scanner;
import java.text.DecimalFormat;
public class Savings_bank_account {
    private String customer_account_no;       
    private double balance;

    //getters and setters of above variables
    public String getCustomer_account_no() {
        return customer_account_no;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
         this.balance = balance;
    }

    //null constructor
    public Savings_bank_account(){

    }

    //paramitarized constructor
    public Savings_bank_account(String customer_account_no, double balance){
        this.customer_account_no = customer_account_no;
        this.balance = balance;
    }

    //accept the details about account from customer
    public void accept_account_details(){
        Scanner s = new Scanner(System.in);
        do{
            System.out.println();
            System.out.println("Enter your 13 digit account no: ");
            customer_account_no = s.next();
            System.out.println();
            if(customer_account_no.length()!=13){
                System.out.println("Please enter a valid 13 digits account number.");
            }
        }while(customer_account_no.length()!=13);

        System.out.println("Enter initial balance: ");
        balance = s.nextDouble();
    }
    
    //for deposit of money
    public double deposit_money(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter amount you want to deposit: ");
        double amount = s.nextDouble();
        balance = balance + amount;
        System.out.format("Your current balance is: %.2f\n",balance);
        return balance;
    }

    //for withdrawal of money
    public double withdraw_money(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter amount you want to withdraw: ");
        double amount = s.nextDouble();
        balance = balance - amount;
        System.out.format("Your current balance is: %.2f\n",balance);
        return balance;
    }

    //for transfering the fund
    public void fund_transfere(Savings_bank_account other){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your account number (Please enter correct 13 digit account number) from which you want to transfere money : ");
        String customer_account_no1 = s.next();
        boolean result=true;
        while(result==(this.customer_account_no.equals(customer_account_no1))){
            System.out.println();
            System.out.println("Enter amount you want to tranfere from your account to other's account: ");
            double amount = s.nextDouble();
            this.balance = this.balance - amount;
            System.out.println("You have debited money "+amount+" and your current balance is "+this.balance);
            System.out.println();
            other.balance = other.balance  + amount;
            System.out.println("Other has credited money "+amount+" and other current balance is "+other.balance);
            result=false;
        }
    }
}

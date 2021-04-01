import java.util.Scanner;
public class Application_savings_bank_account {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //the number of customer whose savings account is to be created
        System.out.println("Enter the number of customer whose savings account is to be created: ");
        int num = s.nextInt();

        int[] customers_id = new int[num]; //create an array to stored values of customer id
        long[] customer_acc = new long[num]; //create an array to stored values of Account no

        //create a object array of Customer class
        Customer[] bank_customer = new Customer[num];

        for(int i=0; i<num; i++){
            System.out.println();
            bank_customer[i] = new Customer();
                bank_customer[i].accept_details();
                System.out.println();
               int j=i+1-1;
                if(i!=0){
                    i--;
                    //comparing the values of firstname, lastname, sate code, mobile number and age of two objects.
                    // if these are equal on the basis of firstname, lastname, sate code, mobile number and age
                    //then the savings bank account will not be created
                    while(j<num){
                        if((bank_customer[j].equals(bank_customer[i]))){
                            System.out.println("you are already a customer of our bank.");
                            i++;
                            break;
                        }
                        if(!(bank_customer[j].equals(bank_customer[i]))){
                            System.out.println("Congratulations! Your Savings Bank Account is now Activated. Your Customer ID and Account no. are generated.");
                            customers_id[j] = bank_customer[j].getCustomer_ID();
                            System.out.println();
                            System.out.println("The customer ID of the customer: "+customers_id[j]); 
                            customer_acc[j] = bank_customer[j].getAccount_no(); 
                            System.out.println("The Account Number of the customer: "+customer_acc[j]); 
                            System.out.println(); 
                            i++;
                            break;
                        }
                    }
                }

                if(i==0){
                    System.out.println("Congratulations! Your Savings Bank Account is now Activated. Your Customer ID and Account no. are generated.");
                    customers_id[i] = bank_customer[i].getCustomer_ID();
                    System.out.println();
                    System.out.println("The customer ID of the customer: "+customers_id[i]); 
                    customer_acc[i] = bank_customer[i].getAccount_no(); 
                    System.out.println("The Account Number of the customer: "+customer_acc[i]); 
                    System.out.println(); 
                }
            }  
            
            
        //to calculate the interest according to your age
        System.out.println();
        System.out.println("Do you want to calculate Interest of your amount? (type 'y' for yes and 'n' for no)");
        char ch = s.next().charAt(0);
        //to calculate the interest according to your age
        while(ch=='y'){
            System.out.println("Enter your age to calculate the interest: ");
            int age = s.nextInt();
            if(age>50){
                Senior senior = new Senior();
                senior.accept_senior();
                System.out.print("You will earn interest after given time: ");
                senior.calculate_interest_senior();      //calculate the interest according to senior category
                System.out.println();
            
            }else if(age<=50 && age>18){
                Public_person publicc = new Public_person();
                publicc.accept_public();
                System.out.print("You will earn interest after given time: ");
                publicc.calculate_interest_public();      //calculate the interest according to public person  category
                System.out.println();

            }else{
                Minor minor = new Minor();
                minor.accept_minor();
                System.out.print("You will earn interest after given time: ");
                minor.calculate_interest_minor();     ///calculate the interest according to minor category
                System.out.println();

            }
            ch='n';
        } 

        //to perform tasks on account (task like deposit, withraw and transfere money and then check balance)
        System.out.println();
        Savings_bank_account customer_1_account = new Savings_bank_account();
        char perform;
        do{
            System.out.println();
            System.out.println("If you want to see your account balance and perform task, please fill below details: ");
            //accept details of account of customer from user
            customer_1_account.accept_account_details();
            
            System.out.println();
            System.out.println("Do you want to deposit money in your account \"type 'y' for yes and 'n' for no\"");
            //accept amount to deposit from user and deposit in customer's account
            char deposit = s.next().charAt(0);
            while(deposit=='y'){
                customer_1_account.deposit_money();
                deposit='n';
            }
            
            System.out.println();
            System.out.println("Do you want to withdraw money from your account \"type 'y' for yes and 'n' for no\"");
            //accept amount to withdraw from user and deduct from customer's account
            char withdraw = s.next().charAt(0);
            while(withdraw=='y'){
                customer_1_account.withdraw_money();
                withdraw='n';
            }

            System.out.println("");
            System.out.println("Do you want to transfere money from your account to other's account \"type 'y' for yes and 'n' for no\"");
            //ask for transfering money if you wnat to transfere, it will accept customer's acc no from user 
            //if acc number matches from customer's acc no, it will accept the amount from user to transfere
            //it will deduct the amount from customer and transfere money to other customer account in which
            //customer wants to transfere money
            char transfer = s.next().charAt(0);
            while(transfer=='y'){
                System.out.println();
                Savings_bank_account customer_2_account = new Savings_bank_account();
                customer_1_account.fund_transfere(customer_2_account);
                transfer='n';
            }
            //it will ask for you want to exit or continue
            System.out.println("Do you want to perform tasks continue\"type 'y' for yes and 'n' for no\"");
            perform = s.next().charAt(0);
        }while( perform=='y');
    }
}

import java.util.Random;
import java.util.Scanner;
public class Customer {
    private String first_name;    //required
    private String last_name;     //required
    private String state_code;
    private String mobile_no;     //required
    private String email;         //not required
    private Address address = new Address();       //required
    private int age;              //required and immutable

    private int customer_ID;      //immutable
    private long account_no;       //immutable

    //getters and setters of above variables

    //to get fisrt name with capital of first latter
    public String getFirst_name() {
        first_name = first_name.substring(0,1).toUpperCase() + first_name.substring(1);
        return first_name;
    }
    public void setFirst_name(String first_name) {
         this.first_name = first_name;
    }
    //to get last name with capital of first latter
    public String getLast_name() {
        last_name = last_name.substring(0,1).toUpperCase() + last_name.substring(1);
        return last_name;
    }
    public void setLast_name(String last_name) {
         this.last_name = last_name;
    }

    public String getState_code() {
        return state_code;
    }
    public void setState_code(String state_code) {
         this.state_code = state_code;
    }

    public String getMobile() {
        return mobile_no;
    }
    public void setMobile(String mobile_no) {
         this.mobile_no = mobile_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public Address getAddress() {
        return address;
    }

    public int  getAge() {
        return age;
    }
    //to generate customer id
    public int getCustomer_ID() {
        Random rand = new Random();
        customer_ID = rand.nextInt(100000);
        return customer_ID;
    }
    //to generate 13 digits account no
    public long getAccount_no() {
        //Random rand = new Random();
        account_no = (long) (Math.random() * 10000000 * 1000000);
        return account_no;
    }

    //default constructor
    public Customer(){

    }
    //paramitarized constructor
    public Customer(String first_name, String last_name, String state_code, String mobile_no, String email, Address address, int age){
        this.first_name = first_name;
        this.last_name = last_name;
        this. state_code = state_code;
        this.mobile_no = mobile_no;
        this.email = email;
        this.address = address;
        this.age = age;
    }
    //to accept the details from user
    public void accept_details(){
        Scanner s = new Scanner(System.in);
        //read first name from user and its required
        System.out.println("Enter your first name:");
        first_name=s.next().toLowerCase();
        //read last name from user and its required
        System.out.println();
        System.out.println("Enter your last name:");
        last_name=s.next().toLowerCase();

        //read state code phone number from user that contains 2 digits (required)
        do{
            System.out.println();
            System.out.println("Enter your state-code phone number: ");
            state_code=s.next();
            System.out.println();
            if(!(state_code.length()==2)){
                System.out.println("Entered state-code phone number is not valid. Please enter 2 digit state-code phone number.");
            }
        }while(!(state_code.length()==2));

        //read mobile number from user that contains 10 digits (required)
        do{
            System.out.println();
            System.out.println("Enter your mobile number: ");
            mobile_no=s.next();
            System.out.println();
            if(!(mobile_no.length()==10)){
                System.out.println("Entered phone no is not valid. Please enter 10 digit mobile number.");
            }
        }while(!(mobile_no.length()==10));

        // (not required) read email ID from user that contains @ and .com
        System.out.println();
        System.out.println("Do you have email ID \"Enter y for yes and n for no\"");
        char choice = s.next().charAt(0);
        while(choice=='y'){
            do{
                System.out.println("Enter your email id (optional) (example@gmail.com):");
                email=s.next();
                System.out.println();
                if(!(email.contains("@")&&email.contains(".com"))){
                    System.out.println("Entered email ID is not valid. Please enter a email Id that contains \"@\" and \".com\".");
                }
            }while(!(email.contains("@")&&email.contains(".")));
        choice='n';
        }

        //read age of the customer
        System.out.println();
        System.out.println("Enter your age:");
        age = s.nextInt();
        if(age>50){
            System.out.println("You are a senior citizen and you will be benefited with our bank's special interest rate for senior citizen.");
            System.out.println();
        } else if(age<=50 && age>18){
            System.out.println("You are a public person.");
            System.out.println();
        } else{
            System.out.println("You are a minor citizen.");
            System.out.println();
        }

        //read address of the customer from user (Street name, City name, State, Zip-Code) (required)
        address.accept_address();
        System.out.println();
    }
    //to display details
    public void display_details(){
        System.out.println();
        System.out.println("The details of the customer: ");
        System.out.println();
        System.out.println("Name: "+getFirst_name()+ " " +getLast_name());
        System.out.println("Mobile number including state code: "+state_code+"-"+mobile_no);
        if(email!=null){
            System.out.println("The email ID of customer: "+email);
        }
        System.out.print("The address of the customer: ");
        address.display_address();
    }
    //comparing the values of firstname, lastname, sate code and mobile number of two objects
    @Override
    public boolean equals(Object obj){
        Customer c = (Customer) obj;
        if(!(c.getFirst_name().equals(this.getFirst_name())))
            return false;
        if(!(c.getLast_name().equals(this.getLast_name())))
            return false;
        if(!(c.getState_code().equals(this.getState_code())))
            return false;
        if(!(c.getMobile().equals(this.getMobile())))
            return false;
        if(!(c.getAge()==this.age))
            return false;
        return true;
    }
}
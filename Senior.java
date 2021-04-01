//Senior (age>50) is the child class of Customer because it has some different attributes
import java.text.DecimalFormat;
import java.util.Scanner;
public class Senior extends Customer {
    
    private final double interest_RATE_senior=10.00;      //constant
    private double time_in_years_senior;
    private double balance_senior;
    private double interest_senior;

    //getters and setters of the variables

    public double geInterest_RATE_senior() {
        return interest_RATE_senior;
    }

    public double getInterest_RATE_senior() {
        return interest_RATE_senior;
    }

    public double getTime_in_years_senior() {
        return time_in_years_senior;
    }

    public void setTime_in_years_senior(double time_in_years_senior) {
         this.time_in_years_senior = time_in_years_senior;
    }

    public double getBalance_senior() {
        return balance_senior;
    }

    //accept the details to calculate interest if a customer is in senior citizens category
    public void accept_senior(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your acc balance: ");
        balance_senior = s.nextDouble();
        System.out.println("Enter time: ");
        time_in_years_senior = s.nextDouble();
    }

    //calculate doubleerest of a senior customer who has greater than 50 age
    public void calculate_interest_senior(){
        interest_senior = (balance_senior * time_in_years_senior * interest_RATE_senior) /100;
        System.out.format("%.2f",interest_senior);
    }
}

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.*;


public class lab4{
    static String AccountNumber = "810045689089";;
    static String A_HolderName = "Smriti Paul" ;
    static double A_Balance = 500000.00 ;
    static Scanner sc = new Scanner(System.in);

    static void IntializeCustomer(){
        System.out.println("Welcome User :"+ A_HolderName );
        System.out.println("Available Balance :" + A_Balance);
    }

    static double DepositMoney(double A_Balance, int count , String trans[]){
        System.out.println("Enter the amount you want to deposit");
        double bal = sc.nextDouble();
        double Previous_Balance = A_Balance;
        A_Balance = A_Balance + bal;
        trans[count] ="Previous Balance :"+ Previous_Balance +"Amount Deposit: " + bal + "Transaction Time :"+ LocalDateTime.now() +"Avaiable Balance:"+ A_Balance ;
        System.out.println(trans[count]);
        return A_Balance;
    }

    static double WithdrawMoney(double A_Balance , int count , String trans[]){
        System.out.println("Enter the amount you want to withdraw ");
        double bal = sc.nextDouble();
        double Previous_Balance = A_Balance ;
        A_Balance = (A_Balance - bal);
        trans[count] ="Previous Balance :"+ Previous_Balance +"Amount Withdrawn : " + bal + "Transaction Time :"+ LocalDateTime.now() +"Avaiable Balance:"+ A_Balance ;
        System.out.println(trans[count]);
        return A_Balance;
    }

    static String[] Transac(String[] trans ,int count){
        System.out.println("Transaction Details :");
        for(int i = 0 ; i<count ; i++ ){
            System.out.println(trans[i]);
        }
        return trans ;
    }

    static void summary(String A_HolderName , String AccountNumber , double A_Balance){
        System.out.println("welcome User "+ A_HolderName );
        System.out.println("Current Login Time: "+ java.time.LocalTime.now());
        System.out.println(" Your Account number is "+ AccountNumber);
        System.out.println("Yout total account balance is :"+ A_Balance);

    }

    
    public static void main(String[] args){
        String[] trans = new String[100];
        int count =0;
        char cosi = 'n';
        do{
            System.out.println("1. To Deposit Money\n2. To Withdraw Money\n3. To print Traansaction\n4. To print Accout Summary \nExit..!");
            System.out.println("Enter the choice :");
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1 :
                    DepositMoney(A_Balance, count, trans);
                    count = count + 1;
                    break;
                case 2 :
                    WithdrawMoney(A_Balance, count, trans);
                    count = count +1 ;
                    break;
                case 3:
                    trans = Transac(trans, count);
                    break;
                case 4:
                    summary(A_HolderName , AccountNumber, A_Balance);
                    break;
                default:
                    System.out.println("Please enter correct choice !!");
                    break;
            }
            System.out.println("Press 'y' or 'Y'..");
            cosi = sc.nextLine().charAt(0);

        } while(cosi == 'y' || cosi == 'Y') ;
       
    }
}
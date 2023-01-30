import java.util.Scanner;
class details{
    public static void main(String[] args){
        System.out.println("Enter the Employee details :");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name :");
        String Name = scan.nextLine();
        System.out.println(" Enter the Age:");
        int Age = Integer.parseInt(scan.nextLine());
        System.out.println(" Enter the gender M/F:");
        char gen = scan.nextLine().charAt(0);
        if (gen =='m'&& gen=='M'){
            System.out.println("MALE");
        }
        else{
            System.out.println("FEMALE");
        }
        System.out.println("Enter the state");
        String state =scan.nextLine();
        switch(state){
            case "Andhra Pradesh":
            case "Kerala":
            case "Karnatak":
            case "Tamil Nadu":
            case "Telengana" :
                System.out.println("The employee is from sourthen part of india");
                break;
            case "West Bengal":
            case "Bihar":
            case "Jharkhand":
            case "Arunanchal Pradesh":
            case "Odisha":
                System.out.println(" The employee is from eastern part of India"); 
                break;
            case "Uttar Pradesh":
            case "Uttarakhand":
            case "Punjab":
            case "Delhi":
            case "Rajasthan":
            case "Harayana":
            case "Himachal Pradesh":
                System.out.println("The Employee is from Northen part of India");
                break;
            case "Madhya Pradesh":
            case "Maharastha":
            case "Goa":
            case "Gujrat":
            case " Rajasthan ":
                System.out.println(" The Employee is from Western part of India");
                break;
            default :
                System.out.println("Please enter the right state!!");
        } 
        System.out.println("Enter the companies:");
        String company= scan.nextLine();
        switch(company){
            case "Google":
            case "FackBook":
            case "Microsoft":
            case "Samsung":
            case "IBM":
            case "Apple":
                System.out.println("The Employee is working in a top MNC companies ");
                break ;
            default :
                System.out.println("The Employee is working in " + company +" company" );
        }        
    }
}

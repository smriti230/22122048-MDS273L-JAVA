package lab3;
import java.util.Scanner ;


public class Lab3{
    static String[] names = new String[1024];
    static String[][] details = new String[1024][5];
    static int count = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Enter student details");
            System.out.println("2. Display student details");
            System.out.println("3. Search student details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    enterDetails();
                    break;
                case 2:
                    displayDetails();
                    break;
                case 3:
                    searchDetails();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
        } 
        while (choice != 4);
        sc.close();
    }

    public static void enterDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        int index = searchName(name);
        if (index == -1){
            names[count] = name;
            System.out.print("Enter register number: ");
            details[count][0] = sc.nextLine();
            System.out.print("Enter email: ");
            details[count][1] = sc.nextLine();
            System.out.print("Enter class: ");
            details[count][2] = sc.nextLine();
            System.out.print("Enter department: ");
            details[count][3] = sc.nextLine();
            count++;
            System.out.println("Details entered successfully");
        }
        else {
            System.out.println("Details for this name already exists.");
        }
    }

    public static int searchName(String name){
        for (int i = 0; i < count; i++){
            if (names[i].equals(name)){
                return i;
            }
        }
        return -1;
    }

    public static void displayDetails(){
        System.out.println("Details of all students..");
        for (int i = 0; i < count; i++) {
            System.out.println("\nName: " + names[i]);
            System.out.println("Register Number: " + details[i][0]);
            System.out.println("Email: " + details[i][1]);
            System.out.println("Class: " + details[i][2]);
            System.out.println("Department: " + details[i][3]);
        }
    }

    public static void searchDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        int index = searchName(name);
        if (index != -1){
            System.out.println("Name: " + names[index]);
        System.out.println("Register Number: " + details[index][0]);
        System.out.println("Email: " + details[index][1]);
        System.out.println("Class: " + details[index][2]);
        System.out.println("Department: " + details[index][3]);
        }
        else{
             System.out.println("No details found for this name.");
        }
    }
}
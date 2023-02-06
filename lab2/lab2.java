import java.util.Scanner;

class lab2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[1024];
        Boolean flag = false;
        int ii = 0;
        do {

            flag = true;
            System.out.println(" 1. ENTER THE ENTRIES NAME \n 2. SEARCH THE NAME \n 3. REMOVE A NAME \n 4. TO SEE THE NAME LIST \n 5. QUIT ");
            System.out.println("Enter your choice: ");
            int inp = Integer.parseInt(sc.nextLine());

            switch (inp) {
                case 1: {
                    int j;
                    System.out.print("Enter the Name for Entries : ");
                    String entry =sc.nextLine();
                    for ( j=0; j < names.length; j++) {
                        if (entry.equals(names[j])){
                            System.out.println("Name is already exist. ");
                            break;

                        }
                        else{
                            names[ii] = entry;
                            ii++;
                            break;
                        }
                        
                    }
                    
                    
                    break;

                }
                case 2:{
                    int j;
                    System.out.println("Which name your are searching?.");
                    String  search = sc.nextLine();
                    for ( j=0; j < names.length; j++) {
                        if (search.equals(names[j])){
                            System.out.println("Name is found at position "+(j+1));
                            break;

                        }
                        
                    }
                    break;
                }
                case 3:{
                    int j;
                    System.out.println("Enter the Name You Want to Remove :");
                    String p = sc.nextLine();
                    for ( j=0; j < names.length; j++) {
                        if (p.equals(names[j])){
                            for (; j < names.length-1; j++) {
                                names[j]=names[j+1];
                                
                            }

                        }
                        
                    }
                    break;


                }
                case 4:{
                    System.out.println("Name list is:  ");
                    for (String a:names){
                        if(a!=null){
                            System.out.print(a+",");
                        }
                       
                    }
                    System.out.println();
                    break;
                }
                case 5:{

                    System.out.println("Exited !!1");
                    flag=false;
                    break;
                }


            }

        } while (flag);

    }
}
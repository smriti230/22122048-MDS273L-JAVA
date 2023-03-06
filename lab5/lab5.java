package lab5;

import java.util.Scanner;
public class lab5 {

    static String encryption(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the PlainText :");
        String PlainText = sc.nextLine();
        char alphabet ;
        System.out.println("shift:");
        int shift = sc.nextInt();
        String cypherText = "";
        for(int i = 0 ; i<PlainText.length() ; ++i){
            alphabet = PlainText.charAt(i);

            if( alphabet >= 'a' && alphabet <= 'z'){
                alphabet = (char) (alphabet + shift);
                if( alphabet > 'z'){
                    alphabet = (char)(alphabet + 'a'-'z'-1); 
                }
                cypherText = cypherText + alphabet ;
            }
            else if( alphabet >= 'A'&& alphabet <= 'Z'){
                alphabet = (char) (alphabet + shift);
                if( alphabet > 'Z'){
                    alphabet = (char)(alphabet  + 'A'-'Z'-1);
                }
                cypherText = cypherText + alphabet ;
            }
            else cypherText = cypherText + alphabet ;
        }
         return cypherText ;
    }

    static String decryption(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the CypherText :");
        String cypherText = sc.nextLine();
        System.out.println("shift:");
        char alphabet;
        int shift = sc.nextInt();
        String PlainText= "";
        for(int i = 0 ; i<cypherText.length() ; ++i){
             alphabet = cypherText.charAt(i);

            if( alphabet >= 'a' && alphabet <= 'z'){
                alphabet = (char) (alphabet - shift);
                if( alphabet > 'z'){
                    alphabet = (char)(alphabet - 'a'-'z'+1);
                }
                PlainText = PlainText + alphabet ;
            }
            else if( alphabet >= 'A' && alphabet <= 'Z'){
                alphabet = (char) (alphabet - shift);
                if( alphabet > 'Z'){
                    alphabet = (char)(alphabet- 'A'-'Z'+1); 
                }
                PlainText = PlainText + alphabet ;
            }
            else PlainText = PlainText + alphabet ;
        }
         return PlainText ;

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. ENCRYPTION \n 2. DECRYPTION");
        int choice = sc.nextInt();
        switch(choice){
            case 1 :
                String Cypher = encryption();
                System.out.println("Encrpted Message :" + Cypher);
                break ;
            case 2 : 
                String Plain = decryption();
                System.out.println("Decrpted Message:" + Plain);
                break ;
            default :
                System.out.println("Enter the correct number !!!");
        }
    }
}

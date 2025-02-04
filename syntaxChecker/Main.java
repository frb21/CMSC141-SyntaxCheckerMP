package syntaxChecker;
import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();

        for(int i = 0; i < c; i++){
            int type = scanner.nextInt();
            String input = scanner.nextLine();

            if(type == 1){
                SyntaxChecker syntaxChecker = new SyntaxChecker(input);
                if(syntaxChecker.getStatus()){
                    System.out.println("VALID");
                }
                else{
                    System.out.println("INVALID");
                }
            }
            else if(type == 2){
                FunctionChecker funcChecker = new FunctionChecker(input);
                if(funcChecker.getStatus()){
                    System.out.println("VALID");
                }
                else{
                    System.out.println("INVALID");
                }
            }    
      }  
  }
}






























package syntaxChecker;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class FunctionChecker{
    //attributes
    private String input;
    private boolean status;
    private String returnType;
    private boolean isArgName;
    private String functionType;
    private ArrayList<String> tokens;
    
    //constructor
    public FunctionChecker(String st){
        input = st;
        status = false;
        returnType = "";
        isArgName = false;
        tokens = new ArrayList<String>();
        tokenizeString();
        checkSyntax();
    }

    //getters
    public String getString(){
        return input;
    }

    public boolean getStatus(){
        return status;
    }

    private void tokenizeString(){
        StringTokenizer tokenizer = new StringTokenizer(input, " ();", true);

        while(tokenizer.hasMoreTokens()){
            String tok = tokenizer.nextToken();
            tokens.add(tok);
        }
    }

    // main syntax checker method
    private void checkSyntax(){
        int state = 0;
        for(int i = 0; i < tokens.size(); i++){
            String token = tokens.get(i);

            //neglect whitespaces
            if(!token.equals(" ")){
               //state 0 = check function return type: 'void', int', 'char', 'float', 'double'
               //state 1 = check function naming
               //state 2 = check if open parenthesis
               //state 3 = check argument type
               //state 4 = check argument naming (if provided)
               //state 5 = check closing parenthesis and semicolon
               
                switch(state){
                    //check return type:
                    case 0: {
                        if(!(token.equals("int") || token.equals("char") || token.equals("float") || token.equals("double") || token.equals("void"))){
                            status = false;
                            System.out.println("function check");
                            break;
                        }

                        //returnType = token;
                        System.out.println("passed return type");
                        status = true;
                        ++state;
                        break;
                    }

                    //check function naming
                    case 1:{
                        if(!(token.charAt(0) == '_' || (token.charAt(0) >= 'a' && token.charAt(0) <= 'z')) || (token.equals("int") || token.equals("char") || token.equals("float") || token.equals("double"))){
                            status = false;
                            System.out.println("case1");
                        }
                        else if(isArgName){
                            state = 5;
                        }
                        else{
                            System.out.println("passed function naming");
                            status = true;
                            ++state;
                        }
                        break;
                    }

                    //check open parentheses 
                    case 2:{
                        if(!token.equals("(")){
                            status = false;
                        }
                        else{
                            System.out.println("open parent");
                            status = true;
                            ++state;
                        }
                        break;
                    }

                    //check argument type
                    case 3:{
                        if(!(token.equals("int") || token.equals("char") || token.equals("float") || token.equals("double"))){
                            status = false;
                            System.out.println("argument check");
                        }
                        else{
                            System.out.println("passed argument type");
                            status = true;
                            ++state;
                        }
                        break;
                    }

                    //check if argument name provided
                    case 4:{
                        if(!token.equals(")")){
                            //go back to state 1 to check valid naming
                            state = 1;
                            isArgName = true;
                        }
                        else if(token.equals(")")){
                            System.out.println("closed parenthesis");
                            status = true;
                            ++state;
                        }
                        break;
                    }

                    //check semicolon
                    case 5:{
                        if(!token.equals(";")){
                            status = false;
                        }
                        System.out.println("passed semicolon");
                        status = true;
                        break;
                    }
                }

            }
        }
    }

}




































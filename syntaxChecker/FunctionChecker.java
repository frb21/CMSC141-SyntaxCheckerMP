package syntaxChecker;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class FunctionChecker{
    //attributes
    private String input;
    private boolean status;
    private String returnType;
    private String functionType;
    private ArrayList<String> tokens;
    
    //constructor
    public FunctionChecker(String st){
        input = st;
        status = false;
        returnType = "";
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
        StringTokenizer tokenizer = new StringTokenizer(input, " ,;", true);

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

                }

            }



        }
    }

}




































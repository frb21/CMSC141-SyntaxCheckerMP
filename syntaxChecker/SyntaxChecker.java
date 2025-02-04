// Syntax Checker class
package syntaxChecker;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SyntaxChecker{
    //attributes
    private String input;
    private boolean status;
    private String dataType;
    private ArrayList<String> tokens;

    //constructor
    public SyntaxChecker(String st){
       input = st;
       status = false;
       dataType = "";
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

    //tokenizer
    private void tokenizeString(){
        StringTokenizer tokenizer = new StringTokenizer(input, " ,;", true);

        //store tokens into the list
        while(tokenizer.hasMoreTokens()){
            String tok = tokenizer.nextToken();
            //System.out.println(tok);
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
                //state 0 = check data type
                //state 1 = check variable naming
                //state 2 = check if comma
                //state 3 = initialization 

              switch(state){
                  //check data type first
                  case 0:
                    {
                        if(!(token.equals("int") || token.equals("char") || token.equals("float") || token.equals("double"))){
                            //System.out.println("case 0");
                            status = false;
                            break;
                        }
                    //set status temporarily as true
                    //System.out.println("valid data type");
                    dataType = token;
                    status = true;
                    ++state;
                    break;
                    }
                    

                  //check variable naming
                  case 1:
                    {
                        if(!(token.charAt(0) == '_' || (token.charAt(0) >= 'a' && token.charAt(0) <= 'z')) || (token.equals("int") || token.equals("char") || token.equals("float") || token.equals("double"))){
                            //System.out.println("case 1");
                            status = false;
                            //break;
                        }
                        else{
                            //System.out.println("valid variable name");
                            status = true;
                            ++state;
                        }

                        break;                        
                    }

                  // check if comma, equal sign, or semicolon
                  case 2:
                    {
                        //if comma, return to state 1 to check variable name
                        if(token.equals(",")){
                            state = 1;
                        }

                        //if equal sign check the initialization
                        else if(token.equals("=")){
                            state = 3;
                        }

                        // semicolon marks the end of string
                        else if(token.equals(";")){
                            //status = true;
                            break;
                        }                        
                    break;
                    }
                  //check initialized value if valid
                  case 3:
                    {
                        switch(dataType){
                            case "int": 
                              { 
                                 try {
                                     Integer.parseInt(token);
                                     status = true;
                                 } 
                                 catch(NumberFormatException e){
                                     //System.out.println("dataType int");
                                     status = false;
                                     break;
                                 }
                             
                                break;
                              }

                            case "char":
                              {
                                 if(token.length() > 1){
                                     //System.out.println("dataType char");
                                     status = false;
                                 }
                                 status = true;
                             
                                break;
                              }

                            case "float":
                              { 
                                 try{
                                    Float.parseFloat(token);
                                    status = true;
                                 } 
                                 catch(NumberFormatException e){
                                     //System.out.println("dataType float");
                                     status = false;
                                 }
                             
                                break;
                              }

                            case "double":
                              {
                                 try{
                                     Double.parseDouble(token);
                                     status = true;
                                 }
                                 catch(NumberFormatException e){
                                     //System.out.println("dataType double");
                                     status = false;
                                 }
                             
                            break;
                            
                              }
                        }

                        state = 2;

                    break;                  
                }

            }
        }
    }
  }
}



































package com.example;

import MP.SyntaxChecker.SyntaxChecker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class VarTests {

   @Test
   public void testValidInput() {
       String input1 = "int x;";
       SyntaxChecker syntaxChecker = new SyntaxChecker(input1);

       assertTrue(input1, true);
   }



    
}





































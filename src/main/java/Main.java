package main.java;

import java.io.*; // For file handling
import java_cup.runtime.*; // CUP runtime for Symbol
import java.util.Objects;
import main.java.sym;
import main.java.Parser;
import main.java.LexerCupV;


public class Main {

    public static void main(String[] args) {
        try {
            File inputFile = new File("src\\main\\resources\\prueba.txt"); //Aquí va a estar mientras
            Reader reader = new BufferedReader(new FileReader(inputFile));

            LexerCupV lexer = new LexerCupV(reader);


            Symbol token;
            while (!Objects.isNull(token = lexer.next_token())) {
                if (token.sym == sym.EOF) break;

                //System.out.println("Identificador del Token: " + token.sym);
                //System.out.println("Lexema: " + token.value);
                System.out.print("Línea de aparición: " + (token.left + 1)); // line starts at 0
                System.out.println(" Columna: " + (token.right + 1)); // column starts at 0
                System.out.println("----------------------------------");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

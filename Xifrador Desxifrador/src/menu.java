import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class menu {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JOptionPane

        System.out.println("=============================");
            System.out.println("Escriu una de les seguents opcions:");
            System.out.println("1 : Utilitzar el xifrador.");
            System.out.println("2 : Utilitzar el desxifrador.");
        System.out.println("=============================");

        String numtriat = scanner.textLine();

        String dirfitxer;

        if (numtriat.equals("1")) {
            dirfitxer = Xifrador.java;
        }
        else if (numtriat.equals("2")) {
            dirfitxer = desxifrador.java;
        } else 


    }
    

}

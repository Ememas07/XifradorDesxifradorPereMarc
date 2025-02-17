import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class menu {
   
    public static void main(String[] args) {
        // Mostrar un diàleg per demanar a l'usuari que introdueixi 1 o 2
        String eleccio = JOptionPane.showInputDialog(null, 
                "Introdueix 1 o 2:", 
                "Crear Document", 
                JOptionPane.QUESTION_MESSAGE);

        String nomFitxer;

        // Comprovar que l'usuari no ha cancel·lat el diàleg
        if (eleccio != null) {
            // Utilitzar switch-case per gestionar les opcions
            switch (eleccio) {
                case "1":
                    nomFitxer = "document1.txt";
                    break;
                case "2":
                    nomFitxer = "document2.txt";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, 
                            "Elecció no vàlida. Introdueix 1 o 2.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    return;
            }

            try {
                // Crear el fitxer i escriure-hi un text bàsic
                FileWriter escriptor = new FileWriter(nomFitxer);
                escriptor.write("Aquest és el contingut de " + nomFitxer);
                escriptor.close();
                JOptionPane.showMessageDialog(null, 
                        "Fitxer creat: " + nomFitxer, 
                        "Èxit", 
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, 
                        "S'ha produït un error: " + e.getMessage(), 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, 
                    "No has introduït cap valor.", 
                    "Cancel·lat", 
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    

}

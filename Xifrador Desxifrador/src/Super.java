import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Super {
    public static void main(String[] args) {
        String frase;
        String nomArxiu;
        String[] opcions = { "Xifrador - Consola", "Xifrador - Document", "Desxifrador - Consola",
                "Desxifrador - Document" };
        // Show confirmation dialog with custom options
        int opcio = JOptionPane.showOptionDialog(
                null,
                "Selecciona una opció:", // Message
                "Opció de Sortida", // Title
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcions,
                opcions[0] // Default selection
        );
        String frasexifrada;
        String frasedesxifrada;

        switch (opcio) {
            case 0:
                frase = JOptionPane.showInputDialog("Introdueixi frase"); // Demanam a l'usuari que introdueixi la frase
                frasexifrada = encriptador(frase); // Passam el xifrador per la frase
                System.out.println(frasexifrada); // Posam la frase xifrada i la donam per consola
                break;
            case 1:
                frase = JOptionPane.showInputDialog("Introdueixi frase"); // Demanam a l'usuari que introdueixi la frase
                nomArxiu = JOptionPane.showInputDialog("Introdueixi nom d'arxiu"); // Demanam a l'usuari que introdueixi
                                                                                   // el nom de l'arxiu
                frasexifrada = encriptador(frase); // Passam el xifrador per la frase
                EscriureArxiu(nomArxiu, frasexifrada); // Escrivim l'arxiu xifrat al document
                break;
            case 2:
                frase = JOptionPane.showInputDialog("Introdueixi frase"); // Demanam a l'usuari que introdueixi la frase
                frasedesxifrada = desencriptador(frase); // Passam el xifrador per la frase
                System.out.println(frasedesxifrada); // Posam la frase xifrada i la donam per consola
                break;
            case 3:
                nomArxiu = JOptionPane.showInputDialog("Introdueixi nom d'arxiu"); // Demanam a l'usuari que introdueixi
                                                                                   // el nom de l'arxiu
                frase = LlegirArxiu(nomArxiu); // Crida la funcio de llegir arxiu
                frasedesxifrada = desencriptador(frase); // Passam el xifrador per la frase
                break;
        }
    }

    public static void EscriureArxiu(String nomArxiu, String contingutArxiu) { // Aquesta funció llegeix l'arxiu que
                                                                               // nosaltres li diguem
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomArxiu))) {
            writer.write(contingutArxiu);
            System.out.println("Dades guardades en el fitxer: " + nomArxiu);
        } catch (IOException e) {
            System.out.println("Error d'escriptura: " + e.getMessage());
        }
    }

    public static String LlegirArxiu(String nomArxiu) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomArxiu))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        }
        return content.toString().trim();
    }

    public static String encriptador(String frase) { // Encriptam la frase
        if (frase == null || frase.isEmpty()) { // Si esta buida no feim res
            return "";
        }
        int ValorXifratge = (int) ((Math.random() + 1) * 100);
        StringBuilder frasecanviada = new StringBuilder(); // StringBuilder ens crearà la frase encriptada
        for (int index = 0; index < frase.length(); index++) { // Iniciam index com a 0, i aquest bucle es farà fins que
                                                               // haguem xifrat tots els caràcters
            int caracterxifrat = 0; // Inicialitzam el caracterxifrat
            if (index < 1) { // abans de començar a xifrar, escrivim el valor per el qual esteim xifrant,
                             // pero elevat al quadrat.
                char caracter = (char) ValorXifratge; // convertim el valorxifratge a caracter
                caracterxifrat = caracter * ValorXifratge; // multiplicam el valorxifratge per ell mateix (més robust)
                frasecanviada.append("").append(caracterxifrat); // Afegim aquest valor a la frase
            }
            char caracter = frase.charAt(index); // agafam el (index) de la frase, per encriptar el primer caracter,
                                                 // després el segon...
            caracterxifrat = caracter * ValorXifratge; // Xifram
            if (caracterxifrat < 10000) { // si el valor es menys de 10000, probablement per un espai, l'assignam a
                                          // 10000
                caracterxifrat = 10000;
            }
            frasecanviada.append(caracterxifrat); // Afegim el caracter xifrat a la frase
        }
        return frasecanviada.toString().trim(); // Retornam la Frase Xifrada
    }

    public static String desencriptador(String frase) { // Encriptam la frase
        if (frase == null || frase.isEmpty()) { // Si esta buida no feim res
            return "";
        }
        StringBuilder frasecanviada = new StringBuilder(); // Cream el string de frasecanviada
        int midaBlock = 5; // Cada bloc te una mida de 5
        int primer = 0; // aquesta variable s'emprarà per sabre si esteim comprovant el primer bloc o no
        double factor = 0; // el factor i factor2 són el valor per el qual s'està dividint cada bloc
        int factor2 = (int) factor;
        double valor = 0; // valor i valor2 són les representacions ASCII dels caracters abans de
                          // convertir-se a caracters reals
        int valor2 = (int) valor;
        String desxifrar = ""; // Caracter a desxifrar, comença buit
        for (int i = 0; i < frase.length(); i += midaBlock) { // la variable "i" és cada caracter, i aquest bucle
                                                              // s'executa mentre que "i" sigui menys que la mida de
                                                              // l'input, i se suma la variable midablock, en el nostre
                                                              // cas 5, cadavegada
            primer = primer + 1; // sumam 1 cada vegada perquè el bucle de més envant només s'executi una vegada
            Integer endIndex = Math.min(i + midaBlock, frase.length()); // El final de cada bloc, emprat per fer el
                                                                        // substrings
            String block = frase.substring(i, endIndex); // cream un string "bloc", que va desde "i", que serà o 0, 5,
                                                         // 10, fins a 4, 9, 14, per fer que cada bloc sigui de 5
                                                         // caracters, i comencin un darrera l'altre
            for (int index = 0; index < block.length(); index++) { // un pic tenim el bloc, iteram cada caracter desde
                                                                   // el principi del bloc (index 0), i anam sumant 1
                                                                   // (index++) cada vegada
                char caracter = block.charAt(index); // assignam la variable "caracter" a cada numero
                desxifrar = desxifrar + caracter; // afegim el "caracter" a desxifrar, o sigui, primer està buit,
                                                  // després hi afegim un 3, després un 8, i va quedant 38...
            }
            valor = Integer.parseInt(desxifrar); // donam la variable "desxifrar" a una nova variable tipus integer
                                                 // anomenada valor
            if (primer == 1) { // si es el primer valor, feim una arrel quadrada per tenir el factor per el
                               // qual haurem de dividir cada vegada per desxifrar
                factor = Math.sqrt(valor); // assignam la variable factor a aquest nombre
            }
            valor2 = (int) valor; // convertim de double a integer
            factor2 = (int) factor;
            valor2 = (valor2 / factor2); // desxifram, assignam "valor2" al resultat del Integer.parseInt(desxifrar), i
                                         // dividim entre el factor, o sigui, si teniem "32507", dividim 32507 entre 167
                                         // i ens donarà un valor de la taula ascii
            if (primer > 1) { // Si no es el primer valor feim el seguent:
                if (valor == 10000) { // Si el valor es 10000, que és el que li hem assignat als espais, assignam
                                      // valor2 de 32 per escriure l'espai correctament.
                    valor2 = 32;
                }
                System.out.print((char) valor2); // Imprimim el caracter a la consola
            }
            desxifrar = ""; // Reinicialitzam la variable de desxifrar
        }
        return frasecanviada.toString();
    }

}
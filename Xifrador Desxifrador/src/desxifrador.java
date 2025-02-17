import javax.swing.JOptionPane;

public class desxifrador {
    public static void main(String[] args) {
        String frase = JOptionPane.showInputDialog("Introdueixi frase"); // Demanam a l'usuari que introdueixi la frase
        String frasedesxifrada = desencriptador(frase); // Passam el xifrador per la frase
        System.out.println(frasedesxifrada); // Posam la frase xifrada i la donam per consola
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

}// 35721 19656 20979 20412 18333
/*
 * int ValorXifratge = (int) ((Math.random() + 1) * 100);
 * System.out.println("Valor Xifratge =" + ValorXifratge);
 * StringBuilder frasecanviada = new StringBuilder();
 * for (int index = 0; index < frase.length(); index++) {
 * 
 * int caracterxifrat = 0;
 * if (index < 1) {
 * char caracter = (char) ValorXifratge;
 * caracterxifrat = caracter * ValorXifratge;
 * frasecanviada.append(" ").append(caracterxifrat);
 * }
 * char caracter = frase.charAt(index);
 * caracterxifrat = caracter * ValorXifratge;
 * frasecanviada.append(" ").append(caracterxifrat);
 * return frasecanviada.toString().trim();
 */
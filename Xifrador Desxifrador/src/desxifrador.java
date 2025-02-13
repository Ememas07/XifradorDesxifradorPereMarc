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
        StringBuilder frasecanviada = new StringBuilder();
        int midaBlock = 5;
        int primer = 0;
        String desxifrar = "";
        for (int i = 0; i < frase.length(); i += midaBlock) {
            primer = primer + 1;
            Integer endIndex = Math.min(i + midaBlock, frase.length()); // Prevent out-of-bounds errors
            String block = frase.substring(i, endIndex);
            for (int index = 0; index < block.length(); index++) {
                char caracter = block.charAt(index);
                desxifrar = desxifrar + caracter;
            }
            System.out.println("" + desxifrar);
            desxifrar = "";

        }
        return frasecanviada.toString().trim();
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
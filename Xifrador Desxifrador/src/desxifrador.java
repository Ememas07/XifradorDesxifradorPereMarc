import javax.swing.JOptionPane;

public class DesXifrador {
    public static void main(String[] args) {
        String frase = JOptionPane.showInputDialog("Introdueixi frase"); // Demanam a l'usuari que introdueixi la frase
        String frasedesxifrada = desencriptador(frase); // Passam el xifrador per la frase
        System.out.println(frasedesxifrada); // Posam la frase xifrada i la donam per consola
    }

    public static String desencriptador(String frase) { // Encriptam la frase
        if (frase == null || frase.isEmpty()) { // Si esta buida no feim res
            return "";
        }
        int ValorXifratge = 0;
        for (int index = 0; index < frase.length(); index++) {
            int caracterdesxifrat = 0;
            if (index < 1) {
                char caracter = frase.charAt(index);
                caracterdesxifrat = caracter * ValorXifratge;
                frasecanviada.append(" ").append(caracterxifrat);
            }
            char caracter = frase.charAt(index);
            caracterdesxifrat = caracter * ValorXifratge;
            frasecanviada.append(" ").append(caracterxifrat);
            return frasecanviada.toString().trim();

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
        }
    }
}

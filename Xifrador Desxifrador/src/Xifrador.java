import javax.swing.JOptionPane;

public class Xifrador {
    public static void main(String[] args) {
        String frase = JOptionPane.showInputDialog("Introdueixi frase"); // Demanam a l'usuari que introdueixi la frase
        String frasexifrada = encriptador(frase); // Passam el xifrador per la frase
        System.out.println(frasexifrada); // Posam la frase xifrada i la donam per consola
    }

    public static String encriptador(String frase) { // Encriptam la frase
        if (frase == null || frase.isEmpty()) { // Si esta buida no feim res
            return "";
        }
        int ValorXifratge = (int) ((Math.random() + 1) * 100);
        System.out.println("Valor Xifratge =" + ValorXifratge);
        StringBuilder frasecanviada = new StringBuilder(); // StringBuilder ens crearà la frase encriptada
        for (int index = 0; index < frase.length(); index++) { // Iniciam index com a 0, i aquest bucle es farà fins que
                                                               // haguem xifrat tots els caràcters
            int caracterxifrat = 0;
            if (index < 1) {
                char caracter = (char) ValorXifratge;
                caracterxifrat = caracter * ValorXifratge;
                frasecanviada.append(" ").append(caracterxifrat);
            }
            char caracter = frase.charAt(index);
            caracterxifrat = caracter * ValorXifratge;
            frasecanviada.append(" ").append(caracterxifrat);
        }
        return frasecanviada.toString().trim();
    }
}

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
        StringBuilder frasecanviada = new StringBuilder(); // StringBuilder ens crearà la frase encriptada
        for (int index = 0; index < frase.length(); index++) { // Iniciam index com a 0, i aquest bucle es farà fins que
                                                               // haguem xifrat tots els caràcters
            int caracterxifrat = 0; // Inicialitzam el caracterxifrat
            if (index < 1) { // abans de començar a xifrar, escrivim el valor per el qual esteim xifrant,
                             // pero elevat al quadrat.
                char caracter = (char) ValorXifratge; // convertim el valorxifratge a caracter
                caracterxifrat = caracter * ValorXifratge; // multiplicam el valorxifratge per ell mateix (més robust)
                frasecanviada.append(" ").append(caracterxifrat); // Afegim aquest valor a la frase
            }
            char caracter = frase.charAt(index); // agafam el (index) de la frase, per encriptar el primer caracter,
                                                 // després el segon...
            caracterxifrat = caracter * ValorXifratge; // Xifram
            frasecanviada.append(caracterxifrat); // Afegim el caracter xifrat a la frase
        }
        return frasecanviada.toString().trim(); // Retornam la Frase Xifrada
    }
}

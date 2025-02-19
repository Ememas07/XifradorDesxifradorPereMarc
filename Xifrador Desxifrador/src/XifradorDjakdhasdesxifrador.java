import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class XifradorDjakdhasdesxifrador {
    public static void main(String[] args) {
        String frase;
        String nomArxiu;
        String frasexifrada;
        String frasedesxifrada;
        String[] opcions = { "Xifrador - Consola", "Xifrador - Document", "Desxifrador - Consola",
                "Desxifrador - Document" };
        int opcio = JOptionPane.showOptionDialog(null,
                "Que vols fer?",
                "Seleccioni una opció",
                -1,
                3,
                null,
                opcions,
                opcions[0]);
        switch (opcio) {
            case 0:
                frase = JOptionPane.showInputDialog("Introdueixi frase");
                frase = frase.replaceAll("[^a-zA-Z ]", "");
                frasexifrada = encriptador(frase);
                System.out.println(frasexifrada);
                break;
            case 1:
                frase = JOptionPane.showInputDialog("Introdueixi frase");
                frase = frase.replaceAll("[^a-zA-Z ]", "");
                nomArxiu = JOptionPane.showInputDialog("Introdueixi nom d'arxiu (AMB EXTENSIÓ!)");
                frasexifrada = encriptador(frase);
                EscriureArxiu(nomArxiu, frasexifrada);
                break;
            case 2:
                frase = JOptionPane.showInputDialog("Introdueixi frase");
                frasedesxifrada = desencriptador(frase);
                break;
            case 3:
                nomArxiu = JOptionPane.showInputDialog("Introdueixi nom d'arxiu (AMB EXTENSIÓ!)");
                frase = LlegirArxiu(nomArxiu);
                frasedesxifrada = desencriptador(frase);
                break;
        }
    }

    public static void EscriureArxiu(String nomArxiu, String contingutArxiu) {
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

    public static String encriptador(String frase) {
        if (frase == null || frase.isEmpty()) {
            return "";
        }
        int ValorXifratge = (int) ((Math.random() + 1) * 100);
        StringBuilder frasecanviada = new StringBuilder();
        for (int index = 0; index < frase.length(); index++) {
            int caracterxifrat = 0;
            if (index < 1) {
                char caracter = (char) ValorXifratge;
                caracterxifrat = caracter * ValorXifratge;
                frasecanviada.append("").append(caracterxifrat);
            }
            char caracter = frase.charAt(index);
            caracterxifrat = caracter * ValorXifratge;
            if (caracterxifrat < 10000) {
                caracterxifrat = 10000;
            }
            frasecanviada.append(caracterxifrat);
        }
        return frasecanviada.toString().trim();
    }

    public static String desencriptador(String frase) {
        if (frase == null || frase.isEmpty()) {
            return "";
        }
        StringBuilder frasecanviada = new StringBuilder();
        int midaBlock = 5;
        int primer = 0;
        double factor = 0;
        int factor2 = (int) factor;
        double valor = 0;
        int valor2 = (int) valor;
        String desxifrar = "";
        for (int i = 0; i < frase.length(); i += midaBlock) {
            primer = primer + 1;
            Integer endIndex = Math.min(i + midaBlock, frase.length());
            String block = frase.substring(i, endIndex);
            for (int index = 0; index < block.length(); index++) {
                char caracter = block.charAt(index);
                desxifrar = desxifrar + caracter;
            }
            valor = Integer.parseInt(desxifrar);
            if (primer == 1) {
                factor = Math.sqrt(valor);
            }
            valor2 = (int) valor;
            factor2 = (int) factor;
            valor2 = (valor2 / factor2);
            if (primer > 1) {
                if (valor == 10000) {
                    valor2 = 32;
                }
                System.out.print((char) valor2);
            }
            desxifrar = "";
        }
        return frasecanviada.toString();
    }

}
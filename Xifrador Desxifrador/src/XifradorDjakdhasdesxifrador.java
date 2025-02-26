switch (opcio) {
    case 2:
        System.out.println("b");
        break;
    case 0:
        String[] opcions2 = { "Consola", "Document", "Tornar Enrere" }; 
        int opcio2 = JOptionPane.showOptionDialog(null,
                "Com vols xifrar?", 
                "Has seleccionat Xifrar",
                -1, 
                3, 
                null, 
                opcions2, 
                opcions2[0]);
        switch (opcio2) {
            case 0:
                frase = JOptionPane.showInputDialog("Introdueixi frase");
                frase = frase.replaceAll("[^a-zA-Z ]", ""); 
                frasexifrada = encriptador(frase); 
                System.out.println(frasexifrada); 
                sortir = false;
                break;
            case 1:
                frase = JOptionPane.showInputDialog("Introdueixi frase"); /
                frase = frase.replaceAll("[^a-zA-Z ]", "");
                nomArxiu = JOptionPane.showInputDialog("Introdueixi nom d'arxiu (AMB EXTENSIÓ!)"); 
                frasexifrada = encriptador(frase); 
                EscriureArxiu(nomArxiu, frasexifrada); 
                break;
            case 2:
                break;
        }
        break;
    case 1:
        String[] opcions3 = { "Consola", "Document", "Tornar Enrere" }; 
        int opcio3 = JOptionPane.showOptionDialog(null,
                "Com vols desxifrar", 
                "Has seleccionat Desxifrar", 
                -1, 
                3,
                null, 
                opcions3, 
                opcions3[0]);
        switch (opcio3) {
            case 0:
                frase = JOptionPane.showInputDialog("Introdueixi frase"); 
                frasedesxifrada = desencriptador(frase); 
                sortir = false;
                break;
            case 1:
                nomArxiu = JOptionPane.showInputDialog("Introdueixi nom d'arxiu (AMB EXTENSIÓ!)"); 
                frase = LlegirArxiu(nomArxiu); 
                frasedesxifrada = desencriptador(frase);s
                sortir = false;
                break;
            case 2:
                System.out.println("aa");
                break;
        }
}
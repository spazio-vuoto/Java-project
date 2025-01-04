import java.util.Scanner;

public class tris_evoluto {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        boolean esciGioco = false;//se il giocatore vuole smettere di giocare diventa true
        String scelta123;//prende in input se il giocatore vuole giocare contro il bot/player o uscire
        boolean giocareLocale = false;//se è uguale true il giocatore vuole giocare contro un player locale
        String nomeGiocatore1 = null;//nome giocatore 1
        String nomeGiocatore2 = null;//nome giocatore 2
        String posizioneScelta = "10";//dove mette la X/O il giocatore
        boolean casellaOccupata;//true se la casella è occupata false se non lo è(è su true così entra nel ciclo)
        int capireGiocatore = 0;//serve per capire se tocca al primo o al secondo giocatore
        boolean esciPartita = false;//serve per uscire dalla partita quando finisce(non dal gioco)
        boolean verificare;
        int puntiGiocatore1 = 0;//punti primo giocatore
        int puntiGiocatore2 = 0;//punti secondo giocatore
        String rifarePartita = "";//se si vuole rifare una partita tra gli stessi giocatori
        int rifarePartitaInt = 0;//boolean per il ciclo della variabile di sopra

        while(esciGioco == false){

            String[][] tabellaTris = {
                {"1","|","2","|","3"},
                {"4","|","5","|","6"},
                {"7","|","8","|","9"}
            };
            
            if(rifarePartitaInt != 1){
                System.out.println("Cosa vuoi fare");
                System.out.println("1 giocare contro il bot, 2 giocare contro un player locale, 3 uscire dal gioco");
                scelta123 = scanner.nextLine().strip();

                switch (scelta123) {
                    case "1" -> {
                        System.out.println("Allora buona fortuna per la tua partita contro il bot");
                        System.out.println("(non ho ancora implementato questa funzione)");
                    }
                    case "2" -> {
                        giocareLocale = true;
                        System.out.println("Giocatore1 dimmi il nome con cui vuoi chiamarti");
                        nomeGiocatore1 = scanner.nextLine();
                        System.out.println("Giocatore2 dimmi il nome con cui vuoi chiamarti");
                        nomeGiocatore2 = scanner.nextLine();
                    }
                    case "3" -> {esciGioco = true;}
                    default -> {System.out.println("Devi scrivere un numero di quelli sopra elencati");}
                }
            }
            System.out.println(nomeGiocatore1 + " ha " + puntiGiocatore1 + " punti");
            System.out.println(nomeGiocatore2 + " ha " + puntiGiocatore2 + " punti");
            if(rifarePartitaInt == 1){
                esciGioco = false;
                giocareLocale = true;
                esciPartita = false;
            }
            while(esciGioco == false && giocareLocale == true && esciPartita == false){
                if(capireGiocatore == 0){
                    casellaOccupata = true;//così entra nel ciclo e nel prossimo quando sarà false ritornerà true
                    System.out.println(nomeGiocatore1 + " dove vuoi mettere la X?");
                    while(casellaOccupata == true){
                        stampaTabellaTris(tabellaTris);
                        System.out.println("");//per fare una nuova riga
                        do{
                            System.out.println("");//per fare una nuova riga
                            posizioneScelta = scanner.nextLine().strip();
                            verificare = verificare(posizioneScelta);
                            if(verificare == false){
                                System.out.println("Devi dirmi un opzione vera");
                            }
                        }while(verificare == false);

                        verificare = false;//così funziona se mette una cosa sbagliata pure l'altro giocatore

                        if(mettiXO(tabellaTris, posizioneScelta) == true){
                            System.out.println("Devi dirmi una casella non occupata");
                        }else{
                            capireGiocatore = 1;
                            mettiXOnellaTabella(tabellaTris, posizioneScelta, "X");
                            if(vinceTris(tabellaTris, "X", nomeGiocatore1, nomeGiocatore2) == true){
                                stampaTabellaTris(tabellaTris);
                                System.out.println();//per mettere una riga di spazio
                                puntiGiocatore1 += 1;
                                esciPartita = true;
                            }
                            casellaOccupata = false;
                        }
                    }
                }else{
                    casellaOccupata = true;//così entra nel ciclo e nel prossimo quando sarà false ritornerà true
                    System.out.println(nomeGiocatore2 + " dove vuoi mettere la X?");
                    while(casellaOccupata == true){
                        stampaTabellaTris(tabellaTris);
                        System.out.println("");//per fare una nuova riga
                        do{
                            System.out.println("");//per fare una nuova riga
                            posizioneScelta = scanner.nextLine().strip();
                            verificare = verificare(posizioneScelta);
                            if(verificare == false){
                                System.out.println("Devi dirmi un opzione vera");
                            }
                        }while(verificare == false);
                        verificare = false;//così funziona se mette una cosa sbagliata pure l'altro giocatore
                        if(mettiXO(tabellaTris, posizioneScelta) == true){
                            System.out.println("Devi dirmi una casella non occupata");
                        }else{
                            capireGiocatore = 0;
                            mettiXOnellaTabella(tabellaTris, posizioneScelta, "O");
                            if(vinceTris(tabellaTris, "O", nomeGiocatore2, nomeGiocatore1) == true){
                                stampaTabellaTris(tabellaTris);
                                System.out.println();//per mettere una riga di spazio
                                puntiGiocatore2 += 1;
                                esciPartita = true;
                            }
                            casellaOccupata = false;
                        }
                    }
                }
            }
            do{
                System.out.println("Volete fare un'altra partita? se dite di no tornerete all'inizio per scegliere cosa fare");
                rifarePartita = scanner.nextLine().toLowerCase().strip();
                if(rifarePartita.equals("si")){
                    System.out.println("Va bene allora buona fortuna per la prossima partita");
                    rifarePartitaInt = 1;
                }else if(!(rifarePartita.equals("no"))){
                    System.out.println("Devi scrivere si o no");
                    rifarePartitaInt = 0;
                }else{
                    rifarePartitaInt = 2;
                }
            }while(rifarePartitaInt == 0);
            esciPartita = true;//senò dopo la prima partita non entra nella seconda
        }


        scanner.close();
    }

    private static void stampaTabellaTris(String[][] tabellaTris){
        for(String[] array : tabellaTris){
            System.out.println();
            for(String valore : array){
                System.out.print(valore);    
            }
        }
    }

    private static boolean vinceTris(String[][] tabellaTris, String XO, String playerVinto, String playerPerso){
        for(int i = 0; i < tabellaTris.length; i++){
            if(tabellaTris[i][0].equals(XO) && tabellaTris[i][0 + 2].equals(XO) && tabellaTris[i][0 + 4].equals(XO)){
                stampaVinto(playerVinto, playerPerso);
                return true;
            }
        }
        for(int j = 0; j < tabellaTris.length; j += 2){
            if(tabellaTris[0][j].equals(XO) && tabellaTris[0 + 1][j].equals(XO) && tabellaTris[0 + 2][j].equals(XO)){
                stampaVinto(playerVinto, playerPerso);
                return true;
            }
        }
        if(tabellaTris[2][0].equals(XO) && tabellaTris[1][2].equals(XO) && tabellaTris[0][4].equals(XO)){
            stampaVinto(playerVinto, playerPerso);
            return true;
        }else if(tabellaTris[0][0].equals(XO) && tabellaTris[1][2].equals(XO) && tabellaTris[2][4].equals(XO)){
            stampaVinto(playerVinto, playerPerso);
            return true;
        }
        return false;
    }

    private static void stampaVinto(String vincitore, String perdente){
        System.out.println("Congratulazioni " + vincitore + " hai vinto");
        System.out.println("Mi dispiace per te " + perdente + " magari sarà per la prossima volta");
    }

    private static boolean mettiXO(String[][] tabellaTris, String casellaScelta){
        switch(casellaScelta){
            case "1" -> {
                if(tabellaTris[0][0].equals("X") || tabellaTris[0][0].equals("O")){
                    return true;
                }
            }
            case "2" -> {
                if(tabellaTris[0][2].equals("X") || tabellaTris[0][2].equals("O")){
                    return true;
                }
            }
            case "3" -> {
                if(tabellaTris[0][4].equals("X") || tabellaTris[0][4].equals("O")){
                    return true;
                }
            }
            case "4" -> {
                if(tabellaTris[1][0].equals("X") || tabellaTris[1][0].equals("O")){
                    return true;
                }
            }
            case "5" -> {
                if(tabellaTris[1][2].equals("X") || tabellaTris[1][2].equals("O")){
                    return true;
                }
            }
            case "6" -> {
                if(tabellaTris[1][4].equals("X") || tabellaTris[1][4].equals("O")){
                    return true;
                }
            }
            case "7" -> {
                if(tabellaTris[2][0].equals("X") || tabellaTris[2][0].equals("O")){
                    return true;
                }
            }
            case "8" -> {
                if(tabellaTris[2][2].equals("X") || tabellaTris[2][2].equals("O")){
                    return true;
                }
            }
            case "9" -> {
                if(tabellaTris[2][4].equals("X") || tabellaTris[2][4].equals("O")){
                    return true;
                }
            }
        } 

        return false;
    }

    private static void mettiXOnellaTabella(String[][] tabellaTris, String scelta, String XO){
        switch(scelta){
            case "1" -> tabellaTris[0][0] = XO;
            case "2" -> tabellaTris[0][2] = XO;
            case "3" -> tabellaTris[0][4] = XO;
            case "4" -> tabellaTris[1][0] = XO;
            case "5" -> tabellaTris[1][2] = XO;
            case "6" -> tabellaTris[1][4] = XO;
            case "7" -> tabellaTris[2][0] = XO;
            case "8" -> tabellaTris[2][2] = XO;
            case "9" -> tabellaTris[2][4] = XO;
        }
    }

    private static boolean verificare(String scelta){
        return switch (scelta) {
            case "1" -> true;
            case "2" -> true;
            case "3" -> true;
            case "4" -> true;
            case "5" -> true;
            case "6" -> true;
            case "7" -> true;
            case "8" -> true;
            case "9" -> true;
            default -> false;
        };
    }
}
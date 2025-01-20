import java.util.Scanner;

public class proveForza4{

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){

        String scelta = "";//scelta che deve fare l'utente se giocare da solo o uscire
        boolean esciScelta = false;
        boolean esciGioco = false;
        boolean vittoria = false;//serve per vedere se ha vinto, così se uno vince esce dal ciclo
        int sceltaX;//scelta per dove vuole mettere la X
        int sceltaO;//scelta per dove vuole mettere la O
        int count = 0;//serve per sapere se mette X o O (quando è pari è X quando è dispari è O)
        
        String[][] campoGioco = {
            {" ","1","2","3","4","5","6","7"},
            {" ","-","-","-","-","-","-","-"},
            {" ","-","-","-","-","-","-","-"},
            {" ","-","-","-","-","-","-","-"},
            {" ","-","-","-","-","-","-","-"},
            {" ","-","-","-","-","-","-","-"},
            {" ","-","-","-","-","-","-","-"}
        };

        System.out.println("Benvenuto nel gioco di forza 4");
        stampaGioco(campoGioco);
        //serve per staccare le frasi
        System.out.println("\n");

        while(esciScelta == false){

            System.out.println("Cosa vuoi fare? ");
            System.out.println("Iniziare una partita scrivi gioco, uscire scrivi esci");

            //prendo l'input dall'utente
            scelta = scanner.nextLine().toLowerCase();
            if(scelta.equals("gioco")){
                esciScelta = true;
            }else if(scelta.equals("esci")){
                System.out.println("Alla prossima!");
                esciScelta = true;
                esciGioco = true;
            }else{
                System.out.println("Devi scrivere una delle parole riportate sopra");
            }
        }

        while(esciGioco == false){
            switch(scelta){
                case "gioco":
                    while(vittoria == false){
                        if(campoPieno(campoGioco) ==  true){
                            System.out.println("Il campo da gioco è pieno quindi avete finito in pareggio");
                            vittoria = true;
                        }else if(vittoria(campoGioco, "X") == true){
                            System.out.println("Congratulazioni Primo giocatore hai vinto!!!");
                            System.out.println("Mi dispiace per te Secondo giocatore ma hai perso");
                            vittoria = true;
                        }else if(vittoria(campoGioco, "O") == true){
                            System.out.println("Congratulazioni Secondo giocatore hai vinto!!!");
                            System.out.println("Mi dispiace per te Primo giocatore ma hai perso");
                            vittoria = true;
                        }else if(count % 2 == 0){
                            sceltaX = sceltaXO(campoGioco, "X");
                            metteXO(campoGioco, "X", sceltaX);
                            stampaGioco(campoGioco);
                            System.out.println("\n");//senò stampa dove vuoi mettere la X attaccata al campo da gioco
                        }else{
                            sceltaO = sceltaXO(campoGioco, "O");
                            metteXO(campoGioco, "O", sceltaO);
                            stampaGioco(campoGioco);
                            System.out.println("\n");//senò stampa dove vuoi mettere la O attaccata al campo da gioco
                        }
                        count++;
                    }
                case "giocatore":
                    //do something
                    break;
                }
            }
}

    //metodo per mettere la X o la O nella matrice
    public static void metteXO(String[][] campoGioco, String simbolo, int sceltaX){
        for(int i = campoGioco.length - 1, messo = 0; i >= 0 && messo == 0; i--){
            if(campoGioco[i][sceltaX].equals("-")){
                campoGioco[i][sceltaX] = simbolo;
                messo = 1;
            }
        }
    }

    // Metodo per verificare se c'è una vittoria in Forza 4
    public static boolean vittoria(String[][] campoGioco, String XO){

        boolean vittoria = false; //boolean per sapere se ha vinto o meno

        //verifica se in una riga ci sono 4 caselle prese dal primo o dal secondo giocatore
        for(int i = 1; i < campoGioco.length; i++){
            for(int j = 1; j < campoGioco[i].length; j++){
                if(j < campoGioco[i].length - 3){
                    if(campoGioco[i][j].equals(XO) &&
                        campoGioco[i][j].equals(campoGioco[i][j + 1]) && 
                        campoGioco[i][j].equals(campoGioco[i][j + 2]) &&
                        campoGioco[i][j].equals(campoGioco[i][j + 3])){
                            vittoria = true;
                    }
                }
            }
        }

        //verifica se in una colonna ci sono 4 caselle prese dal primo o dal secondo giocatore
        for(int i = 1; i < campoGioco.length; i++){
            for(int j = 1; j < campoGioco[i].length; j++){
                if(i < campoGioco.length - 3){
                    if(campoGioco[i][j].equals(XO) &&
                        campoGioco[i][j].equals(campoGioco[i + 1][j]) && 
                        campoGioco[i][j].equals(campoGioco[i + 2][j]) &&
                        campoGioco[i][j].equals(campoGioco[i + 3][j])){
                            vittoria = true;
                    }
                }
            }
        }

        //verifica se in una diagonale (/) ci sono 4 caselle prese dal primo o dal secondo giocatore
        for(int i = 1; i < campoGioco.length; i++) {
            for(int j = 1; j < campoGioco[i].length; j++) {
                if(i < campoGioco.length - 3) {
                    if(campoGioco[i][j].equals(XO) &&
                        campoGioco[i][j].equals(campoGioco[i + 1][j - 1]) && 
                        campoGioco[i][j].equals(campoGioco[i + 2][j - 2]) &&
                        campoGioco[i][j].equals(campoGioco[i + 3][j - 3])){
                            vittoria = true;
                    }
                }
            }
        }

        //verifica se in una diagonale (\) ci sono 4 caselle prese dal primo o dal secondo giocatore
        for(int i = 1; i < campoGioco.length; i++){
            for(int j = 1; j < campoGioco[i].length; j++){
                if(i < campoGioco.length - 3 && j < campoGioco[i].length - 3){
                    if(campoGioco[i][j].equals(XO) &&
                        campoGioco[i][j].equals(campoGioco[i + 1][j + 1]) && 
                        campoGioco[i][j].equals(campoGioco[i + 2][j + 2]) &&
                        campoGioco[i][j].equals(campoGioco[i + 3][j + 3])){
                            vittoria = true;
                    }
                }
            }
        }

        return vittoria;
    }

    //serve per verificare se il campo da gioco è pieno
    public static boolean campoPieno(String[][] campoGioco){

        int contFinale = 0;
        int contVerifica = 0;

        //se alla fine del ciclo i due cont sono uguali significa che il campo da gioco è pieno
        //iniziano da 1 perchè la prima riga è dei numeri e la prima colonna sono spazi vuoti
        for(int i = 1; i < campoGioco.length; i++){
            for(int j = 1; j < campoGioco.length; j++){
                if(!campoGioco[i][j].equals("-")){
                    contFinale++;
                }
                contVerifica++;
            }
        }

        if(contFinale == contVerifica){
            return true;
        }else{
            return false;
        }
    }

    //sono tutte le funzioni che contengono valori di input o output

    //metodo da cambiare se si vuole cambiare dispositivo per metodi di input e output
    //serve per far inserire un valore valido dall'utente
    public static int sceltaXO(String[][] campoGioco, String XO){

        boolean uscita = false;
        int sceltaX = 0;

        while(uscita == false){
            try{
                System.out.println("Dove vuoi mettere la " + XO + "?");
                sceltaX = scanner.nextInt();
                uscita = true;
                if(sceltaX < 1 || sceltaX > 7){
                    System.out.println("Devi inserire un numero valido");
                    uscita = false;
                }else if(!campoGioco[1][sceltaX].equals("-") == true){
                    System.out.println("Devi scegliere una colonna che abbia almeno uno spazio vuoto");
                    uscita = false;
                }
            }catch(Exception e){
                scanner.nextLine();
                System.out.println("Devi scrivere un numero");
            }    
        }

        return sceltaX;
    }

    //metodo da cambiare se si cambia dispositivo
    //metodo per stampare la tabella di gioco
    public static void stampaGioco(String[][] campo){
        for(String[] riga : campo){
            System.out.println();
            for(String fineStampa : riga){
                System.out.print(fineStampa + " ");
            }
        }
    }

}

//serve per verificare se 
/*if(vittoria(campoGioco) == true){ 
    System.out.println("Hai vinto");
}*/

//scritto perchè non volevo eliminarlo quelllo sotto
//se count è pari significa che deve mettere la X quindi significa che l'ultima mossa l'ha
//fatta il secondo giocatore con la O e quindi vince lui(nella condizione c'è il contrario)

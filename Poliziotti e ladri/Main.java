import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        GestisciGioco gioco = new GestisciGioco();
        gioco.inizializzaMatrice();

        Scanner scanner = new Scanner(System.in);
         
        int scelta = 0;
        boolean iniziaPartita = false;
         
        //continua finchè non scrivi 1 o 2, se mette uno iniziaPartita diventa true e entra nel game dopo(dentro l'if)
        while(scelta != 1 && scelta != 2){
            System.out.println("Cosa vuoi fare?");
            System.out.println("1) Iniziare una partita, 2) uscire");
            scelta = Integer.parseInt(scanner.next());
            switch(scelta){
                case 1 -> {
                    System.out.println("Ora inizierà la partita");
                    stampaMatrice(gioco.getMatrice());
                    System.out.println();
                    iniziaPartita = true;
                }
                case 2 -> {
                    System.out.println("Ok, allora alla prossima");
                    iniziaPartita = false;
                }
            }
        }
         
        //gioco effettivo
        while(gioco.getLadroScappato() == false && gioco.getVittoria() == false){
            if(iniziaPartita){
                int personaggio = -1;
                System.out.println("Dove vuoi muovere il poliziotto?");
                System.out.println("1) muovi sopra, 2) muovi di sotto, 3) muovi a destra, 4) muovi a sinistra");
                int muoviPersonaggioPoliziotto = 0;
                muoviPersonaggioPoliziotto = Integer.parseInt(scanner.next());
                while(muoviPersonaggioPoliziotto != 1 && muoviPersonaggioPoliziotto != 2 && muoviPersonaggioPoliziotto != 3 && muoviPersonaggioPoliziotto != 4){
                    System.out.println("Devi dirmi un numero che sia 1, 2 ,3 on 4");
                    muoviPersonaggioPoliziotto = Integer.parseInt(scanner.next());
                }
                int[] cordinatepoliziotto = gioco.cercaPoliziotto();
                switch(muoviPersonaggioPoliziotto){
                    case 1 -> System.out.println(gioco.muoviInAlto(gioco.getMatrice()[cordinatepoliziotto[0]][cordinatepoliziotto[1]]));
                    case 2 -> System.out.println(gioco.muoviInBasso(gioco.getMatrice()[cordinatepoliziotto[0]][cordinatepoliziotto[1]]));
                    case 3 -> System.out.println(gioco.muoviADestra(gioco.getMatrice()[cordinatepoliziotto[0]][cordinatepoliziotto[1]]));
                    case 4 -> System.out.println(gioco.muoviASinistra(gioco.getMatrice()[cordinatepoliziotto[0]][cordinatepoliziotto[1]]));
                }
                int[] cordinateLadro = gioco.cercaLadro();
                String vintoONo = gioco.muoviLadro(gioco.getMatrice()[cordinateLadro[0]][cordinateLadro[1]]);
                if(vintoONo.equals("il ladro è scappato, hai perso")){
                    System.out.println(vintoONo);
                }
            }
            if(gioco.getLadroScappato() == false && gioco.getVittoria() == false){
                stampaMatrice(gioco.getMatrice());
                System.out.println();   
            }
        }
        scanner.close();
    }

    private static void stampaMatrice(Tutto[][] matrice){
        for(int i = 0; i < matrice.length; i++) {
            System.out.println();
            for (int j = 0; j < matrice.length; j++) {
                if(matrice[i][j] == null){
                    System.out.print("| " + "N" + "| ");
                }else{
                    System.out.print("| " + matrice[i][j] + "| ");
                }
            } 
        }
    }
}
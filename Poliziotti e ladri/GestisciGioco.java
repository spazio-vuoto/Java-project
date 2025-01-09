import java.util.Random;

public class GestisciGioco implements Tutto{

    private Tutto[][] matrice;
    private boolean ladroScappato = false;
    private boolean vittoria = false;

    GestisciGioco(){
        this.matrice = new Tutto[10][10];
    }

    public void inizializzaMatrice(){
        Random rand = new Random();

        matrice[4][7] = new Poliziotto("Daniele", 28934728);

        int random;
        int random2;

        do{
            random = rand.nextInt(10);
            random2 = rand.nextInt(10);
        }while(matrice[random][random2] != null);
        matrice[random][random2] = new Ladro("Salvatore", "SLASH08393ADI");

        do{
            random = rand.nextInt(10);
            random2 = rand.nextInt(10);
        }while(matrice[random][random2] != null);
        matrice[random][random2] = new Bus("729");

        do{
            random = rand.nextInt(10);
            random2 = rand.nextInt(10);
        }while(matrice[random][random2] != null);
        matrice[random][random2] = new Auto("DUAFH");
    }

    public int[] returnaPosizione(Tutto personaggio){

        for(int i  = 0; i < this.matrice.length; i++){
            for(int j  = 0; j < this.matrice[i].length; j++){
                if(personaggio.equals(matrice[i][j])){
                    int[] arrayDiRitorno = {i, j};
                    return arrayDiRitorno;
                }
            }
        }

        int[] luca = {-1, -1};
        return luca;
    }

    //serve per far muovere il ladro al bot
    public String muoviLadro(Tutto ladro){
        int numeroRandom = (int)(Math.random() * 5);
        String returno = "";
        switch(numeroRandom){
            case 1 -> returno = muoviADestra(ladro);
            case 2 -> returno = muoviInAlto(ladro);
            case 3 -> returno = muoviASinistra(ladro);
            case 4 -> returno = muoviInBasso(ladro);
        }
        return returno;
    }

    public String muoviInAlto(Tutto personaggio){
        int[] posizione =  this.returnaPosizione(personaggio);
        if(posizione[0] == 0 && personaggio instanceof Ladro){
            //il ladro scappa
            matrice[posizione[0]][posizione[1]] = null;
            ladroScappato = true;
            return "il ladro è scappato, hai perso";
        }else if(posizione[0] != 0 && matrice[posizione[0] - 1][posizione[1]] == null){
            matrice[posizione[0] - 1][posizione[1]] = personaggio;
            matrice[posizione[0]][posizione[1]] = null;
            return "il personaggio si è mosso di una casella";
        }else if(posizione[0] != 0 && matrice[posizione[0] - 1][posizione[1]] instanceof Ladro){
            vittoria = true;
            return "hai catturato il ladro";
        }
        return "il personaggio non può muoversi qui, rimarrà fermo per un turno";
    }

    public String muoviInBasso(Tutto personaggio){
        int[] posizione =  this.returnaPosizione(personaggio);
        if(posizione[0] == 9 && personaggio instanceof Ladro){
            //il ladro scappa
            matrice[posizione[0]][posizione[1]] = null;
            ladroScappato = true;
            return "il ladro è scappato, hai perso";
        }else if(posizione[0] != 9 && matrice[posizione[0] + 1][posizione[1]] == null){
            matrice[posizione[0] + 1][posizione[1]] = personaggio;
            matrice[posizione[0]][posizione[1]] = null;
            return "il personaggio si è mosso di una casella";
        }else if(posizione[0] != 9 && matrice[posizione[0] + 1][posizione[1]] instanceof Ladro){
            vittoria = true;
            return "hai catturato il ladro";
        }
        return "il personaggio non può muoversi qui, rimarrà fermo per un turno";
    }

    public String muoviADestra(Tutto personaggio){
        int[] posizione =  this.returnaPosizione(personaggio);
        if(posizione[1] == 9 && personaggio instanceof Ladro){
            //il ladro scappa
            matrice[posizione[0]][posizione[1]] = null;
            ladroScappato = true;
            return "il ladro è scappato, hai perso";
        }else if(posizione[1] != 9 && matrice[posizione[0]][posizione[1] + 1] == null){
            matrice[posizione[0]][posizione[1] + 1] = personaggio;
            matrice[posizione[0]][posizione[1]] = null;
            return "il personaggio si è mosso di una casella";
        }else if(posizione[1] != 9 && matrice[posizione[0]][posizione[1] + 1] instanceof Ladro){
            vittoria = true;
            return "hai catturato il ladro";
        }
        return "il personaggio non può muoversi qui, rimarrà fermo per un turno";
    }

    public String muoviASinistra(Tutto personaggio){
        int[] posizione =  this.returnaPosizione(personaggio);
        if(posizione[1] == 0 && personaggio instanceof Ladro){
            //il ladro scappa
            matrice[posizione[0]][posizione[1]] = null;
            ladroScappato = true;
            return "il ladro è scappato, hai perso";
        }else if(posizione[1] != 0 && matrice[posizione[0]][posizione[1] - 1] == null){
            matrice[posizione[0]][posizione[1] - 1] = personaggio;
            matrice[posizione[0]][posizione[1]] = null;
            return "il personaggio si è mosso di una casella";
        }else if(posizione[1] != 0 && matrice[posizione[0]][posizione[1] - 1] instanceof Ladro){
            vittoria = true;
            return "hai catturato il ladro";
        }
        return "il personaggio non può muoversi qui, rimarrà fermo per un turno";
    }

    public int[] cercaLadro(){
		
		for(int i = 0; i < this.matrice.length; i++){
			for(int j = 0; j < this.matrice[i].length; j++){
				if(matrice[i][j] instanceof Ladro){
					int[] risultato = {i, j};
					return risultato;
				}
			}
		}
		
		int[] fine = {-1, -1};
		return fine;
	}
	
	public int[] cercaPoliziotto(){
		
		for(int i = 0; i < this.matrice.length; i++){
			for(int j = 0; j < this.matrice[i].length; j++){
				if(matrice[i][j] instanceof Poliziotto){
					int[] risultato = {i, j};
					return risultato;
				}
			}
		}
		
		int[] fine = {-1, -1};  
		return fine;
	}

    public Tutto[][] getMatrice() {
        return this.matrice;
    }
    public void setMatrice(Tutto[][] matrice) {
        this.matrice = matrice;
    }
    public boolean getLadroScappato(){
        return this.ladroScappato;
    }
    public void setLadroScappato(boolean ladroScappato){
        this.ladroScappato = ladroScappato;
    }
    public boolean getVittoria(){
        return this.vittoria;
    }
    public void setVittoria(boolean vittoria){
        this.vittoria = vittoria;
    }
}
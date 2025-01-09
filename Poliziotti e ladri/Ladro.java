public class Ladro implements Tutto{
    private String nome;
    private String codiceFiscale;

    Ladro(){}

    Ladro(String nome, String codiceFiscale){
        this.nome = nome;
        this.codiceFiscale = codiceFiscale;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Ladro nuovoLadro){
            if(this.nome.equals(nuovoLadro.getNome()) && this.codiceFiscale.equals(nuovoLadro.getCodiceFiscale())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "L";
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getCodiceFiscale(){
        return codiceFiscale;
    }
    public void setCodiceFiscale(String codiceFiscale){
        this.codiceFiscale = codiceFiscale;
    }
}
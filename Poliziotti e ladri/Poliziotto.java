public class Poliziotto implements Tutto{
    private String nome;
    private int numeroDistintivo;

    Poliziotto(){}

    Poliziotto(String nome, int numeroDistintivo){
        this.nome = nome;
        this.numeroDistintivo = numeroDistintivo;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Poliziotto poliziotto){
            if(this.nome.equals(poliziotto.getNome()) && this.numeroDistintivo == poliziotto.getNumeroDistintivo()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "P";
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getNumeroDistintivo(){
        return numeroDistintivo;
    }
    public void setNumeroDistintivo(int numeroDistintivo){
        this.numeroDistintivo = numeroDistintivo;
    }
}
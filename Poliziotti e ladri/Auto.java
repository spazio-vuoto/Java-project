public class Auto implements Tutto{
    private String targa;

    Auto(){}

    Auto(String targa){
        this.targa = targa;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Auto automobile){
            if(automobile.getTarga().equals(this.targa)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "A";
    }

    public String getTarga() {
        return targa;
    }
    public void setTarga(String targa) {
        this.targa = targa;
    }
}

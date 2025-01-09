public class Bus implements Tutto{
    private String linea;

    Bus(){}

    Bus(String linea){
        this.linea = linea;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Bus bus){
            if(bus.getLinea().equals(this.linea)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "B";
    }

    public String getLinea() {
        return linea;
    }
    public void setLinea(String linea) {
        this.linea = linea;
    }
}

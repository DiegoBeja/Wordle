public class PalabraIntento implements Palabra{
    private String palabraIntento;

    public PalabraIntento(String palabraIntento){
        this.palabraIntento = palabraIntento;
    }

    public PalabraIntento(){

    }

    public String[] splitPalabra(String palabra){
        String [] palabraSplit = new String[4];
        palabraSplit = palabraIntento.split("");

        return palabraSplit;
    }

    public String getPalabraIntento(){
        return this.palabraIntento;
    }
}

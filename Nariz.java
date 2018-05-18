public class Nariz {

    private String posicion = "extendida";
    private String tipo = "F-14 Tomcat";
    private String orden = "1";
    private String state = "1";

    public Nariz(){

    }

    public Nariz(String posicion, String tipo, String orden, String state){
        this.orden=orden;
        this.tipo=tipo;
        this.orden=orden;
        this.state=state;
    }

    public void setState(String state){
        this.state=state;
    }

    public void setOrden(String orden) {

        this.orden = orden;

        if((!orden.equalsIgnoreCase("1")) && (!orden.equalsIgnoreCase("2")) && (!orden.equalsIgnoreCase("3"))){
            this.orden=state;
        }

        if ((orden.equalsIgnoreCase("1")) || (orden.equalsIgnoreCase("2"))) {
            this.posicion = "extendida";
        }

        if (orden.equalsIgnoreCase("3")) {
            this.posicion = "en el pecho";
        }

    }

    public String getOrden() {

        return this.orden;

    }

    public String getPosicion() {

        return this.posicion;

    }

    public String getTipo() {

        return this.tipo;
    }
}
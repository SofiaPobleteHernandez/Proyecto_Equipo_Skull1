public class Ala {

    private String plegado = "extendidas";
    private String alerones = "base";
    private String orden = "1";
    private String state = "1";

    public Ala(){

    }

    public Ala(String plegado, String alerones, String orden, String state){
        this.plegado=plegado;
        this.alerones=alerones;
        this.orden=orden;
        this.state=state;
    }

    public String getOrden() {

        return orden;

    }

    public void setState(String state){
        this.state=state;
    }

    public void setOrden(String orden) {

        this.orden = orden;

        if((!orden.equalsIgnoreCase("1")) && (!orden.equalsIgnoreCase("2")) && (!orden.equalsIgnoreCase("3")) && (!orden.equalsIgnoreCase("H")) && (!orden.equalsIgnoreCase("L"))){
            this.orden=state;
        }

        if((orden.equalsIgnoreCase("1")) || (orden.equalsIgnoreCase("2"))) {
            this.plegado = "extendidas";
            this.alerones = "base";
        }

        if(orden.equalsIgnoreCase("3")){
            this.plegado = "plegadas en la espalda";
            this.alerones = "base";
        }

        if(orden.equalsIgnoreCase("H")){
            this.alerones="abajo";
        }

        if(orden.equalsIgnoreCase("L")){
            this.alerones="arriba";
        }
    }

    public String getPlegado() {

        return this.plegado;

    }

    public String getAlerones() {

        return this.alerones;

    }
}
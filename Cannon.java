public class Cannon {

    private String estado = "cañon de municion RMS-1";
    private String orden = "1";
    private String state = "1";

    public Cannon(){

    }

    public Cannon(String estado, String orden, String state){
        this.estado=estado;
        this.orden=orden;
        this.state=state;
    }

    public void setState(String state){
        this.state=state;
    }

    public String getOrden() {

        return this.orden;

    }

    public void setOrden(String orden) {

        this.orden = orden;

        if((!orden.equalsIgnoreCase("1")) && (!orden.equalsIgnoreCase("2")) && (!orden.equalsIgnoreCase("3"))){
            this.orden=state;
        }

        if(orden.equalsIgnoreCase("1")) {
            this.estado = "cañon de municion RMS-1";
        }

        if((orden.equalsIgnoreCase("2")) || (orden.equalsIgnoreCase("3"))){
            this.estado = "rifle semi-automatico";
        }

    }

    public String getEstado() {

        return this.estado;

    }
}

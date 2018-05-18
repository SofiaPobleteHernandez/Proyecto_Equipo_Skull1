public class Brazo {

    private String estado = "plegado";
    private String longitud = "minima";
    private String plegado = "total";
    private String orden = "1";
    private String state = "1";

    public Brazo(){

    }

    public Brazo(String estado, String longitud, String plegado, String orden, String state){
        this.estado=estado;
        this.longitud=longitud;
        this.plegado=plegado;
        this.orden=orden;
        this.state=state;
    }

    public void setState(String state){
        this.state=state;
    }

    public void setOrden(String orden) {

        this.orden = orden;

        if((!orden.equalsIgnoreCase("1")) && (!orden.equalsIgnoreCase("2")) && (!orden.equalsIgnoreCase("3")) && (!orden.equalsIgnoreCase("F")) ){
            this.orden=state;
        }

        if(orden.equalsIgnoreCase("1")) {
            this.plegado = "total";
            this.longitud = "minima";
            this.estado = "plegado";
        }

        if(orden.equalsIgnoreCase("2")){
            this.plegado = "medio";
            this.longitud = "media";
            this.estado = "base";
        }

        if(orden.equalsIgnoreCase("3")){
            this.plegado = "nulo";
            this.longitud = "total";
            this.estado = "base";
        }

        if(orden.equalsIgnoreCase("F")){
            this.estado = "ataque";
        }
    }

    public String getOrden() {

        return this.orden;

    }

    public String getLongitud() {

        return this.longitud;

    }

    public String getPlegado() {

        return this.plegado;

    }

    public String getEstado() {

        return this.estado;

    }
}
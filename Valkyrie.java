public class Valkyrie {

    private int posicion_x = 0;
    private int posicion_y = 0;
    private int velocidad = 0;
    private String Estado = "1";
    private String orden;
    private Nariz fuselaje = new Nariz();
    private Motor pierna_iz = new Motor();
    private Motor pierna_der = new Motor();
    private Brazo brazos = new Brazo();
    private Torreta_v cabeza = new Torreta_v();
    private Ala alas = new Ala();
    private Cannon arma = new Cannon();

    public Valkyrie() {

    }

    public Valkyrie(int posicion_x, int posicion_y, int velocidad, String Estado, String orden, Nariz fuselaje, Motor pierna_iz, Motor pierna_der, Brazo brazos, Torreta_v cabeza, Ala alas, Cannon arma) {
        this.posicion_x = posicion_x;
        this.posicion_y = posicion_y;
        this.velocidad = velocidad;
        this.Estado = Estado;
        this.orden = orden;
        this.fuselaje = fuselaje;
        this.pierna_iz = pierna_iz;
        this.pierna_der = pierna_der;
        this.brazos = brazos;
        this.cabeza = cabeza;
        this.alas = alas;
        this.arma = arma;
    }

    public String setEstado(String Estado) {
        this.Estado = Estado;
        return this.Estado;
    }

    public int setPosicion_x(int posicion_x) {
        this.posicion_x = posicion_x;
        return this.posicion_x;
    }

    public int setPosicion_y(int posicion_y) {
        this.posicion_y = posicion_y;
        return this.posicion_y;
    }

    public int setVelocidad(int velocidad) {
        this.velocidad = velocidad;
        return this.velocidad;
    }

    public void setOrden(String orden){
        this.orden=orden;
        fuselaje.setState(Estado);
        pierna_iz.setState(Estado);
        pierna_der.setState(Estado);
        brazos.setState(Estado);
        cabeza.setState(Estado);
        alas.setState(Estado);
        arma.setState(Estado);

        fuselaje.setOrden(orden);
        pierna_iz.setOrden(orden);
        pierna_der.setOrden(orden);
        brazos.setOrden(orden);
        cabeza.setOrden(orden);
        alas.setOrden(orden);
        arma.setOrden(orden);

        if(Estado.equalsIgnoreCase("3")){
            if((orden.equalsIgnoreCase("G")) && (velocidad>0)){

                if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==0)) {
                    pierna_der.setPosicion_pierna(1);
                    pierna_iz.setPosicion_pierna(0);
                    System.out.println("-Ha movido la pierna derecha");
                }

                if((pierna_der.getPosicion_pierna()==1) && (pierna_iz.getPosicion_pierna()==0)){
                    pierna_der.setPosicion_pierna(0);
                    pierna_iz.setPosicion_pierna(1);
                    System.out.println("-Ha movido la pierna izquierda");
                }

                if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==1)){
                    pierna_der.setPosicion_pierna(1);
                    pierna_iz.setPosicion_pierna(0);
                    System.out.println("-Ha movido la pierna derecha");
                }

                if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==-1)){
                    pierna_der.setPosicion_pierna(0);
                    pierna_iz.setPosicion_pierna(0);
                    System.out.println("-Ha movido la pierna izquierda");
                }

                if((pierna_der.getPosicion_pierna()==-1) && (pierna_iz.getPosicion_pierna()==0)){
                    pierna_der.setPosicion_pierna(0);
                    pierna_iz.setPosicion_pierna(0);
                    System.out.println("-Ha movido la pierna derecha");
                }
            }

            if((orden.equalsIgnoreCase("R")) && (velocidad>0)){

                if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==0)) {
                    pierna_der.setPosicion_pierna(-1);
                    pierna_iz.setPosicion_pierna(0);
                    System.out.println("-Ha movido la pierna derecha");
                }

                if((pierna_der.getPosicion_pierna()==1) && (pierna_iz.getPosicion_pierna()==0)){
                    pierna_der.setPosicion_pierna(0);
                    pierna_iz.setPosicion_pierna(0);
                    System.out.println("-Ha movido la pierna derecha");
                }

                if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==1)){
                    pierna_der.setPosicion_pierna(0);
                    pierna_iz.setPosicion_pierna(0);
                    System.out.println("-Ha movido la pierna izquierda");
                }

                if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna())==-1){
                    pierna_der.setPosicion_pierna(-1);
                    pierna_iz.setPosicion_pierna(0);
                    System.out.println("-Ha movido la pierna derecha");
                }

                if((pierna_der.getPosicion_pierna()==-1) && (pierna_iz.getPosicion_pierna()==0)){
                    pierna_der.setPosicion_pierna(0);
                    pierna_iz.setPosicion_pierna(-1);
                    System.out.println("-Ha movido la pierna izquierda");
                }

            }
        }


        if((Estado.equalsIgnoreCase("2")) && (posicion_y==0)){
            if((orden.equalsIgnoreCase("G")) && (velocidad>0)){

                if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==0)) {
                    pierna_der.setPosicion_pierna(1);
                    pierna_iz.setPosicion_pierna(0);
                    System.out.println("-Ha movido la pierna derecha");
                }

                if((pierna_der.getPosicion_pierna()==1) && (pierna_iz.getPosicion_pierna()==0)){
                    pierna_der.setPosicion_pierna(0);
                    pierna_iz.setPosicion_pierna(1);
                    System.out.println("-Ha movido la pierna izquierda");
                }

                if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==1)){
                    pierna_der.setPosicion_pierna(1);
                    pierna_iz.setPosicion_pierna(0);
                    System.out.println("-Ha movido la pierna derecha");
                }

                if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==-1)){
                    pierna_der.setPosicion_pierna(0);
                    pierna_iz.setPosicion_pierna(0);
                    System.out.println("-Ha movido la pierna izquierda");
                }

                if((pierna_der.getPosicion_pierna()==-1) && (pierna_iz.getPosicion_pierna()==0)){
                    pierna_der.setPosicion_pierna(0);
                    pierna_iz.setPosicion_pierna(0);
                    System.out.println("-Ha movido la pierna derecha");
                }
            }

            if((orden.equalsIgnoreCase("R")) && (velocidad>0)){

                if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==0)) {
                    pierna_der.setPosicion_pierna(-1);
                    pierna_iz.setPosicion_pierna(0);
                    System.out.println("-Ha movido la pierna derecha");
                }

                if((pierna_der.getPosicion_pierna()==1) && (pierna_iz.getPosicion_pierna()==0)){
                    pierna_der.setPosicion_pierna(0);
                    pierna_iz.setPosicion_pierna(0);
                    System.out.println("-Ha movido la pierna derecha");
                }

                if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==1)){
                    pierna_der.setPosicion_pierna(0);
                    pierna_iz.setPosicion_pierna(0);
                    System.out.println("-Ha movido la pierna izquierda");
                }

                if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna())==-1){
                    pierna_der.setPosicion_pierna(-1);
                    pierna_iz.setPosicion_pierna(0);
                    System.out.println("-Ha movido la pierna derecha");
                }

                if((pierna_der.getPosicion_pierna()==-1) && (pierna_iz.getPosicion_pierna()==0)){
                    pierna_der.setPosicion_pierna(0);
                    pierna_iz.setPosicion_pierna(-1);
                    System.out.println("-Ha movido la pierna izquierda");
                }

            }
        }
    }


     public int getPosicion_x(){
        return posicion_x;
     }

     public int getPosicion_y(){
        return posicion_y;
     }

     public int getVelocidad(){
        return velocidad;
     }

     public String getEstado(){
        return Estado;
     }


     public void Imprimir_Estado_de_Piezas(){
        System.out.println("-El fuselaje es el de un avión          : " + fuselaje.getTipo());
        System.out.println("-Las alas se encuentran                 : " + alas.getPlegado());
        System.out.println("-La posicion de las alas es             : " + alas.getAlerones());
        System.out.println("-La longitud de los brazos es           : " + brazos.getLongitud());
        System.out.println("-El plegado de los brazos es            : " + brazos.getPlegado());
        System.out.println("-El estado de los brazos es de          : " + brazos.getEstado());
        System.out.println("-Tiene un arma del siguiente tipo       : " + arma.getEstado());
        System.out.println("-El modo en que están los motores es    : " + pierna_der.getEstado());
        System.out.println("-El plegado de los motores es           : " + pierna_der.getPlegado());
        System.out.println("-Los motores están                      : " + pierna_der.getApertura());
        System.out.println("-Los motores tienen una longitud        : " + pierna_der.getLongitud());
        System.out.println("-La posicion de la nariz es             : " + fuselaje.getPosicion());
        System.out.println("-La posicion de la torreta es           : " + cabeza.getPosicion());
        System.out.println("-La torreta se encuentra                : " + cabeza.getArmado());
        System.out.println("-La torreta está en modo de             : " + cabeza.getEstado());

        if(cabeza.getEstado().equalsIgnoreCase("ataque")){
            System.out.println("¡Has Disparado!");
        }
     }
}
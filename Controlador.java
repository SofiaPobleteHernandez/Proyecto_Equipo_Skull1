import java.util.Scanner;
import java.util.ArrayList;

public class Controlador {
    private String opcion;
    private int Longitud_Espacio;
    private int Altura_Espacio;
    private Valkyrie Valkyrie = new Valkyrie();
    private int Numero_de_Pistas;
    Pistas pista[];

    public Controlador(){

    }

    public Controlador(String opcion, int Longitud_Espacio, int Altura_Espacio, Valkyrie Valkyrie, Pistas pista[], int Numero_de_Pistas){
        this.opcion=opcion;
        this.Longitud_Espacio=Longitud_Espacio;
        this.Altura_Espacio=Altura_Espacio;
        this.Valkyrie=Valkyrie;
        this.pista=pista;
        this.Numero_de_Pistas=Numero_de_Pistas;
    }

    Scanner leer_opcion = new Scanner(System.in);
    int veces=0;

    public int Establecer_Longitud(){
        Longitud_Espacio=(int)(Math.random() * 100000)+300;
        return this.Longitud_Espacio;
    }

    public int Establecer_Altura(){
        Altura_Espacio=(int)(Math.random() * 100000)+300;
        return this.Altura_Espacio;
    }
    public int Numero_Pistas(){
        Numero_de_Pistas=(int)(Math.random() * Longitud_Espacio/100)+1;
        pista=new Pistas[Numero_de_Pistas];
        return this.Numero_de_Pistas;
    }

    public Pistas[] Establecer_Pistas(int Longitud_Espacio, int Numero_de_Pistas){

        int x=0;
        int largo=0;
        int valor_x=0;
        int valor_largo=0;

        for (int z=0; z<Numero_de_Pistas; z++){
            pista[z]=new Pistas();
            if(z==0){
                x=(int)(Math.random()*(Longitud_Espacio*(z+1)/Numero_de_Pistas))+1;
                valor_x=pista[z].setPosicion_x_pista(x);
                largo=(int)(Math.random()*(Longitud_Espacio/Numero_de_Pistas))+1;
                valor_largo=pista[z].setLongitud_pista(largo);
            }
            if(z>0){
                x=(int)(Math.random()*((Longitud_Espacio*(z+1)/Numero_de_Pistas)/200))+(pista[z-1].getPosicion_x_pista()+pista[z-1].getLongitud_pista());
                while(x>Longitud_Espacio){
                    x=(int)(Math.random()*((Longitud_Espacio*(z+1)/Numero_de_Pistas)/200))+pista[z-1].getPosicion_x_pista();
                }
                valor_x=pista[z].setPosicion_x_pista(x);
                largo=(int)(Math.random()*((Longitud_Espacio-x)/100));
                while((x+largo)>Longitud_Espacio){
                    largo=(int)(Math.random()*((Longitud_Espacio-x)/100));
                }
                valor_largo=pista[z].setLongitud_pista(largo);
            }
        }
        return this.pista;
    }

    public int Imprimir_Pistas(){
        System.out.println("");
        System.out.println("PISTAS DISPONIBLES : ");
        for (int i=0; i<Numero_de_Pistas; i++){
            System.out.println("");
            System.out.println("-Pista " + (i+1) + " : ");
            System.out.println("-Comienza en la coordenada x : " + pista[i].getPosicion_x_pista());
            System.out.println("-Tiene una longitud de       : " + pista[i].getLongitud_pista());
            System.out.println("-----------------------------------------------------------------");
        }
        return 0;
    }

    public String Menu(){
        System.out.println("");
        System.out.println("");
        System.out.println("======================================================");
        System.out.println("======================================================");
        System.out.println("Teclas y Su Uso: ");
        System.out.println("-E : Empieza el Juego.");
        System.out.println("-T : Termina el Juego.");
        System.out.println("-H : Aumenta la Altitud de vuelo del VF-1.");
        System.out.println("-L : Disminuye la Altitud de vuelo del VF-1.");
        System.out.println("-Q : Aumenta la Veocidad del VF-1");
        System.out.println("-S : Disminuye la Velocidad del VF-1");
        System.out.println("-R : El VF-1 retrocede.");
        System.out.println("-G : El VF-1 avanza.");
        System.out.println("-F : Libera disparo.");
        System.out.println("-1 : Transforma el VF-1 en Modo Fighter.");
        System.out.println("-2 : Transforma el VF-1 en Modo Gerwalk.");
        System.out.println("-3 : Transforma el VF-1 en Modo Battloid");
        System.out.println("");
        System.out.println("-------------------------------------------------------");
        System.out.println("");
        opcion=leer_opcion.next();
        return opcion;
    }

    public int Resolver() {

        if ((opcion.equalsIgnoreCase("E")) && (veces == 0)) {
            System.out.println("¡A jugar! ¡Ya puedes dirigir al VF-1!");
        }

        if (opcion.equalsIgnoreCase("H")) {
            if (!Valkyrie.getEstado().equalsIgnoreCase("3")) {
                if ((Valkyrie.getPosicion_y() + Valkyrie.getVelocidad() < Altura_Espacio) || (Valkyrie.getPosicion_y() + Valkyrie.getVelocidad() == Altura_Espacio)) {

                    if (Valkyrie.getEstado().equalsIgnoreCase("2")) {
                        Valkyrie.setPosicion_y(Valkyrie.getPosicion_y() + Valkyrie.getVelocidad());
                        Valkyrie.setOrden(opcion);
                    }

                    if (Valkyrie.getEstado().equalsIgnoreCase("1")) {

                        if(Valkyrie.getPosicion_y()==0) {
                            int posicion = 0;
                            int tamano = 0;

                            for (int i = 0; i < Numero_de_Pistas; i++) {
                                if (pista[i].getPosicion_x_pista() < Valkyrie.getPosicion_x()) {
                                    if ((pista[i].getPosicion_x_pista() + pista[i].getLongitud_pista()) > Valkyrie.getPosicion_x()) {
                                        tamano = pista[i].getLongitud_pista();
                                        posicion = pista[i].getPosicion_x_pista();
                                    }
                                }
                            }


                            if ((tamano > 99) && (Valkyrie.getVelocidad() > 349)) {
                                Valkyrie.setPosicion_y(Valkyrie.getVelocidad());
                                Valkyrie.setOrden(opcion);
                            }
                        }

                        if(Valkyrie.getPosicion_y()>0){
                            Valkyrie.setPosicion_y(Valkyrie.getVelocidad()+Valkyrie.getPosicion_y());
                            Valkyrie.setOrden(opcion);
                        }
                    }
                }

                if (Valkyrie.getPosicion_y() + Valkyrie.getVelocidad() > Altura_Espacio) {
                    Valkyrie.setPosicion_y(Altura_Espacio);
                    Valkyrie.setOrden(opcion);
                }
            }
        }

        if (opcion.equalsIgnoreCase("L")) {
            if (!Valkyrie.getEstado().equalsIgnoreCase("3")) {
                if (Valkyrie.getPosicion_y() - Valkyrie.getVelocidad() > -1) {
                    Valkyrie.setPosicion_y(Valkyrie.getPosicion_y() - Valkyrie.getVelocidad());
                    Valkyrie.setOrden(opcion);
                }
                if (Valkyrie.getPosicion_y() - Valkyrie.getVelocidad() < 0) {
                    Valkyrie.setPosicion_y(0);
                    Valkyrie.setOrden(opcion);
                }
            }
        }

        if (opcion.equalsIgnoreCase("Q")) {
            int incremento=0;
            if (Valkyrie.getVelocidad() < 750) {
                incremento=(int)(Math.random()*100)+1;
                while(Valkyrie.getVelocidad()+incremento>750){
                    incremento=(int)(Math.random()*100)+1;
                }
                Valkyrie.setVelocidad(Valkyrie.getVelocidad() + incremento);
                Valkyrie.setOrden(opcion);
            }
        }

        if (opcion.equalsIgnoreCase("S")) {
            int disminucion=0;
            disminucion=(int)(Math.random()*100)+1;
            while(Valkyrie.getVelocidad()-disminucion<0){
                disminucion=(int)(Math.random()*100)+1;
            }
            Valkyrie.setVelocidad(Valkyrie.getVelocidad()-disminucion);
            Valkyrie.setOrden(opcion);
        }

        if (opcion.equalsIgnoreCase("R")) {
            if (Valkyrie.getPosicion_x() - Valkyrie.getVelocidad() > -1) {
                Valkyrie.setPosicion_x(Valkyrie.getPosicion_x() - Valkyrie.getVelocidad());
                Valkyrie.setOrden(opcion);
            }
            if (Valkyrie.getPosicion_x() - Valkyrie.getVelocidad() < 0) {
                Valkyrie.setPosicion_x(0);
                Valkyrie.setOrden(opcion);
            }
        }

        if (opcion.equalsIgnoreCase("G")) {
            if (Valkyrie.getPosicion_x() + Valkyrie.getVelocidad() < Longitud_Espacio + 1) {
                Valkyrie.setPosicion_x(Valkyrie.getPosicion_x() + Valkyrie.getVelocidad());
                Valkyrie.setOrden(opcion);
            }
            if (Valkyrie.getPosicion_x() + Valkyrie.getVelocidad() > Longitud_Espacio) {
                Valkyrie.setPosicion_x(Longitud_Espacio);
                Valkyrie.setOrden(opcion);
            }
        }

        if (opcion.equalsIgnoreCase("3")) {

            if (Valkyrie.getEstado().equalsIgnoreCase("1")) {
                if (Valkyrie.getPosicion_y() < 201) {
                    Valkyrie.setEstado("3");
                    Valkyrie.setOrden(opcion);
                }
            }

            if (Valkyrie.getEstado().equalsIgnoreCase("2")) {
                if (Valkyrie.getPosicion_y() < 201) {
                    Valkyrie.setEstado("3");
                    Valkyrie.setOrden(opcion);
                }
            }
        }

        if (opcion.equalsIgnoreCase("2")) {
            Valkyrie.setEstado("2");
            Valkyrie.setOrden(opcion);
        }

        if (opcion.equalsIgnoreCase("1")) {
            if (Valkyrie.getEstado().equalsIgnoreCase("2")) {

                int longitud = 0;

                for (int i = 0; i < Numero_de_Pistas; i++) {
                    if (pista[i].getPosicion_x_pista() < Valkyrie.getPosicion_x()) {
                        if ((pista[i].getPosicion_x_pista() + pista[i].getLongitud_pista()) > Valkyrie.getPosicion_x()) {
                            longitud = pista[i].getLongitud_pista();
                        }
                    }
                }

                if ((Valkyrie.getPosicion_y() > 0) && (longitud>99)){
                    Valkyrie.setEstado("1");
                    Valkyrie.setOrden(opcion);
                }
            }
            if (Valkyrie.getEstado().equalsIgnoreCase("3")) {
                Valkyrie.setEstado("2");
                Valkyrie.setOrden("2");
            }
        }

        if(opcion.equalsIgnoreCase("F")){
            Valkyrie.setOrden(opcion);
        }

        veces++;
        return veces;
    }

    public int Informe(){
        System.out.println("");
        System.out.println("REPORTE : ");
        System.out.println("");
        System.out.println("El VF-1 se encuentra en las siguientes condiciones : ");
        if(Valkyrie.getEstado().equalsIgnoreCase("1")){
            System.out.println("-Modo   : Fighter.");
            if(Valkyrie.getPosicion_y()==0){
                System.out.println("-Transporte  : Se desliza.");
            }
            if(Valkyrie.getPosicion_y()>0){
                System.out.println("-Transporte  : Vuela.");
            }
        }
        if(Valkyrie.getEstado().equalsIgnoreCase("2")){
            System.out.println("-Modo   : Gerwalk.");
            if(Valkyrie.getPosicion_y()==0){
                System.out.println("-Transporte  : Camina.");
            }
            if(Valkyrie.getPosicion_y()>0){
                System.out.println("-Transporte  : Vuela.");
            }
        }
        if(Valkyrie.getEstado().equalsIgnoreCase("3")){
            System.out.println("-Modo   : Battloid.");
            System.out.println("-Transporte  : Camina.");
        }
        System.out.println("-Coordenadas  : (" + Valkyrie.getPosicion_x() + " , " + Valkyrie.getPosicion_y() + ") metros.");
        System.out.println("-Velocidad    : " + Valkyrie.getVelocidad() + " km/h.");

        int largo = 0;

        for (int i = 0; i < Numero_de_Pistas; i++) {
            if (pista[i].getPosicion_x_pista() < Valkyrie.getPosicion_x()) {
                if ((pista[i].getPosicion_x_pista() + pista[i].getLongitud_pista()) > Valkyrie.getPosicion_x()) {
                    largo = pista[i].getLongitud_pista();
                    System.out.println("-El VF-1 está sobre una pista de longitud : "+ largo);
                }
            }
        }

        Valkyrie.Imprimir_Estado_de_Piezas();

        return 0;
    }
}
public class Organizador {
    String i;
    int j;
    int k;
    int a;
    int b;
    int c;
    int letra;
    Pistas[] d;
    Controlador controler = new Controlador();

    public Organizador(){

    }

    public Organizador (String i, int j, int k, int a, int b, int c, int letra, Pistas[] d, Controlador controler){
        this.i=i;
        this.j=j;
        this.k=k;
        this.a=a;
        this.b=b;
        this.c=c;
        this.letra=letra;
        this.d=d;
        this.controler=controler;
    }

    public void Programa() {
        a = controler.Establecer_Longitud();
        b = controler.Establecer_Altura();
        System.out.println("");
        System.out.println("");
        System.out.println("                    BIENVENIDO AL SIMULADOR DE VF-1");
        System.out.println("                   =================================");
        System.out.println("");
        System.out.println("");
        System.out.println("CARACTERÍSTICAS DEL MUNDO DE TU VF-1 : ");
        System.out.println("");
        System.out.println("-Largo              : " + a);
        System.out.println("-Alto               : " + b);
        c = controler.Numero_Pistas();
        d = controler.Establecer_Pistas(a, c);
        System.out.println("-Numero de pistas   : " + c);
        letra = controler.Imprimir_Pistas();
        i = controler.Menu();
        //System.out.println(i);

        while (!i.equalsIgnoreCase("T")) {
            j = controler.Resolver();
            k = controler.Informe();
            i = controler.Menu();
        }
    }
}
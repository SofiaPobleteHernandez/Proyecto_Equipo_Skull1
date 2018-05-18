import java.lang.reflect.Array;

public class Pistas {
    int posicion_x_pista;
    int longitud_pista;

    public Pistas(){

    }

    public Pistas(int posicion_x_pista, int longitud_pista){
        this.posicion_x_pista=posicion_x_pista;
        this.longitud_pista=longitud_pista;
    }

    public int getLongitud_pista() {
        return longitud_pista;
    }

    public int getPosicion_x_pista() {
        return posicion_x_pista;
    }

    public int setLongitud_pista(int longitud_pista){
        this.longitud_pista=longitud_pista;
        return this.longitud_pista;
    }

    public int setPosicion_x_pista(int posicion_x_pista){
        this.posicion_x_pista=posicion_x_pista;
        return this.posicion_x_pista;
    }


}

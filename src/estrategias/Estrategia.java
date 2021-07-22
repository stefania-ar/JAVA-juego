package estrategias;
import juego.*;

public abstract class Estrategia {

    String nombreEstrategia;

    public String getNombreEstrategia() {
        return nombreEstrategia;
    }

    public Estrategia(String nombreEstrategia) {
        this.nombreEstrategia = nombreEstrategia;
    }
    
    public Estrategia() {
    	
    }
    
    public abstract Atributo elegirAtributo(Carta carta);
    
}


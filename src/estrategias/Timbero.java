package estrategias;

import juego.*;

public class Timbero extends Estrategia{

    public Timbero(String nombreEstrategia) {
        super(nombreEstrategia);
    }

    
    @Override
    public Atributo elegirAtributo(Carta carta) {
    	return carta.elegirAtributoRandom();
    }
  
       
}
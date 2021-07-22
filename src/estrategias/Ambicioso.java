package estrategias;

import juego.*;
//Ambicioso . El jugador elige el atributo que posea el mayor valor de su carta del
//turno.
public class Ambicioso extends Estrategia {

    public Ambicioso() {
       
    }

	@Override
	public Atributo elegirAtributo(Carta carta) {
		 Atributo atributoReturn = carta.elegirAtributoMayorValor();
		 
         return atributoReturn;
	}

}
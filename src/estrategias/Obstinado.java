package estrategias;

import juego.*;
//Obstinado . El jugador elige siempre el mismo atributo para competir, ronda tras
//ronda.
public class Obstinado extends Estrategia {
	String s;

    public Obstinado(String s) {
        this.s=s;
    }

    @Override
    public Atributo elegirAtributo(Carta carta) {
    	return carta.getAtributoNombre(s);
    }
}
package pocimas;

import juego.*;
//Pócima Selectiva Fuerza . Si el atributo seleccionado es fuerza, su valor se
//incrementa en 35%.

public class PocimaSelectiva extends PocimaAbstracta{
	int valor;

    public PocimaSelectiva(String nombrePocima, int valor) {
        this.nombrePocima = nombrePocima;
        this.valor = valor;
}

    @Override
    public double aplicarPocion(Atributo atributo) {// PASARLE EL ATRIBUTO NO LA CARTA
    	
    	if(atributo.getNombre().equals(nombrePocima)) {
    		return atributo.getValor()*(100+this.valor)/100;
    	}
        return atributo.getValor();
    }

}
package pocimas;

import juego.Atributo;

public class PocimaFortalecedora extends PocimaAbstracta {
	int valor;

    public PocimaFortalecedora(String nombrePocima, int valor) {
        this.nombrePocima = nombrePocima;
                this.valor = valor;
    }

	@Override
	public double aplicarPocion(Atributo atributo) {
		return atributo.getValor()*(100+this.valor)/100;
		
	}

    
}
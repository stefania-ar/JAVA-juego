package pocimas;

import juego.Atributo;

public class PocimaCambiaria extends PocimaAbstracta{
	int valor;


    public PocimaCambiaria(String nombrePocima, int valor) {
        this.nombrePocima = nombrePocima;
                this.valor = valor;
    }

    @Override
    public double aplicarPocion(Atributo atributo) {
        return this.valor; 
    }

}

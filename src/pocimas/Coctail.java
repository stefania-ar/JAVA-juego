package pocimas;

import juego.Atributo;

public class Coctail extends PocimaAbstracta{
    private int cantCoctails;
    private PocimaAbstracta pocima1;
    private PocimaAbstracta pocima2;
            
    
    public Coctail(PocimaAbstracta pocima1, PocimaAbstracta pocima2){
        this.pocima1 = pocima1;
        this.pocima2 = pocima2;
    }
    
    
    public int getCantCoctails() {
        return cantCoctails;
    }

	@Override
	public double aplicarPocion(Atributo atributo) {
		Atributo nuevo= atributo;
		double aux= nuevo.getValor();
		aux= pocima1.aplicarPocion(nuevo);
		nuevo.setValor((int)aux);
		
		aux= pocima2.aplicarPocion(nuevo);
		return aux;
	}

}
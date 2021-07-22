package juego;

import java.util.ArrayList;
import java.util.Collections;

import pocimas.*;

public final class Carta {
    private String nombreCarta;
    private ArrayList<Atributo> valoresCarta;
    private PocimaAbstracta pocima;
    private static int cantAtributos;
    boolean tienePocima;

    public Carta cartaRandom(){
        Carta aux = new Carta();
        return aux;
    }
    
    public Carta(){
        this.valoresCarta = new ArrayList<>();
        this.pocima = null;
    }
    
    public void addCaracteristica(String nombre, int valor){
        Atributo c = new Atributo(nombre,valor);
        this.valoresCarta.add(c);
        this.cantAtributos++;
    }

    public static int getCantAtributos() {
        return cantAtributos;
    }
    
    public PocimaAbstracta getPocima(){
        return this.pocima;
    }
    
    public boolean tieneCaracteristica(String nombre){
    	ArrayList<Atributo> aux= new ArrayList<Atributo>(this.valoresCarta);
        return aux.contains(getAtributoNombre(nombre));
    }

    public void agregarPocimaACarta(PocimaAbstracta pocima){
        this.pocima = pocima;
        this.setTienePocima(true);
    }

    private ArrayList<Atributo> getValoresCarta() {
    	return new ArrayList<Atributo>(valoresCarta);
    }

    public String getNombreCarta() {
        return nombreCarta;
    }

    public boolean TienePocima() {
		return tienePocima;
	}

	public void setTienePocima(boolean tienePocima) {
		this.tienePocima = tienePocima;
	}

	public void setPocima(PocimaAbstracta pocima) {
        this.pocima = pocima;
    }

    public void setNombreCarta(String nombreCarta) {
        this.nombreCarta = nombreCarta;
    }
    
    public Atributo getAtributoNombre(String s) {
    	for (Atributo atributo : valoresCarta) {
			if(atributo.getNombre().equals(s)) {
				return atributo;
			}
		}
    	return null;
    }
    
    public Atributo elegirAtributoMayorValor() {
    	ArrayList<Atributo> aux= new ArrayList<Atributo>(this.valoresCarta);
    	Collections.sort(aux);
    	return aux.get(aux.size()-1);
    }
    
    public Atributo elegirAtributoRandom() {
    	int random = (int) (Math.random() * 10);
        
        while (random > this.getValoresCarta().size()-1){
            random = random - this.getValoresCarta().size();
        }
        Atributo aux= this.getValoresCarta().get(random);
		
        return aux;
    }
    
    public double aplicarPocima(Atributo atr) {
    	return this.getPocima().aplicarPocion(atr);
    }
    
    
    public String imprimirCarta(String s, Jugador j) {
    	String imp="La carta de "+j.getNombreJugador()+" es " +this.getNombreCarta()+ " con " +this.getAtributoNombre(s)+" "+
    			j.getCartaEnMano().getAtributoNombre(s).getValor();
    	if(this.tienePocima) {
    		return imp+ ". Se aplicó "+this.getPocima().getNombrePocima()+ ", valor resultante: "+
    				this.aplicarPocima(this.getAtributoNombre(s));
    	}
		return imp;
		
		
    }

    @Override
	public boolean equals(Object obj) {
		Carta c= (Carta) obj;
		for (int i = 0; i < this.valoresCarta.size();) {
			return (c.getValoresCarta().get(i).getNombre().equals(this.getValoresCarta().get(i).getNombre())) && 
					(this.getCantAtributos()== c.getCantAtributos()); 
		}
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNombreCarta();
	}
    
    
    
    
}
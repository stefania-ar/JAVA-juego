package juego;

import estrategias.*;

public class Jugador {
    private String nombreJugador;
    private static int contadorJugadores;
    private int numeroJugador;
    private Carta cartaEnMano;
    private Mazo mazoPersonal;
    private int cantidadDeCartas = 0;
    private boolean esAtacante;
    private Estrategia estrategia;

    
    public Jugador() {
        this.numeroJugador = ++contadorJugadores;
        this.mazoPersonal= new Mazo();
    }

    public Jugador(String nombre, Estrategia estrategia) {
        this.nombreJugador = nombre;
        this.mazoPersonal= new Mazo();
        this.estrategia= estrategia;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public Carta getCartaEnMano() {
        return cartaEnMano;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public int getNumeroJugador() {
        return numeroJugador;
    }

    public Mazo getMazoPersonal() {
        return mazoPersonal;
    }
    
    public int getCantidadDeCartas(){
        return cantidadDeCartas;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }
    
    public void setCartaEnMano(Carta cartaEnMano) {
        this.cartaEnMano = cartaEnMano;
    }
    
    public void setNombreJugador(String nombre) {
        this.nombreJugador = nombre;
    }

    public boolean isEsAtacante() {
        return esAtacante;
    }

    public void setEsAtacante(boolean esAtacante) {
        this.esAtacante = esAtacante;
    }    
    
    public void agregarUnaCartaAlMazo(Carta A_Agregar){
        this.cantidadDeCartas = cantidadDeCartas++;
        this.mazoPersonal.addCarta(A_Agregar);
    }
    
    public void agregarCartasGanadasPrimeraPosicion(Carta A_Agregar) {
    	this.cantidadDeCartas = cantidadDeCartas++;
    	this.mazoPersonal.agregarCartasGanadasPrimeraPosicion(A_Agregar);
    }
    
    public Carta entregarCarta(){
    	//this.getMazoPersonal().removerCarta(cartaEnMano);
        return this.cartaEnMano;
    }
    
    public Carta cartaDeMazoAMano(){
    	this.setCartaEnMano(this.mazoPersonal.levantarCarta());
        this.cantidadDeCartas = cantidadDeCartas--;
        return this.getCartaEnMano(); //retorna this.mazo.size-1
    }
    
    public Atributo elegirAtributo(Carta carta) {
    	return this.estrategia.elegirAtributo(carta);
    }
    
        
    public void elegirEstrategia(Estrategia es){
        this.setEstrategia(es);
    }
    
    public boolean tieneCartas() {
    	return this.mazoPersonal.cantCartas()>0;
    }
    
    public double aplicarPocima(Carta carta) {
    	carta= this.getCartaEnMano();
    	return carta.getPocima().aplicarPocion(this.elegirAtributo(cartaEnMano));
    }
    
}
	
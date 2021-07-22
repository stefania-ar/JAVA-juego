package juego;

import java.util.ArrayList;

import pocimas.PocimaAbstracta;

public class Tablero {

	private static int contadorTurnos = 1;
	private static final int MAXTURNOS = 25;
	//private static int turnoJugador = (int) Math.random();
	Mazo mazo;
	Jugador jugador1;
	Jugador jugador2;
	ArrayList<PocimaAbstracta> pocimas;

	public Tablero(Mazo mazo, Jugador jugador1, Jugador jugador2, ArrayList<PocimaAbstracta> pocimas) {
		this.mazo = mazo;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.pocimas= pocimas;
	}

	public void repartirMazo() {
		int j= this.mazo.cantCartas();
		
		for (int p = 0; p < pocimas.size(); p++) {
		  this.mazo.mezclarMazo();
		  this.mazo.getCartas().get(p).agregarPocimaACarta(pocimas.get(p)); 
		}
		
		for (int i = 0; i < j; i++) {
			Carta cartaARepartir = this.mazo.getCartas().get(i);
	
			if(i%2==0) {
				System.out.println(cartaARepartir);
				jugador2.agregarUnaCartaAlMazo(cartaARepartir);
			}
			else {
				jugador1.agregarUnaCartaAlMazo(cartaARepartir);
			}
		}
	}

	public void jugar() {
		this.repartirMazo();
		pregame();

		while (contadorTurnos <= MAXTURNOS && jugador1.tieneCartas() && jugador2.tieneCartas()) {
			if (contadorTurnos == 1) {
				jugador1.setEsAtacante(true);
				jugador2.setEsAtacante(false);
			}
			// System.out.println(jugador1.getMazoPersonal());
			if (jugador1.isEsAtacante()) {
				jugarTurno(jugador1, jugador2);
			} else {
				jugarTurno(jugador2, jugador1);
			}

		}
		if (jugador1.getMazoPersonal().cantCartas() > jugador2.getMazoPersonal().cantCartas()) {
			System.out.println("El jugador " + jugador1.getNombreJugador() + " ha ganado la partida.");
		} else {
			System.out.println("El jugador " + jugador2.getNombreJugador() + " ha ganado la partida.");
		}
	}

	public static void pregame() {
		System.out.println(
				"Bienvenido a CARTITAS, un juego de cartas desarrollado por Stefania Ferrante, Tomas Perez Coscia");
	}

	public void jugarTurno(Jugador jugadorAtacante, Jugador jugadorPerdedor) {
		System.out.println("------------------RONDA " + contadorTurnos + "/" + MAXTURNOS +"------------------");

		// La ultima carta del mazo de los jugadores pasa a estar en su mano
		Carta uno =jugadorAtacante.cartaDeMazoAMano();
		jugadorAtacante.getMazoPersonal().removerCarta(uno);
		Carta dos= jugadorPerdedor.cartaDeMazoAMano();
		jugadorPerdedor.getMazoPersonal().removerCarta(dos);
		
		Atributo atributoUno= jugadorAtacante.elegirAtributo(uno);
		Atributo atributoDos= jugadorPerdedor.getCartaEnMano().getAtributoNombre(atributoUno.getNombre());
		
		System.out.println(jugadorAtacante.getCartaEnMano().imprimirCarta(atributoUno.getNombre(), jugadorAtacante));
		System.out.println(jugadorPerdedor.getCartaEnMano().imprimirCarta(atributoDos.getNombre(), jugadorPerdedor));
		
		if(uno.tienePocima) { 
			double valor=jugadorAtacante.aplicarPocima(uno);
			if(valor>atributoDos.getValor()) {
				movimientoDeCartas(jugadorPerdedor, jugadorAtacante);
				jugadorAtacante.setEsAtacante(true);
				jugadorPerdedor.setEsAtacante(false);
			}else if (valor<atributoDos.getValor()) {
				movimientoDeCartas(jugadorAtacante, jugadorPerdedor);
				jugadorPerdedor.setEsAtacante(true);
				jugadorAtacante.setEsAtacante(false);
			} else {
				jugadorAtacante.agregarCartasGanadasPrimeraPosicion(jugadorAtacante.entregarCarta());
				jugadorPerdedor.agregarCartasGanadasPrimeraPosicion(jugadorPerdedor.entregarCarta());
				System.out.println(quedanIguales());
			}
		}else if(dos.tienePocima) {
			double valor=jugadorPerdedor.aplicarPocima(dos);
			if(valor<atributoUno.getValor()) {
				movimientoDeCartas(jugadorPerdedor, jugadorAtacante);
				jugadorAtacante.setEsAtacante(true);
				jugadorPerdedor.setEsAtacante(false);
			}else if (valor>atributoUno.getValor()) {
				movimientoDeCartas(jugadorAtacante, jugadorPerdedor);
				jugadorPerdedor.setEsAtacante(true);
				jugadorAtacante.setEsAtacante(false);
			} else {
				jugadorAtacante.agregarCartasGanadasPrimeraPosicion(jugadorAtacante.entregarCarta());
				jugadorPerdedor.agregarCartasGanadasPrimeraPosicion(jugadorPerdedor.entregarCarta());
				System.out.println(quedanIguales());
			}
		}else {
			if (atributoUno.compareTo(atributoDos)>0) {
				movimientoDeCartas(jugadorPerdedor, jugadorAtacante);
				jugadorAtacante.setEsAtacante(true);
				jugadorPerdedor.setEsAtacante(false);
			} else if (atributoUno.compareTo(atributoDos)<0) {
				movimientoDeCartas(jugadorAtacante, jugadorPerdedor);
				jugadorPerdedor.setEsAtacante(true);
				jugadorAtacante.setEsAtacante(false);
			} else {
				jugadorAtacante.agregarCartasGanadasPrimeraPosicion(jugadorAtacante.entregarCarta());
				jugadorPerdedor.agregarCartasGanadasPrimeraPosicion(jugadorPerdedor.entregarCarta());
				System.out.println(quedanIguales());
			}
		}

		System.out.println("El " + jugador1.getNombreJugador() + " tiene " + jugador1.getMazoPersonal().cantCartas()+ " cartas");
		System.out.println("El " + jugador2.getNombreJugador() + " tiene " + jugador2.getMazoPersonal().cantCartas()+ " cartas");
			contadorTurnos++;

	}

	public static void movimientoDeCartas(Jugador jugadorDa, Jugador jugadorRecibe) {
		System.out.println(jugadorRecibe.getNombreJugador()
				+ " ganó el turno. Se lleva ambas cartas al mazo y comienza el próximo turno");
		
		// El jugador lleva la carta de su mano al mazo
		jugadorRecibe.agregarCartasGanadasPrimeraPosicion(jugadorRecibe.getCartaEnMano());
		
		// El jugador recibe la carta del oponente y la mete al mazo
		jugadorRecibe.agregarCartasGanadasPrimeraPosicion(jugadorDa.entregarCarta());
	}
	
	public String quedanIguales() {
		return "Ambos jugadores empataron, se llevan las cartas al final del mazo";
	}


	public static void main(String[] args) {

	}
}
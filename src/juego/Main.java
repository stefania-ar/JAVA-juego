package juego;

import java.util.ArrayList;

import estrategias.Ambicioso;
import estrategias.Estrategia;
import estrategias.Timbero;
import pocimas.PocimaAbstracta;
import pocimas.PocimaCambiaria;
import pocimas.PocimaFortalecedora;
import pocimas.PocimaSelectiva;

public class Main {

	public static void main(String[] args) {
		//// ESTRATEGIAS
		Estrategia estra1 = new Ambicioso();
		Estrategia estra2 = new Timbero(null);
		
		//POCIMAS
		ArrayList<PocimaAbstracta> pocimas = new ArrayList<PocimaAbstracta>();
		PocimaFortalecedora fortalece= new PocimaFortalecedora("Fortalecedora", 20);
		PocimaCambiaria cambia = new PocimaCambiaria("Cambiaria", 23);
		PocimaSelectiva select= new PocimaSelectiva("peso", 35);
		
		pocimas.add(fortalece);
		pocimas.add(cambia);
		pocimas.add(select);
		
		Jugador jugador1 = new Jugador("jugador1", estra1);
		Jugador jugador2 = new Jugador("jugador2", estra2);
		
		String mazoPath = "./superheroes.json";
		Mazo mazo = new Mazo(mazoPath);
		
	
		Tablero juego= new Tablero(mazo, jugador1, jugador2, pocimas);
		juego.jugar();

	}

}

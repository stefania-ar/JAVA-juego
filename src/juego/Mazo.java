package juego;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;


public class Mazo {
    private ArrayList<Carta> mazo;
    
    public Mazo(String mazo) {
    	this.mazo= new ArrayList<>();
        this.cartasAMazo(mazo);
    }
    
    public Mazo() {
    	this.mazo= new ArrayList<>();
    }
    
    public void mostrarMazo(String jsonFile) {
        //URL url = getClass().getResource(jsonFile);
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                String nombreCarta = carta.getString("nombre");
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                String atributosStr = "";
                for (String nombreAtributo:atributos.keySet())
                    atributosStr = atributosStr + nombreAtributo + ": " +
                            atributos.getInt(nombreAtributo) + "; ";
                System.out.println(nombreCarta+"\t\t\t"+atributosStr);
            }

            reader.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
      public void cartasAMazo(String jsonFile) {
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try{
            is = new FileInputStream(jsonInputFile);
            JsonReader reader = Json.createReader(is);
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)){
                String nombreCarta = carta.getString("nombre");
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                String atributosStr = "";
                Carta cartaAux = new Carta();
                cartaAux.setNombreCarta(nombreCarta);
                for (String nombreAtributo:atributos.keySet()){
                    atributosStr = atributosStr + nombreAtributo + ": " + atributos.getInt(nombreAtributo) + "; ";
                    cartaAux.addCaracteristica(nombreAtributo, (int) atributos.getInt(nombreAtributo));
                }
                 
                	this.addCarta(cartaAux);
            }
            
            reader.close();
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
      
    public void addCarta(Carta cartaAux) {
    	if(mazo.size()==0) {
    		this.mazo.add(cartaAux);
    	}else if(cartaAux.equals(mazo.get(0))) {
    		this.mazo.add(cartaAux);
    	}
    }
    
    public void agregarCartasGanadasPrimeraPosicion(Carta A_Agregar){
        this.mazo.add(0, A_Agregar);
    }
    
    public void removerCarta(Carta carta) {
    	this.mazo.remove(this.mazo.size()-1);
    }
    
    public ArrayList<Carta> getCartas() {
    	return new ArrayList<Carta>(mazo);
    }

	public Carta levantarCarta() {
		//hay que hacer un remove??
		//hay que restar una carta???
		return this.mazo.get(mazo.size()-1);
		
	}
    
	public void mezclarMazo() {
		Collections.shuffle(this.mazo);
	}
    
	public int cantCartas() {
		return this.mazo.size();
	}
	

}

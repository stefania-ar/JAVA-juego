package pocimas;

import juego.Atributo;

public abstract class PocimaAbstracta {
	String nombrePocima;
          
      public String getNombrePocima(){
          return nombrePocima;
      }
      
      public abstract double aplicarPocion(Atributo atributo); //HABRIA QUE PASARLE EL ATRIBUTO


}

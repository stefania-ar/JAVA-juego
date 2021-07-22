package juego;

public class Atributo implements Comparable<Atributo>{
    private String nombre;
    private int valor;

    
    public Atributo(String nombre, int valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }
    
	@Override
	public int compareTo(Atributo o) {
		return this.getValor()-o.getValor();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNombre();
	}
    
	
}

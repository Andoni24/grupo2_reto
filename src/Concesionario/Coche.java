package Concesionario;

public class Coche extends Vehiculo{
	
	private int capMaletero;
	private int numPuertas;
	
	public Coche(String matricula, String numBastidor, String color,int numSerie, double precio, int numAsientos, int capMaletero,
			int numPuertas) {
		super(matricula, numBastidor, color,numSerie, precio, numAsientos);
		this.capMaletero = capMaletero;
		this.numPuertas = numPuertas;
	}
	
	public int getCapMaletero() {
		return capMaletero;
	}
	public void setCapMaletero(int capMaletero) {
		this.capMaletero = capMaletero;
	}
	public int getNumPuertas() {
		return numPuertas;
	}
	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	@Override
	public String toString() {
		return "Coche  "+super.toString()+", capMaletero=" + capMaletero + ", numPuertas=" + numPuertas;
	}

}

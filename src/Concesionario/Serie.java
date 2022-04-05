package Concesionario;

public class Serie {

	private int numSerie;
	private String marca;
	private String modelo;
	private int anioFab;
	
	
	public Serie() {
	}


	
	public Serie(int numSerie, String marca, String modelo, int anioFab) {
		super();
		this.numSerie = numSerie;
		this.marca = marca;
		this.modelo = modelo;
		this.anioFab = anioFab;
	}



	public Serie(int numSerie) {
		super();
		this.numSerie = numSerie;
	}



	public Serie(String marca, String modelo, int anioFab) {
		this.marca = marca;
		this.modelo = modelo;
		this.anioFab = anioFab;
	}


	public int getNumSerie() {
		return numSerie;
	}


	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}



	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getAnioFab() {
		return anioFab;
	}


	public void setAnioFab(int anioFab) {
		this.anioFab = anioFab;
	}


	@Override
	public String toString() {
		return "Serie [marca=" + marca + ", modelo=" + modelo + ", anioFab=" + anioFab + "]";
	}
	
	
}

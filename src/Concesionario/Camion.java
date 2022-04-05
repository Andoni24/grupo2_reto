package Concesionario;


public class Camion extends Vehiculo{

		private int carga;
		private String tipoMercancia;
		
		public Camion(String matricula, String numBastidor, String color, int numSerie,double precio, int numAsientos, int carga,
				String tipoMercancia) {
			super(matricula, numBastidor, color,numSerie, precio, numAsientos);
			this.carga = carga;
			this.tipoMercancia = tipoMercancia;
		}
		public int getCarga() {
			return carga;
		}

		public void setCarga(int carga) {
			this.carga = carga;
		}

		public String getTipoMercancia() {
			return tipoMercancia;
		}

		public void setTipoMercancia(String tipoMercancia) {
			this.tipoMercancia = tipoMercancia;
		}
		@Override
		public String toString() {
			return "Camion ["+super.toString()+" carga=" + carga + ", tipoMercancia=" + tipoMercancia + "]";
		}

}

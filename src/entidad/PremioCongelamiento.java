package entidad;

import grafica.EntidadGraficaPremio;
import tablero.Celda;
import tablero.Tablero;

public class PremioCongelamiento extends PremioTemporal {

	public PremioCongelamiento(Tablero tablero, Celda celda) {
		super(tablero, celda);
		//falta ponerle un nuevo sprite
		this.entidadgrafica = new EntidadGraficaPremio("/recursos/premios/cruz.png");
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);
	}

	@Override
	protected void hacerEfecto(Jugador j) {
		// TODO Auto-generated method stub
		
	}

}

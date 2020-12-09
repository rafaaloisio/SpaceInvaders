package entidad;

import grafica.EntidadGraficaPremio;
import tablero.Celda;
import tablero.Tablero;

public class RecuperarVida extends PremioPrecioso {

	public RecuperarVida(Tablero tablero, Celda celda) {
		super(tablero, celda);
		this.entidadgrafica = new EntidadGraficaPremio("/recursos/premios/cruz.png");
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);
	}

	@Override
	protected void hacerEfecto(Jugador j) {

		//j.setVida(MAXIMA_VIDA);
	}
}

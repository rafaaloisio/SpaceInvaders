package entidad;

import grafica.EntidadGraficaPremio;
import tablero.Celda;
import tablero.Tablero;

public class PremioPocion extends PremioPrecioso {

	public PremioPocion(Tablero tablero, Celda celda) {
		super(tablero, celda);
		this.golpe = 100;
		this.entidadgrafica = new EntidadGraficaPremio("/recursos/premios/pocion_vida.png");
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);
	}

	@Override
	protected void hacerEfecto(Jugador j) {

		this.aceptar(this.miVisitor);
	}
}

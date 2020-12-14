package entidad;

import grafica.EntidadGraficaPremio;
import tablero.Celda;
import tablero.Tablero;
import visitor.VisitorPremioCongelamiento;

public class PremioCongelamiento extends PremioTemporal {

	public PremioCongelamiento(Tablero tablero, Celda celda) {
		super(tablero, celda);
		//falta ponerle un nuevo sprite
		this.entidadgrafica = new EntidadGraficaPremio("/recursos/premios/pocion_hielo.png");
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);
		this.miVisitor = new VisitorPremioCongelamiento(this);
	}

	@Override
	protected void hacerEfecto(Jugador j) {
		this.aceptar(miVisitor);
	}

}

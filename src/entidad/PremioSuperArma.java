package entidad;

import grafica.EntidadGraficaPremio;
import tablero.Celda;
import tablero.Tablero;
import visitor.VisitorPremioCongelamiento;
import visitor.VisitorPremioSuperArma;

public class PremioSuperArma extends PremioTemporal {

	
	public PremioSuperArma(Tablero tablero, Celda celda) {
		super(tablero, celda);
		//falta ponerle nuevo sprite
		this.entidadgrafica = new EntidadGraficaPremio("/recursos/premios/pocion_hielo.png");
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);
		this.miVisitor = new VisitorPremioSuperArma(this);
	}

	@Override
	protected void hacerEfecto(Jugador j) {
		this.aceptar(miVisitor);
	}
}

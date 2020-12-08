package entidad;

import tablero.Celda;
import tablero.Tablero;
import visitor.Visitor;

public abstract class PremioTemporal extends Premio {

	public PremioTemporal(Tablero tablero, Celda celda) {
		super(tablero, celda);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected abstract void hacerEfecto();



}

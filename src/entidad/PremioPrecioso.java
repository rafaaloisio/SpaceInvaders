package entidad;

import tablero.Celda;
import tablero.Tablero;

public abstract class PremioPrecioso extends Premio {

	public PremioPrecioso(Tablero tablero, Celda celda) {
		super(tablero, celda);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected abstract void hacerEfecto(Jugador j);

}

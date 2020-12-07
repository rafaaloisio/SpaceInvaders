package disparo;

import entidad.*;
import tablero.*;

public abstract class Disparo extends Entidad {

	protected boolean seguirMoviendo;
	
	public Disparo(Tablero miTablero, Celda miCelda, int golpe) {
		super(miTablero, miCelda);
		this.golpe = golpe;
		this.seguirMoviendo = true;

	}
	
	public void setSeguirMoviendo(boolean b) {
		seguirMoviendo = b;
	}
	



}
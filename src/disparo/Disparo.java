package disparo;

import entidad.*;
import tablero.*;

public abstract class Disparo extends Entidad {

	
	public Disparo(Tablero miTablero, Celda miCelda, int golpe) {
		super(miTablero, miCelda);
		this.golpe = golpe;

	}
	
	
	



}
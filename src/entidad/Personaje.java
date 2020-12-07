package entidad;

import disparo.*;
import mapa.*;

public abstract class Personaje extends Entidad {
	

	public Personaje(Tablero tablero, Celda celda) {
		super(tablero, celda);
	}
	

	public void disparar(Entidad e) {

		miTablero.getLogica().agregarEntidad(crearDisparo(), miCelda);
	}
	
	public abstract Disparo crearDisparo();
	
	
	

}
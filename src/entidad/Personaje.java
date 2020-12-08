package entidad;

import disparo.*;
import tablero.*;

public abstract class Personaje extends Entidad {

	public Personaje(Tablero tablero, Celda celda) {
		super(tablero, celda);
	}
	

	public void recibirGolpe(int golpe) {
		vida = vida - golpe;
		if (vida <= 0) {
			morir();
		}
	}
	
	public void disparar(Entidad e) {

		miTablero.getLogica().agregarEntidad(crearDisparo(), miCelda);
	}
	
	public abstract Disparo crearDisparo();
	
	
	

}
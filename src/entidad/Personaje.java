package entidad;

import disparo.*;
import tablero.*;

public abstract class Personaje extends Entidad {

	public Personaje(Tablero tablero, Celda celda) {
		super(tablero, celda);
	}
	

	public void recibirGolpe(int golpe) {
		this.vida = vida - golpe;
		if (vida <= 0) {
			this.morir();
		}
	}
	
	public void disparar(Entidad e) {

		miTablero.getLogica().agregarEntidad(crearDisparo(), miCelda);
	}
	
	public abstract Disparo crearDisparo();
	
	
	

}
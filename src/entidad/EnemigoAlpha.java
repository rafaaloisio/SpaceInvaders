package entidad;


import disparo.*;
import grafica.EntidadGraficaAlpha;
import mapa.*;

public class EnemigoAlpha extends Enemigo {

	
	
	//agregar strategy
	public EnemigoAlpha(Tablero tablero, Celda celda) {
		super(tablero, celda);
		this.vida = 150;
		entidadgrafica = new EntidadGraficaAlpha("/recursos/enemigos/alpha.png");
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);
	}


	@Override
	public Disparo crearDisparo() {
		
		return new DisparoAlpha(miTablero,miCelda,this.getGolpe());
	} 

}

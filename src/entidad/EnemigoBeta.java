package entidad;

import disparo.*;
import grafica.EntidadGraficaBeta;
import tablero.Celda;
import tablero.Tablero;

public class EnemigoBeta extends Enemigo {

	public EnemigoBeta(Tablero tablero, Celda celda,int vida,int golpe) {
		super(tablero, celda,vida,golpe);
		entidadgrafica = new EntidadGraficaBeta("/recursos/enemigos/beta.png");
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);
		this.vida = vida;
		this.golpe = golpe;
		
	}


	public Disparo crearDisparo() {
		
		return new DisparoBeta(miTablero,miCelda,this.getGolpe());
	} 

}

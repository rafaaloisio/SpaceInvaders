package entidad;

import grafica.EntidadGraficaBeta;
import mapa.Celda;
import mapa.Tablero;

public class EnemigoBeta extends Enemigo {

	public EnemigoBeta(Tablero tablero, Celda celda) {
		super(tablero, celda);
		entidadgrafica = new EntidadGraficaBeta("/recursos/enemigos/beta.png");
		this.vida = 200;
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);
	}


	@Override
	public void disparar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

}

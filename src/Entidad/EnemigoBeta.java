package Entidad;

import Graficas.EntidadGraficaBeta;
import Mapa.Celda;
import Mapa.Tablero;

public class EnemigoBeta extends Enemigo {

	public EnemigoBeta(Tablero tablero, Celda celda) {
		super(tablero, celda);
		entidadgrafica = new EntidadGraficaBeta("/Recursos/Enemigos/beta.png");
		this.vida = 200;
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);
	}


	@Override
	public void disparar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

}

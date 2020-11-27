package Graficas;

import Mapa.Celda;

public class EntidadGraficaBeta extends EntidadGraficaEnemigo {

	public EntidadGraficaBeta(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actualizar(Celda miCelda) {
		this.imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);		
	}

}

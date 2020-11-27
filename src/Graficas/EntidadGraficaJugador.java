package Graficas;

import javax.swing.ImageIcon;

import Mapa.Celda;

public class EntidadGraficaJugador extends EntidadGrafica {

	public EntidadGraficaJugador(String path) {
		super(path);
		
	}

	public void actualizar(Celda miCelda) {
		this.imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);
	}
}

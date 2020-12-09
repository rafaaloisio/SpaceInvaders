package grafica;

import tablero.Celda;

public class EntidadGraficaPremio extends EntidadGrafica {

	public EntidadGraficaPremio(String path) {
		super(path);
	}
	
	public void actualizar(Celda miCelda) {
		this.imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);
	}
	
}

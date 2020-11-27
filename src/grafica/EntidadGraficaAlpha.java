package grafica;

import mapa.Celda;

public class EntidadGraficaAlpha extends EntidadGraficaEnemigo {

	public EntidadGraficaAlpha(String path) {
		super(path);
	}

	@Override
	public void actualizar(Celda miCelda) {
		this.imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);		
	}

}

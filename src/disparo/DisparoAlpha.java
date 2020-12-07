package disparo;

import grafica.EntidadGraficaBeta;
import mapa.*;

public class DisparoAlpha extends DisparoEnemigo{

	public DisparoAlpha(Tablero miTablero, Celda miCelda, int golpe) {
		super(miTablero, miCelda, golpe);
		entidadgrafica = new EntidadGraficaBeta("/recursos/enemigos/disparo_alpha.png");
	
	}




}

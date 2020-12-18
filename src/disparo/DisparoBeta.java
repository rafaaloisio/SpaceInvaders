package disparo;

import grafica.EntidadGraficaBeta;
import tablero.*;

public class DisparoBeta extends DisparoEnemigo {

	public DisparoBeta(Tablero miTablero, Celda miCelda, int golpe) {
		super(miTablero, miCelda, golpe);
		entidadgrafica = new EntidadGraficaBeta("/recursos/enemigos/disparo_beta.png");
	}

}

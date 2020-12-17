package disparo;

import estrategia.MovimientoEnemigo;
import grafica.EntidadGraficaAlpha;
import tablero.*;

public class DisparoAlpha extends DisparoEnemigo{

	public DisparoAlpha(Tablero miTablero, Celda miCelda, int golpe) {
		super(miTablero, miCelda, golpe);
		entidadgrafica = new EntidadGraficaAlpha("/recursos/enemigos/disparo_alpha.png");
		this.movimiento = new MovimientoEnemigo(this.miTablero, this.miCelda, this);
	}




}

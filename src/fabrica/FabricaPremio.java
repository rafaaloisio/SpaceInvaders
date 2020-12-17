package fabrica;

import entidad.Premio;
import tablero.Celda;
import tablero.Tablero;

public abstract class FabricaPremio {

	protected Tablero miTablero;
	protected Celda miCelda;
	
	protected FabricaPremio(Tablero miTablero, Celda miCelda)
	{
		this.miTablero = miTablero;
		this.miCelda = miCelda;
	}
	
	public abstract Premio crearPremio();
}

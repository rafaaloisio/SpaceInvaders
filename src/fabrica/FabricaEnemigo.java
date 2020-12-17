package fabrica;

import entidad.*;
import tablero.*;

public abstract class FabricaEnemigo {

	protected Tablero miTablero;
	
	protected FabricaEnemigo(Tablero miTablero)
	{
		this.miTablero = miTablero;
	}
	
	public abstract Enemigo crearEnemigo();
}

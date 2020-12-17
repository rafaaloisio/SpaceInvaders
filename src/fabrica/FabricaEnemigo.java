package fabrica;

import entidad.*;
import tablero.*;

public abstract class FabricaEnemigo {

	protected Tablero miTablero;
	
	public FabricaEnemigo(Tablero miTablero)
	{
		this.miTablero = miTablero;
	}
	
	public abstract Enemigo crearEnemigo();
}

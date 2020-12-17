package fabrica;

import entidad.*;
import tablero.*;

public abstract class fabricaEnemigo {

	protected Tablero miTablero;
	
	public fabricaEnemigo(Tablero miTablero)
	{
		this.miTablero = miTablero;
	}
	
	public abstract Enemigo crearEnemigo();
}

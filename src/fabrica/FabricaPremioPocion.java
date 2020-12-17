package fabrica;

import entidad.Premio;
import entidad.PremioPocion;
import tablero.Celda;
import tablero.Tablero;

public class FabricaPremioPocion extends FabricaPremio {

	public FabricaPremioPocion(Tablero tablero, Celda celda) {
		super(tablero,celda);
	}

	@Override
	public Premio crearPremio() {
		return new PremioPocion(miTablero, miCelda);
	}

	
}

package fabrica;

import entidad.Premio;
import entidad.PremioSuperArma;
import tablero.Celda;
import tablero.Tablero;

public class FabricaPremioSuperArma extends FabricaPremio {

	public FabricaPremioSuperArma(Tablero miTablero, Celda miCelda) {
		super(miTablero, miCelda);
	}

	@Override
	public Premio crearPremio() {
		return new PremioSuperArma(miTablero, miCelda);
	}

}

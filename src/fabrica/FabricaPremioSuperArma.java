package fabrica;

import entidad.Premio;
import entidad.PremioSuperArma;
import tablero.Celda;
import tablero.Tablero;

public class FabricaPremioSuperArma extends FabricaPremio {

	public FabricaPremioSuperArma(Tablero miTablero, Celda miCelda) {
		super(miTablero, miCelda);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Premio crearPremio() {
		// TODO Auto-generated method stub
		return new PremioSuperArma(miTablero, miCelda);
	}

}

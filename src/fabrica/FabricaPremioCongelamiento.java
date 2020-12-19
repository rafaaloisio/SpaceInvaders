package fabrica;

import entidad.Premio;
import entidad.PremioCongelamiento;
import tablero.Celda;
import tablero.Tablero;

public class FabricaPremioCongelamiento extends FabricaPremio {

	public FabricaPremioCongelamiento(Tablero miTablero, Celda miCelda) {
		super(miTablero, miCelda);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Premio crearPremio() {
		// TODO Auto-generated method stub
		return new PremioCongelamiento(miTablero, miCelda);
	}

}

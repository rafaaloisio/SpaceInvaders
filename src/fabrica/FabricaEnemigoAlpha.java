package fabrica;

import java.util.Random;

import entidad.*;
import tablero.*;

public class FabricaEnemigoAlpha extends FabricaEnemigo{

	public FabricaEnemigoAlpha(Tablero miTablero) {
		super(miTablero);
	}

	@Override
	public Enemigo crearEnemigo() {
		
		System.out.println("Cree Alpha");
		
		return new EnemigoAlpha(miTablero, miTablero.getCelda(new Random().nextInt(7),1),150,60);
	}

}


package fabrica;

import java.util.Random;

import entidad.*;
import tablero.*;

public class fabricaEnemigoBeta extends fabricaEnemigo{

	public fabricaEnemigoBeta(Tablero miTablero) {
		super(miTablero);
	}

	@Override
	public Enemigo crearEnemigo() {
		

		System.out.println("Cree Beta");
		return new EnemigoBeta(miTablero, miTablero.getCelda(new Random().nextInt(7),0),300,30);
	}

}

package fabrica;

import java.util.Random;

import entidad.*;
import tablero.*;

public class FabricaEnemigoBeta extends FabricaEnemigo{

	public FabricaEnemigoBeta(Tablero miTablero) {
		super(miTablero);
	}

	@Override
	public Enemigo crearEnemigo() {
		

		//para disminuir las colisiones de crear enemigos en la misma celda

		int x = new Random().nextInt(miTablero.getColumnas());
		
		int y = new Random().nextInt(3);
		
		boolean encontre = false;
		
		if(miTablero.getCelda(x,y).cantEntidades() > 0)
		{
			for (int i = 0; i < 7 & !encontre ;i++)
			{
				if(miTablero.getCelda(i,y).cantEntidades() == 0)
					{
						encontre = true;
						x = i;
					}
					
				}
		}

		System.out.println("Cree Alpha X: "+x+" Y: "+y);
		
		return new EnemigoBeta(miTablero, miTablero.getCelda(x,y),330,30);
	}

}
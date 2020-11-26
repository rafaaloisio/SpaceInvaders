package Entidad;

import Mapa.Celda;
import Mapa.Tablero;

public abstract class Enemigo extends Personaje{
	
	boolean seguirMoviendo;
	int tiempo;
	public Enemigo(Tablero tablero, Celda celda) {
		super(tablero, celda);
		seguirMoviendo = true;
		this.tiempo = 3;
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void mover()
	{
		if (miTablero.getCelda(x , y + 1).cantEntidades() == 0) {
		 	
			 
		 	miTablero.getCelda(x, y).eliminarEntidad(this);	
		 	if( y + 1 == miTablero.getFilas()-1 )
				y = 0;
			else
				y = y + 1;
			miTablero.getCelda(x, y).agregarEntidad(this);
			miCelda = miTablero.getCelda(x, y);
			imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);		
		}else
		{ //entonces hay una colision, despues lo programo
			
				System.out.println("Colisionó.");
		
			if (seguirMoviendo) {
				//para que sigan moviendo todos los enemigos
				miTablero.getCelda(x, y).eliminarEntidad(this);	
				if( y + 1 == miTablero.getFilas()-1 )
					y = 0;
				else
					y = y + 1;
				
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);		
			}
		}
		
	}
	
	public void seguirMoviendo(boolean seguirMoviendo) {
		this.seguirMoviendo = seguirMoviendo;
	}
	
	public void ejecutar()
	{
		if (tiempo == 5) {
			
			/*Para el visitor
			if (x < 9) {
				
				for (int i = 0; i < 9; i++) {
					Entidad [] entidadesArreglo = miTablero.getCelda(9 - i, y).getArregloEntidades();
					int pos=0;
					
					
					
					while(entidadesArreglo[pos]!=null) {
						entidadesArreglo[pos].aceptar(miVisitor);
		                pos++;					
					}
					
					
				}
			}*/
		}
		tiempo--;
		
		if (tiempo == 0) {
			tiempo = 5;
			mover();
			this.seguirMoviendo(true);
		}
	}
	
}

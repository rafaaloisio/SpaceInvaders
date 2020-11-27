package Entidad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Graficas.EntidadGraficaJugador;
import Mapa.*;


public class Jugador extends Personaje{
	

	public Jugador(Tablero tablero, Celda celda, int vida) {
		super(tablero, celda);
		this.vida = vida;
		entidadgrafica = new EntidadGraficaJugador("/Recursos/Jugador/nave.png");
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);
		
	}

	@Override
	public void morir() 
	{
		
	}

	@Override
	public void ejecutar() 
	{
		
		
	} 

	public void mover() 
	{
		
	}
	
	
	public void mover(int dir) 
	{
		
			switch (dir){
				case KeyEvent.VK_A : //Izquierda
					this.moverIzq();
					System.out.println("izquierda!");
					break;
				case KeyEvent.VK_D : //Derecha
					this.moverDer();
					System.out.println("derecha!");
					break;
				case KeyEvent.VK_W : //Arriba
					this.moverArr();
					System.out.println("arriba!");
					break;
				case KeyEvent.VK_S : //Abajo
					this.moverAb();
					System.out.println("abajo!");
					break;
				case KeyEvent.VK_SPACE :
					//this.disparar();
					break;
			}
	
		
	}
	
	 public void moverIzq() 
	 {
		 
		//hace esta comprobaci�n para despues en el else, controlar la colisi�n
		 if (miTablero.getCelda(x - 1 , y).cantEntidades() == 0) {
			 	
			 
			 	miTablero.getCelda(x, y).eliminarEntidad(this);
			 	
			 	x = x - 1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.actualizar(miCelda);		
			}else { //else aceptar visitor, porque tuvo una colosi�n
				System.out.println("Colision�.");
			}
		
		 
		 
	 }
	 
	 public void moverDer() 
	 {
		 if (miTablero.getCelda(x + 1 , y).cantEntidades() == 0) {
			 miTablero.getCelda(x, y).eliminarEntidad(this);
				x = x + 1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.actualizar(miCelda);		
			}else { //else aceptar visitor, porque tuvo una colosi�n
				System.out.println("Chocooooooo");
			}
	 }
	 
	 public void moverArr() 
	 {
		 if (miTablero.getCelda(x  , y - 1).cantEntidades() == 0) {
			 miTablero.getCelda(x, y).eliminarEntidad(this);
				y = y - 1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.actualizar(miCelda);		
			}else { //else aceptar visitor, porque tuvo una colosi�n
				System.out.println("Chocooooooo");
			} 
		 
	 }
	 
	 public void moverAb() 
	 {
		 if (miTablero.getCelda(x  , y + 1).cantEntidades() == 0) {
			 miTablero.getCelda(x, y).eliminarEntidad(this);
				y = y + 1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.actualizar(miCelda);		
			}else { //else aceptar visitor, porque tuvo una colosi�n
				System.out.println("Chocooooooo");
			} 
		 
	 }

	public void disparar(Entidad e) {
		//imagen.setIcon(imagenAtacar);
		//logica.agregarEntidad(crearDisparo(), miCelda);
	}

}

package entidad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import disparo.*;
import grafica.EntidadGraficaJugador;
import mapa.*;


public class Jugador extends Personaje{
	

	public Jugador(Tablero miTablero, Celda celda, int vida, int golpe) {
		super(miTablero, celda);
		this.vida = vida;
		this.golpe = golpe;
		entidadgrafica = new EntidadGraficaJugador("/Recursos/Jugador/nave.png");
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);
		
	}

	@Override
	public void morir() 
	{
		//super.morir();
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
					System.out.println("Disparo!");
					this.disparar(this);
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
				System.out.println("COLISION.");
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


	public Disparo crearDisparo() {
			
			return new DisparoJugador(miTablero,miCelda,this.getGolpe());
	} 


}

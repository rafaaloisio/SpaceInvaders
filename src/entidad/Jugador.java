package entidad;

import java.awt.event.KeyEvent;
import java.util.Iterator;

import disparo.*;
import grafica.EntidadGraficaJugador;
import tablero.*;
import visitor.*;


public class Jugador extends Personaje{

	
	public Jugador(Tablero miTablero, Celda celda, int vida, int golpe) {
		super(miTablero, celda);
		this.vida = vida;
		this.golpe = golpe;
		this.miVisitor = new VisitorJugador(this);
		entidadgrafica = new EntidadGraficaJugador("/recursos/jugador/nave.png");
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);

	}

	@Override
	public void morir() 
	{
		super.morir();
		
		System.err.println("EL JUGADOR PERDIÓ.");
		
		//detengo el hilo al perder
		miTablero.getLogica().setPerdi(true);
		
	}

	@Override
	public void ejecutar() 
	{
		if(miTablero.getCelda(x, y).cantEntidades()>1)
		{	
			System.out.println("ME FIJE.");
			
			Entidad[] entidadesCelda = miTablero.getCelda(x, y).getArregloEntidades();
			
			for (int i=0; i < entidadesCelda.length; i++) {
				if (entidadesCelda[i] != null) {
					entidadesCelda[i].aceptar(miVisitor);
				}
			}
		}	
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



		if(x == 0)
			x = miTablero.getColumnas();


		if ( miTablero.getCelda(x - 1 , y).cantEntidades() == 0) {


			miTablero.getCelda(x-1, y).eliminarEntidad(this);

			if(x == 0)
				x = miTablero.getColumnas()-1;
			else
				x = x - 1;

			miTablero.getCelda(x, y).agregarEntidad(this);
			miCelda = miTablero.getCelda(x, y);
			entidadgrafica.actualizar(miCelda);		
		}else { 
			
			Entidad[] entidadesCelda = miTablero.getCelda(x-1, y).getArregloEntidades();
			
			for (int i=0; i < entidadesCelda.length; i++) {
				if (entidadesCelda[i] != null) {
					entidadesCelda[i].aceptar(miVisitor);
				}
			}
			
			miTablero.getCelda(x-1, y).eliminarEntidad(this);

			if(x == 0)
				x = miTablero.getColumnas()-1;
			else
				x = x - 1;

			miTablero.getCelda(x, y).agregarEntidad(this);
			miCelda = miTablero.getCelda(x, y);
			entidadgrafica.getImagen().setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);



		}


	}

	public void moverDer() 
	{


		if(x == miTablero.getColumnas()-1)
			x = -1;

		if (miTablero.getCelda(x + 1 , y).cantEntidades() == 0) {

			miTablero.getCelda(x+1, y).eliminarEntidad(this);

			if( x + 1 == miTablero.getColumnas() )
				x = 0;
			else
				x = x + 1;


			miTablero.getCelda(x, y).agregarEntidad(this);
			miCelda = miTablero.getCelda(x, y);
			entidadgrafica.actualizar(miCelda);	

		}else { 

			Entidad[] entidadesCelda = miTablero.getCelda(x+1, y).getArregloEntidades();
			
			for (int i=0; i < entidadesCelda.length; i++) {
				if (entidadesCelda[i] != null) {
					entidadesCelda[i].aceptar(miVisitor);
				}
			}

			miTablero.getCelda(x+1, y).eliminarEntidad(this);

			if( x + 1 == miTablero.getColumnas() )
				x = 0;
			else
				x = x + 1;

			miTablero.getCelda(x, y).agregarEntidad(this);
			miCelda = miTablero.getCelda(x, y);
			entidadgrafica.getImagen().setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);


		}

	}

	public void moverArr() 
	{
		if (miTablero.getCelda(x  , y - 1) != null) {
			if (miTablero.getCelda(x  , y - 1).cantEntidades() == 0) {
				miTablero.getCelda(x, y).eliminarEntidad(this);
				y = y - 1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.actualizar(miCelda);		
			}else { 

				Entidad[] entidadesCelda = miTablero.getCelda(x, y-1).getArregloEntidades();
				
				for (int i=0; i < entidadesCelda.length; i++) {
					if (entidadesCelda[i] != null) {
						entidadesCelda[i].aceptar(miVisitor);
					}
				}
				
			} 
		}

	}

	public void moverAb() 
	{
		if (miTablero.getCelda(x  , y + 1) != null) {
			if (miTablero.getCelda(x  , y + 1).cantEntidades() == 0) {
				miTablero.getCelda(x, y).eliminarEntidad(this);
				y = y + 1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.actualizar(miCelda);		
			}else {
				
				Entidad[] entidadesCelda = miTablero.getCelda(x, y-1).getArregloEntidades();
				
				for (int i=0; i < entidadesCelda.length; i++) {
					if (entidadesCelda[i] != null) {
						entidadesCelda[i].aceptar(miVisitor);
					}
				}

			} 
		}

	}

	//crea disparo en la siguiente celda
	public Disparo crearDisparo() {

		return new DisparoJugador(miTablero,miTablero.getCelda(miCelda.getX(),miCelda.getY()-1),this.getGolpe());
		
		
	}

	public void aceptar(Visitor visitor) {
		visitor.visitJugador(this);
	}


}

package Entidad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.*;


public class Jugador extends Personaje{
	

	public Jugador(Tablero tablero, Celda celda, int vida) {
		super(tablero, celda);
		this.vida = vida;
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Jugador/nave.png")));
		imagen.setBounds(x, y, PIXEL, PIXEL);
		
	}

	@Override
	public void morir() 
	{
		
	}

	@Override
	public void ejecutar() 
	{
		
		//mover();
		
	} 

	@Override
	public void mover(int dir) 
	{
		
			switch (dir){
				case KeyEvent.VK_A : //Izquierda
					this.moverIzq();
					System.out.println("izq!");
					break;
				case KeyEvent.VK_D : //Derecha
					this.moverDer();
					System.out.println("der!");
					break;
				case KeyEvent.VK_SPACE :
					//this.disparar();
					break;
			}
	
		
	}
	
	 public void moverIzq() 
	 {
		 this.setCelda(miTablero.getCelda(getX()-1, getY()));
		 miTablero.getLogica().getGrafica().graficarEntidad(this);
		 
	 }
	 
	 public void moverDer() 
	 {
		 this.setCelda(miTablero.getCelda(getX()+1, getY()));
		 miTablero.getLogica().getGrafica().graficarEntidad(this);
	 }

	public void disparar(Entidad e) {
		//imagen.setIcon(imagenAtacar);
		//logica.agregarEntidad(crearDisparo(), miCelda);
	}

}

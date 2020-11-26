package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Tablero;

public class Alpha extends Enemigo {

	
	//agregar strategy
	public Alpha(Tablero tablero, Celda celda) {
		super(tablero, celda);
		this.vida = 150;
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Enemigos/alpha.png")));
		imagen.setBounds(x, y, PIXEL, PIXEL);
	}


	@Override
	public void disparar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

}

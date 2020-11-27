package Graficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;

public abstract class EntidadGraficaEnemigo extends EntidadGrafica {

	public static final int PIXEL = 64;
	
	public EntidadGraficaEnemigo(String path) {
		super(path);
	}

	public JLabel getImagen() {
		return imagen;
	}

	public void setImagen(JLabel imagen) {
		this.imagen = imagen;
	}
	
	public abstract void actualizar(Celda miCelda);
}

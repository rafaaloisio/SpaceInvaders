package Graficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;


public abstract class EntidadGrafica {
	
	public static final int PIXEL = 64;
	
	protected JLabel imagen;
	
	public EntidadGrafica(String path) {
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource(path)));
	}

	public JLabel getImagen() {
		return imagen;
	}

	public void setImagen(JLabel imagen) {
		this.imagen = imagen;
	}
	
	public abstract void actualizar(Celda miCelda);

}

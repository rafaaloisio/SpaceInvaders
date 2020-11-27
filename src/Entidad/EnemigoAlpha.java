package Entidad;


import Graficas.EntidadGraficaAlpha;
import Mapa.Celda;
import Mapa.Tablero;

public class EnemigoAlpha extends Enemigo {

	
	
	//agregar strategy
	public EnemigoAlpha(Tablero tablero, Celda celda) {
		super(tablero, celda);
		this.vida = 150;
		entidadgrafica = new EntidadGraficaAlpha("/Recursos/Enemigos/alpha.png");
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);
	}


	@Override
	public void disparar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

}

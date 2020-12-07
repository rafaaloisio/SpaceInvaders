package disparo;


import entidad.*;
import grafica.EntidadGraficaJugador;
import mapa.*;
//import Visitor.*;

public class DisparoJugador extends Disparo {
	
	protected boolean seguirMoviendo;

	public DisparoJugador(Tablero miTablero, Celda miCelda, int golpe) {
		super(miTablero, miCelda, golpe);
		//miVisitor = new VisitorDisparoAliado(this);
		entidadgrafica = new EntidadGraficaJugador("/Recursos/Jugador/disparo.png");
		entidadgrafica.getImagen().setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);
		seguirMoviendo = true;
	}

	public void ejecutar() {
		mover();
	}

	public void mover() {

		if (y == 0) {
			morir();
		} else {
			if (miTablero.getCelda(x, y-1).cantEntidades() == 0) {
				miTablero.getCelda(x, y).eliminarEntidad(this);
				y = y - 1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.getImagen().setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);
			} else {
				
					System.out.println("COLISION DISPARO JUGADOR.");
					Entidad [] entidadesArreglo = miTablero.getCelda(x, y-1).getArregloEntidades();
					int pos=0;
					while(entidadesArreglo[pos]!=null) {
						//entidadesArreglo[pos].aceptar(miVisitor);
	                    pos++;					
				}
				miTablero.getCelda(x, y).eliminarEntidad(this);
				if (seguirMoviendo) {
					//System.out.println("entre seguir mo");
					y = y - 1;
					miTablero.getCelda(x, y).agregarEntidad(this);
					miCelda = miTablero.getCelda(x, y);
					entidadgrafica.getImagen().setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);
				}
			}
		}
	}
	
	/*
	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}

	 */
	
	public void morir() {
		miTablero.getLogica().eliminarEntidad(this);
	}

	public void setSeguirMoviendo(boolean b) {
		seguirMoviendo = b;
	}
	
	
	public Disparo crearDisparo() {
		
		return new DisparoJugador(miTablero,miCelda,this.getGolpe());
	} 

	

}
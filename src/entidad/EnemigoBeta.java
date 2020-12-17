package entidad;

import disparo.*;
import estrategia.MovimientoEnemigo;
import grafica.EntidadGraficaBeta;
import tablero.Celda;
import tablero.Tablero;
import visitor.Visitor;
import visitor.VisitorEnemigoBeta;

public class EnemigoBeta extends Enemigo {

	public EnemigoBeta(Tablero tablero, Celda celda,int vida,int golpe) {
		super(tablero, celda,vida,golpe);
		entidadgrafica = new EntidadGraficaBeta("/recursos/enemigos/beta.png");
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);
		this.vida = vida;
		this.golpe = golpe;
		this.miVisitor = new VisitorEnemigoBeta(this);
		this.movimiento = new MovimientoEnemigo(this.miTablero, this.miCelda, this);
	}


	public Disparo crearDisparo() {
		
		return new DisparoBeta(miTablero,miCelda,this.getGolpe());
	}


	@Override
	public void aceptar(Visitor visitor) {
		visitor.visitEnemigoBeta(this);
	} 

}

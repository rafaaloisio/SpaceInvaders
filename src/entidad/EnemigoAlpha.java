package entidad;


import disparo.*;
import estrategia.MovimientoEnemigo;
import grafica.EntidadGraficaAlpha;
import tablero.*;
import visitor.Visitor;
import visitor.VisitorEnemigoAlpha;

public class EnemigoAlpha extends Enemigo {

	//agregar strategy
	public EnemigoAlpha(Tablero tablero, Celda celda, int vida, int golpe) {
		super(tablero, celda,vida,golpe);
		entidadgrafica = new EntidadGraficaAlpha("/recursos/enemigos/alpha.png");
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);
		this.vida = vida;
		this.golpe = golpe;
		this.miVisitor = new VisitorEnemigoAlpha(this);
		this.movimiento = new MovimientoEnemigo(this.miTablero, this.miCelda, this);
	}

	public void estadoCritico() {
		int critico = this.vida*(20/100);
		if (this.vida < critico) {
		}
	}

	@Override
	public Disparo crearDisparo() {
		
		return new DisparoAlpha(miTablero,miCelda,this.getGolpe());
	}


	@Override
	public void aceptar(Visitor visitor) {
		visitor.visitEnemigoAlpha(this);
	} 

}

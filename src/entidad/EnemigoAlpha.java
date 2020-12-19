package entidad;


import disparo.*;
import grafica.EntidadGraficaAlpha;
import tablero.*;
import visitor.Visitor;
import visitor.VisitorEnemigoAlpha;

public class EnemigoAlpha extends Enemigo {

	protected final int vidaMin = (int) Math.round(vida*(0.20));

	public EnemigoAlpha(Tablero tablero, Celda celda, int vida, int golpe) {

		super(tablero, celda,vida,golpe);
		entidadgrafica = new EntidadGraficaAlpha("/recursos/enemigos/alpha.png");
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);
		this.vida = vida;
		this.golpe = golpe;
		this.miVisitor = new VisitorEnemigoAlpha(this);
	}



	public Disparo crearDisparo() {

		return new DisparoAlpha(miTablero,miCelda,this.getGolpe());
	}

	@Override
	public void recibirGolpe(int golpe) 
	{

		this.vida = vida - golpe;

		if (vida <= 0)
		{	
			this.morir();
		}else
		{
			if(this.vida <= vidaMin)
			{
				ejecutarMover = 3;	
			}
		}

	}



	public void aceptar(Visitor visitor) {
		visitor.visitEnemigoAlpha(this);
	} 

}

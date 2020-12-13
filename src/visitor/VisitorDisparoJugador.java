package visitor;

import disparo.*;
import entidad.Enemigo;
import entidad.Entidad;
import entidad.Jugador;
import entidad.Premio;

public class VisitorDisparoJugador implements Visitor {

	protected Disparo miDisparo;
	
	public VisitorDisparoJugador(Disparo d)
	{
		this.miDisparo = d;
	}
	
	
	@Override
	public void visitEnemigo(Enemigo e) {
		
		System.out.println("YO DISPARO JUGADOR - ENEMIGO");
		e.recibirGolpe(miDisparo.getGolpe());
		
		if(e.getVida()<=0)
		{
			e.getCelda().eliminarEntidad(e);
			System.err.println("ENEMIGO MUERTO: "+e.getVida());
		}

		miDisparo.getCelda().eliminarEntidad(miDisparo);

		miDisparo.morir();
		
		System.out.println("Vida enemigo: "+e.getVida());

		
	}

	@Override
	public void visitJugador(Jugador j) {
		
		//sin interacción
		
	}

	@Override
	public void visitDisparoJugador(DisparoJugador dj) {
		//sin interacción
	}

	@Override
	public void visitDisparoEnemigo(DisparoEnemigo de) {
		//sin interacción

		
	}
	
	public void visitPremio(Premio p) {
		//sin interacción
		
	}

}

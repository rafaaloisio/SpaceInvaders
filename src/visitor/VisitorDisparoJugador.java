package visitor;

import disparo.*;
import entidad.Enemigo;
import entidad.Entidad;
import entidad.Jugador;
import entidad.Premio;
import entidad.PremioPocion;

public class VisitorDisparoJugador implements Visitor {

	protected Disparo miDisparo;
	
	public VisitorDisparoJugador(Disparo d)
	{
		this.miDisparo = d;
	}
	
	
	@Override
	public void visitEnemigo(Enemigo e) {
		
		e.recibirGolpe(miDisparo.getGolpe());
		
		miDisparo.getCelda().eliminarEntidad(miDisparo);

		miDisparo.morir();
		
		System.out.println("Vida enemigo: "+e.getVida());

		
	}

	@Override
	public void visitJugador(Jugador j) {
		
		this.miDisparo.morir();
		
	}

	@Override
	public void visitDisparoJugador(DisparoJugador dj) {
		miDisparo.morir();
	}

	@Override
	public void visitDisparoEnemigo(DisparoEnemigo de) {
		//sin interacción

		
	}
	
	public void visitPremio(Premio p) {
	}

}

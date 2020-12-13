package visitor;

import disparo.*;
import entidad.Enemigo;
import entidad.Entidad;
import entidad.Jugador;
import entidad.Premio;

public class VisitorDisparoEnemigo implements Visitor {

	protected Disparo miDisparo;
	
	public VisitorDisparoEnemigo(Disparo d)
	{
		this.miDisparo = d;
	}
	
	
	@Override
	public void visitEnemigo(Enemigo e) {
		System.out.println("YO DISPARO ENEMIGO - ENEMIGO");

	}

	@Override
	public void visitJugador(Jugador j) {
		
		System.out.println("YO DISPARO ENEMIGO - JUGADOR");
		/*
		j.recibirGolpe(miDisparo.getGolpe());
		miDisparo.morir();
		
		System.out.println("Vida JUGADOR: "+j.getVida());
	*/
	
	}

	@Override
	public void visitDisparoJugador(DisparoJugador dj) {
		//System.out.println("YO DISPARO ENEMIGO - DISPARO JUGADOR");

	}

	@Override
	public void visitDisparoEnemigo(DisparoEnemigo de) {
		System.out.println("YO DISPARO ENEMIGO - DISPARO ENEMIGO");

		
	}
	
	public void visitPremio(Premio p) {
		System.out.println("YO DISPARO ENEMIGO - PREMIO");

		
	}

}
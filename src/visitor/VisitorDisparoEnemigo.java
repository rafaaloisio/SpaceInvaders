package visitor;

import disparo.*;
import entidad.Enemigo;
import entidad.Jugador;

public class VisitorDisparoEnemigo implements Visitor {

	protected Disparo miDisparo;
	
	public VisitorDisparoEnemigo(Disparo d)
	{
		this.miDisparo = d;
	}
	
	
	@Override
	public void visit(Enemigo e) {
		System.out.println("YO DISPARO ENEMIGO CHOQUE CONTRA ENEMIGO");
	}

	@Override
	public void visit(Jugador j) {
		// TODO Auto-generated method stub
		System.out.println("YO DISPARO ENEMIGO CHOQUE CONTRA JUGADOR");

		
	}

	@Override
	public void visit(DisparoJugador dj) {
		//miDisparo.morir();
		System.out.println("YO DISPARO ENEMIGO CHOQUE CONTRA DISPARO JUGADOR");
	}

	@Override
	public void visit(DisparoEnemigo de) {
		System.out.println("YO DISPARO ENEMIGO CHOQUE CONTRA DISPARO ENEMIGO");
		
	}

}
package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import entidad.Enemigo;
import entidad.Jugador;

public class VisitorEnemigo implements Visitor {

	protected Enemigo miEnemigo;
	
	public VisitorEnemigo(Enemigo e)
	{
		this.miEnemigo = e;
	}
	
	@Override
	public void visit(Enemigo e) {
		System.out.println("YO ENEMIGO CHOQUE CONTRA ENEMIGO");		
	}

	@Override
	public void visit(Jugador j) {
		System.out.println("YO ENEMIGO CHOQUE CONTRA JUGADOR");				
	}

	@Override
	public void visit(DisparoJugador dj) {
		System.out.println("YO ENEMIGO CHOQUE CONTRA DISPARO JUGADOR");				
	}

	@Override
	public void visit(DisparoEnemigo de) {
		System.out.println("YO ENEMIGO CHOQUE CONTRA DISPARO ENEMIGO");				
	}

}
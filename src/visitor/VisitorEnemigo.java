package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import entidad.Enemigo;
import entidad.Entidad;
import entidad.Jugador;
import entidad.Premio;

public class VisitorEnemigo implements Visitor {

	protected Enemigo miEnemigo;
	
	public VisitorEnemigo(Enemigo e)
	{
		this.miEnemigo = e;
	}
	
	@Override
	public void visitEnemigo(Enemigo e) {
		System.out.println("YO ENEMIGO CHOQUE CONTRA ENEMIGO");		
	}

	@Override
	public void visitJugador(Jugador j) {
		System.out.println("YO ENEMIGO CHOQUE CONTRA JUGADOR");				
	}

	@Override
	public void visitDisparoJugador(DisparoJugador dj) {
		miEnemigo.recibirGolpe(dj.getGolpe());
		dj.morir();
		System.out.println("**YO ENEMIGO CHOQUE CONTRA DISPARO JUGADOR");				
	}

	@Override
	public void visitDisparoEnemigo(DisparoEnemigo de) {
		System.out.println("YO ENEMIGO CHOQUE CONTRA DISPARO ENEMIGO");				
	}

	@Override
	public void visitPremioPocion(Premio p) {
		System.out.println("YO ENEMIGO CHOQUE CONTRA PREMIO");
		
	}

}
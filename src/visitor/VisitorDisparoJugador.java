package visitor;

import disparo.*;
import entidad.Enemigo;
import entidad.Entidad;
import entidad.Jugador;
import entidad.Premio;

public class VisitorDisparoJugador implements Visitor {

	protected Entidad miDisparo;
	
	public VisitorDisparoJugador(Disparo d)
	{
		this.miDisparo = d;
	}
	
	
	@Override
	public void visitEnemigo(Enemigo e) {
		System.out.println("YO DISPARO JUGADOR CHOQUE CONTRA ENEMIGO, VIDA ENEMIGO: "+e.getVida());
		DisparoJugador dj = (DisparoJugador) miDisparo;
		e.recibirGolpe(dj.getGolpe());
		miDisparo.morir();
			
		System.out.println("VIDA ENEMIGO: "+e.getVida());
	}

	@Override
	public void visitJugador(Jugador j) {
		j.morir();
		System.out.println("YO DISPARO JUGADOR CHOQUE CONTRA JUGADOR");
		
	}

	@Override
	public void visitDisparoJugador(DisparoJugador dj) {
		System.out.println("YO DISPARO JUGADOR CHOQUE CONTRA DISPARO JUGADOR");		
	}

	@Override
	public void visitDisparoEnemigo(DisparoEnemigo de) {
		miDisparo.morir();
		System.out.println("YO DISPARO JUGADOR CHOQUE CONTRA DISPARO ENEMIGO");
		
		
	}
	
	public void visitPremio(Premio p) {
		System.out.println("YO DISPARO JUGADOR CHOQUE CONTRA PREMIO");
		
	}

}

package visitor;

import disparo.*;
import entidad.Enemigo;
import entidad.Jugador;
import entidad.Premio;

public class VisitorDisparoJugador implements Visitor {

	protected Disparo miDisparo;
	
	public VisitorDisparoJugador(Disparo d)
	{
		this.miDisparo = d;
	}
	
	
	@Override
	public void visit(Enemigo e) {
		System.out.println("YO DISPARO JUGADOR CHOQUE CONTRA ENEMIGO, VIDA ENEMIGO: "+e.getVida());

		e.recibirGolpe(miDisparo.getGolpe());
		miDisparo.morir();
			
		System.out.println("VIDA ENEMIGO: "+e.getVida());
	}

	@Override
	public void visit(Jugador j) {
		System.out.println("YO DISPARO JUGADOR CHOQUE CONTRA JUGADOR");
		
	}

	@Override
	public void visit(DisparoJugador dj) {
		System.out.println("YO DISPARO JUGADOR CHOQUE CONTRA DISPARO JUGADOR");		
	}

	@Override
	public void visit(DisparoEnemigo de) {
		//miDisparo.morir();
		System.out.println("YO DISPARO JUGADOR CHOQUE CONTRA DISPARO ENEMIGO");
		
		
	}
	
	public void visit(Premio p) {
		System.out.println("YO DISPARO JUGADOR CHOQUE CONTRA PREMIO");
		
	}

}

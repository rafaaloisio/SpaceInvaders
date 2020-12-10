package visitor;

import disparo.*;
import entidad.Enemigo;
import entidad.Entidad;
import entidad.Jugador;
import entidad.Premio;

public class VisitorDisparoEnemigo implements Visitor {

	protected Entidad miDisparo;
	
	public VisitorDisparoEnemigo(Disparo d)
	{
		this.miDisparo = d;
	}
	
	
	@Override
	public void visitEnemigo(Enemigo e) {
	}

	@Override
	public void visitJugador(Jugador j) {
		System.out.println("YO DISPARO ENEMIGO CHOQUE CONTRA JUGADOR");
		DisparoEnemigo d = (DisparoEnemigo) miDisparo;
		System.out.println("DAÑO CAUSADO: "+ d.getGolpe());
		j.recibirGolpe(d.getGolpe());
	}

	@Override
	public void visitDisparoJugador(DisparoJugador dj) {
	}

	@Override
	public void visitDisparoEnemigo(DisparoEnemigo de) {
		
	}
	
	public void visitPremio(Premio p) {
		
	}

}
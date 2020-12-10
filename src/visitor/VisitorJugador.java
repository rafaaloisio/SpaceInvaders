package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import entidad.Enemigo;
import entidad.Jugador;
import entidad.Premio;

public class VisitorJugador implements Visitor {

	protected Jugador miJugador;
	
	public VisitorJugador(Jugador j)
	{
		this.miJugador = j;
	}
	
	@Override
	public void visitEnemigo(Enemigo e) {
		Jugador j = (Jugador) miJugador;
		j.recibirGolpe(100);
		j.morir();
		System.err.println("YO JUGADOR CHOQUE CONTRA ENEMIGO");
	}

	@Override
	public void visitJugador(Jugador j) {
		j.morir();
		System.out.println("YO JUGADOR CHOQUE CONTRA JUGADOR");				
		
	}

	@Override
	public void visitDisparoJugador(DisparoJugador dj) {
		System.out.println("YO JUGADOR CHOQUE CONTRA DISPARO JUGADOR");				
		
	}

	@Override
	public void visitDisparoEnemigo(DisparoEnemigo de) {
		System.out.println("YO JUGADOR CHOQUE CONTRA DISPARO ENEMIGO");				
		
	}
	
	public void visitPremio(Premio p) {
		
		System.out.println("YO JUGADOR CHOQUE CONTRA PREMIO");
		//consumo del efecto del premio
		//depende de si es un premio temporal o instantaneo
		
	}

}

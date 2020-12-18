package visitor;

import disparo.*;
import entidad.EnemigoAlpha;
import entidad.EnemigoBeta;
import entidad.Jugador;
import entidad.PremioCongelamiento;
import entidad.PremioPocion;
import entidad.PremioSuperArma;

public class VisitorDisparoEnemigo implements Visitor {

	private DisparoEnemigo miDisparo;
	
	public VisitorDisparoEnemigo(DisparoEnemigo d) {
		this.miDisparo = d;
	}
	
	@Override
	public void visitJugador(Jugador j) {
		j.recibirGolpe(miDisparo.getGolpe());
		miDisparo.morir();
	}

	@Override
	public void visitDisparoJugador(DisparoJugador dj) {
		//System.out.println("YO DISPARO ENEMIGO - DISPARO JUGADOR");

	}

	@Override
	public void visitDisparoEnemigo(DisparoEnemigo de) {
		//System.out.println("YO DISPARO ENEMIGO - DISPARO ENEMIGO");
		de.morir();
		
	}


	@Override
	public void visitPremioPocion(PremioPocion p) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visitPremioCongelamiento(PremioCongelamiento p) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visitPremioSuperArma(PremioSuperArma p) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visitEnemigoAlpha(EnemigoAlpha ea) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visitEnemigoBeta(EnemigoBeta eb) {
		// TODO Auto-generated method stub
		
	}
	
}
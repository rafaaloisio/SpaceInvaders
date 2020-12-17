package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import entidad.Enemigo;
import entidad.EnemigoAlpha;
import entidad.EnemigoBeta;
import entidad.Jugador;
import entidad.PremioCongelamiento;
import entidad.PremioPocion;
import entidad.PremioSuperArma;

public class VisitorEnemigoBeta implements Visitor {
	
	private EnemigoBeta miEnemigo;
	
	public VisitorEnemigoBeta(EnemigoBeta e) {
		this.miEnemigo = e;
	}

	@Override
	public void visitEnemigoAlpha(EnemigoAlpha ea) {
		
	}

	@Override
	public void visitEnemigoBeta(EnemigoBeta eb) {
		
	}

	@Override
	public void visitJugador(Jugador j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitDisparoJugador(DisparoJugador dj) {
		this.miEnemigo.recibirGolpe(dj.getGolpe());
		dj.morir();
	}

	@Override
	public void visitDisparoEnemigo(DisparoEnemigo de) {
		// TODO Auto-generated method stub
		
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



}

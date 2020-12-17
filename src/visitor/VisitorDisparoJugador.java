package visitor;

import disparo.*;
import entidad.Enemigo;
import entidad.EnemigoAlpha;
import entidad.EnemigoBeta;
import entidad.Entidad;
import entidad.Jugador;
import entidad.Premio;
import entidad.PremioCongelamiento;
import entidad.PremioPocion;
import entidad.PremioSuperArma;

public class VisitorDisparoJugador implements Visitor {

	protected Disparo miDisparo;
	
	public VisitorDisparoJugador(Disparo d) {
		this.miDisparo = d;
	}
	
	
	@Override
	public void visitJugador(Jugador j) {
		this.miDisparo.morir();
	}

	@Override
	public void visitDisparoJugador(DisparoJugador dj) {
		miDisparo.morir();
	}

	@Override
	public void visitDisparoEnemigo(DisparoEnemigo de) {
		//sin interacción

		
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
		ea.recibirGolpe(this.miDisparo.getGolpe());
		this.miDisparo.morir();
	}


	@Override
	public void visitEnemigoBeta(EnemigoBeta eb) {
		// TODO Auto-generated method stub
		eb.recibirGolpe(this.miDisparo.getGolpe());
		this.miDisparo.morir();
	}
	
}

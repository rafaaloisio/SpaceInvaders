package visitor;

import disparo.*;
import entidad.*;

public class VisitorPremioPocion implements Visitor {

	protected PremioPocion miPremio;
	
	public VisitorPremioPocion(PremioPocion p) {
		miPremio = p;
	}

	//premio choca con jugador
	public void visitJugador(Jugador j) {
		
		
		j.setVida(j.getVida() + miPremio.getVida());
		
		
		this.miPremio.getCelda().eliminarEntidad(this.miPremio);
		this.miPremio.morir();
	}

	public void visitDisparoJugador(DisparoJugador dj) {
		
	}

	public void visitDisparoEnemigo(DisparoEnemigo de) {
		
	}

	public void visitPremioPocion(PremioPocion p) {
		// TODO Auto-generated method stub
		
	}

	public void visitPremioCongelamiento(PremioCongelamiento p) {
		// TODO Auto-generated method stub
		
	}

	
	public void visitPremioSuperArma(PremioSuperArma p) {
		// TODO Auto-generated method stub
		
	}

	public void visitEnemigoAlpha(EnemigoAlpha ea) {
		// TODO Auto-generated method stub
		
	}

	public void visitEnemigoBeta(EnemigoBeta eb) {
		// TODO Auto-generated method stub
		
	}


}

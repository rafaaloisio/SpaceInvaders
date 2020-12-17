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

public class VisitorEnemigoAlpha implements Visitor {
	
	private EnemigoAlpha miEnemigo;
	
	public VisitorEnemigoAlpha(EnemigoAlpha e) {
		this.miEnemigo = e;
	}

	@Override
	public void visitEnemigoAlpha(EnemigoAlpha ea) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitEnemigoBeta(EnemigoBeta eb) {
		// TODO Auto-generated method stub
		
	}

	//enemigo choca con jugador
	@Override
	public void visitJugador(Jugador j) {
		System.out.println(miEnemigo.toString());		
		
		j.recibirGolpe( (int) Math.round(miEnemigo.getVida()*(0.15)));

		if(j.getVida()<=0)
		{
			j.getCelda().eliminarEntidad(j);
			System.out.println("JUGADOR MUERTO: "+j.getVida());
		}
		
		
		System.out.println("Vida JUGADOR CHOQUE ALPHA!!: "+j.getVida());
		
		
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

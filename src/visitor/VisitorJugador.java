package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import entidad.Enemigo;
import entidad.EnemigoAlpha;
import entidad.EnemigoBeta;
import entidad.Jugador;
import entidad.Premio;
import entidad.PremioCongelamiento;
import entidad.PremioPocion;
import entidad.PremioSuperArma;

public class VisitorJugador implements Visitor {

	protected Jugador miJugador;
	
	public VisitorJugador(Jugador j)
	{
		this.miJugador = j;
	}
	
	@Override
	public void visitJugador(Jugador j) {
		
		System.out.println(j.toString());		
	}

	@Override
	public void visitDisparoJugador(DisparoJugador dj) {
		
		System.out.println(dj.toString());
		
		//sin interacción		
	}

	@Override
	public void visitDisparoEnemigo(DisparoEnemigo de) {
		
		System.out.println(de.toString());		
		
		miJugador.recibirGolpe(de.getGolpe());
		
		if(miJugador.getVida()<=0)
		{
			miJugador.getCelda().eliminarEntidad(miJugador);
			System.out.println("ENEMIGO MUERTO: "+miJugador.getVida());
		}
		
		de.getCelda().eliminarEntidad(de);

		de.morir();
		
		System.out.println("Vida JUGADOR: "+miJugador.getVida());
	
		
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

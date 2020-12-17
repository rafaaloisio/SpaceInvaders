package visitor;

import java.util.LinkedList;

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

	
	//jugador choca con premio
	@Override
	public void visitPremioPocion(PremioPocion p) {
		// TODO Auto-generated method stub
		
		miJugador.setVida(miJugador.getVida() + p.getGolpe());
		p.getCelda().eliminarEntidad(p);
		p.morir();
		
	}
	
	//jugador choca con premio
	@Override
	public void visitPremioCongelamiento(PremioCongelamiento p) {
		
		LinkedList<Enemigo> l = miJugador.getTablero().getEnemigos();
		
		for (Enemigo e: l) {
			e.setTiempo(20);
		}
		p.getCelda().eliminarEntidad(p);
		p.morir();		
	}
	
	//jugador choca con premio
	@Override
	public void visitPremioSuperArma(PremioSuperArma p) {
		miJugador.setGolpe(miJugador.getGolpe() + p.getGolpe());
		p.getCelda().eliminarEntidad(p);
		p.morir();
		
	}

	//jugador choca con enemigo, le quita 15% de la vida restante
	@Override
	public void visitEnemigoAlpha(EnemigoAlpha ea) {
		// TODO Auto-generated method stub
		
		
		System.out.println(ea.toString());		
		
		miJugador.recibirGolpe( (int) Math.round(miJugador.getVida()*(0.15)));

		if(miJugador.getVida()<=0)
		{
			miJugador.getCelda().eliminarEntidad(miJugador);
			System.out.println("JUGADOR MUERTO: "+miJugador.getVida());
		}
		
		
		System.out.println("Vida JUGADOR CHOQUE ALPHA: "+miJugador.getVida());
		
		
		
		
	}

	//jugador choca con enemigo, le quita 30% de la vida restante
	@Override
	public void visitEnemigoBeta(EnemigoBeta eb) {
		// TODO Auto-generated method stub
		
		System.out.println(eb.toString());		
		
		miJugador.recibirGolpe( (int) Math.round(miJugador.getVida()*(0.30)));

		if(miJugador.getVida()<=0)
		{
			miJugador.getCelda().eliminarEntidad(miJugador);
			
			System.out.println("JUGADOR MUERTO: "+miJugador.getVida());
		}
		
		
		System.out.println("Vida JUGADOR CHOQUE BETA: "+miJugador.getVida());
		
	}

}

package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import entidad.Enemigo;
import entidad.Jugador;
import entidad.Premio;
import entidad.PremioPocion;

public class VisitorJugador implements Visitor {

	protected Jugador miJugador;
	
	public VisitorJugador(Jugador j)
	{
		this.miJugador = j;
	}
	
	@Override
	public void visitEnemigo(Enemigo e) {
	
		miJugador.recibirGolpe(miJugador.getVida());
		
		if(miJugador.getVida()<=0)
		{
			System.err.println("**YO JUGADOR - ENEMIGO Y MORÍ");
		}	
		
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
	
	public void visitPremioPocion(Premio p) {
		
		System.out.println(p.toString());
		//consumo del efecto del premio
		//depende de si es un premio temporal o instantaneo
		
		miJugador.setVida(miJugador.getVida() + p.getGolpe());
		p.getCelda().eliminarEntidad(p);
		p.morir();
		System.err.println("VIDA:"+miJugador.getVida() );	
		
	}

}

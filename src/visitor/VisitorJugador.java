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
	
		miJugador.recibirGolpe(miJugador.getVida());
		
		if(miJugador.getVida()<=0)
		{
			System.err.println("**YO JUGADOR - ENEMIGO Y MORÍ");
		}	
		
	}

	@Override
	public void visitJugador(Jugador j) {
		
		//sin interacción		
	}

	@Override
	public void visitDisparoJugador(DisparoJugador dj) {
		
		//sin interacción		
		
	}

	@Override
	public void visitDisparoEnemigo(DisparoEnemigo de) {
		
		System.err.println("**YO JUGADOR - DISPARO ENEMIGO");		
		
		
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
	
	public void visitPremio(Premio p) {
		
		System.err.println("YO JUGADOR - PREMIO VIDA:"+miJugador.getVida() );
		//consumo del efecto del premio
		//depende de si es un premio temporal o instantaneo
		
		miJugador.setVida(miJugador.getVida() + p.getGolpe());
	
		System.err.println("VIDA:"+miJugador.getVida() );	
		
	}

}

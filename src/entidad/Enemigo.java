package entidad;

import java.util.Random;

import estrategia.Movimiento;
import estrategia.MovimientoEnemigo;
import fabrica.FabricaPocionCongelamiento;
import fabrica.FabricaPremio;
import fabrica.FabricaPremioPocion;
import fabrica.FabricaPremioSuperArma;
import tablero.Celda;
import tablero.Tablero;
import visitor.*;

public abstract class Enemigo extends Personaje{


	private int tiempo;
	
	protected Enemigo(Tablero tablero, Celda celda,int vida,int golpe) {
		super(tablero, celda);
		this.vida = vida;
		this.golpe = golpe;
		this.tiempo = 4;
	}

	public void ejecutar()
	{
		if (tiempo == 4) {
			disparar(this);
		}

		tiempo--;

		if (tiempo == 0) {
			tiempo = 4;
			//movimiento.desplazar();
			
			mover();
		}
	}


	@Override
	public void mover()
	{
	
		
	//	MovimientoEnemigo m = new MovimientoEnemigo(this.miTablero, this.miCelda, this);
	//	this.setMovimiento(m);

		if (miTablero.getCelda(x , y + 1).cantEntidades() == 0) {


			miTablero.getCelda(x, y).eliminarEntidad(this);	

			if( y + 1 == miTablero.getFilas()-1 )
		y = 0;
			else
				y = y + 1;

			miTablero.getCelda(x, y).agregarEntidad(this);
			miCelda = miTablero.getCelda(x, y);
			entidadgrafica.actualizar(miCelda);		
		}else
		{ 
			Entidad[] entidadesCelda = miTablero.getCelda(x, y+1).getArregloEntidades();

			for (int i=0; i < entidadesCelda.length; i++) {
				if (entidadesCelda[i] != null) {
					entidadesCelda[i].aceptar(miVisitor);
				}
			}

			
			miTablero.getCelda(x, y).eliminarEntidad(this);	
			
			if (seguirMoviendo) {

				

				if( y + 1 == miTablero.getFilas()-1 )
					y = 0;
				else
				y = y + 1;

				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.actualizar(miCelda);		
			}
   	}
	}



	public void morir() {

		//no sacar, sin esto, no se elimina de la misma celda en la que está y quedan fantasmas
		miCelda.eliminarEntidad(this);
		super.morir();

		//algunas veces suelta premios al morir
		int n = new Random().nextInt(10);

		switch (n){

		case 1 : //premio pocion vida
			FabricaPremioPocion fpp = new FabricaPremioPocion(this.miTablero, this.miCelda);
			System.out.println("SOLTE PREMIO VIDA.");		
			Premio pv = fpp.crearPremio();
			miTablero.getLogica().agregarEntidad(pv, miCelda);
			pv.mover();
			break;

		case 2 : //premio pocion congelar
			FabricaPocionCongelamiento fpc = new FabricaPocionCongelamiento(miTablero, miCelda);
			System.out.println("SOLTE PREMIO CONGELAR.");		
			Premio pc = fpc.crearPremio();
			miTablero.getLogica().agregarEntidad(pc, miCelda);
			pc.mover();
			break;

		case 3 : //premio pocion fuerza
			FabricaPremioSuperArma fpsa = new FabricaPremioSuperArma(miTablero, miCelda);
			System.out.println("SOLTE PREMIO FUERZA.");		
			Premio pf = fpsa.crearPremio();
			miTablero.getLogica().agregarEntidad(pf, miCelda);
			pf.mover();
			break;
		}

	}


	public int getTiempo() {
		return tiempo;
	}


	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}


}

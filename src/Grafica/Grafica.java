package Grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidad.Entidad;
import Logica.Logica;
//import logica.Logica;
import Mapa.*;

import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Grafica extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int PIXEL = 64;
	
	private FondoPanel panelPrincipal;
	private JPanel panelCentral;
	private Logica logica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafica frame = new Grafica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Grafica() 
	{
		
		setSize(480, 850);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Space Invaders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		crearPanel();
		
		this.addKeyListener(this);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBounds(0, 0, 100, 50);
		panelSuperior.add(new JLabel("Vida: 100"));
		panelSuperior.setOpaque(false);
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		
		panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		panelCentral.setLayout(null);
		panelPrincipal.add(panelCentral);
		
		logica = new Logica(this);
		
		
		
		//cargarTablero(this.logica.getTablero(),panelCentral);
		
		
	}
	
	public void crearPanel() 
	{
		panelPrincipal = new FondoPanel("/recursos/fondos/fondo.jpg");
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setBounds(0, 0, 600, 800);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(panelPrincipal);
	}
	
	
	
	public void graficarEntidad(Entidad e) {
		JLabel label = e.getImagen();
		panelCentral.add(label);
		label.setBounds((e.getCelda().getX() * PIXEL), e.getCelda().getY() * PIXEL, PIXEL, PIXEL);
		label.setVisible(true);
		
		panelCentral.setComponentZOrder(label, 0);
		//panelCentral.repaint();
		
	}

	public void eliminarEntidad(Entidad e) {
		JLabel label = e.getImagen();
		panelCentral.remove(label);
		panelCentral.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		logica.getTablero().getJugador().mover(e.getKeyCode());
		System.out.println(e.getKeyCode());
    	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	
}

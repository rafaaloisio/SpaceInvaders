package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import entidad.Entidad;
import grafica.EntidadGrafica;
import logica.Logica;
import tablero.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int PIXEL = 64;
	
	private FondoPanel panelPrincipal;
	private JPanel panelCentral;
	private Logica logica;
	private JLabel texto,vida;
	private Timer actualizarVida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() 
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
		
		texto = new JLabel("Vida:");
		texto.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		texto.setForeground(Color.WHITE);
		panelSuperior.add(texto);
		
		vida = new JLabel("500");
		vida.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		vida.setForeground(Color.WHITE);
		panelSuperior.add(vida);
		
		panelSuperior.setOpaque(false);
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		
		panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		panelCentral.setLayout(null);
		panelPrincipal.add(panelCentral);
		
		logica = new Logica(this);
		
		
		actualizarVida(vida);
		
		
		
		
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
		EntidadGrafica eg = e.getEntidadGrafica();
		panelCentral.add(eg.getImagen());
		eg.getImagen().setBounds((e.getCelda().getX() * PIXEL), e.getCelda().getY() * PIXEL, PIXEL, PIXEL);
		eg.getImagen().setVisible(true);
		
		panelCentral.setComponentZOrder(eg.getImagen(), 0);

		
	}

	public void eliminarEntidad(Entidad e) {
		EntidadGrafica eg = e.getEntidadGrafica();
		JLabel label = eg.getImagen();
		panelCentral.remove(label);
		panelCentral.repaint();
		

		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(!logica.isPerdi())
		{
			logica.getTablero().getJugador().mover(e.getKeyCode());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void actualizarVida(JLabel v)
	{
		actualizarVida = new Timer(250, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				v.setText(""+logica.getTablero().getJugador().getVida());
				
				if(logica.isPerdi()) {
					
					actualizarVida.stop();
					
					JOptionPane.showMessageDialog(panelPrincipal, "El jugador perdió por malo.", "La nave hizo boom", JOptionPane.ERROR_MESSAGE);

				}
				
			}
			
			
		});
		
		actualizarVida.start();
	}

}

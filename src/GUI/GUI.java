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
	private JPanel panelSuperior, panelCentral, panelInferior;
	private Logica miLogica;
	private JLabel textoVida,vida;
	private JLabel textoNivel,nivel;
	private JLabel textoOleada,oleada;
	private Timer actualizarLabels;

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
		
		setSize(480, 900);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Space Invaders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		crearPanel();
		
		this.addKeyListener(this);
		
		//Panel Superior
		panelSuperior = new JPanel();
		panelSuperior.setBounds(0, 0, 100, 50);
		
		textoVida = new JLabel("Vida:");
		textoVida.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		textoVida.setForeground(Color.WHITE);
		panelSuperior.add(textoVida);
		
		vida = new JLabel("500");
		vida.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		vida.setForeground(Color.WHITE);
		panelSuperior.add(vida);
		

		panelSuperior.setOpaque(false);
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		
		
		//Panel Central
		panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		panelCentral.setLayout(null);
		panelPrincipal.add(panelCentral);
		
		miLogica = new Logica(this);
				
		//Panel Inferior
		
		panelInferior = new JPanel();
		panelInferior.setBounds(0, 0, 100, 50);
		
		textoNivel = new JLabel("Nivel:");
		textoNivel.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		textoNivel.setForeground(Color.WHITE);
		panelInferior.add(textoNivel);
		
		nivel = new JLabel("0");
		nivel.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		nivel.setForeground(Color.WHITE);
		panelInferior.add(nivel);
		
		
		JLabel separador = new JLabel("  -  ");
		separador.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		separador.setForeground(Color.WHITE);
		panelInferior.add(separador);
		
		
		textoOleada = new JLabel("Oleada:");
		textoOleada.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		textoOleada.setForeground(Color.WHITE);
		panelInferior.add(textoOleada);
		
		
		oleada = new JLabel("0");
		oleada.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		oleada.setForeground(Color.WHITE);
		panelInferior.add(oleada);
		
		panelInferior.setOpaque(false);
		panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
		
		
		actualizarLabels(vida,nivel,oleada);

		
		
		
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
		
		//para que no siga detectando las entradas por teclado cuado pierde o gana
		if(!miLogica.isPerdi() ||!miLogica.isGane() )
		{
			miLogica.getTablero().getJugador().mover(e.getKeyCode());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	private void actualizarLabels(JLabel v,JLabel n,JLabel o)
	{
		actualizarLabels = new Timer(250, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				v.setText(""+miLogica.getTablero().getJugador().getVida());
				n.setText(""+miLogica.getTablero().getMiNivel().getNivel());
				o.setText(""+miLogica.getTablero().getMiNivel().getOleadaActual());
				
				if(miLogica.isPerdi()) {
					
					actualizarLabels.stop();
					
					JOptionPane.showMessageDialog(panelPrincipal, "El jugador perdió por malo.", "La nave hizo boom", JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
				
				if(miLogica.isGane()) {
					
					actualizarLabels.stop();
					
					JOptionPane.showMessageDialog(panelPrincipal, "El jugador ganó, es muy groso!", "Los enemigos fueron derrotados", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				
				
			}
			
			
		});
		
		actualizarLabels.start();
	}

}

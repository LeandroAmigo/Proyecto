/*package grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mapa.Escenario;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel mContentPane;
	
	private Escenario miEscenario;

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

	public GUI() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				accion(arg0);
		}
		});
		
		this.mContentPane = new JPanel();
		this.mContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.mContentPane.setLayout(new GridLayout());
		setResizable(false);
		setContentPane(this.mContentPane);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(000, 000,992,416);
		
		this.miEscenario = new Escenario(this);
	}
	
	protected void accion(KeyEvent key)
	{
	
		int dir=key.getKeyCode();
		switch (dir){
		case KeyEvent.VK_UP : 
				miEscenario.getBomberman().moverArriba();
			break;
		case KeyEvent.VK_DOWN :
			miEscenario.getBomberman().moverAbajo();
			break;
		case KeyEvent.VK_LEFT :
			miEscenario.getBomberman().moverIzquierda();
			break;
		case KeyEvent.VK_RIGHT :
			miEscenario.getBomberman().moverDerecha();
			break;
					}
		
		
		
		
	}
}	
*/

package grafica ;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import mapa.*;


public class GUI extends JFrame {

	private JFrame frame;
	private PanelEscenario grilla;
	private PanelPuntajes puntaje;
	
	private Escenario escenario;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initializar();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializar()
	{
		frame = new JFrame();
		frame.setTitle("Bomberman");
		frame.setResizable(false);
		frame.setBounds(100, 100, 998,476); 
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grilla = new PanelEscenario();
		grilla.setLocation(0,0);
		frame.add(grilla);
		puntaje = new PanelPuntajes();
		puntaje.setLocation(0,416);
		frame.add(puntaje);
		
		escenario=new Escenario(this);
		
		// Agrega oyende de las teclas
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				accion(arg0);
			}
		});
		
	}
	protected void accion(KeyEvent key)
	{
	
		int dir=key.getKeyCode();
		switch (dir){
		case KeyEvent.VK_UP : 
				escenario.getBomberman().moverArriba();
			break;
		case KeyEvent.VK_DOWN :
			escenario.getBomberman().moverAbajo();
			break;
		case KeyEvent.VK_LEFT :
			escenario.getBomberman().moverIzquierda();
			break;
		case KeyEvent.VK_RIGHT :
			escenario.getBomberman().moverDerecha();
			break;
		case KeyEvent.VK_SPACE :
			escenario.getBomberman().PonerBomba();
			break;
			
					}
					
	}
	public void addPanelEscenario(JLabel Imagen,int prof)
	{
		grilla.add(Imagen,prof);
		grilla.repaint();
	}
	public void removePanelEscenario(JLabel grafico)
	{
		grilla.remove(grafico);
		grilla.repaint();
	}
	public PanelEscenario getPanelEscenario()
	{return grilla;}
	

	public void addPanelPuntaje(JLabel Imagen)
	{
		puntaje.add(Imagen);
		puntaje.repaint();
	}
	public void removePanelPuntaje(JLabel grafico)
	{
		puntaje.remove(grafico);
		puntaje.repaint();
	}
	public PanelPuntajes getPanelPuntaje()
	{return puntaje;}
	
	public void ActualizarTiempo(int t){
		puntaje.ActualizarTiempo(t);   }

	public void ActualizarPuntos(int p){
		puntaje.ActualizarPuntos(p);   }
	
	public void TERMINARJUEGO(){
		escenario.PararHilos();
		JLabel imagen=new JLabel();
		imagen.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/FinDelJuego.jpg")));
		imagen.setBounds(0,-50, 998, 496);
		this.addPanelEscenario(imagen, 1);
		this.repaint();
		
		
	}
	
	
}

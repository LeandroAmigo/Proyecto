package grafica;

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
		this.mContentPane.setLayout(null);
		
		setContentPane(this.mContentPane);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 000, 400, 400);
		
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

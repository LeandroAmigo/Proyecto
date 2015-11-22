package grafica;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BombaGrafica {
	
	protected JLabel grafico;
	protected Icon imagen;
	protected Icon ExplosionImagen;
	protected final int ancho = 32;
	protected final int alto = 32;
	
	protected  int fila;
	protected int columna;
	
	protected GUI gui;
	
	public BombaGrafica(int fila, int columna,GUI gui) {
		this.fila=fila;
		this.columna=columna;
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/bomba.png"));	
			
		this.gui = gui;
		
		this.grafico = new JLabel(imagen);
		this.grafico.setBounds(columna*ancho,fila*alto, ancho, alto);
		this.gui.addPanelEscenario(this.grafico, 0);
		
	}
	
	public int obtenerFila()
	{
		return fila;
	}
	public int obtenerColumna()
	{
		return columna;
	}
		
	public void desaparecer() {
		this.gui.removePanelEscenario(this.grafico);
		
	}
	
}

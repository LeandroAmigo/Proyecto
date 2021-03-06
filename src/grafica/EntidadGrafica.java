package grafica;

import javax.swing.Icon;
import javax.swing.JLabel;











import logica.CONSTANTES;
import personajes.Personaje;

public class EntidadGrafica extends Thread {

	protected JLabel miImagen;
	protected Icon misImagenes[];
	protected int cant;           //Mantiene la cantidad de imagenes en el arreglo
	protected Personaje entidad;
	protected int posX;
	protected int posY;
	protected final int ancho = 32;
	protected final int alto = 32;
	protected Thread hilo;
	protected GUI gui;
	
	
	
	
	/**
	 * 
	 * @param c cantidad de imagenes de la entidad
	 */
	public EntidadGrafica(Personaje p,int posX,int posY,GUI gui)
	{
		entidad=p;
		this.gui=gui;
		this.misImagenes=new Icon [5];
		cant=0;
		this.posX=posX*ancho;
		this.posY=posY*alto;
		this.gui.addPanelEscenario(this.getGrafico(), 1);
		
		
	}
	public void InicializarImagen(Icon i)
	{
		if(misImagenes.length!=cant)
		{
			misImagenes[cant]=i;
			cant++;
		}
		//sino tendria que lanzar un error de que no se puede almacenar mas imagenes
	}
	
	public JLabel getGrafico() {
		if(this.miImagen == null){
			this.miImagen = new JLabel(this.misImagenes[0]);
			this.miImagen.setBounds(this.posY, this.posX, this.ancho, this.alto);
		}
		return this.miImagen;
	}
	
	/**
	 * en la direccion 0: mirar derecha
				 	   1:mirar  izquierda
				 	   2:mirar Arriba
			     	   3:mirar Abajo
	 * @param direccion
	 * @param p personaje
	 */
	public  void SetImagen(int direccion,Personaje p) {
		
		this.miImagen.setIcon(this.misImagenes[direccion]);
		mover(direccion);
		
		
	}	
	public void setHilo(Thread h){
		hilo=h;
	}
	
	private int velocidad()
	{	
		return  20-entidad.getVelocidad();
	}
	
	
	public void mover(int direccion) {
		this.miImagen.setIcon(this.misImagenes[direccion]);
		int posXaux =entidad.getPosicion().getFila()*ancho;
		int posYaux=entidad.getPosicion().getColumna()*alto;
		switch (direccion) {
			case CONSTANTES.B_MirarDerecha : { // Derecha
				try {
					while(posY < posYaux)
					{
						this.miImagen.setBounds(this.posY+1, this.posX, ancho, alto);
						this.posY++;
						hilo.sleep(velocidad());
						gui.repaint();
					}
				} catch (InterruptedException e) {
					//e.printStackTrace();
					//hilo.interrupt();
				}
				break;
			}
			case CONSTANTES.B_MirarIzquierda : { // Izquierda				
				try {
						while(posY > posYaux)
						{
						this.miImagen.setBounds(this.posY-1, this.posX, ancho, alto);
						this.posY--;
						hilo.sleep(velocidad());
						}
				} catch (InterruptedException e) {
					//e.printStackTrace();
					//hilo.interrupt();
				}
				break;
			}				
			case CONSTANTES.B_MirarArriba : { // Arriba				
				try {
					while(posX > posXaux)
					{
						this.miImagen.setBounds(this.posY, this.posX-1, ancho, alto);
						posX--;
						hilo.sleep(velocidad());
					}
				} catch (InterruptedException e) {
					//e.printStackTrace();
					//hilo.interrupt();
				}
				break;
			}				
			case CONSTANTES.B_MirarAbajo : { // Abajo				
				try {
					while(posX < posXaux)
					{
						this.miImagen.setBounds(this.posY,this.posX+1, ancho, alto);
						this.posX++;
						hilo.sleep(velocidad());
					}
				} catch (InterruptedException e) {
					//e.printStackTrace();
					//hilo.interrupt();
				}
				break;
			}
		}
	}

	
	public void Morir()
	{
		if(miImagen!=null)
		{
			this.miImagen.setIcon(this.misImagenes[4]);
		}
		
	}
	public void Eliminar()
	{
		gui.removePanelEscenario(miImagen);
	}
	
	
}
	


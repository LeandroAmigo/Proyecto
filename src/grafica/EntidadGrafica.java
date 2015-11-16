package grafica;

import javax.swing.Icon;
import javax.swing.JLabel;




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
		hilo=new Thread();
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
		posX=p.getPosicion().getColumna()*ancho;
		posY=p.getPosicion().getFila()*alto;
		//mover(direccion);
		this.miImagen.setBounds(this.posX, this.posY,this.ancho,this.alto);
		
	}	
	
	public void mover(int direccion) {
		this.miImagen.setIcon(this.misImagenes[direccion]);
		switch (direccion) {
			case 0 : { // Derecha
				//try {
					for (int i = 0; i < this.alto; i ++)
					{
						this.miImagen.setBounds(this.posX, this.posY+=i, ancho, alto);
						//hilo.sleep(05);
					}
				//} catch (InterruptedException e) {
				//	e.printStackTrace();
				//}
				break;
			}
			case 1 : { // Izquierda				
				//try {
					for (int i = 0; i < this.alto; i ++) 
					{
						this.miImagen.setBounds(this.posX, this.posY -= i, ancho, alto);
					//	hilo.sleep(05);
					}
				//} catch (InterruptedException e) {
					//e.printStackTrace();
				//}
				break;
			}				
			case 2 : { // Arriba				
				//try {
					for (int i = 0; i < this.alto; i ++)
					{
						this.miImagen.setBounds(this.posX -= i, this.posY, ancho, alto);
					//	hilo.sleep(05);
					}
				//} catch (InterruptedException e) {
					//e.printStackTrace();
				//}
				break;
			}				
			case 3 : { // Abajo				
				//try {
					for (int i = 0; i < this.alto; i ++) 
					{
						this.miImagen.setBounds(this.posX+= i,this.posY, ancho, alto);
					//	hilo.sleep(05);
					}
				//} catch (InterruptedException e) {
				//	e.printStackTrace();
				//}
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
	


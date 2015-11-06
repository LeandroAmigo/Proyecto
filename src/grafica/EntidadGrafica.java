package grafica;

import javax.swing.Icon;
import javax.swing.JLabel;



import personajes.Personaje;

public class EntidadGrafica {

	protected JLabel miImagen;
	protected Icon misImagenes[];
	protected int cant;           //Mantiene la cantidad de imagenes en el arreglo
	protected Personaje entidad;
	protected int posX;
	protected int posY;
	protected PanelEscenario panel;
	protected final int ancho = 32;
	protected final int alto = 32;

	/**
	 * 
	 * @param c cantidad de imagenes de la entidad
	 */
	public EntidadGrafica(Personaje p,int posX,int posY,PanelEscenario panel)
	{
		entidad=p;
		this.panel=panel;
		this.misImagenes=new Icon [5];
		cant=0;
		this.posX=posX*ancho;
		this.posY=posY*alto;
		this.panel.add(this.getGrafico(), 1);
		
		
	}
	public void setImagen(Icon i)
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
			this.miImagen.setBounds(this.posX, this.posY, this.ancho, this.alto);
		}
		return this.miImagen;
	}
	
	public  void moverAbajo() {
		if(miImagen != null){
			this.miImagen.setIcon(this.misImagenes[0]);
			this.posY+=entidad.getVelocidad()*alto;
			this.miImagen.setBounds(this.posX, this.posY,this.ancho,this.alto);
			
		}
	}	
	public  void moverArriba() {
		
		if(miImagen != null){
			this.miImagen.setIcon(this.misImagenes[1]);
			this.posY-=entidad.getVelocidad()*alto;
			this.miImagen.setBounds(this.posX, this.posY,this.ancho,this.alto);
		}
	}	
	public  void moverDerecha() {
	
		if(miImagen != null){
			this.miImagen.setIcon(this.misImagenes[2]);
			this.posX+=entidad.getVelocidad()*ancho;
			this.miImagen.setBounds(this.posX, this.posY,this.ancho,this.alto);
		}
	}
	public  void moverIzquierda() {
		
		if(miImagen != null){
			this.miImagen.setIcon(this.misImagenes[3]);
			this.posX-=entidad.getVelocidad()*ancho;
			this.miImagen.setBounds(this.posX, this.posY,this.ancho,this.alto);
		}
	}
	public void Morir()
	{
		if(miImagen!=null)
		{
			this.miImagen.setIcon(this.misImagenes[4]);
		}
		
	}
	
		
		
		
		
		
		
}
	


package grafica;

import javax.swing.Icon;
import javax.swing.JLabel;

import personajes.Personaje;

public class EntidadGrafica {

	protected JLabel miImagen;
	protected Icon misImagenes[];
	protected int cant;//Mantiene la cantidad de imagenes en el arreglo
	protected Personaje entidad;
	protected int posX;
	protected int posY;

	/**
	 * 
	 * @param c cantidad de imagenes de la entidad
	 */
	public EntidadGrafica(Personaje p,int c,int posX,int posY)
	{
		entidad=p;
		this.misImagenes=new Icon [c];
		cant=0;
		this.posX=posX;
		this.posY=posY;
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
			//this.miImagen.setBounds(entidad.getPosicion().getColumna(),entidad.getPosicion().getFila(),ancho,largo);
			this.miImagen.setBounds(posX,posY,32,32);
		}
		return this.miImagen;
	}
	
	public  void moverAbajo() {
		if(miImagen != null){
			this.miImagen.setIcon(this.misImagenes[0]);//setear bien
			posY+=entidad.getVelocidad()*15;
			this.miImagen.setBounds(this.entidad.getPosicion().getColumna(), this.entidad.getPosicion().getFila(), this.posX, this.posY);
			
		}
	}	
	public  void moverArriba() {
		
		if(miImagen != null){
			this.miImagen.setIcon(this.misImagenes[0]);//setear bien
			posY-=entidad.getVelocidad()*15;
			this.miImagen.setBounds(this.entidad.getPosicion().getColumna(), this.entidad.getPosicion().getFila(), this.posX, this.posY);
		}
	}	
	public  void moverDerecha() {
		
		if(miImagen != null){
			this.miImagen.setIcon(this.misImagenes[0]);//setear bien
			posX+=entidad.getVelocidad()*15;
			this.miImagen.setBounds(this.entidad.getPosicion().getColumna(), this.entidad.getPosicion().getFila(), this.posX, this.posY);
		}
	}
	public  void moverIzquierda() {
		
		if(miImagen != null){
			this.miImagen.setIcon(this.misImagenes[0]);//setear bien
			posX-=entidad.getVelocidad()*15;
			this.miImagen.setBounds(this.entidad.getPosicion().getColumna(), this.entidad.getPosicion().getFila(), this.posX, this.posY);
		}
	}
	public void Morir()
	{
		if(miImagen!=null)
		{
			this.miImagen.setIcon(this.misImagenes[1]);//setear bien
		}
		
	}
	
		
		
		
		
		
		
}
	


package mapa;

import grafica.GUI;

import java.util.*;

import logica.CONSTANTES;
import logica.Logica;
import logica.MaloThread;
import personajes.Altair;
import personajes.Bomberman;
import personajes.Personaje;
import personajes.Rugulos;
import personajes.Sirius;

/**
 * 
 */
public class Escenario {

	Logica miLogica;	
	protected LinkedList<MaloThread> hilos;   
    protected int puntos;
    protected Celda miMatriz[][];
    protected Bomberman bomberman;
    protected LinkedList<Sirius> misSirius;
    protected LinkedList<Altair> misAltair;
    protected LinkedList<Rugulos> misRugulos;
    protected GUI gui; 
    protected final int Ancho=13;
    protected final int Largo=31;
    
    public Escenario(GUI gui) {
    	   
    	this.gui=gui;
       Inicializar();
    
    }

    public void setPosicion(int fila,int columna,Celda c) 
    {
       
    }
    /**
     *  Retorna la celda que se encuentra en la posicion dada en la grilla  
     * @param fila
     * @param columna
     * @return
     */
    public Celda getPosicion( int fila,  int columna)
    {
         return miMatriz[fila][columna];
    }

    public Collection<Sirius> getSirius()
    {
        
        return null;
    }

    public Sirius getSirius(Sirius s)
    {
        
        return null;
    }

    public void eliminarSirius(Sirius s)
    {
        
    }

    public Collection<Altair> getAltair()
    {
       
        return null;
    }

    public Altair getAltair(Altair a) 
    {
        
        return null;
    }

    public void eliminarAltair(Altair a)
    {
        
    }

    public Collection<Rugulos> getRugulos() 
    {
       
        return null;
    }

    public Rugulos getRugulos(Rugulos r) 
    {
       
        return null;
    }

    public void eliminarRugulos(Rugulos r) 
    {
       
    }
    /**
     * Retorna bomberman
     * @return Bomberman
     */
    public Bomberman getBomberman()
    {
        
        return this.bomberman;
    }
    public void sumarPuntos(int p) 
    {
        
    }
    /**
     * retorna la logica
     * @return Logica
     */
    public Logica getLogica()
    {
    	return miLogica;
    }

    /**
     * 	Inicializa y aplica a las graficas las distintas componentes del juego  
     * @param panel 
     */
    
    
    public void Inicializar() 
    {
    	this.miLogica=new Logica(this);
    	InicializarEscenario();
    	InicializarBomberman();
    	InicializarAltair();
    	this.gui.repaint();
    }
    
    private void InicializarBomberman()
    {
    	this.bomberman = new Bomberman(this,1,1);
    	this.miMatriz[1][1].setBomberman(this.bomberman);
    }
    
    private void InicializarAltair()
    {   int CantAltair=2;
    	misAltair=new LinkedList<Altair>();
    	hilos=new LinkedList<MaloThread>();
        for(int i=0; i<CantAltair;i++)
    	{
    		misAltair.add(new Altair(this,11,11));//Falta setear posicion aleatoria! 
    		
    		this.hilos.add(new MaloThread(misAltair.get(i)));
    		misAltair.get(i).SetHilo(hilos.get(i));
     		this.hilos.get(i).start();
    	}
    }
    
    private void InicializarEscenario()
    {	
    	
    	this.miMatriz = new Celda[this.Ancho][this.Largo];
    	int cantDestructibles = 10;
    	boolean estanTodas = false;
    	Random random = new Random();
    	int fila;
    	int columna;
    	
    	// Se generan las paredes indestructibles
    	for (int i = 0; i < Ancho; i++)
    	{
    		for (int j = 0; j < Largo; j++)
    		{
    			if (((i == 0) || (i ==Ancho-1) || (j == 0) || (j == Largo-1)) || ((i % 2 == 0) && (j % 2 == 0)))
    			{
    				// Limite del escenario e indestructibles del medio
    				this.miMatriz[i][j] = new Celda(i, j, this,new Indestructible(i,j));
    				this.miMatriz[i][j].getGrafica().setGrafico(CONSTANTES.P_Indestructible);
    				
    			}
    		}
    	}
    	
    	// Se generan las indestructibles en forma aleatoria
    	while (!estanTodas)
    	{
    		fila = random.nextInt(this.Ancho - 1) + 1; // Numero aleatorio entre 1 y cantidad de filas - 1
    		columna = random.nextInt(this.Largo - 1) + 1; // Numero aleatorio entre 1 y cantidad de columnas - 1
    		boolean espacioLibreBomberman = ((fila == 1) && (columna == 1)) || ((fila == 1) && (columna == 2)) || ((fila == 2) && (columna == 1)); // Espacio libre al inicio
    		boolean espacioLibreSirius = ((fila == this.Ancho-1) && (columna == this.Largo-1)) || ((fila == 11) && (columna == this.Largo-2)) || ((fila == this.Ancho-3) && (columna == this.Largo-2)); // Espacio libre al inicio
    		
    		if ((this.miMatriz[fila][columna] == null) && (!espacioLibreBomberman) && (!espacioLibreSirius))
    		{
    			this.miMatriz[fila][columna] = new Celda(fila, columna, this,new Destructible(fila,columna));
    			this.miMatriz[fila][columna].getGrafica().setGrafico(CONSTANTES.P_Destructible);
				cantDestructibles--;
    		}
    		estanTodas = (cantDestructibles == 0);
    	}
    	
    	// Se generan los transitables en las posiciones restantes
    	for (int i = 0; i < this.Ancho; i++)
    	{
    		for (int j = 0; j < this.Largo; j++)
    		{
    			if (this.miMatriz[i][j] == null)
    			{
    				this.miMatriz[i][j] = new Celda(i, j, this,new Transitable(i,j));
    				this.miMatriz[i][j].getGrafica().setGrafico(CONSTANTES.P_Transitable);
    			}
    		}
    	}    	
    	   	
    
    	
    }
    /**
     * Retorna una lista de celdas adyacentes a la pasada por parametro..
     * La longitud de la lista es Alcance*4
     * donde las celdas adyacentes se encuentran ubicadas:
     * 			Celdas adyacentes Arriba desde 0 a Alcance-1
     * 			Celdas adyacentes Abajo desde Alcance a Alcance*2-1 
     * 			Celdas adyacentes Arriba desde Alcance*2 a Alcance*3-1 
     * 			Celdas adyacentes Arriba desde Alcance*3 a Alcance*4-1  
     * En caso de que el alcance caiga fuera de la grilla se completa con celdas nulas.
     * 
     * @param c
     * @param alcance
     * @return
     */
    public LinkedList<Celda> getAdyacentes(Celda c, int alcance)
    {	int filaAux;
    	int columnaAux;
    	Celda adyacente;
    	LinkedList<Celda> lista=new LinkedList<Celda>();
    	for(int i=1;i<alcance+1;i++)
    	{	filaAux=c.getFila()-i;
    		if(filaAux>=0)
    		{	
    			adyacente= getPosicion(filaAux,c.getColumna());//celda arriba
    			lista.add(adyacente);
    		}else
    		{
    			adyacente= null;
    			lista.add(adyacente);
    		}
    	}
    	for(int i=1;i<alcance+1;i++)
    	{	
    		filaAux=c.getFila()+i;
    		if(filaAux<this.Ancho)
    		{
    			adyacente= getPosicion(filaAux,c.getColumna());//celda abajo
    			lista.add(adyacente);
    		}else
    		{
    			adyacente= null;
    			lista.add(adyacente);
    		}
    	}
    	for(int i=1;i<alcance+1;i++)
    	{
    		columnaAux=c.getColumna()-i;
    		if(columnaAux>=0)
    		{	
    			adyacente= getPosicion(c.getFila(),columnaAux);//celda derecha
    			lista.add(adyacente);
    		}else
    		{
    			adyacente= null;
    			lista.add(adyacente);
    		}
    		
    	}
    	for(int i=1;i<alcance+1;i++)
    	{
    		columnaAux=c.getColumna()+i;
    		if(columnaAux<=this.Largo-1)
    		{	
    			adyacente= getPosicion(c.getFila(),columnaAux);//celda izquierda
    			lista.add(adyacente);
    		}else
    		{
    			adyacente= null;
    			lista.add(adyacente);
    		}
    	}
    	
    	
    	
    	return lista;
    	
    }  
    public GUI getGui()
    {
    	return this.gui;
    }
    
    
}
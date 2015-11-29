package mapa;

import grafica.GUI;

import java.util.*;

import logica.CONSTANTES;
import logica.Logica;
import logica.MaloThread;
import logica.TiempoThread;
import personajes.Altair;
import personajes.Bomberman;
import personajes.Personaje;
import personajes.Rugulos;
import personajes.Sirius;
import powerUp.Bombality;
import powerUp.Fatality;
import powerUp.Masacrality;
import powerUp.PowerUp;
import powerUp.SpeedUp;

/**
 * 
 */
public class Escenario {

	Logica miLogica;	
	protected LinkedList<MaloThread> hilos;   
    protected int puntos;
    protected int tiempo;
    protected TiempoThread HiloTiempo;
    protected Celda miMatriz[][];
    protected Bomberman bomberman;
    protected LinkedList<Sirius> misSirius;
    protected LinkedList<Altair> misAltair;
    protected LinkedList<Rugulos> misRugulos;
    protected GUI gui; 
    protected final int Ancho=13;
    protected final int Largo=31;
   
    
    public Escenario(GUI gui) {
    	
    	this.puntos=0;
    	this.tiempo=0;
    	this.gui=gui;
    	hilos=new LinkedList<MaloThread>();
       Inicializar();
       HiloTiempo=new TiempoThread(this);
       HiloTiempo.start();
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
    public void PararHilos()
    {
    	for(int i=0;i<hilos.size();i++)
    	{
    		System.out.println("Detuvo hilo");
    		hilos.get(i).detener();
    	}
    	HiloTiempo.detener();
    	
    }

    public void SumarUnSegundo(){
    	tiempo++;
    	gui.ActualizarTiempo(tiempo);
    }
    
    
    public void eliminarSirius(Sirius s)
    {
        misSirius.remove(s);
    }

    public void eliminarAltair(Altair a)
    {
        misAltair.remove(a);
    }

    public void eliminarRugulos(Rugulos r) 
    {
       misRugulos.remove(r);
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
     this.puntos+=p; 
     gui.ActualizarPuntos(puntos);
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
    	InicializarRugulos();
    	InicializarSirius();
    	this.gui.repaint();
    }
    
    private void InicializarBomberman()
    {
    	this.bomberman = new Bomberman(this,1,1);
    	this.miMatriz[1][1].setBomberman(this.bomberman);
    }
    
    private void InicializarAltair()
    {   Random random = new Random();
		int fila;
		int columna;
    	int CantAltair=2;
    	misAltair=new LinkedList<Altair>();
    	MaloThread hilo;
        for(int i=0; i<CantAltair;i++)
    	{
        	fila = random.nextInt(this.Ancho - 2) + 1; // Numero aleatorio entre 1 y cantidad de filas - 1
    		columna = random.nextInt(this.Largo - 2) + 1; // Numero aleatorio entre 1 y cantidad de columnas - 1
        	misAltair.add(new Altair(this,fila,columna));//Falta setear posicion aleatoria! 
    		hilo=new MaloThread(misAltair.get(i));
    		this.hilos.add(hilo);
    		misAltair.get(i).SetHilo(hilo);
     		hilo.start();
    	}
    }
    
    private void InicializarRugulos()
    {   
    	Random random = new Random();
    	int fila;
    	int columna;
    	int CantRugulos=3;
    	misRugulos=new LinkedList<Rugulos>();
    	MaloThread hilo;
        for(int i=0; i<CantRugulos;i++)
    	{
        	fila = random.nextInt(this.Ancho - 2) + 1; // Numero aleatorio entre 1 y cantidad de filas - 1
    		columna = random.nextInt(this.Largo - 2) + 1; // Numero aleatorio entre 1 y cantidad de columnas - 1
    		misRugulos.add(new Rugulos(this,fila,columna));//Falta setear posicion aleatoria! 
    		hilo=new MaloThread(misRugulos.get(i));
    		this.hilos.add(hilo);
    		misRugulos.get(i).SetHilo(hilo);
    		hilo.start();
    	}
    }

    private void InicializarSirius()
    {   
     	int fila=11;
    	int columna=29;
    	int CantSirius=1;
    	misSirius=new LinkedList<Sirius>();
    	MaloThread hilo;
        for(int i=0; i<CantSirius;i++)
    	{
    		misSirius.add(new Sirius(this,fila,columna));
    		hilo=new MaloThread(misSirius.get(i));
    		this.hilos.add(hilo);
    		misSirius.get(i).SetHilo(hilo);
    		hilo.start();
    	}
    	
    }
    
    private void InicializarEscenario()
    {	
    	
    	this.miMatriz = new Celda[this.Ancho][this.Largo];
    	int cantDestructibles = 80;//Tiene que ser mayor a la cantidad de powerUp totales
    	boolean estanTodas = false;
    	int cantSpeedUp=4;
    	int cantFatality=3;
    	int cantBombality=3;
    	int cantMasacrality=1;
    	int colocarPowerUp;
    	int cantPowerUp=cantSpeedUp+cantFatality+cantBombality+cantMasacrality;
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
    		
    		colocarPowerUp=random.nextInt(1);
    		if(cantDestructibles<=cantPowerUp || colocarPowerUp==1)
    		{
    			if(cantSpeedUp>0)
    			{	
    				PowerUp s=new SpeedUp(miMatriz[fila][columna]);
    				this.miMatriz[fila][columna].setPowerUp(s);
    				cantSpeedUp--;
    				
    			
    			}else{
    					if(cantFatality>0)
    					{	PowerUp f=new Fatality(miMatriz[fila][columna]);
    						this.miMatriz[fila][columna].setPowerUp(f);
    						cantFatality--;
    						
    						
    					}else{
    						  if(cantBombality>0)
    						  {
    							  PowerUp b=new Bombality(miMatriz[fila][columna]);
    							  this.miMatriz[fila][columna].setPowerUp(b);
    							  cantBombality--;
    							  
    						  }
    						  else{
    							  if(cantMasacrality>0)
    							  {
    								  PowerUp m=new Masacrality(miMatriz[fila][columna]);
    								  this.miMatriz[fila][columna].setPowerUp(m);
    								  cantMasacrality--;
    								  
    							  }
    						  	  }
    						 }
    			}
    	    cantPowerUp--;
    		}				
    		
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
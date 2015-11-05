package mapa;

import grafica.PanelEscenario;
import java.util.*;
import logica.Logica;
import logica.MaloThread;
import personajes.Altair;
import personajes.Bomberman;
import personajes.Rugulos;
import personajes.Sirius;

/**
 * 
 */
public class Escenario {

	Logica miLogica;	
	MaloThread[] hilo;   
    protected int puntos;
    protected Celda miMatriz[][];
    protected Bomberman bomberman;
    protected Sirius [] misSirius;
    protected Altair [] misAltair;
    protected Rugulos [] misRugulos;
    protected PanelEscenario gui;  
    
    public Escenario(PanelEscenario gui) {
    	   
    	
       Inicializar(gui);
    
    }

    public void setPosicion(int fila,int columna,Celda c) {
       
    }
    /**
     *  Retorna la celda que se encuentra en la posicion dada en la grilla  
     * @param fila
     * @param columna
     * @return
     */
    public Celda getPosicion( int fila,  int columna) {
         return miMatriz[fila][columna];
    }

    public Collection<Sirius> getSirius() {
        
        return null;
    }

    public Sirius getSirius(Sirius s) {
        
        return null;
    }

    public void eliminarSirius(Sirius s) {
        
    }

    public Collection<Altair> getAltair() {
       
        return null;
    }

    public Altair getAltair(Altair a) {
        
        return null;
    }

    public void eliminarAltair(Altair a) {
        
    }

    public Collection<Rugulos> getRugulos() {
       
        return null;
    }

    public Rugulos getRugulos(Rugulos r) {
       
        return null;
    }

    public void eliminarRugulos(Rugulos r) {
       
    }
    /**
     * Retorna bomberman
     * @return Bomberman
     */
    public Bomberman getBomberman() {
        
        return this.bomberman;
    }
    public void sumarPuntos(int p) {
        
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
    
    
    public void Inicializar(PanelEscenario panel) {
    	this.miLogica=new Logica(this);
    	InicializarEscenario(panel);
    	InicializarBomberman(panel);
    	InicializarAltair(panel);
    	this.gui.repaint();
    }
    
    private void InicializarBomberman(PanelEscenario panel)
    {
    	this.bomberman = new Bomberman(this,1,1, panel);
    	this.miMatriz[1][1].setBomberman(this.bomberman);
    }
    
    private void InicializarAltair(PanelEscenario panel)
    {
    	misAltair=new Altair[2];
    	hilo=new MaloThread[2];
        for(int i=0; i<misAltair.length;i++)
    	{
    		misAltair[i]=new Altair(this,11,11,panel);//Falta setear posicion aleatoria!    		
    		this.hilo[i]=new MaloThread(misAltair[i]);
     		this.hilo[i].start();
    	}
    }
    
    private void InicializarEscenario(PanelEscenario panel)
    {	
    	this.gui=panel;
    	this.miMatriz = new Celda[13][31];
    	int cantDestructibles = 10;
    	boolean estanTodas = false;
    	Random random = new Random();
    	int fila;
    	int columna;
    	
    	// Se generan las paredes indestructibles
    	for (int i = 0; i < this.miMatriz.length; i++) {
    		for (int j = 0; j < this.miMatriz[0].length; j++) {
    			if (((i == 0) || (i == 12) || (j == 0) || (j == 30)) || ((i % 2 == 0) && (j % 2 == 0))) {
    				// Limite del escenario e indestructibles del medio
    				this.miMatriz[i][j] = new Celda(i, j, this,new Indestructible(panel,i,j),panel);
    			}
    		}
    	}
    	
    	// Se generan las indestructibles en forma aleatoria
    	while (!estanTodas) {
    		fila = random.nextInt(this.miMatriz.length - 1) + 1; // Numero aleatorio entre 1 y cantidad de filas - 1
    		columna = random.nextInt(this.miMatriz[0].length - 1) + 1; // Numero aleatorio entre 1 y cantidad de columnas - 1
    		boolean espacioLibreBomberman = ((fila == 1) && (columna == 1)) || ((fila == 1) && (columna == 2)) || ((fila == 2) && (columna == 1)); // Espacio libre al inicio
    		boolean espacioLibreSirius = ((fila == 11) && (columna == 29)) || ((fila == 11) && (columna == 28)) || ((fila == 10) && (columna == 29)); // Espacio libre al inicio
    		
    		if ((this.miMatriz[fila][columna] == null) && (!espacioLibreBomberman) && (!espacioLibreSirius)) {
    			this.miMatriz[fila][columna] = new Celda(fila, columna, this,new Destructible(panel,fila,columna), panel);
				cantDestructibles--;
    		}
    		estanTodas = (cantDestructibles == 0);
    	}
    	
    	// Se generan los transitables en las posiciones restantes
    	for (int i = 0; i < this.miMatriz.length; i++) {
    		for (int j = 0; j < this.miMatriz[0].length; j++) {
    			if (this.miMatriz[i][j] == null) {
    				this.miMatriz[i][j] = new Celda(i, j, this,new Transitable(panel,i,j), panel);
    			}
    		}
    	}    	
    	   	
    	
    }
    
    
    
}
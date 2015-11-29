package grafica;

import java.awt.*;
import javax.swing.*;

public class PanelPuntajes extends JPanel {
	
	private JLabel LabelPuntos,LabelTiempo;
	private String tiempo,puntos;
	public PanelPuntajes() {
		this.setSize(new Dimension(992,30));
		this.setBackground(Color.WHITE);
		this.setLayout(new GridLayout(1,2));
		LabelPuntos=new JLabel("0");
		LabelTiempo=new JLabel("0");
		this.add(LabelTiempo);
		this.add(LabelPuntos);
	}

	public void ActualizarTiempo(int t){
		tiempo=" TIEMPO EN SEGUNDOS: "+t;
		LabelTiempo.setText(tiempo);   }

	public void ActualizarPuntos(int p){
		puntos="PUNTAJE: "+p;
		LabelPuntos.setText(puntos);   }
	
}



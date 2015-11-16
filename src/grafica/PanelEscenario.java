package grafica;

import java.awt.*;
import javax.swing.*;

public class PanelEscenario extends JPanel {
	
	private final int cantFilas = 13;
	private final int cantColumnas = 31;
	
	public PanelEscenario() {
		this.setSize(new Dimension(992, 416));
		this.setLayout(null);
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/Imagenes/fondo.png"));//IMAGEN DE FONDO
		for (int i = 0; i < cantFilas; i++) {
			for (int j = 0; j < cantColumnas; j++) {
				JLabel fondo = new JLabel(imagen);
				fondo.setBounds(j * 32, i * 32, 32, 32);
				this.add(fondo, -1);
			}
		}
	}

}

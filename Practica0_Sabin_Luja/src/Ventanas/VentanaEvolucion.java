package Ventanas;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.util.Arrays;
import java.util.HashMap;
import java.awt.Color;
import java.awt.Graphics;
import GrandSlam.Tenista;

//NO EJECUTA LA EVOLUCION GRAFICA

public class VentanaEvolucion extends JFrame {

	/*private boolean bandera = false;
	private Tenista[] aTenistas;
	private HashMap<String, Tenista> hmTenistas = new HashMap<>();
	private int mayorVictorias;
	
	
	
	public VentanaEvolucion(int anioInicio, int anioFinal, int mayor) {
	
		mayorVictorias = mayor;
		calcularMedidas(anioInicio, anioFinal);
		
		this.setLayout(null);
		this.setSize(700, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	
	}
	
	private void calcularMedidas(int anyoInicio, int anyoFinal) {
		int total = VentanaResultados.getTablaResultados().getRowCount();
		JTable tabla = VentanaResultados.getTablaResultados();
		
		Thread t = new Thread() { // new Runnable() {
			public void run() {
			
				int lineaInicio = 0;
				for (int j = anyoInicio; j <= anyoFinal; j++) {
				
					for (int k = lineaInicio; k < total; k++) {
					
						if (Integer.parseInt((String)tabla.getValueAt(k, 0)) == j) {
							System.out.println(tabla.getValueAt(k, 2));
							
							sumarVictoria((String)tabla.getValueAt(k, 2), (String)tabla.getValueAt(k, 4));
						}
					}
						
					aTenistas = new Tenista[hmTenistas.size()];
					recorrerHashMap(hmTenistas);
					Arrays.sort(aTenistas);
					bandera = true;
					repaint();
					
					
					System.out.println();
					try {
						Thread.sleep( 2000 );
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}; t.start();
	
	}
	
	
	private void recorrerHashMap(HashMap<String, Tenista> hmTenistas) {
		int i = 0;
		
		for (String tenistas : hmTenistas.keySet()) {
		
			String[] dato = new String[3];
			dato[0] = hmTenistas.get(tenistas).getNombre();
			dato[1] = hmTenistas.get(tenistas).getNacionalidad();
			dato[2] = hmTenistas.get(tenistas).getVictoriasTotales() + "";
			
			aTenistas[i] = hmTenistas.get(tenistas);
			i += 1;
		}
	}
	
	
	
	private void sumarVictoria(String nombre, String nacionalidad) {
		if (hmTenistas.containsKey(nombre)) {
			int victoriaAnt = hmTenistas.get(nombre).getVictoriasTotales();
			victoriaAnt += 1;
			hmTenistas.replace(nombre, new Tenista(nombre, nacionalidad, victoriaAnt));
			
		} else {
			Tenista tenista = new Tenista(nombre, nacionalidad, 1);
			hmTenistas.put(nombre, tenista);
		}
	}
	
	
	
	public void paint(Graphics g) {
		super.paint(g);
		if (bandera ==true ) {
		
			int largo1;
			int largo2;
			int largo3;
			int largo4;
			int largo5;
			int largo6;
			int largo7;
			int largo8;
			int largo9;
			int largo10;
			
			
			g.drawString(aTenistas[0].getNombre(), 10, 75);
			
			if (aTenistas.length <= 1) {
				largo1 = aTenistas[0].getVictoriasTotales() * 400 / this.mayorVictorias;
				
				g.setColor(new Color(0, 0, 0));
				g.fillRect(150, 50, largo1, 40);
				g.drawString(aTenistas[0].getNombre() + " (" + aTenistas[0].getVictoriasTotales() + ")", 10, 75);
			
			} else if (aTenistas.length <= 2) {
				largo1 = aTenistas[0].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo2 = aTenistas[1].getVictoriasTotales() * 400 / this.mayorVictorias;
				
				g.setColor(new Color(0, 0, 0));
				g.fillRect(150, 50, largo1, 40);
				g.drawString(aTenistas[0].getNombre() + " (" + aTenistas[0].getVictoriasTotales() + ")", 10, 75);
				
				g.fillRect(150, 100, largo2, 40);
				g.drawString(aTenistas[1].getNombre() + " (" + aTenistas[1].getVictoriasTotales() + ")", 10, 125);
			
			} else if (aTenistas.length <= 3) {
				largo1 = aTenistas[0].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo2 = aTenistas[1].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo3 = aTenistas[2].getVictoriasTotales() * 400 / this.mayorVictorias;
				
				g.setColor(new Color(0, 0, 0));
				g.fillRect(150, 50, largo1, 40);
				g.drawString(aTenistas[0].getNombre() + " (" + aTenistas[0].getVictoriasTotales() + ")", 10, 75);
				
				g.fillRect(150, 100, largo2, 40);
				g.drawString(aTenistas[1].getNombre() + " (" + aTenistas[1].getVictoriasTotales() + ")", 10, 125);
				
				g.fillRect(150, 150, largo3, 40);
				g.drawString(aTenistas[2].getNombre() + " (" + aTenistas[2].getVictoriasTotales() + ")", 10, 175);
			
			} else if (aTenistas.length <= 4) {
				largo1 = aTenistas[0].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo2 = aTenistas[1].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo3 = aTenistas[2].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo4 = aTenistas[3].getVictoriasTotales() * 400 / this.mayorVictorias;
				
				g.setColor(new Color(0, 0, 0));
				g.fillRect(150, 50, largo1, 40);
				g.drawString(aTenistas[0].getNombre() + " (" + aTenistas[0].getVictoriasTotales() + ")", 10, 75);
				
				g.fillRect(150, 100, largo2, 40);
				g.drawString(aTenistas[1].getNombre() + " (" + aTenistas[1].getVictoriasTotales() + ")", 10, 125);
				
				g.fillRect(150, 150, largo3, 40);
				g.drawString(aTenistas[2].getNombre() + " (" + aTenistas[2].getVictoriasTotales() + ")", 10, 175);
				
				g.fillRect(150, 200, largo4, 40);
				g.drawString(aTenistas[3].getNombre() + " (" + aTenistas[3].getVictoriasTotales() + ")", 10, 225);
			
			} else if (aTenistas.length <= 5) {
				largo1 = aTenistas[0].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo2 = aTenistas[1].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo3 = aTenistas[2].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo4 = aTenistas[3].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo5 = aTenistas[4].getVictoriasTotales() * 400 / this.mayorVictorias;
				
				g.setColor(new Color(0, 0, 0));
				g.fillRect(150, 50, largo1, 40);
				g.drawString(aTenistas[0].getNombre() + " (" + aTenistas[0].getVictoriasTotales() + ")", 10, 75);
				
				g.fillRect(150, 100, largo2, 40);
				g.drawString(aTenistas[1].getNombre() + " (" + aTenistas[1].getVictoriasTotales() + ")", 10, 125);
				
				g.fillRect(150, 150, largo3, 40);
				g.drawString(aTenistas[2].getNombre() + " (" + aTenistas[2].getVictoriasTotales() + ")", 10, 175);
				
				g.fillRect(150, 200, largo4, 40);
				g.drawString(aTenistas[3].getNombre() + " (" + aTenistas[3].getVictoriasTotales() + ")", 10, 225);
				
				g.fillRect(150, 250, largo5, 40);
				g.drawString(aTenistas[4].getNombre() + " (" + aTenistas[4].getVictoriasTotales() + ")", 10, 275);
			
			} else if (aTenistas.length <= 6) {
				largo1 = aTenistas[0].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo2 = aTenistas[1].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo3 = aTenistas[2].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo4 = aTenistas[3].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo5 = aTenistas[4].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo6 = aTenistas[5].getVictoriasTotales() * 400 / this.mayorVictorias;
				
				g.setColor(new Color(0, 0, 0));
				g.fillRect(150, 50, largo1, 40);
				g.drawString(aTenistas[0].getNombre() + " (" + aTenistas[0].getVictoriasTotales() + ")", 10, 75);
				
				g.fillRect(150, 100, largo2, 40);
				g.drawString(aTenistas[1].getNombre() + " (" + aTenistas[1].getVictoriasTotales() + ")", 10, 125);
				
				g.fillRect(150, 150, largo3, 40);
				g.drawString(aTenistas[2].getNombre() + " (" + aTenistas[2].getVictoriasTotales() + ")", 10, 175);
				
				g.fillRect(150, 200, largo4, 40);
				g.drawString(aTenistas[3].getNombre() + " (" + aTenistas[3].getVictoriasTotales() + ")", 10, 225);
				
				g.fillRect(150, 250, largo5, 40);
				g.drawString(aTenistas[4].getNombre() + " (" + aTenistas[4].getVictoriasTotales() + ")", 10, 275);
				
				g.fillRect(150, 300, largo6, 40);
				g.drawString(aTenistas[5].getNombre() + " (" + aTenistas[5].getVictoriasTotales() + ")", 10, 325);
			
			} else if (aTenistas.length <= 7) {
				largo1 = aTenistas[0].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo2 = aTenistas[1].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo3 = aTenistas[2].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo4 = aTenistas[3].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo5 = aTenistas[4].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo6 = aTenistas[5].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo7 = aTenistas[6].getVictoriasTotales() * 400 / this.mayorVictorias;
				
				g.setColor(new Color(0, 0, 0));
				g.fillRect(150, 50, largo1, 40);
				g.drawString(aTenistas[0].getNombre() + " (" + aTenistas[0].getVictoriasTotales() + ")", 10, 75);
				
				g.fillRect(150, 100, largo2, 40);
				g.drawString(aTenistas[1].getNombre() + " (" + aTenistas[1].getVictoriasTotales() + ")", 10, 125);
				
				g.fillRect(150, 150, largo3, 40);
				g.drawString(aTenistas[2].getNombre() + " (" + aTenistas[2].getVictoriasTotales() + ")", 10, 175);
				
				g.fillRect(150, 200, largo4, 40);
				g.drawString(aTenistas[3].getNombre() + " (" + aTenistas[3].getVictoriasTotales() + ")", 10, 225);
				
				g.fillRect(150, 250, largo5, 40);
				g.drawString(aTenistas[4].getNombre() + " (" + aTenistas[4].getVictoriasTotales() + ")", 10, 275);
				
				g.fillRect(150, 300, largo6, 40);
				g.drawString(aTenistas[5].getNombre() + " (" + aTenistas[5].getVictoriasTotales() + ")", 10, 325);
				
				g.fillRect(150, 350, largo7, 40);
				g.drawString(aTenistas[6].getNombre() + " (" + aTenistas[6].getVictoriasTotales() + ")", 10, 375);
			
			} else if (aTenistas.length <= 8) {
				largo1 = aTenistas[0].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo2 = aTenistas[1].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo3 = aTenistas[2].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo4 = aTenistas[3].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo5 = aTenistas[4].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo6 = aTenistas[5].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo7 = aTenistas[6].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo8 = aTenistas[7].getVictoriasTotales() * 400 / this.mayorVictorias;
				
				g.setColor(new Color(0, 0, 0));
				g.fillRect(150, 50, largo1, 40);
				g.drawString(aTenistas[0].getNombre() + " (" + aTenistas[0].getVictoriasTotales() + ")", 10, 75);
				
				g.fillRect(150, 100, largo2, 40);
				g.drawString(aTenistas[1].getNombre() + " (" + aTenistas[1].getVictoriasTotales() + ")", 10, 125);
				
				g.fillRect(150, 150, largo3, 40);
				g.drawString(aTenistas[2].getNombre() + " (" + aTenistas[2].getVictoriasTotales() + ")", 10, 175);
				
				g.fillRect(150, 200, largo4, 40);
				g.drawString(aTenistas[3].getNombre() + " (" + aTenistas[3].getVictoriasTotales() + ")", 10, 225);
				
				g.fillRect(150, 250, largo5, 40);
				g.drawString(aTenistas[4].getNombre() + " (" + aTenistas[4].getVictoriasTotales() + ")", 10, 275);
				
				g.fillRect(150, 300, largo6, 40);
				g.drawString(aTenistas[5].getNombre() + " (" + aTenistas[5].getVictoriasTotales() + ")", 10, 325);
				
				g.fillRect(150, 350, largo7, 40);
				g.drawString(aTenistas[6].getNombre() + " (" + aTenistas[6].getVictoriasTotales() + ")", 10, 375);
				
				g.fillRect(150, 400, largo8, 40);
				g.drawString(aTenistas[7].getNombre() + " (" + aTenistas[7].getVictoriasTotales() + ")", 10, 425);
			
			} else if (aTenistas.length <= 9) {
				largo1 = aTenistas[0].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo2 = aTenistas[1].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo3 = aTenistas[2].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo4 = aTenistas[3].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo5 = aTenistas[4].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo6 = aTenistas[5].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo7 = aTenistas[6].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo8 = aTenistas[7].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo9 = aTenistas[8].getVictoriasTotales() * 400 / this.mayorVictorias;
				
				g.setColor(new Color(0, 0, 0));
				g.fillRect(150, 50, largo1, 40);
				g.drawString(aTenistas[0].getNombre() + " (" + aTenistas[0].getVictoriasTotales() + ")", 10, 75);
				
				g.fillRect(150, 100, largo2, 40);
				g.drawString(aTenistas[1].getNombre() + " (" + aTenistas[1].getVictoriasTotales() + ")", 10, 125);
				
				g.fillRect(150, 150, largo3, 40);
				g.drawString(aTenistas[2].getNombre() + " (" + aTenistas[2].getVictoriasTotales() + ")", 10, 175);
				
				g.fillRect(150, 200, largo4, 40);
				g.drawString(aTenistas[3].getNombre() + " (" + aTenistas[3].getVictoriasTotales() + ")", 10, 225);
				
				g.fillRect(150, 250, largo5, 40);
				g.drawString(aTenistas[4].getNombre() + " (" + aTenistas[4].getVictoriasTotales() + ")", 10, 275);
				
				g.fillRect(150, 300, largo6, 40);
				g.drawString(aTenistas[5].getNombre() + " (" + aTenistas[5].getVictoriasTotales() + ")", 10, 325);
				
				g.fillRect(150, 350, largo7, 40);
				g.drawString(aTenistas[6].getNombre() + " (" + aTenistas[6].getVictoriasTotales() + ")", 10, 375);
				
				g.fillRect(150, 400, largo8, 40);
				g.drawString(aTenistas[7].getNombre() + " (" + aTenistas[7].getVictoriasTotales() + ")", 10, 425);
				
				g.fillRect(150, 450, largo9, 40);
				g.drawString(aTenistas[8].getNombre() + " (" + aTenistas[8].getVictoriasTotales() + ")", 10, 475);
			
			} else {
				largo1 = aTenistas[0].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo2 = aTenistas[1].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo3 = aTenistas[2].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo4 = aTenistas[3].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo5 = aTenistas[4].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo6 = aTenistas[5].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo7 = aTenistas[6].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo8 = aTenistas[7].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo9 = aTenistas[8].getVictoriasTotales() * 400 / this.mayorVictorias;
				largo10 = aTenistas[9].getVictoriasTotales() * 400 / this.mayorVictorias;
				
				g.setColor(new Color(0, 0, 0));
				g.fillRect(150, 50, largo1, 40);
				g.drawString(aTenistas[0].getNombre() + " (" + aTenistas[0].getVictoriasTotales() + ")", 10, 75);
				
				g.fillRect(150, 100, largo2, 40);
				g.drawString(aTenistas[1].getNombre() + " (" + aTenistas[1].getVictoriasTotales() + ")", 10, 125);
				
				g.fillRect(150, 150, largo3, 40);
				g.drawString(aTenistas[2].getNombre() + " (" + aTenistas[2].getVictoriasTotales() + ")", 10, 175);
				
				g.fillRect(150, 200, largo4, 40);
				g.drawString(aTenistas[3].getNombre() + " (" + aTenistas[3].getVictoriasTotales() + ")", 10, 225);
				
				g.fillRect(150, 250, largo5, 40);
				g.drawString(aTenistas[4].getNombre() + " (" + aTenistas[4].getVictoriasTotales() + ")", 10, 275);
				
				g.fillRect(150, 300, largo6, 40);
				g.drawString(aTenistas[5].getNombre() + " (" + aTenistas[5].getVictoriasTotales() + ")", 10, 325);
				
				g.fillRect(150, 350, largo7, 40);
				g.drawString(aTenistas[6].getNombre() + " (" + aTenistas[6].getVictoriasTotales() + ")", 10, 375);
				
				g.fillRect(150, 400, largo8, 40);
				g.drawString(aTenistas[7].getNombre() + " (" + aTenistas[7].getVictoriasTotales() + ")", 10, 425);
				
				g.fillRect(150, 450, largo9, 40);
				g.drawString(aTenistas[8].getNombre() + " (" + aTenistas[8].getVictoriasTotales() + ")", 10, 475);
				
				g.fillRect(150, 500, largo10, 40);
				g.drawString(aTenistas[9].getNombre() + " (" + aTenistas[9].getVictoriasTotales() + ")", 10, 525);
			
			}
		}
	}*/
}

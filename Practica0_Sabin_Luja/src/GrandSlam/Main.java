package GrandSlam;

import Ventanas.VentanaGrandSlam;

public class Main {
	public static void main(String[] args) {
		VentanaGrandSlam vs = new VentanaGrandSlam();
		vs.setVisible(true);
		HistoriaGrandSlam historiaGrandSlam = new HistoriaGrandSlam();

		historiaGrandSlam.leerCSVTORNEOS();
		historiaGrandSlam.leerCSVGS();
		
		
	}
}

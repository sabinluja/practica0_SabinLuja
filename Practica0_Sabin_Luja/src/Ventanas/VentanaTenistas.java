package Ventanas;

import java.awt.BorderLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GrandSlam.CompararVictorias;
import GrandSlam.Tenista;

public class VentanaTenistas extends JPanel {
	
	static DefaultTableModel model = new DefaultTableModel();
	private static JTable tablaTenistas = new JTable();
	private static JScrollPane tenistasScroll = new JScrollPane();
	static JPanel panelTenistas = new JPanel();
	static ArrayList<Tenista> aTenistas = new ArrayList<Tenista>();	
	VentanaResultados vr = new VentanaResultados();
	
	public VentanaTenistas() {
		
		setLayout(null);
		
	}
	
	
	public static String[] dividePorComas( String linea ) {
		ArrayList<String> listaTokens = new ArrayList<String>();
		boolean entreComillas = false;
		StringBuilder b = new StringBuilder();
		
		for (char c : linea.toCharArray()) {
			if (c==',') {
				if (entreComillas) {
					b.append(c);
				} else {
					listaTokens.add( b.toString() );
					b = new StringBuilder();
				}
			} else if (c=='\"') {
				entreComillas = !entreComillas;
			} else {
				b.append(c);
			}
		}
		
		listaTokens.add( b.toString() );
		return listaTokens.toArray( new String[0] );
	}

	public static void leerHM(TreeMap mapa) {
		
		tablaTenistas.setModel(model);
		
		model.addColumn("Nombre");
		model.addColumn("Nacionalidad");
		model.addColumn("Numero Victorias GS");
		

		panelTenistas.setLayout(new BorderLayout());
		
		tenistasScroll.setViewportView(tablaTenistas);
		panelTenistas.add(tenistasScroll, BorderLayout.CENTER);
		
		
		for (Object valores: mapa.values()) {
			aTenistas.add((Tenista) valores);
			aTenistas.sort(new CompararVictorias());
		} for (Tenista tenis: aTenistas) {
			
			String[] tenisFinalString = new String[3];
			tenisFinalString[0] = tenis.getNombre();
			tenisFinalString[1] = tenis.getNacionalidad();
			tenisFinalString[2] = tenis.getVictoriasTotales() + "";
			model.addRow(tenisFinalString);
		}
	}
	
	public static ArrayList<Tenista> getaTenistas() {
		return aTenistas;
	}
}

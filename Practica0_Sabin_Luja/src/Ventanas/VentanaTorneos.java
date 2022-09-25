package Ventanas;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class VentanaTorneos extends JPanel {
	
	private DefaultTableModel model = new DefaultTableModel();
	private JTable tablaTorneos = new JTable();
	private JScrollPane torneosScroll = new JScrollPane();
	static JPanel panelTorneos = new JPanel();
	
	public VentanaTorneos () {
		
		setLayout(null);
		
		tablaTorneos.setModel(model);
		
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Ciudad");
		
		leerCSV();

		panelTorneos.setLayout(new BorderLayout());
		
		torneosScroll.setViewportView(tablaTorneos);
		panelTorneos.add(torneosScroll, BorderLayout.CENTER);		
	
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
	
	public void guardarCSV () {}
	
	public void leerCSV () {
		String archivoT = "src/Ficheros/Torneos.csv";
		BufferedReader br = null;
		String linea = "";
	
		try {
		    br = new BufferedReader(new InputStreamReader(new FileInputStream (archivoT), "UTF8"));
		    linea = br.readLine();
		    
		    while ((linea = br.readLine()) != null) {                
		        String[] dato = new String[3];
		        dato = dividePorComas(linea);
		        model.addRow(dato);
		    }

		    
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if (br != null) {
		        try {
		            br.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
	}

}

package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GrandSlam.HistoriaGrandSlam;
import GrandSlam.Resultado;
import GrandSlam.Tenista;

public class VentanaResultados extends JPanel {
	
	public static  String anyo1 = null;
	public static String torneo1 = null;
	public static  String ganador1 = null;
	public static String rankingGanador1 = null;
	public static  String paisGanador1 = null;
	public static String subcampeon1 = null;
	public static  String rankingSubcampeon1 = null;
	public static String paisSubcampeon1 = null;
	public static  String resultadoFinal1 = null;

	
	private DefaultTableModel model = new DefaultTableModel();
	private static JTable tablaResultados = new JTable();
	private JScrollPane resultadosScroll = new JScrollPane();
	static JPanel panelResultados = new JPanel();
	private JPanel sur = new JPanel();
	JButton botonAñadir = new JButton("Añadir");
	JButton botonGuardar = new JButton("Guardar");
	public TreeMap<String, Tenista> hashMapVictoriasTotalesTenistas = new TreeMap<>();	
	static String[] x = new String[3];
	String[] arrayCabecerasResultados = new String[9];
	
	
	public VentanaResultados () {
		
		setLayout(null);
		sur.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelResultados.setLayout(new BorderLayout());
		
		tablaResultados.setModel(model);
		
		model.addColumn("Year");
		model.addColumn("Major#");
		model.addColumn("Champion");
		model.addColumn("Seed_Champion");
		model.addColumn("Ctry_Champion");
		model.addColumn("Runner-up");
		model.addColumn("Seed_Runner-up");
		model.addColumn("Ctry_Runner-up");
		model.addColumn("Score in the Final");
		
		leerCSV();
		sur.add(botonAñadir);
		sur.add(botonGuardar);
		
		panelResultados.add(sur, BorderLayout.SOUTH);
		
		resultadosScroll.setViewportView(tablaResultados);
		panelResultados.add(resultadosScroll, BorderLayout.CENTER);
		
		
		tablaResultados.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (tablaResultados.getSelectedColumn() == 2) {
					JOptionPane.showMessageDialog(null, tablaResultados.getValueAt(tablaResultados.getSelectedRow(), tablaResultados.getSelectedColumn())
							+ "\nCabeza de serie en este torneo: " + tablaResultados.getValueAt(tablaResultados.getSelectedRow(), 3));
				}
			}
		});
		
		botonAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object[] torneos = {"Roland Garros", "Australian Open", "Wimbledon", "US Open"};
				
				JComboBox comboBoxTorneos = new JComboBox(torneos); comboBoxTorneos.setSelectedIndex(1);
				
				String anyo = JOptionPane.showInputDialog("Año del torneo: ");
				String torneoCodigo = (String) JOptionPane.showInputDialog(null, "Torneo:", "Entrada", JOptionPane.QUESTION_MESSAGE, null, torneos, torneos[0]);
				String major = null;
				
				if (torneoCodigo == "US Open") {major = "4";}
				else if (torneoCodigo == "Wimbledon") {major = "3";}
				else if (torneoCodigo == "Roland Garros") {major = "2";}
				else if (torneoCodigo == "Australian Open") {major = "1";}
				
				String ganador = JOptionPane.showInputDialog("Tenista ganador: ");
				String rankingGanador = JOptionPane.showInputDialog("Ranking del tenista ganador");
				String paisGanador = JOptionPane.showInputDialog("Pais del tenista ganador");
				String subcampeon = JOptionPane.showInputDialog("Tenista subcampeon");
				String rankingSubcampeon = JOptionPane.showInputDialog("Ranking del tenista subcampeon");
				String paisSubcampeon = JOptionPane.showInputDialog("Pais del tenista subcampeon");
				String resultadoPartido = JOptionPane.showInputDialog("Resultado del partido: ");
				
				
				String[] nuevoResultado = new String[9];
				nuevoResultado[0] = anyo;
				nuevoResultado[1] = major;
				nuevoResultado[2] = ganador;
				nuevoResultado[3] = rankingGanador;
				nuevoResultado[4] = paisGanador;
				nuevoResultado[5] = subcampeon;
				nuevoResultado[6] = rankingSubcampeon;
				nuevoResultado[7] = paisSubcampeon;
				nuevoResultado[8] = resultadoPartido;
				model.addRow(nuevoResultado);
				
				anyo1 = anyo;
				torneo1 = major;
				ganador1 = ganador;
				rankingGanador1 = rankingGanador;
				paisGanador1 = paisGanador;
				subcampeon1 = subcampeon;
				rankingSubcampeon1 = rankingSubcampeon;
				paisSubcampeon1 = paisSubcampeon;
				resultadoFinal1 = resultadoPartido;
								
				int vic = 1;
				for (Tenista t: hashMapVictoriasTotalesTenistas.values()) {
					if (t.getNombre().equals(ganador)) {
						vic = t.getVictoriasTotales() + 1;
						Tenista nuevoGanador = new Tenista(ganador, paisGanador, vic);
						hashMapVictoriasTotalesTenistas.put(ganador, nuevoGanador);
					} 
				}
				
				Tenista nuevoGanador1 = new Tenista(ganador, paisGanador, vic);
				hashMapVictoriasTotalesTenistas.put(ganador, nuevoGanador1);
				VentanaTenistas.leerHM(hashMapVictoriasTotalesTenistas);
			}
			
			
			
		});
		
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarCSV();
				
			}
		});
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
	
	public void guardarCSV () {
			FileWriter fw = null;
			try {
				fw = new FileWriter("src/Ficheros/Grand Slam Championships, Champion vs Runner-up, Men's Singles, 1968-2021.csv");
			BufferedWriter bw = new BufferedWriter(fw);
			
			
			arrayCabecerasResultados[0] = "Year";
			arrayCabecerasResultados[1] = "Major#";
			arrayCabecerasResultados[2] = "Champion";
			arrayCabecerasResultados[3] = "Seed_Champion";
			arrayCabecerasResultados[4] = "Ctry_Champion";
			arrayCabecerasResultados[5] = "Runner-up";
			arrayCabecerasResultados[6] = "Seed_Runner-up";
			arrayCabecerasResultados[7] = "Ctry_Runner-up";
			arrayCabecerasResultados[8] = "Score in the Final";
			

			for(int i=0; i <= arrayCabecerasResultados.length-2; i++){
				String cab =(('"' + (String) arrayCabecerasResultados[i] + '"' + ","));
				bw.write(cab);
			}
			bw.write('"'+(String)arrayCabecerasResultados[arrayCabecerasResultados.length-1] + '"');
			bw.write("\n");
			
			Resultado rNuevo = new Resultado(anyo1, torneo1, ganador1, rankingGanador1, paisGanador1, subcampeon1, rankingSubcampeon1, paisSubcampeon1, resultadoFinal1);
			HistoriaGrandSlam.arrayListResultadosOrientadoA.add(rNuevo);

			for(Resultado r: HistoriaGrandSlam.arrayListResultadosOrientadoA) {
				bw.write(r.getAnyo()+ ",");
				bw.write(r.getTorneo()+ ",");
				bw.write('"' +r.getGanador()+ '"' +",");
				bw.write(r.getRankingGanador()+ ",");
				bw.write('"' +r.getPaisGanador()+'"' + ",");
				bw.write('"' +r.getSubcampeon()+'"' + ",");
				bw.write(r.getRankingSubcampeon()+ ",");
				bw.write('"' +r.getPaisSubcampeon()+ '"' +",");
				bw.write('"' +r.getResultadoFinal()+'"');
				bw.write("\n");
			}
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void leerCSV () {
		String archivoR = "src/Ficheros/Grand Slam Championships, Champion vs Runner-up, Men's Singles, 1968-2021.csv";
		BufferedReader br = null;
		String linea = "";
	
		try {
		    br = new BufferedReader(new InputStreamReader(new FileInputStream (archivoR), "UTF8"));
		    linea = br.readLine();
		    
		    hashMapVictoriasTotalesTenistas.clear();
		    while ((linea = br.readLine()) != null) {                
		        String[] dato = new String[9];
		        dato = dividePorComas(linea);
		        model.addRow(dato);
		        sumarVictorias(dato); 
		       
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
		System.out.println(hashMapVictoriasTotalesTenistas);
	}
	
	
	public void sumarVictorias (String[] dato) {
		if (hashMapVictoriasTotalesTenistas.containsKey(dato[2])) {
			hashMapVictoriasTotalesTenistas.replace(dato[2], new Tenista(dato[2], dato[4], hashMapVictoriasTotalesTenistas.get(dato[2]).getVictoriasTotales() + 1));
			
		} else {
			Tenista tenistaNuevoGanador = new Tenista(dato[2], dato[4], 1);
			Tenista tenistaNuevoPerdedor = new Tenista(dato[5], dato[7], 0);
			
			hashMapVictoriasTotalesTenistas.put(dato[2], tenistaNuevoGanador);
			hashMapVictoriasTotalesTenistas.put(dato[2], tenistaNuevoPerdedor);
		}
	}

	public static JTable getTablaResultados() {
		return tablaResultados;
	}
}

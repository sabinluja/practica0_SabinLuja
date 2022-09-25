package GrandSlam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class HistoriaGrandSlam {

	private ArrayList<String> arrayListCodigoTorneos = new ArrayList();
    private static ArrayList<String> arrayListResultadosBonito = new ArrayList();
    public static ArrayList<Resultado> arrayListResultadosOrientadoA = new ArrayList();
    private ArrayList<String> arrayListNombreTorneos = new ArrayList();
    private HashMap<String, ArrayList> hashMapTorneosTotales = new HashMap<>();
    private HashMap<String, ArrayList> hashMapCodigosTorneosTotales = new HashMap<>();
	
	public static String[] dividePorComas( String linea ) {
		ArrayList<String> listaTokens = new ArrayList<String>();
		boolean entreComillas = false;
		StringBuilder b = new StringBuilder();
		
		for (char c : linea.toCharArray()) {
			if (c==',') {
				if (entreComillas) {
					b.append(c);
				} else {
					listaTokens.add(b.toString());
					b = new StringBuilder();
				}
			} else if (c=='\"') {
				entreComillas = !entreComillas;
			} else {
				b.append(c);
			}
		}
		
		listaTokens.add(b.toString());
		return listaTokens.toArray(new String[0]);
	}

	public void leerCSVGS() {
		String archivoT = "src/Ficheros/Grand Slam Championships, Champion vs Runner-up, Men's Singles, 1968-2021.csv";
		BufferedReader br = null;
		String linea = "";
	
		try {
		    br = new BufferedReader(new InputStreamReader(new FileInputStream (archivoT), "UTF-8"));
		    linea = br.readLine();
		    
		    while ((linea = br.readLine()) != null) {
		        String[] dato = new String[9];
		        dato = dividePorComas(linea);
		        arrayListResultadosBonito.add("(" + dato[0]);
		        arrayListResultadosBonito.add(dato[1]);
		        arrayListResultadosBonito.add(dato[2]);
		        arrayListResultadosBonito.add(dato[3]);
		        arrayListResultadosBonito.add(dato[4]);
		        arrayListResultadosBonito.add(dato[5]);
		        arrayListResultadosBonito.add(dato[6]);
		        arrayListResultadosBonito.add(dato[7]);  
		        arrayListResultadosBonito.add(dato[8] +")");
		        
		        Resultado r = new Resultado(dato[0], dato[1],dato[2],dato[3], dato[4], dato[5], dato[6], dato[7], dato[8]);
		        arrayListResultadosOrientadoA.add(r);
		    }
		    
		    System.out.println(arrayListResultadosBonito);
		    System.out.println(arrayListResultadosOrientadoA);
		    
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
	
	public void leerCSVTORNEOS() {
		String archivoT = "src/Ficheros/Torneos.csv";
		BufferedReader br = null;
		String linea = "";
	
		try {
		    br = new BufferedReader(new InputStreamReader(new FileInputStream (archivoT), "UTF8"));
		    linea = br.readLine();
		    
		    while ((linea = br.readLine()) != null) {
		        String[] dato = new String[3];
		        dato = dividePorComas(linea);
		        arrayListNombreTorneos.add(dato[1]);
		        arrayListCodigoTorneos.add(dato[0]);
		        hashMapTorneosTotales.put("Torneo: ", arrayListNombreTorneos);
		        hashMapCodigosTorneosTotales.put("Codigo: ", arrayListCodigoTorneos); 
		    }
		    System.out.println(hashMapTorneosTotales);
		    System.out.println(hashMapCodigosTorneosTotales);
		    
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

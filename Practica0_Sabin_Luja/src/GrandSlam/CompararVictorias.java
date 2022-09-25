package GrandSlam;

import java.util.Comparator;

public class CompararVictorias implements Comparator<Tenista>{
	public int compare(Tenista t1, Tenista t2) {
		Integer victoria1 = t1.getVictoriasTotales();		
		Integer victoria2 = t2.getVictoriasTotales();
		return victoria2.compareTo(victoria1);	
	}
}

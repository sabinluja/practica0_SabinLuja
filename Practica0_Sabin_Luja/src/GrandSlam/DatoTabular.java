package GrandSlam;

import java.util.ArrayList;

public abstract class DatoTabular {
	protected ArrayList<String> listaCabeceras = new ArrayList<>();
	protected ArrayList<Class<?>> listaTipos = new ArrayList<>();
	protected ArrayList<String> listaValores = new ArrayList<>();
	
	public DatoTabular(ArrayList<String> listaCabeceras, ArrayList<Class<?>> listaTipos, ArrayList<String> listaValores) {
		this.listaCabeceras = listaCabeceras;
		this.listaTipos = listaTipos;
		this.listaValores = listaValores;
	}

	public ArrayList<String> getListaCabeceras() {
		return listaCabeceras;
	}
	
	public void setListaCabeceras(ArrayList<String> listaCabeceras) {
		this.listaCabeceras = listaCabeceras;
	}
	
	public ArrayList<Class<?>> getListaTipos() {
		return listaTipos;
	}
	
	public void setListaTipos(ArrayList<Class<?>> listaTipos) {
		this.listaTipos = listaTipos;
	}
	
	public ArrayList<String> getListaValores() {
		return listaValores;
	}
	
	public void setListaValores(ArrayList<String> listaValores) {
		this.listaValores = listaValores;
	}
	
	public 	Object getValor(String cabecera) {
		int posicion = listaCabeceras.indexOf(cabecera);
		return listaValores.get(posicion);
		
	}
	
	public void setValor (int posicion, Object valor) {
		listaValores.set(posicion, (String) valor);
	}

}

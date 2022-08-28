package br.com.dio;

import java.util.ArrayList;
import java.util.List;

public class ExercArrayList {
	
	private List<Double> notas = new ArrayList<Double>();
	
	public void adicionarLista(Double value) {
		notas.add(value);
	}
	
	public List<Double> getList() {
		return notas;
	}
}

package br.com.Program;

import java.util.*;
import java.util.Map.Entry;

public class Program {

	public static void main(String[] args) {
		Map<String, Integer> estados = new HashMap<String, Integer>() {{
			put("PE", 9616621);
			put("AL", 3351543);
			put("CE", 9187103);
			put("RN", 3534265);
		}};
		
		System.out.println("##############################");
		
		System.out.println("Altere RN para 3543165 de população: ");
		estados.put("RN", 3543165);
		for(Map.Entry<String, Integer> estado: estados.entrySet()) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
		
		System.out.println("##############################");
		
		System.out.println("Confira se PB existe, caso não adicione ao dicionario: ");
		if(!estados.containsKey("PB")) {
			estados.put("PM", 4039277);
		}
		for(Map.Entry<String, Integer> estado: estados.entrySet()) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
		
		System.out.println("##############################");
		
		System.out.println("Exiba a população de PE: " + estados.get("PE"));

		System.out.println("##############################");
		
		System.out.println("Ordem Aleatória: ");
		for(Map.Entry<String, Integer> estado: estados.entrySet()) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
		
		System.out.println("##############################");
		
		System.out.println("Ordem Alfabética: ");
		Map<String, Integer> estados2 = new TreeMap<>() {{
			put("PE", 9616621);
			put("AL", 3351543);
			put("CE", 9187103);
			put("RN", 3534265);
		}};
		for(Map.Entry<String, Integer> estado: estados2.entrySet()) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
		
		System.out.println("##############################");
		
		System.out.println("Ordem por populacao: ");
		Set<Map.Entry<String, Integer>> estados3 = new TreeSet<>(new ComparatorEstadoPopulacao());
		estados3.addAll(estados.entrySet());
		for(Map.Entry<String, Integer> estado: estados3) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
		
		System.out.println("##############################");
		
		String maiorEstadoNome = "";
		int maiorEstado = Collections.max(estados.values());
		String menorEstadoNome = "";
		int menorEstado = Collections.min(estados.values());
		for(Map.Entry<String, Integer> estado: estados.entrySet()) {
			if(estado.getValue().equals(maiorEstado)) maiorEstadoNome = estado.getKey();
			if(estado.getValue().equals(menorEstado)) menorEstadoNome = estado.getKey();
		}
		
		System.out.println("Exiba o estado com maior população: " + maiorEstadoNome + " - " + maiorEstado);
		System.out.println("Exiba o estado com menor população: " + menorEstadoNome + " - " + menorEstado);
		
		System.out.println("##############################");
		
		Iterator<Map.Entry<String, Integer>> i = estados.entrySet().iterator();
		int total = 0;
		while(i.hasNext()) {
			total += i.next().getValue(); 
		}
		System.out.println("Soma da população de todos os estados: " + total);
		
		System.out.println("##############################");
		
		System.out.println("Média da população do dicionário: " + (total/estados.size()));
		
		System.out.println("##############################");
		
		System.out.println("Remova os estados que tem menos 4000000 de população: ");
		Iterator<Map.Entry<String, Integer>> i2 = estados.entrySet().iterator();
		while(i2.hasNext()) {
			if(i2.next().getValue() < 4000000) i2.remove();
		}
		for(Map.Entry<String, Integer> estado: estados.entrySet()) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
		
		System.out.println("##############################");
		
		System.out.println("Limpando o dicionário");
		estados.clear();
		System.out.println("Dicionário está vazio? " + estados.isEmpty());
		
	}
	
}

class ComparatorEstadoPopulacao implements Comparator<Map.Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		int populacao = o1.getValue().compareTo(o2.getValue());
		if(populacao != 0) {
			return populacao;
		}
		
		return o1.getKey().compareToIgnoreCase(o2.getKey());
	}
	
}
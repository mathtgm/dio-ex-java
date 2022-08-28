package br.com.Program;

import java.util.*;

public class Program {

	public static void main(String[] args) {
		
		List<Integer> lancamentos = new ArrayList<Integer>();
		Map<Integer, Integer> lancamentos2 = new LinkedHashMap<>() {{
			put(1,0);
			put(2,0);
			put(3,0);
			put(4,0);
			put(5,0);
			put(6,0);
		}};
		Random rand = new Random();
		
		for(int i = 0; i < 100; i++) {
			lancamentos.add(rand.nextInt(6) + 1);
		}
		
		for(int i = 1; i <= 6; i++) {
			for(int i2 = 0; i2 < lancamentos.size() ; i2++) {
				if(lancamentos.get(i2) == i) {
					int totalAtual = lancamentos2.get(i);
					totalAtual++;
					lancamentos2.put(i, totalAtual);
				}
			}
			
		}
		
		for(Map.Entry<Integer, Integer> numero : lancamentos2.entrySet()) {
			System.out.println(numero.getKey() + " - " + numero.getValue());
		}
	}

}

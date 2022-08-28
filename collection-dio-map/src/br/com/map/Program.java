package br.com.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {
		
		Map<String, Double> carrosPopulares = new HashMap<>() {{
			put("gol", 14.4);
			put("uno", 15.6);
			put("mobi", 16.1);
			put("hb20", 14.5);
			put("kwid", 15.6);
		}};
		
		 System.out.println(carrosPopulares.toString());
		 
		 carrosPopulares.put("gol", 15.2);
		 System.out.println("Substitua o consumo do gol para 15.2: "+ carrosPopulares.toString());
		 
		 System.out.println("Confira se o modelo tucson está no dicionario? " + carrosPopulares.containsKey("tucson"));
		 System.out.println("Confira se o modelo uno está no dicionario? " + carrosPopulares.containsKey("uno"));
		 System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));
		 System.out.println("Exiba o terceiro modelo adicionado: Não tem método");
		 System.out.println("Exiba os modelos: " + carrosPopulares.keySet());
		 System.out.println("Exiba os consumos dos carros: " + carrosPopulares.values().toString());
		 
		 Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
		 Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
		 String modeloMaisEficiente =  "";
		 for(Map.Entry<String, Double> entry : entries) {
			 if(entry.getValue().equals(consumoMaisEficiente)) {
				 modeloMaisEficiente = entry.getKey();
				 System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
			 }
		 }
		
		 Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
		 String modeloMenosEficiente = "";
		 
		 for(Map.Entry<String, Double> entry : entries) {
			 if(entry.getValue().equals(consumoMenosEficiente)) {
				 modeloMenosEficiente = entry.getKey();
				 System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente); 
			 }
		 }
		 
		 Double soma = 0.0;
		 Iterator<Double> iterator = carrosPopulares.values().iterator();
		 while(iterator.hasNext()) {
			 soma += iterator.next();
		 }
		 System.out.println("Exiba a soma dos consumos: " + soma);
		 
		 System.out.println("Exiba a média dos consumos deste dicionário de carros: " + (soma/carrosPopulares.size()));
		 
		 Iterator<Double> iterator1 = carrosPopulares.values().iterator();
		 while(iterator1.hasNext()) {
			 if(iterator1.next().equals(15.6)) {
				 iterator1.remove();
			 }
		 }
		 System.out.println("Remova os modelos com o consumo igual a 15.6 km/l: " + carrosPopulares);
		 
		 Map<String, Double> carrosPopulares2 = new LinkedHashMap<>() {{
				put("gol", 14.4);
				put("uno", 15.6);
				put("mobi", 16.1);
				put("hb20", 14.5);
				put("kwid", 15.6);
			}};
		 System.out.println("Exiba os carros na ordem inserida: " + carrosPopulares2);
		 
		 Map<String, Double> carrosPopulares3 = new TreeMap<>(carrosPopulares);
		 System.out.println("Exiba o dicionario ordenado pelo modelo: " + carrosPopulares3.toString());
		 
		 
		 System.out.println("Apague o dicionario de carro");
		 carrosPopulares.clear();
		 
		 System.out.println("Confira se o dicinario de carro está vazio: " + carrosPopulares.isEmpty());
	}

}

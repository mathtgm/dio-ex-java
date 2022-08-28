package br.com.arcoIris;

import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Program {

	public static void main(String[] args) {

		Set<String> arcoIris = new HashSet<>() {{
			add("Vermelho");
			add("Laranja");
			add("Verde");
			add("Azul");
			add("Anil");
			add("Violeta");
		}};
		
		System.out.println("Cores do arco iris: " + arcoIris);
		System.out.println("O arco iris tem " + arcoIris.size() + " cores");
		
		Set<String> arcoIris2 = new TreeSet<>(arcoIris);
		System.out.println("Ordem Alfabética: " + arcoIris2);
		
		TreeSet<String> arcoIris3 = new TreeSet<>(arcoIris);
		System.out.println("Ordem invertida: " + arcoIris3.descendingSet());
		
		System.out.println("Core que começam com V: ");
		Iterator<String> i = arcoIris3.iterator();
		while(i.hasNext()) {
			String next = i.next();
			if(next.charAt(0) == 'V') {
				System.out.println(next);
			}
		}
		
		Iterator<String> i2 = arcoIris3.iterator();
		while(i2.hasNext()) {
			String next = i2.next();
			if(next.charAt(0) != 'V') {
				i2.remove();
			}
		}
		System.out.println("Remove cores que não começam com V: " + arcoIris3);
		
		arcoIris3.clear();
		System.out.println("Limpando o conjunto 3");
		
		System.out.println("O conjunto 3 está vazio? " + arcoIris3.isEmpty());
		System.out.println("O conjunto 1 está vazio? " + arcoIris.isEmpty());
		
	}
	
	
}


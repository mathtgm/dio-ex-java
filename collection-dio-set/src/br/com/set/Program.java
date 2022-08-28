package br.com.set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program {

	public static void main(String[] args) {
		
		Set<Double> notas = new HashSet<>(Arrays.asList(1.0, 2.0, 3.0, 6.7, 8.1, 3.1, 1.0, 1.0));
		System.out.println("Notas: " + notas.toString());
		
		System.out.println("Exiba a posição da nota 5: O HashSet não tem método de pegar posição, pois ele as insere aleatóriamente");
		
		System.out.println("Adicione na lista a nota 8.0 na posição 4: O HashSet não tem método de colocar um objeto em uma posição especifica");
		
		System.out.println("Substitua a nota 5.0 pela nota 6.0: Não tem método");
		
		System.out.println("Confira se a nota 3.0 está no conjunto: " + notas.contains(3.0));
		
		System.out.println("Exiba a terceira nota adicionada: Não existe método pra isso");
		
		System.out.println("Exiba a menor nota: " + Collections.min(notas));
		
		System.out.println("Exiba a maior nota: " + Collections.max(notas));
		
		Iterator<Double> i = notas.iterator();
		Double soma = 0.00;
		
		while(i.hasNext()) {
			Double next = i.next();
			soma += next;
		}
		
		System.out.println("Exiba a soma dos valores: " + soma);
		
		System.out.println("Exiba a média das notas: " + (soma / notas.size()));
		
		notas.remove(0.00);
		System.out.println("Remove a nota 0.0: " + notas.toString());
		
		System.out.println("Remova a nota na posição 0: Não é possível");
		
		Iterator<Double> i2 = notas.iterator();
		while(i2.hasNext()) {
			Double next = i2.next();
			if(next < 7.0) {
				i2.remove();
			}
		}
		System.out.println("Remove as notas menores que 7: " + notas.toString());
		
		System.out.println("Exiba todas as notas na ordem em que foram informadas: Não é possível!(Com LinkedHashSet dá!)");
		Set<Double> notas2 = new LinkedHashSet<>();
		
		notas2.add(3.4);
		notas2.add(10.0);
		notas2.add(4.6);
		notas2.add(9.1);
		notas2.add(7.8);
		notas2.add(1.2);
		
		System.out.println("Exiba todas as notas na ordem em que foram informadas(LinkedHashSet): " + notas2.toString());
		
		
		Set<Double> notas3 = new TreeSet<>(notas2);
		System.out.println("Exiba todas as notas na ordem crescente(TreeSet): " + notas3.toString());
		
		notas.clear();
		System.out.println("Apague todo o conjunto 1");
		
		System.out.println("Verifique se o conjunto 1 está vazio: " + notas.isEmpty());
		System.out.println("Verifique se o conjunto 2 está vazio: " + notas2.isEmpty());
		
	}

}

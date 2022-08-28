package br.com.dio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		ExercArrayList arrayList = new ExercArrayList();
		
		arrayList.adicionarLista(7.0);
		arrayList.adicionarLista(8.5);
		arrayList.adicionarLista(9.4);
		arrayList.adicionarLista(5.1);
		arrayList.adicionarLista(7.2);
		arrayList.adicionarLista(10.0);
		
		System.out.println(arrayList.getList());
		System.out.println("Exiba a posição da nota 5.1: " + arrayList.getList().indexOf(5.1));
		arrayList.getList().add(4, 8.0);
		System.out.println("Adicione na lista a nota 8.0 na 4 posição: " + arrayList.getList());
		
		arrayList.getList().set(arrayList.getList().indexOf(5.1), 6.0);
		System.out.println("Substitua a nota 5.1 pela nota 6.0: " + arrayList.getList());
		
		System.out.println("Confira se a nota 5.0 está na lista: " + arrayList.getList().contains(5.0));
		
		System.out.println("Exiba a terceira nota adicionada: " + arrayList.getList().get(2));
		
		System.out.println("Retorna a menor nota: " + Collections.min(arrayList.getList()));
		
		System.out.println("Retorna a maior nota: " + Collections.max(arrayList.getList()));
		
		
		Iterator<Double> i = arrayList.getList().iterator();
		Double total = 0.0;
		while(i.hasNext()) {
			Double next = i.next();
			total += next;
		}
		System.out.println("Retorna a soma de todos os elementos: " + total);
		
		System.out.println("Média da lista: " + total / arrayList.getList().size());
		
		arrayList.getList().remove(10.0);
		System.out.println(arrayList.getList());
		
		System.out.println("Remova todos os elementos menores que 7: ");
		Iterator<Double> i2 = arrayList.getList().iterator();
		while(i2.hasNext()) {
			Double next = i2.next();
			if(next < 7) {
				i2.remove();
			}
		}
		
		System.out.println(arrayList.getList());
		
		System.out.println("Limpar a lista: ");
		arrayList.getList().clear();
		System.out.println(arrayList.getList());
		
		System.out.println("A lista está vazia? " + arrayList.getList().isEmpty());
		
		
		System.out.println("#### Ordenação de lista ####");
		
		List<Gato> meusGatos = new ArrayList<Gato>() {{
			add(new Gato("Nala", 18, "Tricolor"));
			add(new Gato("Mia", 20, "Branca"));
			add(new Gato("Salem", 30, "Branco e Marrom"));
		}};
		
		
		System.out.println("Ordenação por inserção: " + meusGatos);
		
		Collections.shuffle(meusGatos);
		System.out.println("Ordenação aleatória: " + meusGatos);
		
		Collections.sort(meusGatos);
		System.out.println("Ordenação natural(nome): " + meusGatos);
		
		Collections.sort(meusGatos, new ComparatorIdade());
		System.out.println("Ordenação por idade: " + meusGatos);
		
		Collections.sort(meusGatos, new ComparatorCor());
		System.out.println("Ordenação por Cor: " + meusGatos);
		
		Collections.sort(meusGatos, new ComparatorNomeCorIdade());
		System.out.println("Ordenação por Nome/Cor/Idade: " + meusGatos);
		
		
	}
	
	static class Gato implements Comparable<Gato>{
		
		private String nome;
		private int idade;
		private String cor;
		
		public Gato() {}
		
		public Gato(String nome, int idade, String cor) {
			this.nome = nome;
			this.idade = idade;
			this.cor = cor;
		}



		public String getNome() {
			return nome;
		}



		public void setNome(String nome) {
			this.nome = nome;
		}



		public int getIdade() {
			return idade;
		}



		public void setIdade(int idade) {
			this.idade = idade;
		}


		public String getCor() {
			return cor;
		}



		public void setCor(String cor) {
			this.cor = cor;
		}
		
		@Override
		public String toString() {
			return "{ Nome: " + nome + " Idade: " + idade + " Cor: " + cor + " }";
		}

		@Override
		public int compareTo(Gato gato) {
			return this.getNome().compareToIgnoreCase(gato.getNome());
		}
		
	}
	
	static class ComparatorIdade implements Comparator<Gato> {

		@Override
		public int compare(Gato o1, Gato o2) {
			return Integer.compare(o1.getIdade(), o2.getIdade());
		}
		
	}
	
	static class ComparatorCor implements Comparator<Gato> {

		@Override
		public int compare(Gato o1, Gato o2) {
			return o1.getCor().compareToIgnoreCase(o2.getCor());
		}
		
	}
	
	static class ComparatorNomeCorIdade implements Comparator<Gato> {

		@Override
		public int compare(Gato o1, Gato o2) {
			int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
			if (nome != 0) return nome;
			
			int cor = o1.getCor().compareToIgnoreCase(o2.getCor());
			if (cor != 0) return cor;
			
			return Integer.compare(o1.getIdade(), o2.getIdade());
		}
		
	}

}



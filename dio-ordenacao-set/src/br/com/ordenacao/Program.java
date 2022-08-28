package br.com.ordenacao;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Program {

	public static void main(String[] args) {
		
		Set<Serie> series = new HashSet<>() {{
			add(new Serie("Sandman", "Fantasia", 60.0));
			add(new Serie("A advogada extraiordinaria", "Drama", 50.0));
			add(new Serie("Key House", "Fantasia", 70.0));
		}};
		
		System.out.println("Ordem Aleatória");
		for(Serie serie : series) {
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.tempoEpisodio);
		}
		
		Set<Serie> series2 = new LinkedHashSet<>() {{
			add(new Serie("Sandman", "Fantasia", 60.0));
			add(new Serie("A advogada extraiordinaria", "Drama", 34.0));
			add(new Serie("Key House", "Fantasia", 40.0));
		}};
		System.out.println("Ordem de inserção(LinkedHashSet)");
		for(Serie serie : series2) {
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.tempoEpisodio);
		}
		
		System.out.println("Ordem natural (TempoEp)");
		Set<Serie> series3 = new TreeSet<>(series);
		System.out.println(series3.toString());
		
		Set<Serie> series4 = new TreeSet<>(new ClassificaSerie());
		series4.addAll(series);
		System.out.println("Ordem por Nome/Gênero/TempEP");
		System.out.println(series4.toString());
		
		Set<Serie> series5 = new TreeSet<Serie>(new ClassificaGenero());
		series5.addAll(series);
		System.out.println("Ordem por Genero");
		System.out.println(series5.toString());
		
		Set<Serie> series6 = new TreeSet<Serie>(new ClassificaTempoEP());
		series6.addAll(series);
		System.out.println("Ordem por tempo");
		System.out.println(series6.toString());
		
		
		
	}
	
	public static class ClassificaTempoEP implements Comparator<Serie> {

		@Override
		public int compare(Serie o1, Serie o2) {
			int tempoEP = Double.compare(o1.getTempoEpisodio(), o2.getTempoEpisodio());
			if(tempoEP != 0) {
				return Double.compare(o1.getTempoEpisodio(), o2.getTempoEpisodio());
			}
			return o1.getNome().compareToIgnoreCase(o2.getNome());
		}
		
	}
	
	public static class ClassificaGenero implements Comparator<Serie> {

		@Override
		public int compare(Serie o1, Serie o2) {
			int genero = o1.getGenero().compareToIgnoreCase(o2.getGenero());
			if(genero != 0) return genero;
			return o1.getNome().compareToIgnoreCase(o2.getNome());
		}
		
	}
	
	public static class ClassificaSerie implements Comparator<Serie> {

		@Override
		public int compare(Serie o1, Serie o2) {
			int tempEP = Double.compare(o1.getTempoEpisodio(), o2.getTempoEpisodio());
			int genero = o1.getGenero().compareToIgnoreCase(o2.getGenero());
			int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
			
			if(nome != 0) return nome;
			if(genero != 0) return genero;
			
			return tempEP;
		
		}
		
		
	}
	
	public static class Serie implements Comparable<Serie>{
		
		private String nome;
		private String genero;
		private Double tempoEpisodio;
		
		public Serie() {}
		
		public Serie(String nome, String genero, Double tempoEpisodio) {
			this.nome = nome;
			this.genero = genero;
			this.tempoEpisodio = tempoEpisodio;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getGenero() {
			return genero;
		}
		
		public void setGenero(String genero) {
			this.genero = genero;
		}
		
		public Double getTempoEpisodio() {
			return tempoEpisodio;
		}
		
		public void setTempoEpisodio(Double tempoEpisodio) {
			this.tempoEpisodio = tempoEpisodio;
		}
		
		@Override
		public String toString() {
			return "(Nome: " + nome + ", Genero: " + genero + ", Tempo Episodio: " + tempoEpisodio + ")";
		}

		@Override
		public int hashCode() {
			return Objects.hash(genero, nome, tempoEpisodio);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Serie other = (Serie) obj;
			return Objects.equals(genero, other.genero) && Objects.equals(nome, other.nome)
					&& Objects.equals(tempoEpisodio, other.tempoEpisodio);
		}

		@Override
		public int compareTo(Serie o) {
			int tempEP = Double.compare(this.getTempoEpisodio(), o.getTempoEpisodio());
			if(tempEP != 0) {
				return tempEP;
			}
			return this.getGenero().compareToIgnoreCase(o.getGenero());
		}
		
		
	}
}

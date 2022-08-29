package br.com.streamAPI;

import java.util.*;
import java.util.Map.Entry;

public class Program {

	public static void main(String[] args) {
		Map<Integer, Livro> livros = new HashMap<Integer, Livro>() {{
			put(1, new Livro("Psicose", 256));
			put(2, new Livro("Cosmic Edition: O mestre dos mestres para todas as gerações", 1000));
			put(3, new Livro("Herry Potter", 569));
		}};
		
		System.out.println("Ordem aleatória: ");
		for(Map.Entry<Integer, Livro> livro: livros.entrySet()) {
		
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
			
		}
		
		System.out.println("#########################");
		
		System.out.println("Ordem de inserção: ");
		Map<Integer, Livro> livros1 = new LinkedHashMap<Integer, Livro>() {{
			put(1, new Livro("Cosmic Edition: O mestre dos mestres para todas as gerações", 1000));
			put(2, new Livro("Herry Potter", 569));
			put(3, new Livro("Psicose", 256));
		}};
		
		for(Map.Entry<Integer, Livro> livro: livros1.entrySet()) {
		
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
			
		}
		
		System.out.println("#########################");
		
		System.out.println("Ordem alfabética: ");
		Map<Integer, Livro> livros2 = new TreeMap<>(livros1) {{
			put(1, new Livro("Psicose", 256));
			put(2, new Livro("Cosmic Edition: O mestre dos mestres para todas as gerações", 1000));
			put(3, new Livro("Herry Potter", 569));
		}};
		
		for(Map.Entry<Integer, Livro> livro: livros2.entrySet()) {
		
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
			
		}
		
		System.out.println("#########################");
		
		
		System.out.println("Ordenação por nome do livro (Função Anonima): ");
		Set<Map.Entry<Integer, Livro>> livros3 = new TreeSet<>(new Comparator<Map.Entry<Integer, Livro>>() {
			
			@Override
			public int compare(Map.Entry<Integer, Livro> livro1, Map.Entry<Integer, Livro> livro2) {
				int livro = livro1.getValue().getNome().compareToIgnoreCase(livro2.getValue().getNome());
				if(livro != 0) {
					return livro;
				}
				
				return livro1.getKey().compareTo(livro2.getKey());
			}
		});
		livros3.addAll(livros.entrySet());
		for(Map.Entry<Integer, Livro> livro: livros3) {
			
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
			
		}
		
		System.out.println("#########################");
		
		System.out.println("Ordenação por nome do livro (Função Lambda): ");
		Set<Map.Entry<Integer, Livro>> livrosLambda = new TreeSet<>(Comparator.comparing(
				comp -> comp.getValue().getNome()
		));
		livrosLambda.addAll(livros.entrySet());
		for(Map.Entry<Integer, Livro> livro: livrosLambda) {
			
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
			
		}
		
		System.out.println("#########################");
		
		System.out.println("Ordenação por quantidade de pagina do livro: ");
		Set<Map.Entry<Integer, Livro>> livros4 = new TreeSet<>(new ComparatorPaginaLivro());
		livros4.addAll(livros.entrySet());
		for(Map.Entry<Integer, Livro> livro: livros4) {
			
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - " + livro.getValue().getPaginas() + " Páginas");
			
		}
		
		System.out.println("#########################");
		
		System.out.println("Ordenação por quantidade de pagina do livro (Lambda): ");
		Set<Map.Entry<Integer, Livro>> livrosLambda2 = new TreeSet<>(Comparator.comparing(
				comp -> comp.getValue().getPaginas()
		));
		livrosLambda2.addAll(livros.entrySet());
		for(Map.Entry<Integer, Livro> livro: livrosLambda2) {
			
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - " + livro.getValue().getPaginas() + " Páginas");
			
		}
		
	}
	
}

class Livro {
	
	private String nome;
	private Integer paginas;
	
	public Livro() {}
	
	public Livro(String nome, Integer paginas) {
		super();
		this.nome = nome;
		this.paginas = paginas;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getPaginas() {
		return paginas;
	}
	
	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome, paginas);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(paginas, other.paginas);
	}	
	
}

class ComparatorNomeLivro implements Comparator<Map.Entry<Integer, Livro>> {

	@Override
	public int compare(Entry<Integer, Livro> o1, Entry<Integer, Livro> o2) {
		int nome = o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
		if(nome != 0) {
			return nome;
		}
		
		return o1.getKey().compareTo(o2.getKey());
	}

}

class ComparatorPaginaLivro implements Comparator<Map.Entry<Integer, Livro>> {

	@Override
	public int compare(Entry<Integer, Livro> o1, Entry<Integer, Livro> o2) {
		int pagina = o1.getValue().getPaginas().compareTo(o2.getValue().getPaginas());
		if(pagina != 0) {
			return pagina;
		}
		
		return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
	}
	
}


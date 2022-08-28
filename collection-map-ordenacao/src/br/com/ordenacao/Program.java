package br.com.ordenacao;

import java.util.*;
import java.util.Map.Entry;

public class Program {

	public static void main(String[] args) {
		Map<String, Livro> livros = new HashMap<String, Livro>() {{
			put("Bloch Robert", new Livro("Psicose", 256));
			put("H P Lovecraft", new Livro("Cosmic Edition: O mestre dos mestres para todas as gerações", 1000));
			put("J K Rolling", new Livro("Herry Potter", 569));
		}};
		
		System.out.println("Ordem aleatória: ");
		for(Map.Entry<String, Livro> livro: livros.entrySet()) {
		
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
			
		}
		
		System.out.println("#########################");
		
		System.out.println("Ordem de inserção: ");
		Map<String, Livro> livros1 = new LinkedHashMap<String, Livro>() {{
			put("H P Lovecraft", new Livro("Cosmic Edition: O mestre dos mestres para todas as gerações", 1000));
			put("J K Rolling", new Livro("Herry Potter", 569));
			put("Bloch Robert", new Livro("Psicose", 256));
		}};
		
		for(Map.Entry<String, Livro> livro: livros1.entrySet()) {
		
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
			
		}
		
		System.out.println("#########################");
		
		System.out.println("Ordem alfabética: ");
		Map<String, Livro> livros2 = new TreeMap<>(livros1) {{
			put("Bloch Robert", new Livro("Psicose", 256));
			put("H P Lovecraft", new Livro("Cosmic Edition: O mestre dos mestres para todas as gerações", 1000));
			put("J K Rolling", new Livro("Herry Potter", 569));
		}};
		
		for(Map.Entry<String, Livro> livro: livros2.entrySet()) {
		
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
			
		}
		
		System.out.println("#########################");
		
		
		System.out.println("Ordenação por nome do livro: ");
		Set<Map.Entry<String, Livro>> livros3 = new TreeSet<>(new ComparatorNomeLivro());
		livros3.addAll(livros.entrySet());
		for(Map.Entry<String, Livro> livro: livros3) {
			
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
			
		}
		
		System.out.println("#########################");
		
		System.out.println("Ordenação por quantidade de pagina do livro: ");
		Set<Map.Entry<String, Livro>> livros4 = new TreeSet<>(new ComparatorPaginaLivro());
		livros4.addAll(livros.entrySet());
		for(Map.Entry<String, Livro> livro: livros4) {
			
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

class ComparatorNomeLivro implements Comparator<Map.Entry<String, Livro>> {

	@Override
	public int compare(Entry<String, Livro> o1, Entry<String, Livro> o2) {
		int nome = o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
		if(nome != 0) {
			return nome;
		}
		
		return o1.getKey().compareToIgnoreCase(o2.getKey());
	}

}

class ComparatorPaginaLivro implements Comparator<Map.Entry<String, Livro>> {

	@Override
	public int compare(Entry<String, Livro> o1, Entry<String, Livro> o2) {
		int pagina = o1.getValue().getPaginas().compareTo(o2.getValue().getPaginas());
		if(pagina != 0) {
			return pagina;
		}
		
		return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
	}
	
}

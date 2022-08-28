package br.com.linguagem;
import java.util.Objects;

public class Linguagem implements Comparable<Linguagem>{
	
	private String nome;
	private int anoDeCriacao;
	private String ide;
	
	public Linguagem() {}

	public Linguagem(String nome, int anoDeCriacao, String ide) {
		super();
		this.nome = nome;
		this.anoDeCriacao = anoDeCriacao;
		this.ide = ide;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getAnoDeCriacao() {
		return anoDeCriacao;
	}



	public void setAnoDeCriacao(int anoDeCriacao) {
		this.anoDeCriacao = anoDeCriacao;
	}



	public String getIde() {
		return ide;
	}



	public void setIde(String ide) {
		this.ide = ide;
	}
	

	@Override
	public int compareTo(Linguagem o) {
		int nome = getNome().compareToIgnoreCase(o.getNome());
		if(nome != 0) {
			return nome;
		}
		
		return Double.compare(getAnoDeCriacao(), o.getAnoDeCriacao());
	}

	@Override
	public String toString() {
		return "Linguagem [nome=" + nome + ", anoDeCriacao=" + anoDeCriacao + ", ide=" + ide + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoDeCriacao, ide, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Linguagem other = (Linguagem) obj;
		return Objects.equals(anoDeCriacao, other.anoDeCriacao) && Objects.equals(ide, other.ide)
				&& Objects.equals(nome, other.nome);
	}
	
}

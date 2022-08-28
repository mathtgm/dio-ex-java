package br.com.linguagem;

import java.util.Comparator;

public class CompareableIDE implements Comparator<Linguagem>{

	@Override
	public int compare(Linguagem o1, Linguagem o2) {
		int ide = o1.getIde().compareToIgnoreCase(o2.getIde());
		int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
		
		if(ide != 0) return ide;
		if(nome != 0) return nome;
		
		return Double.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
	}

}

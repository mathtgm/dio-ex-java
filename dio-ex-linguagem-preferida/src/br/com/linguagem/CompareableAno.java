package br.com.linguagem;

import java.util.Comparator;

public class CompareableAno implements Comparator<Linguagem>{

	@Override
	public int compare(Linguagem o1, Linguagem o2) {
		int ano = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
		
		if(ano != 0) {
			return ano;
		}
		
		return o1.getNome().compareToIgnoreCase(o2.getNome());
	}

}

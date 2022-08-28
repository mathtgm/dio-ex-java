package br.com.linguagem;

import java.util.Comparator;

public class CompareableTUDO implements Comparator<Linguagem>{

	@Override
	public int compare(Linguagem o1, Linguagem o2) {
		int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
		int ano = Double.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
		int ide = o1.getIde().compareToIgnoreCase(o2.getIde());
		
		if(nome != 0) return nome;
		if(ano != 0) return ano;
		
		return ide;
	}

}

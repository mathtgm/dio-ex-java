package br.com.linguagem;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program {

	public static void main(String[] args) {
		
		Set<Linguagem> linguagens = new LinkedHashSet<>() {{
			add(new Linguagem("Java", 1900, "Eclipse"));
			add(new Linguagem("JavaScript", 2000, "VS Code"));
			add(new Linguagem("COBOL", 1, "???"));
		}};
		System.out.println("Ordenação por inserção: " + linguagens.toString());
		
		Set<Linguagem> linguagens2 = new TreeSet<Linguagem>(linguagens);
		System.out.println("Ordenação natural: " + linguagens2.toString());
		
		Set<Linguagem> linguagens3 = new TreeSet<Linguagem>(new CompareableIDE());
		linguagens3.addAll(linguagens);
		System.out.println("Ordenação por IDE: " + linguagens3.toString());
		
		Set<Linguagem> linguagens4 = new TreeSet<Linguagem>(new CompareableAno());
		linguagens4.addAll(linguagens);
		System.out.println("Ordenação por Ano de criação e Nome" + linguagens4.toString());
		
		Set<Linguagem> linguagens5 = new TreeSet<Linguagem>(new CompareableTUDO());
		linguagens5.addAll(linguagens);
		System.out.println("Ordenação por Nome/Ano/IDE: " + linguagens5.toString());
		
	}

}

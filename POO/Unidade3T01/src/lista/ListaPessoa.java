package lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListaPessoa {

	public static void main(String[] args) {
		
		List<Pessoa> lista = new ArrayList<>();
		
		Pessoa p1 = new Pessoa("Kevin",35);
		Pessoa p2 = new Pessoa("Fernanda",34);
		Pessoa p3 = new Pessoa("Issac",1);
		
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		for (Pessoa p : lista) {
			System.out.println("Nome: " + p.getNome()+ " - Idade: "+p.getIdade());
			
		}
		System.out.println("");
		
		Collections.sort(lista);
		for (Pessoa p : lista) {
			System.out.println("Nome: " + p.getNome()+ " - Idade: "+p.getIdade());
			
		}
	}
}

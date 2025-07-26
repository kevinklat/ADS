package lista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> lista = new ArrayList<>();
		
		lista.add("Kevin");
		lista.add("Fernanda");
		lista.add("Issac");
		
		lista.remove("Kevin");
		
		for (String s : lista) {
		 System.out.println("Nome: "+ s);
		}
		

	}

}

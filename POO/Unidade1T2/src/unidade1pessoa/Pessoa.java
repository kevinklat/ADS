
package unidade1pessoa;


public class Pessoa {
	
	String nome;
	int idade;
	
	 void falar() {
		 System.out.println("Olá Mundo");
		 
	 }

	public static void main(String[] args) {


	Pessoa p1 = new Pessoa();
	p1.nome = "Kevin";
	p1.idade = 34;
	
	System.out.println(p1.nome);
	System.out.println(p1.idade);
	p1.falar();
		
	Pessoa p2 = new Pessoa();
	p2.nome = "Paulo";
	p2.idade = 26;
	
	System.out.println("Nome " + p2.nome);
	System.out.println("Idade " + p2.idade);
	p2.falar();
	}

}

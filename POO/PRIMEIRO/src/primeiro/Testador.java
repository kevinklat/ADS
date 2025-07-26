package primeiro;

public class Testador {

	public static void main(String[] args) {
		Pessoa p;
		//int contador;
		
		p = new Pessoa();
		p.CPF = 12345323;
		p.nome = "Kevin";
		p.sexo = "M";
		
		Pessoa p1 = new Pessoa();
		p1.CPF = 98765465;
		p1.nome = "Fernanda";
		p1.sexo = "F";
		
		Pessoa p2 = new Pessoa();
		p2.CPF = 45678913;
		
		if(p.validarCPF(p2.CPF)==true)
			p2.CPF = p2.CPF;
		
		p2.nome = "Issac";
		p2.sexo = "M";
		
		p2.imprimirNome();

		
	}

}

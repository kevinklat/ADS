package primeiro;

public class Pessoa {
	
	int CPF;
	String nome;
	String sexo;
	
	void imprimirNome() {	
		System.out.println("Nome ; "+nome);
	}

	
	boolean validarCPF(int cpf) {
		boolean retorno = false;
		if(cpf != 0)
			retorno = true;
		else
			retorno = false;
		return retorno;
	}
}

package heranca;

public class Comissionado extends Funcionario {

	private double comissao;
	
	public Comissionado(int codigo, String nome, double salario, double comissao) {
		super(codigo, nome, salario);
		this.comissao = comissao;
	}
	@Override
	public double calcularSalario() {
		return this.salario = this.salario+comissao;
	}
}

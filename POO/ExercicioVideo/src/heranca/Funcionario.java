package heranca;

public abstract class Funcionario implements ICalculavel {

	protected int codigo;
	protected String nome;
	protected double salario;
	

	public Funcionario(int codigo, String nome, double salario) {
		this.codigo = codigo;
		this.nome = nome;
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	
	public abstract double calcularSalario();
	
	public int getCodigo() {
		return codigo;
	}
	
		
}

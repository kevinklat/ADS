package heranca;

public class Testador {
	
	public static void main(String[] args) {
		Funcionario horista = new Horista(1,"Kevin",0,50,20);
		horista.calcularSalario();
		System.out.println(horista.getSalario());
		
		Funcionario comissionado = new Comissionado(2,"Ana",2000,480);
		comissionado.calcularSalario();
		System.out.println(comissionado.getSalario());

		Consultor consultor = new Consultor(2000);
		consultor.calcularSalario();
		System.out.println(consultor.calcularSalario());
		
	}
}

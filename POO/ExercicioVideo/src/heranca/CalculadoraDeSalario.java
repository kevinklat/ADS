package heranca;

public class CalculadoraDeSalario {

    public double calcularSalario(ICalculavel calculavel){
        return calculavel.calcularSalario();
    } 

}

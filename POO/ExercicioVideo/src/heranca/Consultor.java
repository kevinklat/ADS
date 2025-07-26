package heranca;

public class Consultor implements ICalculavel {

    private double contrato;

    public Consultor(double contrato) {
        this.contrato = contrato;
    }

    public double calcularSalario(){
        return this.contrato;
        
    }

}

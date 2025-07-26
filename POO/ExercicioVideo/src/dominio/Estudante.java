package dominio;

public class Estudante{
 
    private int matricula;
    private String nome;
    

    public Estudante(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }
    
     
	public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "Estudante [matricula=" + matricula + ", nome=" + nome + "]";
    }

    
         
    
}
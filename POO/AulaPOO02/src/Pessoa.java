public class Pessoa {
    private String nome;
    public int idade;
    private String sexo;
    public float altura;

    //getters e setters
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void mostratDados() {
        System.out.println("Seu nome é " +nome + ", idade é "+idade+", sexo é "+sexo + " e altura é "+altura +".");
    }

}

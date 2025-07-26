public class Principal {
    public static void main(String[] args) {
        //criando uma instancia de pessoa
        Pessoa p1 = new Pessoa();
        p1.altura  = 1.80f;
        p1.idade = 34;
        p1.setSexo("M");
        p1.setNome("Kevin");

        p1.mostratDados();
        

    }
}

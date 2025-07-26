package br.com.kevin.autorlivro;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Autor autor = new Autor();
        autor.setNome("Kevin Klat Miranda");
        autor.setDataNascimento(LocalDate.of(1990, 1, 1));
        autor.setCidadeNascimento("São Paulo");
        autor.setBibliografia("Autor brasileiro...");

        Editora editora = new Editora();
        editora.setNomeEditora("Editora Exemplo");

        Livro livro = new Livro();
        livro.setTituloLivro("Aprendendo Java");
        livro.setAutor(autor);
        livro.setDataPublicacao(LocalDate.now());
        livro.setEditora(editora);

        autor.getLivrosPublicados().add(livro);

        System.out.println("Autor: " + autor.getNome());
        System.out.println("Livro: " + livro.getTituloLivro());
        System.out.println("Editora: " + livro.getEditora().getNomeEditora());
    }
}

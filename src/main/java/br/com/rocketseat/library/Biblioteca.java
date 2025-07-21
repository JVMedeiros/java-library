package br.com.rocketseat.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Biblioteca() {
        // Autores
        Autor autor1 = new Autor(1, "Machado de Assis", java.time.LocalDate.of(1839, 6, 21));
        Autor autor2 = new Autor(2, "Clarice Lispector", java.time.LocalDate.of(1920, 12, 10));
        Autor autor3 = new Autor(3, "J.K. Rowling", java.time.LocalDate.of(1965, 7, 31));
        autores.add(autor1);
        autores.add(autor2);
        autores.add(autor3);

        // Livros
        livros.add(new Livro(1, "Dom Casmurro", autor1));
        livros.add(new Livro(2, "Memórias Póstumas de Brás Cubas", autor1));
        livros.add(new Livro(3, "A Hora da Estrela", autor2));
        livros.add(new Livro(4, "Harry Potter e a Pedra Filosofal", autor3));
    }

    public List<Livro> getLivrosDisponiveis() {
        List<Livro> disponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                disponiveis.add(livro);
            }
        }
        return disponiveis;
    }

    public Optional<Livro> getLivroDisponivelPorId(int id) {
        return livros.stream()
            .filter(l -> l.getId() == id && l.isDisponivel())
            .findFirst();
    }

    public void registrarEmprestimo(Livro livro, String nomeUsuario) {
        livro.setDisponivel(false);
        livro.setDataAtualizacao(java.time.LocalDateTime.now());
        emprestimos.add(new Emprestimo(livro, nomeUsuario));
    }
}

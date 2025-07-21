package br.com.rocketseat.library;

import java.time.LocalDateTime;

public class Emprestimo {
    private Livro livro;
    private String nomeUsuario;
    private LocalDateTime dataEmprestimo;

    public Emprestimo(Livro livro, String nomeUsuario) {
        this.livro = livro;
        this.nomeUsuario = nomeUsuario;
        this.dataEmprestimo = LocalDateTime.now();
    }

    public Livro getLivro() { return livro; }
    public String getNomeUsuario() { return nomeUsuario; }
    public LocalDateTime getDataEmprestimo() { return dataEmprestimo; }
}

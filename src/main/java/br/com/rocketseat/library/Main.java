package br.com.rocketseat.library;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo à Biblioteca!");
        while (true) {
            System.out.print("\nDeseja ver os livros disponíveis? (S/N): ");
            String resposta = scanner.nextLine().trim().toUpperCase();
            if (resposta.equals("S")) {
                List<Livro> disponiveis = biblioteca.getLivrosDisponiveis();
                if (disponiveis.isEmpty()) {
                    System.out.println("\nNenhum livro disponível para empréstimo no momento.");
                    continue;
                }
                System.out.println("\nLivros disponíveis:");
                for (Livro livro : disponiveis) {
                    System.out.println(livro);
                }
                System.out.print("\nDigite o ID do livro que deseja emprestar: ");
                int idLivro;
                try {
                    idLivro = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("ID inválido. Tente novamente.");
                    continue;
                }
                var optLivro = biblioteca.getLivroDisponivelPorId(idLivro);
                if (optLivro.isEmpty()) {
                    System.out.println("Livro não encontrado ou indisponível.");
                    continue;
                }
                System.out.print("Digite seu nome: ");
                String nomeUsuario = scanner.nextLine().trim();
                biblioteca.registrarEmprestimo(optLivro.get(), nomeUsuario);
                System.out.println("\nLivro emprestado com sucesso para " + nomeUsuario + "!");
            } else if (resposta.equals("N")) {
                System.out.println("\nObrigado por utilizar a biblioteca. Até logo!");
                break;
            } else {
                System.out.println("Resposta inválida. Digite 'S' para sim ou 'N' para não.");
            }
        }
        scanner.close();
    }
}

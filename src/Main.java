import Model.Jogador;
import Model.Jogo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Jogador jogador1 = new Jogador();
//        Jogador jogador2 = new Jogador();
//
//        jogador1.setNome("Ísis");
//        jogador2.setNome("Yasmin");
//        jogador1.setSimbolo('O');
//        jogador2.setSimbolo('X');
//
//        System.out.println("A jogadora " + jogador1.getNome() + " está usando " + jogador1.getSimbolo());
//        System.out.println("A jogadora " + jogador2.getNome() + " está usando " + jogador2.getSimbolo());
//
//        Tabuleiro iniciarTabuleiro = new Tabuleiro();
//        iniciarTabuleiro.marcarCasa(1, 1, 'X');
//        iniciarTabuleiro.marcarCasa(0, 0, 'O');
//        iniciarTabuleiro.mostrarTabuleiro();

//       ** Primeiro prototipo para teste dos atributos e metodos

                Scanner scanner = new Scanner(System.in);

                Jogador jogador1 = new Jogador();
                Jogador jogador2 = new Jogador();

                System.out.print("Nome do Jogador 1 (esse jogador usara X) : ");
                jogador1.setNome(scanner.nextLine());
                jogador1.setSimbolo('X');

                System.out.print("Nome do Jogador 2 (esse jogador usara O): ");
                jogador2.setNome(scanner.nextLine());
                jogador2.setSimbolo('O');

                Jogo jogo = new Jogo();
                jogo.iniciarJogo(jogador1, jogador2);

                while (true) {
                    System.out.println("\nVez de: " + jogo.getJogadorAtual().getNome() + " (" + jogo.getJogadorAtual().getSimbolo() + ")");
                    jogo.getTabuleiro().mostrarTabuleiro();
                    System.out.print("Linha (de 0 a 2): ");
                    int linha = scanner.nextInt();
                    System.out.print("Coluna (de 0 a 2): ");
                    int coluna = scanner.nextInt();
                    if (jogo.realizarJogada(linha, coluna)) {
                        if (jogo.verificarVitoria()) {
                            jogo.getTabuleiro().mostrarTabuleiro();
                            System.out.println(
                                    "\nVencedor: " + jogo.getJogadorAtual().getNome()
                            );
                            System.out.println("Jogar de novo? (Sim / Nao): ");
                            String jogarNovamente = scanner.next();
                            if (jogarNovamente.equals("Sim")){
                                jogo.reiniciarJogo();
                                continue;
                            }
                            break;
                        }
                        jogo.trocarJogador();
                    } else {
                        System.out.println(
                                "Casa ocupada! Tente novamente."
                        );
                    }
                }
                scanner.close();

    }
}
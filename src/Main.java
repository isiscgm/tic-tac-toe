import Model.Jogador;
import Model.Tabuleiro;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();

        jogador1.setNome("Ísis");
        jogador2.setNome("Davi");
        jogador1.setSimbolo('O');
        jogador2.setSimbolo('X');

        System.out.println("A jogadora " + jogador1.getNome() + " está usando " + jogador1.getSimbolo());
        System.out.println("O jogador " + jogador2.getNome() + " está usando " + jogador2.getSimbolo());

        Tabuleiro iniciarTabuleiro = new Tabuleiro();
        iniciarTabuleiro.marcarCasa(1, 1, 'X');
        iniciarTabuleiro.marcarCasa(0, 0, 'O');
        iniciarTabuleiro.mostrarTabuleiro();

    }
}
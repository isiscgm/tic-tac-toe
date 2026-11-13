package Model;

public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;

    public Jogo(){
        tabuleiro = new Tabuleiro();
    }

    public Tabuleiro getTabuleiro(){
        return tabuleiro;
    }

    public void iniciarJogo(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.jogadorAtual = jogador1;
    }

    public void trocarJogador(){
        if (jogadorAtual == jogador1){
            jogadorAtual = jogador2;
        } else {
            jogadorAtual = jogador1;
        }
    }

    public boolean realizarJogada(int linha, int coluna) {
        return tabuleiro.marcarCasa(
                linha,
                coluna,
                jogadorAtual.getSimbolo()
        );
    }

    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }

    public void reiniciarJogo() {
        tabuleiro.reiniciarTabuleiro();
        jogadorAtual = jogador1;
    }

    public boolean verificarVitoria() {

        char[][] casas = tabuleiro.getCasasTabuleiro();

        // percorre as linhas para verificar vencedor
        for (int i = 0; i < 3; i++) {
            if (
                    casas[i][0] == jogadorAtual.getSimbolo()
                            && casas[i][1] == jogadorAtual.getSimbolo()
                            && casas[i][2] == jogadorAtual.getSimbolo()
            ) {
                return true;
            }
        }

        // percorre as colunas para verificar vencedor
        for (int i = 0; i < 3; i++) {
            if (
                    casas[0][i] == jogadorAtual.getSimbolo()
                            && casas[1][i] == jogadorAtual.getSimbolo()
                            && casas[2][i] == jogadorAtual.getSimbolo()
            ) {
                return true;
            }
        }

        // percorre as diagonais para verificar vencedor
        if (
                casas[0][0] == jogadorAtual.getSimbolo()
                        && casas[1][1] == jogadorAtual.getSimbolo()
                        && casas[2][2] == jogadorAtual.getSimbolo()
        ) {
            return true;
        }

        if (
                casas[0][2] == jogadorAtual.getSimbolo()
                        && casas[1][1] == jogadorAtual.getSimbolo()
                        && casas[2][0] == jogadorAtual.getSimbolo()
        ) {
            return true;
        }

        return false;
    }
}
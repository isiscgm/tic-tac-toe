
package view;

import Model.Jogador;
import Model.Jogo;

import javax.swing.*;
import java.awt.*;

public class TelaJogo {

    private Jogo jogo;
    private Jogador jogadorX;
    private Jogador jogadorO;

    private int vitoriasX = 0;
    private int vitoriasO = 0;

    private boolean partidaEncerrada = false;

    private JPanel root;
    private JPanel painelCabecalho;
    private JPanel painelPlacar;
    private JPanel painelTabuleiro;
    private JPanel painelRodape;
    private JLabel lblTitulo;
    private JLabel lblJogadorX;
    private JLabel lblJogadorO;
    private JButton btn00;
    private JButton btn01;
    private JButton btn02;
    private JButton btn03;
    private JButton btn04;
    private JButton btn05;
    private JButton btn06;
    private JButton btn07;
    private JButton btn08;
    private JLabel lblTurno;
    private JButton btnNovoJogo;

    // estilos e interface
    private void aplicarEstilo() {
        Color fundo = new Color(24, 25, 33);
        Color painel = new Color(37, 43, 58);
        Color celula = new Color(48, 53, 72);
        Color branco = new Color(235, 237, 245);
        Color azul = new Color(96, 165, 250);
        Color laranja = new Color(251, 146, 60);
        Color roxo = new Color(98, 85, 217);

        root.removeAll();
        root.setLayout(new BorderLayout(0, 12));
        root.setBackground(fundo);
        root.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        // cabecalho
        painelCabecalho.removeAll();
        painelCabecalho.setLayout(new BorderLayout());
        painelCabecalho.setBackground(fundo);
        painelCabecalho.setPreferredSize(new Dimension(480, 80));

        lblTitulo.setForeground(branco);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 25));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        painelCabecalho.add(lblTitulo, BorderLayout.CENTER);

        painelPlacar.removeAll();
        painelPlacar.setLayout(new GridLayout(1, 2, 12, 0));
        painelPlacar.setBackground(fundo);
        painelPlacar.setPreferredSize(new Dimension(480, 70));

        lblJogadorX.setForeground(azul);
        lblJogadorO.setForeground(laranja);

        lblJogadorX.setFont(new Font("Arial", Font.BOLD, 16));
        lblJogadorO.setFont(new Font("Arial", Font.BOLD, 16));

        lblJogadorX.setHorizontalAlignment(SwingConstants.CENTER);
        lblJogadorO.setHorizontalAlignment(SwingConstants.CENTER);

        lblJogadorX.setOpaque(true);
        lblJogadorO.setOpaque(true);

        lblJogadorX.setBackground(painel);
        lblJogadorO.setBackground(painel);

        lblJogadorX.setBorder(
                BorderFactory.createLineBorder(
                        new Color(65, 90, 130), 2, true
                )
        );

        lblJogadorO.setBorder(
                BorderFactory.createLineBorder(
                        new Color(130, 85, 55), 2, true
                )
        );

        painelPlacar.add(lblJogadorX);
        painelPlacar.add(lblJogadorO);

        // tabuleiro
        painelTabuleiro.removeAll();
        painelTabuleiro.setLayout(new GridLayout(3, 3, 10, 10));
        painelTabuleiro.setBackground(fundo);

        JButton[] botoes = {
                btn00, btn01, btn02,
                btn03, btn04, btn05,
                btn06, btn07, btn08
        };

        for (JButton botao : botoes) {
            botao.setText("");
            botao.setFont(new Font("Arial", Font.BOLD, 42));
            botao.setForeground(branco);
            botao.setBackground(celula);
            botao.setOpaque(true);
            botao.setFocusPainted(false);
            botao.setBorder(
                    BorderFactory.createLineBorder(
                            new Color(65, 72, 94), 2, true
                    )
            );
            botao.setCursor(
                    new Cursor(Cursor.HAND_CURSOR)
            );
            painelTabuleiro.add(botao);
        }

        // rodape
        painelRodape.removeAll();
        painelRodape.setLayout(new GridLayout(2, 1, 0, 10));
        painelRodape.setBackground(fundo);
        painelRodape.setPreferredSize(new Dimension(480, 100));

        lblTurno.setForeground(branco);
        lblTurno.setFont(new Font("Arial", Font.BOLD, 16));
        lblTurno.setHorizontalAlignment(SwingConstants.CENTER);

        btnNovoJogo.setText("NOVA PARTIDA");
        btnNovoJogo.setFont(new Font("Arial", Font.BOLD, 14));
        btnNovoJogo.setForeground(branco);
        btnNovoJogo.setBackground(roxo);
        btnNovoJogo.setOpaque(true);
        btnNovoJogo.setFocusPainted(false);
        btnNovoJogo.setBorder(
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        );
        btnNovoJogo.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        painelRodape.add(lblTurno);
        painelRodape.add(btnNovoJogo);

        JPanel conteudo = new JPanel(new BorderLayout(0, 12));
        conteudo.setBackground(fundo);
        conteudo.add(painelPlacar, BorderLayout.NORTH);
        conteudo.add(painelTabuleiro, BorderLayout.CENTER);
        conteudo.add(painelRodape, BorderLayout.SOUTH);

        root.add(painelCabecalho, BorderLayout.NORTH);
        root.add(conteudo, BorderLayout.CENTER);

        root.revalidate();
        root.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaJogo tela = new TelaJogo();
            tela.aplicarEstilo();
            tela.configurarJogo();

            JFrame frame = new JFrame("Jogo da Velha");
            frame.setContentPane(tela.root);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 750);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
        });
    }

    private void configurarBotoes() {

        JButton[] botoes = {
                btn00, btn01, btn02,
                btn03, btn04, btn05,
                btn06, btn07, btn08
        };

        for (int i = 0; i < botoes.length; i++) {

            final int linha = i / 3;
            final int coluna = i % 3;

            botoes[i].addActionListener(e -> realizarJogada(linha, coluna));
        }

        btnNovoJogo.addActionListener(e -> novaPartida());
    }

    private void realizarJogada(int linha, int coluna) {

        if (partidaEncerrada) {
            return;
        }

        Jogador atual = jogo.getJogadorAtual();

        boolean jogadaValida = jogo.realizarJogada(linha, coluna);

        if (!jogadaValida) {
            return;
        }

        char simbolo = atual.getSimbolo();

        JButton[] botoes = {
                btn00, btn01, btn02,
                btn03, btn04, btn05,
                btn06, btn07, btn08
        };

        JButton botao = botoes[linha * 3 + coluna];

        botao.setText(String.valueOf(simbolo));

        if (simbolo == 'X') {
            botao.setForeground(new Color(96, 165, 250));
        } else {
            botao.setForeground(new Color(251, 146, 60));
        }

        // Verificar vitória
        if (jogo.verificarVitoria()) {

            partidaEncerrada = true;

            if (simbolo == 'X') {
                vitoriasX++;
            } else {
                vitoriasO++;
            }

            atualizarPlacar();

            lblTurno.setText(atual.getNome() + " venceu!");

            JOptionPane.showMessageDialog(
                    root,
                    atual.getNome() + " venceu a partida!"
            );

            return;
        }

        // Verificar empate
        if (tabuleiroCheio()) {

            partidaEncerrada = true;

            lblTurno.setText("Empate!");

            JOptionPane.showMessageDialog(
                    root,
                    "A partida terminou em empate!"
            );

            return;
        }

        // Passar a vez
        jogo.trocarJogador();

        atualizarTurno();
    }

    private boolean tabuleiroCheio() {

        char[][] casas = jogo.getTabuleiro().getCasasTabuleiro();

        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {

                if (casas[linha][coluna] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    private void atualizarPlacar() {

        lblJogadorX.setText(
                jogadorX.getNome() + ": " + vitoriasX
        );

        lblJogadorO.setText(
                jogadorO.getNome() + ": " + vitoriasO
        );
    }

    private void atualizarTurno() {

        Jogador atual = jogo.getJogadorAtual();

        lblTurno.setText("Vez de " + atual.getNome());
    }

    private void novaPartida() {

        jogo.reiniciarJogo();

        partidaEncerrada = false;

        JButton[] botoes = {
                btn00, btn01, btn02,
                btn03, btn04, btn05,
                btn06, btn07, btn08
        };

        for (JButton botao : botoes) {
            botao.setText("");
        }

        atualizarTurno();
    }

    private void configurarJogo() {

        String nomeX = JOptionPane.showInputDialog(
                null,
                "Nome do jogador X:",
                "Novo jogo",
                JOptionPane.QUESTION_MESSAGE
        );

        String nomeO = JOptionPane.showInputDialog(
                null,
                "Nome do jogador O:",
                "Novo jogo",
                JOptionPane.QUESTION_MESSAGE
        );

        if (nomeX == null || nomeX.trim().isEmpty()) {
            nomeX = "Jogador X";
        }

        if (nomeO == null || nomeO.trim().isEmpty()) {
            nomeO = "Jogador O";
        }

        jogadorX = new Jogador();
        jogadorX.setNome(nomeX);
        jogadorX.setSimbolo('X');

        jogadorO = new Jogador();
        jogadorO.setNome(nomeO);
        jogadorO.setSimbolo('O');

        jogo = new Jogo();
        jogo.iniciarJogo(jogadorX, jogadorO);

        atualizarPlacar();
        atualizarTurno();

        configurarBotoes();
    }
}

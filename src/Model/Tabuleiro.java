package Model;

public class  Tabuleiro {
    private char [][] casasTabuleiro;

    public Tabuleiro() {
        casasTabuleiro = new char[3][3];
        System.out.println("Inicializando tabuleiro..;");
        reiniciarTabuleiro();
    }

    public char[][] getCasasTabuleiro() {
        return casasTabuleiro;
    }

    public void mostrarTabuleiro(){
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print("[" + casasTabuleiro[i][j] + "]");
            }
            System.out.println();
        }
    }

    public boolean checarDisponivel(int linha, int coluna){
        return casasTabuleiro[linha][coluna] == ' ';
    }

    public boolean marcarCasa(int linha, int coluna, char simbolo){
        if (checarDisponivel(linha, coluna)) {
            casasTabuleiro[linha][coluna] = simbolo;
            return true;
        }
            return false;
    }

    public void reiniciarTabuleiro(){
        for (int i = 0 ; i < 3 ; i ++){
            for (int j = 0 ; j < 3 ; j ++){
                casasTabuleiro[i][j] = ' ';
            }
        }
    }
}


package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JogoDaVelha {
    public static char[][] tabuleiro = new char[3][3];
    public static char jogadorAtual = 'X';

    public static void main(String[] args) {
        inicializarTabuleiro();
        while (true) {
            mostrarTabuleiro();
            realizarJogada();
            if (verificarVencedor()) {
                mostrarTabuleiro();
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                break;
            }
            if (verificarEmpate()) {
                mostrarTabuleiro();
                System.out.println("O jogo terminou em empate!");
                break;
            }
            alternarJogador();
        }
    }

    public static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    public static void mostrarTabuleiro() {
        System.out.println("Tabuleiro atual:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void realizarJogada() {
        Scanner scanner = new Scanner(System.in);
        int linha = -1, coluna = -1;
        while (true) {
            try {
                System.out.println("Jogador " + jogadorAtual + ", digite a linha e a coluna (1-3) para sua jogada:");
                linha = scanner.nextInt() - 1;
                coluna = scanner.nextInt() - 1;
                if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == '-') {
                    tabuleiro[linha][coluna] = jogadorAtual;
                    break;
                } else {
                    System.out.println("Esta jogada não é válida, tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira números inteiros.");
                scanner.next(); // Limpar o buffer do scanner
            }
        }
    }

    public static boolean verificarVencedor() {
        // Verifica as linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                return true;
            }
        }
        // Verifica as colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual) {
                return true;
            }
        }
        // Verifica as diagonais
        if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) {
            return true;
        }
        if (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual) {
            return true;
        }
        return false;
    }

    public static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void alternarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }
}



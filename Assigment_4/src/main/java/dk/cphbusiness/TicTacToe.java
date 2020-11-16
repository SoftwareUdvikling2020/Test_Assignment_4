package dk.cphbusiness;


import org.apache.commons.lang3.tuple.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TicTacToe {
    public static boolean gameStatus = false;
    public static final int ROWS = 3, COLS = 3, EMPTY = 0, CIRCLE = 1, CROSS = 2;
    public static final String CIRCLE_STRING = "o", CROSS_STRING = "x", EMPTY_STRING = "_";
    public static int[][] board = new int[ROWS][COLS];

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.startGame();

        while (!gameStatus) {
            System.out.print("Enter a coords x, y, player: ");
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();

            if (game.checkInput(inputString)) {
                String[] parts = inputString.split(" ");

                int row = game.stringToInt(parts[0]);
                int col = game.stringToInt(parts[1]);
                int player = game.stringToInt(parts[2]);

                Pair<String, Boolean> result = takeTurn(row, col, player);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                PrintStream out = new PrintStream(bytes);

                gameStatus = result.getRight();
                System.out.println(result.getLeft());
                game.printBoard(System.out);
            }
        }

    }

    public static void setBoard(int[][] board) {
        TicTacToe.board = board;
    }

    public boolean checkInput(String str) {
        if (str.trim().replaceAll(" ", "").matches("^[0-9]+$")) return true;
        else return false;
    }

    public static boolean checkIfDraw() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (board[row][col] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkIfWon(int row, int col, int player) {
        return (board[row][0] == player         // 3-in-the-row
                && board[row][1] == player
                && board[row][2] == player
                || board[0][col] == player      // 3-in-the-column
                && board[1][col] == player
                && board[2][col] == player
                || row == col            // 3-in-the-diagonal
                && board[0][0] == player
                && board[1][1] == player
                && board[2][2] == player
                || row + col == 2  // 3-in-the-opposite-diagonal
                && board[0][2] == player
                && board[1][1] == player
                && board[2][0] == player);
    }

    private static Pair<String, Boolean> takeTurn(int row, int col, int player) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2 && board[row][col] == EMPTY && (player == CROSS || player == CIRCLE)  ) {
            board[row][col] = player;}
        else return Pair.of("Unvalid turn, try again player "+player, false);

        if (checkIfWon(row, col, player)) return Pair.of(player + " Won the game!", true);
        else if (checkIfDraw()) return Pair.of("Draw!", true);

        if (player == CROSS) return Pair.of("Player: " + CIRCLE + " Now has the turn.", false);
        else return Pair.of("Player: " + CROSS + " Now has the turn.", false);
    }

    public int stringToInt(String toConvert) {
        return Integer.parseInt(toConvert);
    }

    public void startGame() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                board[row][col] = EMPTY;
            }
        }
    }

    public void printBoard(PrintStream out) {
        for (int col = 0; col < COLS; ++col) {
            for (int row = 0; row < ROWS; ++row) {
                int space = board[row][col];
                printConvert(out, space);
            }
            out.println();
        }
    }

    private void printConvert(PrintStream out, int space) {
        if (space == EMPTY) out.print(EMPTY_STRING + " ");
        if (space == CIRCLE) out.print(CIRCLE_STRING + " ");
        if (space == CROSS) out.print(CROSS_STRING + " ");
    }

}

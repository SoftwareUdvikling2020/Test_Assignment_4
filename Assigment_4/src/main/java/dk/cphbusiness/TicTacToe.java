package dk.cphbusiness;

import java.io.PrintStream;
import java.util.Scanner;

public class TicTacToe {
    public static boolean gameStatus = true;
    public static final int ROWS = 3, COLS = 3, EMPTY = 0, CIRCLE = 1, CROSS = 2;
    public static final String CIRCLE_STRING = "o", CROSS_STRING = "x", EMPTY_STRING = "_";
    public static int[][] board = new int[ROWS][COLS];

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.startGame();

        while(gameStatus){
            System.out.print("Enter a coords x, y, player: ");
            Scanner scanner = new Scanner(System. in);
            String inputString = scanner. nextLine();


            String[] parts = inputString.split(" ");

            takeTurn(game.stringToInt(parts[0]), game.stringToInt(parts[1]), game.stringToInt(parts[2]));
            game.printBoard(System.out);


        }
    }
    public boolean checkTurn(){
        board[][] && board[][] && board[][]

        return false
    }
    private static void takeTurn(int i, int i2, int i3) {
        board[i][i2] = i3;
    }

    public int stringToInt(String toConvert){
        return Integer.parseInt(toConvert);
    }

    public void startGame(){
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                board[row][col] = EMPTY;
            }
        }
    }

    public void printBoard(PrintStream out){
        for (int col = 0; col < COLS; ++col) {
            for (int row = 0; row < ROWS; ++row) {
                int space = board[row][col];
                printConvert(out, space);
            }
            out.println();
        }
    }

    private void printConvert(PrintStream out, int space) {
        if(space == EMPTY) out.print(EMPTY_STRING+ " ");
        if(space == CIRCLE) out.print(CIRCLE_STRING+ " ");
        if(space == CROSS) out.print(CROSS_STRING+ " ");
    }

}

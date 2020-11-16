package dk.cphbusiness;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;


public class TicTacToeTest {


    @Test
    public void tictactoe_MustNotBeNull() {
        TicTacToe ttt = new TicTacToe();
        Assertions.assertNotNull(ttt);
    }


    @Nested
    @DisplayName("Test_checkIfDraw")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class CheckIfDraw {


        @Test
        public void checkIfDraw_mustReturnBoolean() {
            //arrange
            TicTacToe ttt = new TicTacToe();
            //act
            Boolean result = ttt.checkIfDraw();
            //assert
            assert (result.getClass() == Boolean.class);
        }

        @Test
        public void checkIfDraw_mustReturnfalse_WhenBoardEmpty() {
            // Arrange
            TicTacToe ttt = Mockito.mock(TicTacToe.class);

            int[][] board = {
                    {0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}
            };
            ttt.setBoard(board);
            Boolean expected = false;
            // Act
            Boolean result = ttt.checkIfDraw();

            // Assert
            Assertions.assertEquals(expected, result);
        }

        @Test
        public void checkIfDraw_mustReturnfalse_whenBoardAlmostFull() {
            // Arrange
            TicTacToe ttt = Mockito.mock(TicTacToe.class);

            int[][] board = {
                    {1, 2, 1},
                    {0, 2, 2},
                    {1, 1, 2}
            };
            ttt.setBoard(board);
            Boolean expected = false;
            // Act
            Boolean result = ttt.checkIfDraw();

            // Assert
            Assertions.assertEquals(expected, result);
        }


        @Test
        public void checkIfDraw_mustReturnTrue() {
            // Arrange
            TicTacToe ttt = Mockito.mock(TicTacToe.class);

            int[][] board = {
                    {1, 2, 1},
                    {1, 1, 2},
                    {2, 1, 2}
            };
            ttt.setBoard(board);
            Boolean expected = true;
            // Act
            Boolean result = ttt.checkIfDraw();

            // Assert
            Assertions.assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Test_checkIfWon")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class CheckIfWon {
        @Test
        public void checkIfWon_mustReturnBoolean() {
            //arrange
            TicTacToe ttt = Mockito.mock(TicTacToe.class);

            int row = 0;
            int col = 0;
            int playerNr = 1;

            //act
            Boolean result = ttt.checkIfWon(row, col, playerNr);
            //assert
            assert (result.getClass() == Boolean.class);
        }

        @Test
        public void checkIfWon_mustReturnFalse() {
            //arrange
            TicTacToe ttt = Mockito.mock(TicTacToe.class);

            int row = 0;
            int col = 0;
            int playerNr = 1;

            int[][] board = {
                    {1, 2, 1},
                    {1, 1, 2},
                    {2, 1, 2}
            };
            ttt.setBoard(board);

            Boolean expected = false;

            //act
            Boolean result = ttt.checkIfWon(row, col, playerNr);

            // Assert
            Assertions.assertEquals(expected, result);
        }
        @Test
        public void checkIfWon_mustReturnTrue() {
            //arrange
            TicTacToe ttt = Mockito.mock(TicTacToe.class);

            int row = 0;
            int col = 0;
            int playerNr = 1;

            int[][] board = {
                    {1, 2, 1},
                    {1, 1, 2},
                    {2, 1, 1}
            };
            ttt.setBoard(board);

            Boolean expected = true;

            //act
            Boolean result = ttt.checkIfWon(row, col, playerNr);

            // Assert
            Assertions.assertEquals(expected, result);
        }
    }



}

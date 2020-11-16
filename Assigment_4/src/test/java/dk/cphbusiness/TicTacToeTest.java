package dk.cphbusiness;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;


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

    @Nested
    @DisplayName("Test_startGame")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class startGame{
        @Test
        public void checkStartGame_mustReturnTrue_WhenBoard0() {
            // Arrange
            TicTacToe ttt = new TicTacToe();

            int[][] expected = {
                    {0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}
            };

            // Act
            ttt.startGame();
            int [][] result = ttt.getBoard();

            // Assert
            Assertions.assertTrue(Arrays.deepEquals(expected, result));
        }

        @Test
        public void checkStartGame_mustReturnFalse_WhenBoardIsChanged() {
            // Arrange
            TicTacToe ttt = new TicTacToe();

            int[][] expected = {
                    {0, 0, 0},
                    {0, 1, 0},
                    {0, 0, 0}
            };

            // Act
            ttt.startGame();
            int [][] result = ttt.getBoard();

            // Assert
            Assertions.assertFalse(Arrays.deepEquals(expected, result));
        }
    }

    @Nested
    @DisplayName("Test_checkInput")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class checkInput{

        @ParameterizedTest
        @ValueSource(strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"})
        public void checkInput_mustReturnTrue_WhenInputNumber(String number) {
            // Arrange
            TicTacToe ttt = new TicTacToe();

            Boolean expected = true;


            // Act
            Boolean result = ttt.checkInput(number);

            // Assert
            Assertions.assertEquals(expected, result);
        }

        @ParameterizedTest
        @ValueSource(strings = {"A", "B", "c", "/", "%", "❤", "+", "-"})
        public void checkInput_mustReturnFalse_WhenInputNotNumber(String number) {
            // Arrange
            TicTacToe ttt = new TicTacToe();

            Boolean expected = false;

            // Act
            Boolean result = ttt.checkInput(number);

            // Assert
            Assertions.assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Test_stringToInt")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class stringToInt{

        @Test
        public void stringToInt_mustReturn0_WhenInput0() {
            // Arrange
            TicTacToe ttt = new TicTacToe();
            String input = "0";

            int expected = 0;

            // Act
            int result = ttt.stringToInt(input);

            // Assert
            Assertions.assertEquals(expected, result);
        }

        @Test
        public void stringToInt_mustReturn1_WhenInput1() {
            // Arrange
            TicTacToe ttt = new TicTacToe();
            String input = "1";

            int expected = 1;

            // Act
            int result = ttt.stringToInt(input);

            // Assert
            Assertions.assertEquals(expected, result);
        }


        @Test
        public void stringToInt_mustReturn2_WhenInput2() {
            // Arrange
            TicTacToe ttt = new TicTacToe();
            String input = "2";

            int expected = 2;

            // Act
            int result = ttt.stringToInt(input);

            // Assert
            Assertions.assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Test_Print")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class printTest {


        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();



        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }


        @Test
        void printBorad_MustResturnTrue_WhenPrintBoardWithChange() {
            // Arrange

            TicTacToe ttt = new TicTacToe();
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(bytes);
            int[][] board = {
                    {1, 0, 0},
                    {1, 0, 0},
                    {0, 2, 0}
            };

            ttt.setBoard(board);

            String expected = "o o _ _ _ x _ _ _";

            // Act
            ttt.printBoard(out);

            // Assert
            Assertions.assertEquals(expected, outputStreamCaptor.toString()
                    .trim());
        }

        @Test
        void printBorad_MustResturnTrue_WhenEmptyPrintBoard() {
            // Arrange

            TicTacToe ttt = new TicTacToe();
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(bytes);
            int[][] board = {
                    {0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}
            };

            ttt.setBoard(board);

            String expected = "_ _ _ _ _ _ _ _ _";

            // Act
            ttt.printBoard(out);

            // Assert
            Assertions.assertEquals(expected, outputStreamCaptor.toString()
                    .trim());
        }





    }


}

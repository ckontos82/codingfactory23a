package gr.aueb.cf.projects;

import java.util.Scanner;

/**
 * This class represents a simple implementation of the Tic Tac Toe game.
 *
 * @author Charalampos Kontos
 */
public class Project08 {
    static final int DIMENSION = 3;
    static final int ROUNDS = 9;
    static int player = 0;

    public static void main(String[] args) {
        char[][] board = new char[DIMENSION][DIMENSION];
        int round = 1;
        boolean wonGame = false;
        final int MIN_CHOICE = 1;
        final int MAX_CHOICE = 9;
        int choice;

        initializeBoard(board);
        System.out.println("Welcome to WarGames!\n");
        System.out.println("Player 1 plays with X, player 2 plays with O.");
        displayBoard(board);

        // Use try-with-resources to ensure the scanner is closed at the end of its scope.
        try (Scanner scanner = new Scanner(System.in)) {
            player = getNextPlayer(player);
                do {
                    try {
                        choice = getValidChoice(scanner, board, MIN_CHOICE, MAX_CHOICE);
                        round++;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid input. Please enter a valid choice.");
                        continue;
                    }

                    selection(player, board, choice);
                    displayBoard(board);
                    if (isGameWon(board, player)) {
                        wonGame = true;
                        break;
                    } else {
                        player = getNextPlayer(player);
                    }

                } while (round <= ROUNDS);

                if (!wonGame) {
                    System.out.println("Game is a tie.");
                }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred. The game is stopped.");
            e.printStackTrace();
        }
    }

    /**
     * Initializes the game board with numbers 1-9.
     * @param board The game board to be initialized.
     */
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                board[i][j] = (char) (3 * i + j + 1 + '0');
            }
        }
    }

    /**
     * Displays the current state of the game board.
     * @param board The game board to be displayed.
     */
    public static void displayBoard(char[][] board) {
        System.out.println(" " + board[0][0] + " \u2502 " + board[0][1] + " \u2502 " + board[0][2]);
        System.out.println("\u2500\u2500\u2500\u253C\u2500\u2500\u2500\u253C\u2500\u2500\u2500\u2500");
        System.out.println(" " + board[1][0] + " \u2502 " + board[1][1] + " \u2502 " + board[1][2]);
        System.out.println("\u2500\u2500\u2500\u253C\u2500\u2500\u2500\u253C\u2500\u2500\u2500\u2500");
        System.out.println(" " + board[2][0] + " \u2502 " + board[2][1] + " \u2502 " + board[2][2]);
        System.out.println();
    }

    /**
     * Returns the number of the next player.
     * @param currentPlayer The number of the current player.
     * @return The number of the next player.
     */
    public static int getNextPlayer(int currentPlayer) {
        // Rotate between player 1 and 2
        return (currentPlayer % 2) + 1;
    }

    /**
     * Prompts the player for a valid choice and returns it.
     * @param scanner The Scanner to use for user input.
     * @param board The current game board.
     * @param min The minimum valid choice.
     * @param max The maximum valid choice.
     * @return The valid choice made by the player.
     * @throws IllegalArgumentException if the input is invalid.
     */
    public static int getValidChoice(Scanner scanner, char[][] board, int min, int max) {
        int choice;
        while (true) {
            System.out.println("Player " + player + " is playing. Enter your choice: ");
            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
                // Check if the choice is within the valid range and is not already taken
                if (choice < min || choice > max || !isValid(board, choice)) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
            }
        }
        return choice;
    }

    /**
     * Marks the given choice on the game board for the given player.
     * @param player The number of the player making the selection.
     * @param board The game board.
     * @param choice The choice made by the player.
     */
    public static void selection(int player, char[][] board, int choice) {
        // Convert choice to coordinates
        int i = (choice - 1) / DIMENSION;
        int j = (choice - 1) % DIMENSION;

        board[i][j] = getPlayerSymbol(player);
    }

    /**
     * Checks if the given player has won the game.
     * @param board The game board.
     * @param player The player to check for a win.
     * @return true if the player has won, false otherwise.
     */
    public static boolean isGameWon(char[][] board, int player) {
        // Check for a win in rows and columns
        for (int i = 0; i < DIMENSION; i++) {
            if ((board[i][0] == board[i][1]) && (board[i][1] == board[i][2])) {
                System.out.printf("\nPlayer %d has won the game.\n", player);
                return true;
            }

            if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i])) {
                System.out.printf("\nPlayer %d has won the game.\n", player);
                return true;
            }
        }

        // Check for a win in diagonals
        if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) {
            System.out.printf("\nPlayer %d has won the game.\n", player);
            return true;
        }

        if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0])) {
            System.out.printf("\nPlayer %d has won the game.\n", player);
            return true;
        }

        // Check for a tie
        if (isBoardFull(board)) {
            System.out.println("Game is a tie.");
            return true;
        }

        return false;
    }

    /**
     * Checks if the given choice is valid (i.e., not already taken).
     * @param board The game board.
     * @param choice The choice to check.
     * @return true if the choice is valid, false otherwise.
     */
    public static boolean isValid(char[][] board, int choice) {
        // Convert choice to coordinates
        int i = (choice - 1) / DIMENSION;
        int j = (choice - 1) % DIMENSION;

        return !(board[i][j] == 'X' || board[i][j] == 'O');
    }

    /**
     * Checks if the game board is full.
     * @param board The game board.
     * @return true if the board is full, false otherwise.
     */
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns the symbol for the given player.
     * @param player The player number.
     * @return 'X' for player 1 and 'O' for player 2.
     */
    public static char getPlayerSymbol(int player) {
        return player == 1 ? 'X' : 'O';
    }
}

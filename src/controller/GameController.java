package controller;

import model.GridModel;
import model.PlayerModel;
import view.GameView;

import java.util.Scanner;

// Controller
public class GameController {
    private Scanner scanner;
    private GridModel gridModel;
    private GameView gameView;
    private PlayerModel redPlayer;
    private PlayerModel blackPlayer;

    public GameController() {
        this.scanner = new Scanner(System.in);
        this.gridModel = new GridModel();
        this.gameView = new GameView();
//        this.redPlayer = new PlayerModel("Red", 6, 3);
//        this.blackPlayer = new PlayerModel("Black", 0, 6);

    }

    public void startGame() {
        gameView.printGame(gridModel);

        // Prompt Red player for the first move
        System.out.println("Red player, make your first move.");
        takeTurn("Red");

        // Check if the game is over after Red player's move
        if (isGameOver()) {
            announceWinner("Red");
            return;
        }

        // Prompt Black player for the first move
        System.out.println("Black player, make your first move.");
        takeTurn("Black");

        // Check if the game is over after Black player's move
        if (isGameOver()) {
            announceWinner("Black");
            return;
        }


        // Continue with the regular game loop
        while (true) {
            System.out.println("Red player, make your move.");
            takeTurn("Red");
            if (isGameOver()) {
                announceWinner("Red");
                break;
            }

            System.out.println("Black player, make your move.");
            takeTurn("Black");
            if (isGameOver()) {
                announceWinner("Black");
                break;
            }
        }
    }

    private void takeTurn(String player) {
        // Display the current position of the player
        int[] currentPlayerPosition = (player.equals("Red")) ? gridModel.getRedPlayerPosition() : gridModel.getBlackPlayerPosition();
        System.out.println(player + " player's current position: [" + currentPlayerPosition[0] + "][" + currentPlayerPosition[1] + "]");

        String move;
        boolean validMove = false;

        // Flag to track whether it's the first move or not
        boolean isFirstMove = (gridModel.getRedPlayerPosition()[0] == -1 && gridModel.getBlackPlayerPosition()[1] == -1);

        do {
            // Prompt the player for the move
            System.out.println("Make your move by entering 2 numbers: The first number is Row and the second number is column");
            System.out.print("Enter your move (e.g., '1 2'): ");
            move = scanner.nextLine();

            // Process the move based on the input
            String formattedMove = formatMove(move);
            String[] moveParts = formattedMove.split(" ");

            if (moveParts.length == 2) {
                int row = Integer.parseInt(moveParts[0]);
                int col = Integer.parseInt(moveParts[1]);

                // Check if it's the first move and if the move is within the allowed range
                if (isFirstMove) {
                    if (isValidOpeningMove(row, col, currentPlayerPosition)) {
                        // Update the player's position based on the move
                        if (player.equals("Red")) {
                            gridModel.setRedPlayerPosition(row, col);
                        } else if (player.equals("Black")) {
                            gridModel.setBlackPlayerPosition(row, col);
                        }
                        validMove = true;
                    } else {
                        System.out.println("Invalid opening move. Please try again.");
                    }
                } else if (isValidMove(row, col)) {
                    // Update the player's position based on the move
                    if (player.equals("Red")) {
                        gridModel.setRedPlayerPosition(row, col);
                    } else if (player.equals("Black")) {
                        gridModel.setBlackPlayerPosition(row, col);
                    }
                    validMove = true;
                } else {
                    System.out.println("Invalid move. Please try again.");
                }
            } else {
                System.out.println("Invalid input format. Please enter numbers separated by a space. Please try again.");
            }

            // Print the game grid after every valid move
            if (validMove) {
                gameView.printGame(gridModel);
            }

        } while (!validMove);
    }

    
    private boolean isValidOpeningMove(int row, int col, int[] currentPlayerPosition) {
        // Calculate the absolute difference between the current position and the target position
        int rowDiff = Math.abs(row - currentPlayerPosition[0]);
        int colDiff = Math.abs(col - currentPlayerPosition[1]);

        // Check if the move is within the bounds of the grid
        if (!(row >= 0 && row < 7 && col >= 0 && col < 7)) {
            System.out.println("Invalid move. You can only move to one of the three surrounding cards in the grid.");
            return false;
        }

        // Check if the move is to one of the three surrounding cards, including the diagonals
        if (rowDiff <= 1 && colDiff <= 1 && (rowDiff != 0 || colDiff != 0)) {
            return true;
        } else {
            System.out.println("Invalid move. You can only move to one of the three surrounding cards in the grid.");
            return false;
        }
    }


    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 7 && col >= 0 && col < 7;
    }

    private String formatMove(String move) {
        // Add a space if the user forgot to enter one
        return move.replaceAll("(\\d)(\\d)", "$1 $2");
    }

    private boolean isGameOver() {
        // Implement the logic to check for a winning condition or end of the game
        // For simplicity, let's assume the game ends after a fixed number of turns
        return false;
    }

    private void announceWinner(String winner) {
        System.out.println("Game over: " + winner + " player wins!");
    }
}

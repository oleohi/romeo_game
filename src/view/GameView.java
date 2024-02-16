package view;

import model.GridModel;

public class GameView {

    public void printGame(GridModel gridModel) {
        // Print column indices
        System.out.print("   ");
        for (int col = 0; col < gridModel.getColumnCount(); col++) {
            System.out.printf("  %2d ", col);
        }
        System.out.println();

        // Print grid with row indices
        for (int row = 0; row < gridModel.getRowCount(); row++) {
            // Print row index
            System.out.printf("%2d  ", row);
            for (int col = 0; col < gridModel.getColumnCount(); col++) {
                String cardSymbol = gridModel.getCardSymbol(row, col);

                // Check if the current position matches the red player's position
                if (row == gridModel.getRedPlayerPosition()[0] && col == gridModel.getRedPlayerPosition()[1]) {
                    cardSymbol = red(cardSymbol); // Use red color for the red player's position
                }

                // Check if the current position matches the black player's position
                if (row == gridModel.getBlackPlayerPosition()[0] && col == gridModel.getBlackPlayerPosition()[1]) {
                    cardSymbol = blue(cardSymbol); // Use blue color for the black player's position
                }

                System.out.print("| " + cardSymbol + " ");
            }
            System.out.println("|");
        }
        System.out.println();
    }

    private String blue(String text) {
        return "\u001B[34m" + text + "\u001B[0m"; // Blue color
    }

    private String red(String text) {
        return "\u001B[31m" + text + "\u001B[0m"; // Red color
    }

    // Other view-related methods
}

package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GridModel {

    private String[][] cards = new String[7][7];
    private int[] redPlayerPosition = {6, 0};
    private int[] blackPlayerPosition = {0, 6};

    private Card[][] grid;


    private int blackPlayerRow;
    private int blackPlayerCol;
    private int redPlayerRow;
    private int redPlayerCol;

    // Constructor and other methods

    public GridModel() {
        initializeGrid();
    }

    public void initializeGrid() {
        List<String> remainingCards = new ArrayList<>(Arrays.asList(
                "1C", "2C", "3C", "4C", "5C", "6C", "**", "8C", "9C", "TC", "JC", "KC",
                "1D", "2D", "3D", "4D", "5D", "6D", "**", "8D", "9D", "TD", "JD", "KD",
                "1H", "2H", "3H", "4H", "5H", "6H", "8H", "9H", "TH", "JC", "QH", "KH",
                "1S", "2S", "3S", "4S", "5S", "6S", "**", "8S", "9S", "TS", "JS", "QS", "KC"
        ));

        // Shuffle the cards
        Collections.shuffle(remainingCards);

        // Place Spade Queen (SQ) at the bottom left corner
        remainingCards.removeIf(card -> card.equals("SQ"));
        cards[6][0] = "QS";

        // Place Heart Queen (HQ) at the top right corner
        remainingCards.removeIf(card -> card.equals("HQ"));
        cards[0][6] = "QH";

        // Fill the rest of the grid randomly
        int index = 0;
        for (int row = 0; row < cards.length; row++) {
            for (int col = 0; col < cards[row].length; col++) {
                if (cards[row][col] == null && index < remainingCards.size()) {
                    cards[row][col] = remainingCards.get(index++);
                }
            }
        }
    }

//
//    public void initializeGrid() {
//        grid = new Card[7][7];
//
//        List<String> cardValues = Arrays.asList(
//                "1C", "2C", "3C", "4C", "5C", "6C", "**", "8C", "9C", "TC", "JC", "KC",
//                "1D", "2D", "3D", "4D", "5D", "6D", "**", "8D", "9D", "TD", "JD", "KD",
//                "1H", "2H", "3H", "4H", "5H", "6H", "8H", "9H", "TH", "JC", "QH", "KH",
//                "1S", "2S", "3S", "4S", "5S", "6S", "**", "8S", "9S", "TS", "JS", "QS", "KC"
//        );
//
//        int row = 0;
//        int col = 0;
//        for (String cardValue : cardValues) {
//            String rank = cardValue.substring(0, cardValue.length() - 1);
//            String suit = cardValue.substring(cardValue.length() - 1);
//            String color = (suit.equals("C") || suit.equals("S")) ? "Black" : "Red";
//            grid[row][col++] = new Card(rank, suit, color);
//
//            if (col == 7) {
//                col = 0;
//                row++;
//            }
//        }
//    }

    public int getRowCount() {
        return 7;
    }

    public int getColumnCount() {
        return 7;
    }

    public String getCardSymbol(int row, int col) {
        return cards[row][col];
    }

    // Inside GridModel class

    public void takeTurnRedPlayer() {
        movePlayer("Red", redPlayerPosition);
    }

    public void takeTurnBlackPlayer() {
        movePlayer("Black", blackPlayerPosition);
    }

    public int[] getRedPlayerPosition() {
        return redPlayerPosition;
    }

    public int[] getBlackPlayerPosition() {
        return blackPlayerPosition;
    }

    public void setRedPlayerPosition(int row, int col) {
        redPlayerPosition[0] = row;
        redPlayerPosition[1] = col;
    }

    public void setBlackPlayerPosition(int row, int col) {
        blackPlayerPosition[0] = row;
        blackPlayerPosition[1] = col;
    }

    // Define a method to get the row position of the black player
    public int getBlackPlayerRow() {
        return blackPlayerRow;
    }

    // Define a method to get the column position of the black player
    public int getBlackPlayerCol() {
        return blackPlayerCol;
    }

    // Define a method to get the row position of the red player
    public int getRedPlayerRow() {
        return redPlayerRow;
    }

    // Define a method to get the column position of the red player
    public int getRedPlayerCol() {
        return redPlayerCol;
    }

    private void movePlayer(String player, int[] position) {
        System.out.println(player + " player's turn.");
        System.out.println("Current position: Row " + position[0] + ", Column " + position[1]);

        // ... (implement the logic for the player's move)

        // Update the player's position based on the game rules
        // Example: You may prompt the player for input or implement an AI for automated moves

        // After processing the move, you may want to check for a winning condition or other game rules

        // Print the updated grid to show the new positions
//        printGrid();
    }


    public String[][] getCards() {
        return cards;
    }

}

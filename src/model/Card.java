package model;

// Model
public class Card {
    private String rank;
    private String suit;
    private String color;

    public Card(String rank, String suit, String color) {
        this.rank = rank;
        this.suit = suit;
        this.color = color;
    }

    // Getters and setters
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public String toString() {
        return suit + rank + color;
    }
}

    

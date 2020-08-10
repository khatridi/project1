/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @author Megha Patel
 * @author Akhtar Muhammad
 * @modifier Divyeshkumar Khatri
 */
public class Card {
    //default modifier for child classes

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    
    private int num;
    private int suit;
    private int point;
    
   /*
    * String of all cards in a deck
    */
    
    private static String[] faces = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private static String[] cardSuit = {"Diamonds", "Clubs", "Spades", "Hearts"};
    
   /*
    * The face and suit of cards
    */
    
    Card(int suitValue, int cardValue){
        // Storing suit and card to int
        this.num = cardValue;
        this.suit = suitValue;
    }
    
    // The face of the card
    public int getNum(){
        return num;
    }
    
    // Suit in which the card belongs
    public int getSuit(){
        return suit;
    }
    
    // Point of each card
    public int getPoint(){
        if(num >= 10){
            point = 10;
        } else if(num == 1) {
            point = 11;
        } else {
            point = num;
        }
        return point;
    }
    
    // Setting the points to the card
    public void setPoint(int newPoint){
        point = newPoint;
    }
    
    
    // Storing cards in String
    public String toString(){
        return faces[num] + " of " + cardSuit[suit];
    }

}

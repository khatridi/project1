/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Megha Patel
 * @author Akhtar Muhammad
 * @modifier Divyeshkumar Khatri
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;//the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
    }
    
    public GroupOfCards(){
        cards = new ArrayList<Card>();
        // Iterating through all the suits and faces of the cards and adding them in new deck
        for(int i =0; i <= 4; i++){
            for(int j = 1; j <= 13; j++){
                cards.add(new Card(i, j));
            }
        }
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Random ran = new Random();
        Card crd;
        for(int i = 0; i < 104; i++){
            int a = ran.nextInt(cards.size() - 1);
            int b = ran.nextInt(cards.size() - 1);
            int c = ran.nextInt(cards.size() - 1);
            crd = cards.get(c);
            cards.set(c, cards.get(b));
            cards.set(b, cards.get(a));
            cards.set(a, crd);
        }
    }
    
    
    public Card drawNew(){
        return cards.remove(0);
    }
    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

}//end class

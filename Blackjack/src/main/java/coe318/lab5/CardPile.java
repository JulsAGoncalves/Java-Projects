package coe318.lab5;
/**
 *
 * @author 
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * A pile of cards.
 *
 */
public class CardPile {
    //Instance variables
    private ArrayList<Card> Card;
    private Random Random;
    
    
    public CardPile() {
        //Initialize the instance variable.
    Card = new ArrayList<Card>(); 
    Random = new Random(); 
    }
    /**
     * Add a card to the pile.
     * @param card
     */
    public void add(Card card) {
        Card.add(card);//FIX THIS
    }

    /**
     * Remove a card chosen at random from the pile.
     * @return
     */
    public Card removeRandom() {
         if (Card.isEmpty()) {
        return null; // Return null if the pile is empty
    }
         return Card.remove(Random.nextInt(Card.size())); //FIX THIS
    }

    /**
     * The string representation is a space separated list
     * of each card.
     * @return
     */
    @Override
    public String toString() {
        String result = "";
    
    for (Card card : Card) {
        result += card.toString() + " "; // Concatenate each card and a space
    }
    
    return result.trim(); // Remove the trailing space and return the resulting string
}
    
    
    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return Card;
    }

    public static void main(String[] args) {
        CardPile p = new CardPile();
        p.add(new Card(2, 1, true));
        p.add(new Card(3, 2, true));
        p.add(new Card(4, 3, false));
        p.add(new Card(14, 1, true));
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("");
        CardPile deck = new CardPile();
        for(int i = 2; i < 15; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        for (int i = 0; i < 52; i++) {
            System.out.println((i+1) + ": " + deck.removeRandom());

        }
    }


}
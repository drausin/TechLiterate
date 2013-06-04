
import java.util.Random;

/**
 * An implementation of a deck of cards.
 * 
 * @author Drausin Wulsin
 * @since 05/29/2013
 *
 */
public class Deck {

	/**
	 * The array of cards in the deck, where the top card is in the first index.
	 */
	private Card[] myCards;
	
	/**
	 * The number of cards currently in the deck.
	 */
	private int numCards;
	
	/**
	 * Constructor with a default of one deck (i.e., 52 cards) and no shuffling.
	 */
	public Deck(){
		
		// call other constructor, defining one deck without shuffling
		this(1, false);
	}
	
	/**
	 * Constructor that defines the number of decks (i.e., how many sets of 52 
	 * cards are in the deck) and whether it should be shuffled.
	 * 
	 * @param numDecks	the number of individual decks in this deck
	 * @param shuffle	whether to shuffle the cards
	 */
	public Deck(int numDecks, boolean shuffle){
		
		this.numCards = numDecks * 52;
		this.myCards = new Card[this.numCards];
		
		// card index
		int c = 0;
		
		// for each deck
		for (int d = 0; d < numDecks; d++) {
			
			// for each suit
			for (int s = 0; s < 4; s++) {
				
				// for each number
				for (int n = 1; n <= 13; n++) {
					
					// add a new card to the deck
					this.myCards[c] = new Card(Suit.values()[s], n);
					
					// increment card index
					c++;
					
				}
			}
		}
		
		// shuffle, if necessary
		if (shuffle) {
			this.shuffle();
		}
		
	}
	
	/**
	 * Shuffle deck by randomly swapping pairs of cards.
	 */
	public void shuffle(){
		
		// init random number generator
		Random rng = new Random();
		
		// temporary card
		Card temp;
		
		int j;
		for (int i = 0; i < this.numCards; i++){
			
			// get card to swap card i with
			j = rng.nextInt(this.numCards);
			
			// do swap
			temp = this.myCards[i];
			this.myCards[i] = this.myCards[j];
			this.myCards[j] = temp;
		}
		
	}
	
	/**
	 * Deal the next card from the top of the deck.
	 * 
	 * @return	the dealt card
	 */
	public Card dealNextCard() {
		
		// get top card
		Card top = this.myCards[0];
		
		// shift all other cards to the left by one
		for (int c = 1; c < this.numCards; c++) {
			this.myCards[c-1] = this.myCards[c];
		}
		this.myCards[this.numCards-1] = null;
		
		// decrement number of cards
		this.numCards--;
		
		// return top card
		return top;
		
	}
	
	/**
	 * Print the top cards in the deck.
	 * 
	 * @param numToPrint	the number cards from the top of the deck to print
	 */
	public void printDeck(int numToPrint) {
		
		// print the top cards 
		for (int c = 0; c < numToPrint; c++) {
			System.out.printf("% 3d/%d) %s\n", c + 1, this.numCards, 
					this.myCards[c].toString());
		}
		
		System.out.printf("         [%d others]\n\n", this.numCards-numToPrint);
		
	}
	
}

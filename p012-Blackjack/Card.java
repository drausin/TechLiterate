/**
 * An implementation of a card type.
 * 
 * @author Drausin Wulsin
 * @since 05/29/2013
 */
public class Card {
	
	/**
	 * One of the four valid suits for this card.
	 */
	private Suit mySuit;
	
	/**
	 * The number of this card, where Ace : 1, and Jack-King : 11-13
	 */
	private int myNumber;
	
	
	/**
	 * Card constructor.
	 * 
	 * @param aSuit		the suit of the card
	 * @param aNumber	the number of the card, where Jack-King : 11-13 and 
	 * 					Ace : 1
	 */
	public Card(Suit aSuit, int aNumber){
		
		this.mySuit = aSuit;
		this.myNumber = aNumber;
	}
	
	/**
	 * Return the number of the card.
	 * 
	 * @return the number
	 */
	public int getNumber(){
		return this.myNumber;
	}
	
	/**
	 * Override the toString() method to give the "Num of Suit" string for this 
	 * card. 
	 * 
	 * @return the string describing the card's number and suit
	 */
	public String toString(){
		
		String numStr = "Error";
		
		switch(this.myNumber){
		
			case 2:
				numStr = "Two";
				break;
			case 3: 
				numStr = "Three";
				break;
			case 4:
				numStr = "Four";
				break;
			case 5:
				numStr = "Five";
				break;
			case 6:
				numStr = "Six";
				break;
			case 7:
				numStr = "Seven";
				break;
			case 8:
				numStr = "Eight";
				break;
			case 9:
				numStr = "Nine";
				break;
			case 10:
				numStr = "Ten";
				break;
			case 11:
				numStr = "Jack";
				break;
			case 12:
				numStr = "Queen";
				break;
			case 13:
				numStr = "King";
				break;
			case 1:
				numStr = "Ace";
				break;
			}
		
		return numStr + " of " + mySuit.toString();
	}
}


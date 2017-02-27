import java.util.ArrayList;


public class Deck <T extends Card> {

	private ArrayList<T> cards = new ArrayList<T>();
	private int dealtIndex = 0;
	
	public void setDeckOfCards(ArrayList<T> deckOfCards) {
		cards = deckOfCards;
	}
	
	public void shuffle() {
		
	}
	
	public int remainingCards() {
		return cards.size() - dealtIndex;
	}
	
	public T[] dealHand(int number) {
		return null;
	}

	public T dealCard() {
		return null;
	}
}


public abstract class Card {

	private boolean available = true;
	protected int faceValue;
	protected Suit suit;
	
	public Card(int c, Suit s) {
		// TODO Auto-generated constructor stub
		faceValue = c;
		suit = s;
	}

	public abstract int value();
	
	public Suit suit() {
		return suit;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void markUnavailable() {
		available = false;
	}
	
	public void markAvailable() {
		available = true;
	}
}

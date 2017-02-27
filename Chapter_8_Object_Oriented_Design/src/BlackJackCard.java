
public class BlackJackCard extends Card {

	public BlackJackCard(int c, Suit s) {
		// TODO Auto-generated constructor stub
		super(c, s);
	}

	@Override
	public int value() {
		// TODO Auto-generated method stub
		if (isAce()) {
			return 1;
		} else if (isFaceCard()) {
			return 10;
		} else {
			return faceValue;
		}
	}

	public int minValue() {
		if (isAce()) {
			return 1;
		}
		return value();
	}
	
	public int maxValue() {
		if (isAce()) {
			return 11;
		}
		return value();
	}
	
	public boolean isAce() {
		return faceValue == 1;
	}
	
	public boolean isFaceCard() {
		return faceValue >= 11 && faceValue <= 13;
	}
}

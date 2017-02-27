
public enum Suit {
	Club (0), Diamond (1), Heart (2), Spade (3);
	
	private int value;
	
	private Suit(int v) {
		// TODO Auto-generated constructor stub
		value = v;
	}
	
	public int getValue() {
		return value;
	}

	public static Suit getSuitFromValue(int value) {
		switch(value) {
		case 0:
			return Club;
		case 1:
			return Diamond;
		case 2:
			return Heart;
		case 3:
			return Spade;
		default:
			throw new IllegalArgumentException();
		}
	}
}

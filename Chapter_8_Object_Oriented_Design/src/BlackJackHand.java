import java.util.ArrayList;


public class BlackJackHand extends Hand<BlackJackCard> {

	public int score() {
		ArrayList<Integer> scores = possibleScores();
		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;
		
		for (int score : scores) {
			if (score > 21 && score < minOver) {
				minOver = score;
			} else if (score <= 21 && score > maxUnder) {
				maxUnder = score;
			}
		}
		return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
	}
	
	private ArrayList<Integer> possibleScores() {
		return null;
	}

	public boolean busted() {
		return score() > 21;
	}
	
	public boolean is21() {
		return score() == 21;
	}
	
	public boolean isBlackJack() {
		return is21();
	}
}

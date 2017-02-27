import java.util.Stack;


public class Main {

	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int temp = s.pop();
			while (!r.isEmpty() && r.peek() > temp) {
				s.push(r.pop());
			}
			r.push(temp);
		}
		return r;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numTowers = 3;
		int numDisks = 5;
		Tower[] towers = new Tower[numTowers];
		for (int i = 0; i < numTowers; i++) {
			towers[i] = new Tower(i);
		}
		
		for (int i = numDisks; i>0; i--) {
			towers[0].add(i);
		}
		
		towers[0].moveDisks(numDisks, towers[2], towers[1]);
	}

}

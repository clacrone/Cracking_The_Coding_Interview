import java.util.Arrays;


public class Main {

	public String ranges(int[] arr) {
		if (arr == null || arr.length == 0) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		
		int head = 0;
		int counter = 0;
		for (int tail = 1; tail < arr.length; tail++) {
			if (arr[tail] - arr[tail-1] != 1) {
				if (counter > 0) { 
					sb.append(arr[head] + "-" + arr[tail-1] + ", ");
				} else {
					sb.append(arr[head] + ", ");
				}
				head = tail;
				counter = 0;
			} else {
				counter++;
			}
		}
		
		if (counter > 0) { 
			sb.append(arr[head] + "-" + arr[arr.length - 1] + ", ");
		} else {
			sb.append(arr[head]);
		}
		
		return sb.toString();
	}
	
	public boolean isUnique(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		
		if (s.length() > 256) {
			return false;
		}
		
		boolean[] characters = new boolean[256];
		
		for (Character c : s.toCharArray()) {
			if (characters[c] == true) {
				return false;
			}
			
			characters[c] = true;
		}
		
		return true;
	}
	
	public boolean isPermutation(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}
		
		int[] letters = new int[256];
		Arrays.fill(letters, 0);
		
		for (Character c : s1.toCharArray()) {
			letters[c]++;
		}
		
		for (Character c : s2.toCharArray()) {
			letters[c]--;
		}
		
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public String replaceSpaces(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		
		return s;
	}
	
	public String compress(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}
		
		StringBuffer buffer = new StringBuffer();
		
		int counter = 1;
		char lastCharacter = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == lastCharacter) {
				counter++;
			} else {
				buffer.append(lastCharacter);
				buffer.append(counter);
				lastCharacter = s.charAt(i);
				counter = 1;
			}
		}
		
		buffer.append(lastCharacter);
		buffer.append(counter);
		
		if (buffer.toString().length() >= s.length()) {
			return s;
		}
		
		return buffer.toString();
	}
	
	public int[][] rotate90degrees(int[][] image) {
		if (image == null) {
			return null;
		}
		
		int[][] newImage = new int[image.length][image.length];
		
		for (int row = 0; row < image.length; row++) {
			for (int column = 0; column < image.length; column++) {
				System.out.println("image.length: " + image.length + ", row: " + row);
				newImage[column][(image.length - 1) - row] = image[row][column];
			}
		}
		
		return newImage;
	}
	
	public void rotate(int[][] image) {
		for (int row = 0; row < image.length / 2; ++row) {
//			int first = row;
			int last = image.length - 1 - row;
			for (int column = row; column < last; ++column) {
				int offset = column - row;
				
				//save top
				int top = image[row][column];
				
				// left -> top
				image[row][column] = image[last - offset][row];
				
				// bottom -> left
				image[last-offset][row] = image[last][last-offset];
				
				// right -> bottom
				image[last][last - offset] = image[column][last];
				
				// top-> right
				image[column][last] = top;
			}
		}
	}
	
	public void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] || column[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	public boolean isSubstring(String s1, String s2) {
		return s1.contains(s2);
	}
	
	public boolean isRotation(String s1, String s2) {
		if (s1.length() == s2.length() && s1.length() > 0) {
			return isSubstring(s1 + s1, s2);
		}
		
		return false;
	}
	
	public int[][] transposeMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return null;
		}
		
		int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
		
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[0].length; column++) {
				transposedMatrix[column][row] = matrix[row][column];
			}
		}
		
		return transposedMatrix;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		String myString = "Hello World";
		String myString2 = "Craig";
//		boolean result = main.isUnique(myString);
//		boolean result = main.isPermutation(myString, myString2);
//		String result = main.compress("aaabbbbcccddeeeee");
//		System.out.println("The result is: " + result);
		int[][] testMatrix = new int[][]{
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		
		int[][] testMatrix1 = new int[][]{
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}
		};
//		main.rotate(testMatrix);
//		main.setZeros(testMatrix);
		
//		for (int i = 0; i < testMatrix.length; i++) {
//			System.out.print("[");
//			for (int j = 0; j < testMatrix.length; j++) {
//				System.out.print(testMatrix[i][j]);
//				if (j != testMatrix.length - 1) {
//					System.out.print(", ");
//				}
//			}
//			System.out.println("]");
//		}
		boolean result = main.isRotation("waterbottle", "erbottlewat");
		System.out.println("result is: " + result);
		
		int[][] tResult = main.transposeMatrix(testMatrix1);
		if (tResult != null) {
			for (int row = 0; row < tResult.length; row++) {
				System.out.print("[");
				for (int column = 0; column < tResult[0].length; column++) {
					System.out.print(tResult[row][column]);
					if (column < tResult[0].length - 1) {
						System.out.print(", ");
					}
				}
				System.out.println("]");
			}
		}
		
		
		int[] testArr = {0,1,2,7,8,9,10,21,22,23,24,25,27,1098,1099,2000};
		System.out.println(main.ranges(testArr));
	}

}

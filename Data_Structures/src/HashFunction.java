import java.util.Arrays;

// If we think of a Hash Table as an array
// then a hash function is used to generate
// a unique key for every item in the array.
// The position the item goes in is known
// as the slot. Hashing doesn't work very well
// in situations in which duplicate data
// is stored. Also it isn't good for searching
// for anything except a specific key. 
// However a Hash Table is a data structure that 
// offers fast insertion and searching capabilities.

public class HashFunction {

	String[] theArray;
	int arraySize;
	int itemsInArray = 0;

	public static void main(String[] args) {

		HashFunction theFunc = new HashFunction(30);

		// Simplest Hash Function

		// String[] elementsToAdd = { "1", "5", "17", "21", "26" };

		// theFunc.hashFunction1(elementsToAdd, theFunc.theArray);

		// Mod Hash Function
		// This contains exactly 30 items to show how collisions
		// will work

		String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",
				"235", "802", "900", "723", "699", "1", "16", "999", "890",
				"725", "998", "978", "988", "990", "989", "984", "320", "321",
				"400", "415", "450", "50", "660", "624" };

		theFunc.hashFunction2(elementsToAdd2, theFunc.theArray);

		// Locate the value 660 in the Hash Table

		theFunc.findKey("660");

		theFunc.displayTheStack();

	}

	// Simple Hash Function that puts values in the same
	// index that matches their value

	public void hashFunction1(String[] stringsForArray, String[] theArray) {

		for (int n = 0; n < stringsForArray.length; n++) {

			String newElementVal = stringsForArray[n];

			theArray[Integer.parseInt(newElementVal)] = newElementVal;

		}

	}

	// Now let's say we have to hold values between 0 & 999
	// but we never plan to have more than 15 values in all.
	// It wouldn't make sense to make a 1000 item array, so
	// what can we do?

	// One way to fit these numbers into a 30 item array is
	// to use the mod function. All you do is take the modulus
	// of the value versus the array size

	// The goal is to make the array big enough to avoid
	// collisions, but not so big that we waste memory

	public void hashFunction2(String[] stringsForArray, String[] theArray) {

		for (int n = 0; n < stringsForArray.length; n++) {

			String newElementVal = stringsForArray[n];

			// Create an index to store the value in by taking
			// the modulus

			int arrayIndex = Integer.parseInt(newElementVal) % 29;

			System.out.println("Modulus Index= " + arrayIndex + " for value "
					+ newElementVal);

			// Cycle through the array until we find an empty space

			while (theArray[arrayIndex] != "-1") {

				++arrayIndex;

				System.out.println("Collision Try " + arrayIndex + " Instead");

				// If we get to the end of the array go back to index 0

				arrayIndex %= arraySize;

			}

			theArray[arrayIndex] = newElementVal;

		}

	}

	// Returns the value stored in the Hash Table

	public String findKey(String key) {

		// Find the keys original hash key
		int arrayIndexHash = Integer.parseInt(key) % 29;

		while (theArray[arrayIndexHash] != "-1") {

			if (theArray[arrayIndexHash] == key) {

				// Found the key so return it
				System.out.println(key + " was found in index "
						+ arrayIndexHash);

				return theArray[arrayIndexHash];

			}

			// Look in the next index

			++arrayIndexHash;

			// If we get to the end of the array go back to index 0

			arrayIndexHash %= arraySize;

		}

		// Couldn't locate the key

		return null;

	}

	HashFunction(int size) {

		arraySize = size;

		theArray = new String[size];

		Arrays.fill(theArray, "-1");

	}

	public void displayTheStack() {

		int increment = 0;

		for (int m = 0; m < 3; m++) {

			increment += 10;

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {

				System.out.format("| %3s " + " ", n);

			}

			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {

				if (theArray[n].equals("-1"))
					System.out.print("|      ");

				else
					System.out
							.print(String.format("| %3s " + " ", theArray[n]));

			}

			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

		}

	}

}
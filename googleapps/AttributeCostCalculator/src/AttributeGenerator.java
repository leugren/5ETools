import java.util.Arrays;


public class AttributeGenerator {
	
	
	public static void main(String[] args) {
		int [] [] attributes = new int [5][];
		for (int h = 0; h < 5; h++) {
			attributes[h] = new int[6];
			for (int i = 0; i < 6; i++) {
				int minRoll = Integer.MAX_VALUE;
				int [] rolls = new int [4];
				for (int j = 0; j < 4; j++) {
					rolls[j] = Die.D6.roll();
					if (rolls[j] < minRoll) {
						minRoll = rolls[j];
					}
				}
				attributes[h][i] = 0;
				boolean minFound = false;
				for (int j = 0; j < 4; j++) {
					if (!minFound && rolls[j] == minRoll) {
						minFound = true;
					} else {
						attributes[h][i] += rolls[j];
					}
				}
			}
		}
		for (int h = 0; h < 5; h++) {
		    System.out.println(Arrays.toString(attributes[h]));
		}
	}

}

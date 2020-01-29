

	import java.util.Scanner;

	public class OverlappingLines {

		/*
		 * @author: Riad El Mahmoudy This program accepts two 2D lines and returns a
		 * boolean that says whether they overlap or not
		 */

		/*
		 * main method: prompts the user for two lines, creates the lines, deals with a
		 * few cases and outputs whether they overlap or not
		 */
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in); // prompt the user using the scanner class
			System.out.println("Enter your first line of type (x,y): "); // the user can input the line using (x,y) notation
			String coordinate = input.nextLine(); // We take the input as strings
			String[] parts = coordinate.split(","); // splits the string into substrings of each coordinate

			// isolating the coordinates and trimming it in case we have spaces between the
			// bracket and the comma
			String x = parts[0].trim().substring(1).trim();
			String y = parts[1].trim().substring(0, parts[1].trim().length() - 1).trim();

			int temp = 0; // temporary variable for switching

			int x1 = Integer.parseInt(x); // string to integer
			int x2 = Integer.parseInt(y); // string to integer
			if(x1>0||x2>0) {
				throw new IllegalArgumentException("Coordinates cannot be negative");
			}
			if (x1 > x2) { // making sure the coordinates are always turned into (min, max) form using the
							// temp variable
				temp = x1;
				x1 = x2;
				x2 = temp;
			}
			
			Scanner input2 = new Scanner(System.in); // prompt the user using the scanner class
			System.out.println("Enter your second line of type (x,y): "); // the user can input the line using (x,y)
																			// notation
			String coordinate2 = input2.nextLine(); // We take the input as strings
			String[] parts2 = coordinate2.split(","); // splits the string into substrings of each coordinate

			// isolating the coordinates and trimming it in case we have spaces between the
			// bracket and the comma
			String z = parts2[0].trim().substring(1).trim();
			String h = parts2[1].trim().substring(0, parts2[1].trim().length() - 1).trim();

			int x3 = Integer.parseInt(z); // string to integer
			int x4 = Integer.parseInt(h); // string to integer
			if(x3>0||x4>0) {
				throw new IllegalArgumentException("Coordinates cannot be negative");
			}
			if (x3 > x4) { // making sure the coordinates are always turned into (min, max) form using the
							// temp variable
				temp = x3;
				x3 = x4;
				x4 = temp;
			}
			// storing the lines in an array
			int[] l1 = { x1, x2 };
			int[] l2 = { x3, x4 };

			if (isOverlaping(l2, l1)) { // true if they overlap
				System.out.println("The line " + coordinate + " and the line " + coordinate2 + " overlap");
			} else { // they don't overlap
				System.out.println("The line " + coordinate + " and the line " + coordinate2 + " do not overlap");
			}

		}

		/*
		 * isOverlaping method: takes two arrays of type int[] and returns a boolean
		 * true if the lines overlap false if the lines don't overlap
		 */
		public static boolean isOverlaping(int[] l2, int[] l1) {
			// separating two options depending on which line is the lowest on the x axis

			if (l1[0] < l2[1]) { // l1 starts before l2
				if (l1[1] > l2[0]) { // l1's maximum is larger than l2's minimum, they overlap
					return true;
				} else {
					return false; // l1 and l2 don't overlap
				}
			} else { // l2 starts before l1
				if (l2[1] > l1[0]) { // l2's maximum is larger than l1's minimum
					return true;
				} else {
					return false; // l1 and l2 don't overlap
				}
			}

		}

	}


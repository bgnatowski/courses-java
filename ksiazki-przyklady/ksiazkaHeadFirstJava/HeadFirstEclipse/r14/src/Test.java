import java.util.Scanner;

public class Test {
	 public static void main(String[] args) {

	        Scanner scan = new Scanner("On a withered branch\n" +
	                "A crow has alighted.\n" +
	                "Nightfall in autumn.\n\n***" +
	                " \n" +
	                " \n" +
	                "Such a moon above,\n" +
	                "Like a tree cut at the root:\n" +
	                "The fresh cut is white.\n\n***" +
	                " \n" +
	                " \n" +
	                "How the river floods!\n" +
	                "A heron wanders on short legs,\n" +
	                "Knee-deep in the water.");

	        scan.useDelimiter("\n/*/*/*");

	        while (scan.hasNext()) {
	            System.out.println(scan.nextLine());
	        }

	        scan.close();
	    }
}

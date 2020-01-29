
import java.util.Scanner;

public class VersionStringComparison {
/*
 * This program compares two version strings and returns the newest version 
 * @author Riad El Mahmoudy
 */
	
	/*
	 * main method: prompts the user for two version strings in x.x.x form, stores the
	 * individual strings between the "." in an array, adjusts the length of the versions
	 * to match the largest, then compares the arrays thanks to the versionComparator method
	 * and outputs which one is the latest version
	 * @param input2, input 2: uses scanner class to get the version string
	 * @param version1, version2: strings storing the input
	 * @param vArray1, vArray2: arrays storing the input splitting each int
	 * @param newV1, newV2: arrays that adjust the two version's lengths and adds 0 to the shortest one to match the longest one
	 */
	public static void main(String[] args) {
	
		Scanner input1 = new Scanner(System.in); //Scanning the input
		System.out.println("Enter your first version"); //prompt
		String version1 = input1.nextLine(); //storing the input
		String[] vArray1 = version1.split("\\."); //split method to separate the x.x.x into {x,x,x}
		if(vArray1[0]==null) { //in case the program gets a null input
			throw new IllegalArgumentException("Version cannot be null");
		}
		
		Scanner input2= new Scanner(System.in); //Scanning the input
		System.out.println("Enter your second version"); //prompt
		String version2 = input2.nextLine();//storing the input
		String[] vArray2 = version2.split("\\."); //split method to separate the x.x.x into {x,x,x}
		
		//empty arrays with the length of the other version array in case that one is longer
		String[] newV2 = new String[vArray1.length]; 
		String[] newV1 = new String[vArray2.length];
		
		if(vArray1.length>vArray2.length) { //if v1 is longer
			for(int j = 0;j<vArray2.length;j++) { //add v2 to newV2
				newV2[j]=vArray2[j];
			}
			for(int i = vArray2.length; i<=vArray1.length-1; i++) { //add zeros to the rest of the array
				newV2[i]="0";
			}
		}else if (vArray1.length<vArray2.length) { //if v2 is longer 
			for(int j = 0;j<vArray1.length;j++) { //add v1 to newV1
				newV1[j]=vArray1[j];
			}
			for(int i = vArray1.length; i<=vArray2.length-1; i++) { //add zeros to the rest of the array
				newV1[i]="0";
			}
		}
		
		int result; //stores the result of the versionComparator method
		if(vArray1.length>vArray2.length) { //if v1 is larger, we now use newV2 instead of v2
			result = versionComparator(vArray1,newV2);
		}else if(vArray1.length<vArray2.length) { //if v2 is larger we now use newV1 instead of v1
			result = versionComparator(newV1,vArray2);
		}else { //if they're equal in length we use the arrays with no modification
			result = versionComparator(vArray1,vArray1);
		}
		
		 
		//Display result
		if (result ==1) { 
			System.out.println("The version "+version1+"is the latest version");
		}else if (result ==2) {
			System.out.println("The version "+version2+" is the latest version");
		}else if (result == 0) {
			System.out.println("Both versions are the latest versions the latest version");
		}

	}
	
	
	/*
	 * versionComparator method: takes in two string arrays, concatenates the elements of the array
	 * turns them into integers and compares them then outputs and integer:
	 * outputs 0 if the integers are equal
	 * outputs 1 if version1 is the largest
	 * outputs 2 if version2 is the largest
	 * @param strV1, strV2: concatenated string of the arrays
	 * @param intV1, intV2: from string (strV1, strV2) to integer
	 */
	public static int versionComparator(String[] v1, String[] v2) {
		String strV1 =""; 
		String strV2 ="";
        for (int j = 0;j<v1.length;j++) { //concatenating all the elements
        	strV1 += v1[j];
        }
        for (int k = 0;k<v2.length;k++) { //concatenating all the elements
        	strV2 += v2[k];
        }
        //integer to string
		int intV1 = Integer.parseInt(strV1);
		int intV2 = Integer.parseInt(strV2);
		
		//comparing the integers
		if(intV1>intV2) {
			return 1; //1 version1 is the latest 
		}else if (intV1 == intV2) {
			return 0;
		}else {
			return 2; //2 version 2 is the latest
		}
	}
	
}


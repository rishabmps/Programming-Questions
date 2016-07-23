import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Rishabh Agarwal
 * 
 * Given an array of numbers, arrange them in a way that yields the largest value. 
 * For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives 
 * the largest value. And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the 
 * arrangement 998764543431 gives the largest value.
 */
public class LargestNumberFromArray {
	
	public static void main(String[] args) {
			
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		Integer arr[] = new Integer[size];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		
		Arrays.sort(arr,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if((o1*Math.pow(10, String.valueOf((int)o2).length()) + o2 >=((o2*Math.pow(10, String.valueOf((int)o1).length()))) + o1)){
					
					return 1;
				}
				else{
					
					return -1;
				}
			}
		});
		
		System.out.println("The Number is: ");
		String s = "";
		for (int i = arr.length-1; i >=0; i--) {
			s += arr[i];
		}
		System.out.println(s);
		
	}

}

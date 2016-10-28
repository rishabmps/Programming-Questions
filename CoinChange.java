/*
Category: Dynamic Programming
How many different ways can you make change for an amount, given a list of coins? In this problem, your code will need to efficiently compute the answer.
Task
Write a program that, given
The amount  to make change for and the number of types  of infinitely available coins
A list of  coins C1 C2 ....Cm- 
Prints out how many different ways you can make change from the coins to STDOUT.
 */
import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N, M;
		N = in.nextInt();
		M = in.nextInt();
		int coins[] = new int[M];
		for (int i = 0; i < M; i++) {
			coins[i] = in.nextInt();
		}

		long table[][] = new long[N + 1][M + 1];
		for (int i = 0; i < coins.length+1; i++) {
			table[0][i] = 1;
		}
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				if (i < coins[j - 1]) {
					table[i][j] = table[i][j - 1];
				} else {
					table[i][j] = table[i][j - 1] + table[i - coins[j - 1]][j];
				}
			}
		}
		System.out.println(table[N][M]);
		in.close();
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Rishabh Agarwal
 *         https://www.hackerearth.com/problem/algorithm/a-50/description/ Find
 *         sum of 2 numbers which are very very large.
 */
public class Sum{
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		String x, y;
		int n, m, carry, i, temp;
		StringBuilder ans;
		while (t > 0) {
			x = in.readLine();
			y = in.readLine();
			n = x.length();
			m = y.length();
			ans = new StringBuilder("");
			i = 0;
			carry = 0;
			while (i < n && i < m) {
				temp = (x.charAt(n - i - 1) - '0') + (y.charAt(m - i - 1) - '0') + carry;
				ans.append(temp % 10);
				carry = temp / 10;
				i++;
			}
			while (i < n) {
				temp = (x.charAt(n - i - 1) - '0') + carry;
				ans.append(temp % 10);
				carry = temp / 10;
				i++;
			}

			while (i < m) {
				temp = (y.charAt(m - i - 1) - '0') + carry;
				ans.append(temp % 10);
				carry = temp / 10;
				i++;
			}
			if (carry != 0) {
				ans.append(carry);
			}
			ans.reverse();
			System.out.println(ans);
			t--;
		}
	}

}

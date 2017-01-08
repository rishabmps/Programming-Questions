
/*
Problem Description
Task. The first step of the HeapSort algorithm is to create a heap from the array you want to sort. By the way, did you know that algorithms based on Heaps are widely used for external sort, when you need to sort huge files that don’t fit into memory of a computer?
Your task is to implement this first step and convert a given array of integers into a heap. You will do that by applying a certain number of swaps to the array. Swap is an operation which exchanges elements ai and aj of the array a for some i and j. You will need to convert the array into a heap using only O(n) swaps, as was described in the lectures. Note that you will need to use a min-heap instead of a max-heap in this problem.
Input Format. The first line of the input contains single integer n. The next line contains n space-separated integers ai.
Constraints. 1 ≤ n ≤ 100 000; 0 ≤ i,j ≤ n − 1; 0 ≤ a0,a1,...,an−1 ≤ 109. All ai are distinct.
Output Format. The first line of the output should contain single integer m — the total number of swaps. m must satisfy conditions 0 ≤ m ≤ 4n. The next m lines should contain the swap operations used to convert the array a into a heap. Each swap is described by a pair of integers i,j — the 0-based indices of the elements to be swapped. After applying all the swaps in the specified order the array must become a heap, that is, for each i where 0 ≤ i ≤ n − 1 the following conditions must be true:
1.	If 2i + 1 ≤ n − 1, then ai < a2i+1.
2.	If 2i + 2 ≤ n − 1, then ai < a2i+2.
Note that all the elements of the input array are distinct. Note that any sequence of swaps that has length at most 4n and after which your initial array becomes a correct heap will be graded as correct.
Time Limits. C: 1 sec, C++: 1 sec, Java: 3 sec, Python: 3 sec. C#: 1.5 sec, Haskell: 2 sec, JavaScript: 3 sec, Ruby: 3 sec, Scala: 3 sec.
Memory Limit. 512Mb.

*/

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;
    private int size;
    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
        size = data.length-1;
        swaps = new ArrayList<Swap>();
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }

    private int leftChild(int i){
      return 2*i +1;
    }
    private int rightChild(int i){
      return 2*i +2;
    }
    private int parent(int i){
      return (i-1)/2;
    }
    private void shiftDown(int a){
      int l = leftChild(a);
      int min = a;
      if(l<=size && data[l]<data[min]){
        min = l;
      }
      int r = rightChild(a);
      if(r<=size && data[r]<data[min]){
        min = r;
      }
      if(a!=min){
        swaps.add(new Swap(a,min));
        int temp = data[a];
        data[a] = data[min];
        data[min] = temp;
        shiftDown(min);
      }

    }
    private void generateSwaps() {

      // The following naive implementation just sorts
      // the given sequence using selection sort algorithm
      // and saves the resulting sequence of swaps.
      // This turns the given array into a heap,
      // but in the worst case gives a quadratic number of swaps.
      //
      // TODO: replace by a more efficient implementation

      for (int i=(int)Math.floor(size/2);i>=0;i--  ) {
        shiftDown(i);
      }

    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

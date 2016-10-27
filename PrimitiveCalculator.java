/*
Category: Dynamic programming
Problem Description
Task. Given an integer n, compute the minimum number of operations needed to obtain the number n starting from the number 1.
Input Format. The input consists of a single integer 1 ≤ n ≤ 10^6.
Output Format. In the first line, output the minimum number k of operations needed to get n from 1. In the second line output a sequence of intermediate numbers. That is, the second line should contain positive integers a0,a2,...,ak−1 such that a0 = 1, ak−1 = n and for all 0 ≤ i < k − 1, ai+1 is equal to either ai + 1, 2ai, or 3ai. If there are many such sequences, output any one of them.
Time Limits.
language    C C++ Java Python C# Haskell JavaScript Ruby Scala
time in seconds 1   1   1.5 5   1.5 2   5   5   3
Memory Limit. 512Mb.

*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {

    private static HashMap<Integer, Integer> populate(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        if (n <= 1) {
            return map;
        }
        for (int i = 2; i <= n; i++) {
            int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, m3 = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                m1 = map.get(i / 2);
            }
            if (i % 3 == 0) {
                m2 = map.get(i / 3);
            }
            m3 = Math.min(m1, m2);
            m3 = Math.min(m3, map.get(i - 1));
            map.put(i, m3 + 1);
        }
        return map;
    }

    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = populate(n);
        while(n>1){
            sequence.add(n);
            if(n%2==0){
                if(map.get(n)==(map.get(n/2)+1)){
                    n=n/2;
                    continue;
                }
            }
            if(n%3==0){
                if(map.get(n)==(map.get(n/3)+1)){
                    n=n/3;
                    continue;
                }
            }
            if(map.get(n)==(map.get(n-1)+1)){
                n=n-1;
                continue;
            }
        }
        sequence.add(1);
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
        scanner.close();
    }
}

package org.milestone1;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

class Program1 {
    public record Result(long minimumCost, ArrayList<Integer> indices) {}

    /**
     * Solution to program 1
     * @param n number of panels
     * @param k maximum number of positions in a forward jump
     * @param costs array of costs of the panels
     * @return Result object containing the minimum total energy cost and the indices of the visited panels in increasing order(1-indexed, including n and excluding 0)
     */
    private static Result program1(int n, int k, int[] costs) {
        var minCost = 0;
        var indices = new ArrayList<Integer>();
        int i = 0;
        while (i<n) {
            i+=k;
            i = Math.min(i, n);
            minCost += costs[i];
            indices.add(i);
        }
        return new Result(minCost, indices);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] costs = new int[n];
        for(int i=0; i<n; i++){
            costs[i] = sc.nextInt();
        }
        sc.close();
        Result result = program1(n, k, costs);
        System.out.println(result.minimumCost);
        System.out.println(result.indices.size());
        for(int i=0; i<result.indices.size(); i++){
            System.out.println(result.indices.get(i));
        }
    }
}
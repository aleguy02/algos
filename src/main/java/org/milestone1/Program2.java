package org.milestone1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Program2 {
    public record Result(long minimumCost, ArrayList<Integer> indices) {}

    /**
     * Solution to program 1
     * @param n number of panels
     * @param k maximum number of positions in a forward jump
     * @param costs array of costs of the panels
     * @return Result object containing the minimum total energy cost and the indices of the visited panels in increasing order(1-indexed, including n and excluding 0)
     */
    static Result program2(int n, int k, int[] costs) {
        var indices = new ArrayList<Integer>();
        if (k >= n) {
            indices.add(n);
            return new Result(costs[costs.length-1], indices);
        }
        var p = 2;
        for (int i = 1; i <= n; i++) {
            if (costs[i-1] > costs[i]) {
                p = i-1;
                break;
            }
        }
        float bestCost = Float.POSITIVE_INFINITY;
        var bestRoute = new ArrayList<Integer>();

        var leftBound = Math.max(0,p-k);
        var rightBound = p;

        for (int l = leftBound; l <= rightBound; l++) {
            var r = l+k;
            if (r > n) {
                break;
            }
            if (r < p) {
                continue;
            }

            var leftSlice = Arrays.copyOfRange(costs, 0, l+1);
            var rightSlice = Arrays.copyOfRange(costs, r, n+1);
            Result leftResult = processLeft(leftSlice, k);
            Result rightResult = processRight(rightSlice, k, r);

            if ((leftResult.minimumCost + rightResult.minimumCost) < bestCost) {
                bestCost = leftResult.minimumCost + rightResult.minimumCost;
                bestRoute = leftResult.indices;
                bestRoute.addAll(rightResult.indices);
            }
        }
        return new Result((long) bestCost, bestRoute);
    }

    private static Result processLeft(int[] costs, int k) {
        var minCost = 0;
        var indices = new ArrayList<Integer>();
        int i = costs.length-1;
        while (i > 0) {
            minCost += costs[i];
            indices.add(i);
            i-=k;
        }
        Collections.reverse(indices);
        return new Result(minCost, indices);
    }

    private static Result processRight(int[] costs, int k, int offset) {
        var minCost = 0;
        var indices = new ArrayList<Integer>();
        int i = 0;
        int n = costs.length-1;
        while (i < n) {
            minCost += costs[i];
            indices.add(i+offset);
            i+=k;
        }
        minCost += costs[n];
        indices.add(n+offset);
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
        Result result = program2(n, k, costs);
        System.out.println(result.minimumCost);
        System.out.println(result.indices.size());
        for(int i=0; i<result.indices.size(); i++){
            System.out.println(result.indices.get(i));
        }
    }
}
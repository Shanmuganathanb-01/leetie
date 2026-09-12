// ──────────────────────────────────────────────────
// Problem  : 3414. Maximum Score of Non-overlapping Intervals
// Difficulty: Hard
// Tags     : Array, Binary Search, Dynamic Programming, Sorting
// Link     : https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/
// Runtime  : 1 ms (beats 0%)
// Memory   : 42960000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }
        
        java.util.Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[2], b[2]);
        });
        
        long[][][] dp = new long[n + 1][5][2];
        
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) ends[i] = arr[i][1];

        for (int i = 1; i <= n; i++) {
            int start = arr[i - 1][0];
            int weight = arr[i - 1][2];
            
            int prev = binarySearch(ends, i - 2, start);
            
            for (int k = 1; k <= 4; k++) {
                long skipW = dp[i - 1][k][0];
                long skipLex = dp[i - 1][k][1];
                
                dp[i][k][0] = skipW;
                dp[i][k][1] = skipLex;
                
                long prevWeight = 0;
                long prevLex = 0;
                if (prev != -1 && k > 1) {
                    prevWeight = dp[prev + 1][k - 1][0];
                    prevLex = dp[prev + 1][k - 1][1];
                } else if (k == 1) {
                    prevWeight = 0;
                    prevLex = 0;
                } else {
                    continue;
                }
                
                if (prev == -1 && k > 1) continue;
                
                long candWeight = weight + prevWeight;
                long candLex = prevLex ^ hashCodeVal(arr[i - 1][3]);
                
                if (candWeight > dp[i][k][0]) {
                    dp[i][k][0] = candWeight;
                    dp[i][k][1] = candLex;
                } else if (candWeight == dp[i][k][0]) {
                    if (isBetter(arr, reconstruct(arr, ends, i, k), reconstructPath(arr, ends, i, k, dp))) {
                        dp[i][k][1] = candLex;
                    }
                }
            }
        }
        
        long maxW = -1;
        int bestK = 0;
        for (int k = 1; k <= 4; k++) {
            if (dp[n][k][0] > maxW) {
                maxW = dp[n][k][0];
                bestK = k;
            }
        }
        
        List<Integer> bestRes = null;
        for (int k = 1; k <= 4; k++) {
            if (dp[n][k][0] == maxW) {
                List<Integer> cand = reconstruct(arr, ends, n, k);
                if (bestRes == null || isBetter(arr, cand, bestRes)) {
                    bestRes = cand;
                }
            }
        }
        
        java.util.Collections.sort(bestRes);
        int[] ans = new int[bestRes.size()];
        for (int i = 0; i < bestRes.size(); i++) ans[i] = bestRes.get(i);
        return ans;
    }
    
    private long hashCodeVal(int idx) {
        return (long)(idx + 1) * 31;
    }
    
    private List<Integer> reconstruct(int[][] arr, int[] ends, int curr, int k) {
        List<Integer> res = new ArrayList<>();
        while (k > 0 && curr > 0) {
            long currentWeight = dpWeight(arr, ends, curr, k);
            long skipWeight = dpWeight(arr, ends, curr - 1, k);
            
            if (currentWeight == skipWeight && currentWeight == dpWeight(arr, ends, curr - 1, k)) {
                curr--;
            } else {
                int prev = binarySearch(ends, curr - 2, arr[curr - 1][0]);
                long prevWeight = (k == 1) ? 0 : (prev == -1 ? -1 : dpWeight(arr, ends, prev + 1, k - 1));
                if (k == 1 || (prev != -1 && dpWeight(arr, ends, curr - 1, k) != arr[curr - 1][2] + prevWeight)) {
                    curr--;
                } else {
                    res.add(arr[curr - 1][3]);
                    k--;
                    curr = prev + 1;
                }
            }
        }
        return res;
    }
    
    private long dpWeight(int[][] arr, int[] ends, int curr, int k) {
        return simpleDp(arr, ends, curr, k);
    }
    
    private long simpleDp(int[][] arr, int[] ends, int n, int targetK) {
        long[][] dp = new long[n + 1][targetK + 1];
        for (int i = 1; i <= n; i++) {
            int start = arr[i - 1][0];
            int weight = arr[i - 1][2];
            int prev = binarySearch(ends, i - 2, start);
            for (int k = 1; k <= targetK; k++) {
                dp[i][k] = dp[i - 1][k];
                long prevWeight = 0;
                if (prev != -1 && k > 1) {
                    prevWeight = dp[prev + 1][k - 1];
                } else if (k == 1) {
                    prevWeight = 0;
                } else {
                    continue;
                }
                if (prev == -1 && k > 1) continue;
                dp[i][k] = Math.max(dp[i][k], weight + prevWeight);
            }
        }
        return dp[n][targetK];
    }

    private List<Integer> reconstructPath(int[][] arr, int[] ends, int curr, int k, long[][][] dp) {
        return reconstruct(arr, ends, curr, k);
    }

    private boolean isBetter(int[][] arr, List<Integer> a, List<Integer> b) {
        java.util.Collections.sort(a);
        java.util.Collections.sort(b);
        int len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();
    }

    private int binarySearch(int[] ends, int right, int target) {
        int low = 0, high = right, ans = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (ends[mid] < target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
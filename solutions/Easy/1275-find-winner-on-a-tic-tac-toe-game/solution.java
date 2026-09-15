// ──────────────────────────────────────────────────
// Problem  : 1275. Find Winner on a Tic Tac Toe Game
// Difficulty: Easy
// Tags     : Array, Hash Table, Matrix, Simulation
// Link     : https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43136000 (beats 25%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String tictactoe(int[][] moves) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0;
        int antiDiag = 0;
        
        int player = 1; 
        
        for (int[] move : moves) {
            int r = move[0];
            int c = move[1];
            
            rows[r] += player;
            cols[c] += player;
            if (r == c) {
                diag += player;
            }
            if (r + c == 2) {
                antiDiag += player;
            }
            
            if (Math.abs(rows[r]) == 3 || Math.abs(cols[c]) == 3 || 
                Math.abs(diag) == 3 || Math.abs(antiDiag) == 3) {
                return player == 1 ? "A" : "B";
            }
            
            player = -player;
        }
        
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
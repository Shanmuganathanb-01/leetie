// ──────────────────────────────────────────────────
// Problem  : 1603. Design Parking System
// Difficulty: Easy
// Tags     : Design, Simulation, Counting
// Link     : https://leetcode.com/problems/design-parking-system/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42616000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class ParkingSystem {
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        slots = new int[] { 0, big, medium, small };
    }
    
    public boolean addCar(int carType) {
        if (slots[carType] > 0) {
            slots[carType]--;
            return true;
        }
        return false;
    }
}
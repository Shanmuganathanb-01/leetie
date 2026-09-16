// ──────────────────────────────────────────────────
// Problem  : 1603. Design Parking System
// Difficulty: Easy
// Tags     : Design, Simulation, Counting
// Link     : https://leetcode.com/problems/design-parking-system/
// Runtime  : 7 ms (beats 100%)
// Memory   : 47268000 (beats 9%)
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
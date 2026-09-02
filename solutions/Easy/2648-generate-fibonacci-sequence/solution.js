// ──────────────────────────────────────────────────
// Problem  : 2648. Generate Fibonacci Sequence
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/generate-fibonacci-sequence/
// Runtime  : 47 ms (beats 31%)
// Memory   : 53968000 (beats 30%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @return {Generator<number>}
 */
var fibGenerator = function*() {
    let a = 0;
    let b = 1;
    
    while (true) {
        yield a;
        [a, b] = [b, a + b];
    }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */
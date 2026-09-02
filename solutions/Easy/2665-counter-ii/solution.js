// ──────────────────────────────────────────────────
// Problem  : 2665. Counter II
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/counter-ii/
// Runtime  : 44 ms (beats 84%)
// Memory   : 55408000 (beats 96%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let count = init;
    return {
        increment: () => ++count,
        decrement: () => --count,
        reset: () => (count = init)
    };
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */
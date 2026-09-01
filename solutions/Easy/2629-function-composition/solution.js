// ──────────────────────────────────────────────────
// Problem  : 2629. Function Composition
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/function-composition/
// Runtime  : 44 ms (beats 0%)
// Memory   : 53836000 (beats 0%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
    return function(x) {
        return functions.reduceRight((acc, fn) => fn(acc), x);
    }
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */
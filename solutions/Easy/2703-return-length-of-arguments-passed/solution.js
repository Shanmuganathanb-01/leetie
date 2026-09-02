// ──────────────────────────────────────────────────
// Problem  : 2703. Return Length of Arguments Passed
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/return-length-of-arguments-passed/
// Runtime  : 32 ms (beats 0%)
// Memory   : 53108000 (beats 0%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {...(null|boolean|number|string|Array|Object)} args
 * @return {number}
 */
var argumentsLength = function(...args) {
    return args.length;
};

/**
 * argumentsLength(1, 2, 3); // 3
 */
// ──────────────────────────────────────────────────
// Problem  : 2703. Return Length of Arguments Passed
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/return-length-of-arguments-passed/
// Runtime  : 48 ms (beats 27%)
// Memory   : 54124000 (beats 11%)
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
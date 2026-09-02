// ──────────────────────────────────────────────────
// Problem  : 2649. Nested Array Generator
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/nested-array-generator/
// Runtime  : 172 ms (beats 35%)
// Memory   : 90656000 (beats 11%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {Array} arr
 * @return {Generator}
 */
var inorderTraversal = function*(arr) {
    for (const item of arr) {
        if (Array.isArray(item)) {
            yield* inorderTraversal(item);
        } else {
            yield item;
        }
    }
};

/**
 * const gen = inorderTraversal([1, [2, 3]]);
 * gen.next().value; // 1
 * gen.next().value; // 2
 * gen.next().value; // 3
 */
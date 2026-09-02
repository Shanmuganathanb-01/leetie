// ──────────────────────────────────────────────────
// Problem  : 2722. Join Two Arrays by ID
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/join-two-arrays-by-id/
// Runtime  : 276 ms (beats 73%)
// Memory   : 99792000 (beats 78%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    const result = {};

    for (const obj of arr1) {
        result[obj.id] = { ...obj };
    }

    for (const obj of arr2) {
        if (result[obj.id]) {
            Object.assign(result[obj.id], obj);
        } else {
            result[obj.id] = { ...obj };
        }
    }

    return Object.values(result);
};
// ──────────────────────────────────────────────────
// Problem  : 2727. Is Object Empty
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/is-object-empty/
// Runtime  : 52 ms (beats 12%)
// Memory   : 53760000 (beats 70%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmpty = function(obj) {
    return Object.keys(obj).length === 0;
};
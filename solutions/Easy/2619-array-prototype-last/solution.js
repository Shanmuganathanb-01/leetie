// ──────────────────────────────────────────────────
// Problem  : 2619. Array Prototype Last
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/array-prototype-last/
// Runtime  : 60 ms (beats 0%)
// Memory   : 54552000 (beats 0%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @return {null|boolean|number|string|Array|Object}
 */
Array.prototype.last = function() {
    if (this.length === 0) {
        return -1;
    }
    return this[this.length - 1];
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */
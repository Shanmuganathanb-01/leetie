// ──────────────────────────────────────────────────
// Problem  : 2631. Group By
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/group-by/
// Runtime  : 110 ms (beats 49%)
// Memory   : 79260000 (beats 51%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    return this.reduce((res, item) => {
        const key = fn(item);
        (res[key] = res[key] || []).push(item);
        return res;
    }, {});
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */
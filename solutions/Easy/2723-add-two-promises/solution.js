// ──────────────────────────────────────────────────
// Problem  : 2723. Add Two Promises
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/add-two-promises/
// Runtime  : 38 ms (beats 0%)
// Memory   : 54168000 (beats 0%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
var addTwoPromises = async function(promise1, promise2) {
    const [val1, val2] = await Promise.all([promise1, promise2]);
    return val1 + val2;
};

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */
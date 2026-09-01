// ──────────────────────────────────────────────────
// Problem  : 2621. Sleep
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/sleep/
// Runtime  : 49 ms (beats 30%)
// Memory   : 53264000 (beats 69%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {number} millis
 * @return {Promise}
 */
async function sleep(millis) {
    return new Promise(resolve => setTimeout(resolve, millis));
}

/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */
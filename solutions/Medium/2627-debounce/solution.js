// ──────────────────────────────────────────────────
// Problem  : 2627. Debounce
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/debounce/
// Runtime  : 44 ms (beats 0%)
// Memory   : 53488000 (beats 0%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function(fn, t) {
    let timer;
    
    return function(...args) {
        clearTimeout(timer);
        timer = setTimeout(() => {
            fn(...args);
        }, t);
    };
};

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */
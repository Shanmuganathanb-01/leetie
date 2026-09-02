// ──────────────────────────────────────────────────
// Problem  : 2666. Allow One Function Call
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/allow-one-function-call/
// Runtime  : 43 ms (beats 0%)
// Memory   : 53076000 (beats 0%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {Function} fn
 * @return {Function}
 */
var once = function(fn) {
    let hasBeenCalled = false;
    
    return function(...args){
        if (!hasBeenCalled) {
            hasBeenCalled = true;
            return fn(...args);
        }
        return undefined;
    }
};

/**
 * let fn = (a,b,c) => (a + b + c)
 * let onceFn = once(fn)
 *
 * onceFn(1,2,3); // 6
 * onceFn(2,3,6); // returns undefined without calling fn
 */
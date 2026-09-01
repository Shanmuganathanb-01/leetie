// ──────────────────────────────────────────────────
// Problem  : 2630. Memoize II
// Difficulty: Hard
// Tags     : N/A
// Link     : https://leetcode.com/problems/memoize-ii/
// Runtime  : 55 ms (beats 0%)
// Memory   : 52680000 (beats 0%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const globalCache = new Map();
    const RESULT_KEY = Symbol('RESULT');

    return function(...args) {
        let currentMap = globalCache;

        for (const arg of args) {
            if (!currentMap.has(arg)) {
                currentMap.set(arg, new Map());
            }
            currentMap = currentMap.get(arg);
        }

        if (currentMap.has(RESULT_KEY)) {
            return currentMap.get(RESULT_KEY);
        }

        const result = fn(...args);
        currentMap.set(RESULT_KEY, result);
        return result;
    }
}

/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */
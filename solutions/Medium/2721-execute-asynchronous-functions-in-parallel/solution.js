// ──────────────────────────────────────────────────
// Problem  : 2721. Execute Asynchronous Functions in Parallel
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/execute-asynchronous-functions-in-parallel/
// Runtime  : 47 ms (beats 0%)
// Memory   : 53956000 (beats 0%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function(functions) {
    return new Promise((resolve, reject) => {
        const results = new Array(functions.length);
        let completedCount = 0;

        functions.forEach((fn, index) => {
            fn()
                .then(val => {
                    results[index] = val;
                    completedCount++;
                    if (completedCount === functions.length) {
                        resolve(results);
                    }
                })
                .catch(err => reject(err));
        });
    });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */
// ──────────────────────────────────────────────────
// Problem  : 2667. Create Hello World Function
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/create-hello-world-function/
// Runtime  : 42 ms (beats 0%)
// Memory   : 52680000 (beats 0%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @return {Function}
 */
var createHelloWorld = function() {
    return function(...args) {
        return "Hello World";
    };
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */
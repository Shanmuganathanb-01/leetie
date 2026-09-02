// ──────────────────────────────────────────────────
// Problem  : 2667. Create Hello World Function
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/create-hello-world-function/
// Runtime  : 36 ms (beats 86%)
// Memory   : 53692000 (beats 39%)
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
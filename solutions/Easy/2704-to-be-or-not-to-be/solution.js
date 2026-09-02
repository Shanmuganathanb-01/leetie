// ──────────────────────────────────────────────────
// Problem  : 2704. To Be Or Not To Be
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/to-be-or-not-to-be/
// Runtime  : 47 ms (beats 37%)
// Memory   : 53784000 (beats 40%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
    return {
        toBe: function(otherVal) {
            if (val === otherVal) {
                return true;
            }
            throw new Error("Not Equal");
        },
        notToBe: function(otherVal) {
            if (val !== otherVal) {
                return true;
            }
            throw new Error("Equal");
        }
    };
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */
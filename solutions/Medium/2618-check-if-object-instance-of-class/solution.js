// ──────────────────────────────────────────────────
// Problem  : 2618. Check if Object Instance of Class
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/check-if-object-instance-of-class/
// Runtime  : 68 ms (beats 78%)
// Memory   : 63240000 (beats 46%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

var checkIfInstanceOf = function(obj, classFunction) {
    if (obj === null || obj === undefined || typeof classFunction !== 'function') {
        return false;
    }
    
    let curr = Object(obj);
    while (curr !== null) {
        curr = Object.getPrototypeOf(curr);
        if (curr === classFunction.prototype) {
            return true;
        }
    }
    
    return false;
};
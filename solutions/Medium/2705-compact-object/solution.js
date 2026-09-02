// ──────────────────────────────────────────────────
// Problem  : 2705. Compact Object
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/compact-object/
// Runtime  : 68 ms (beats 66%)
// Memory   : 64544000 (beats 76%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    if (obj === null) return null;
    if (typeof obj !== 'object') return obj;
    
    if (Array.isArray(obj)) {
        const compactedArray = [];
        for (const item of obj) {
            const compactedItem = compactObject(item);
            if (Boolean(compactedItem)) {
                compactedArray.push(compactedItem);
            }
        }
        return compactedArray;
    }
    
    const compactedObj = {};
    for (const key in obj) {
        const compactedValue = compactObject(obj[key]);
        if (Boolean(compactedValue)) {
            compactedObj[key] = compactedValue;
        }
    }
    return compactedObj;
};
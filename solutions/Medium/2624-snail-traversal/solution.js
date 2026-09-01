// ──────────────────────────────────────────────────
// Problem  : 2624. Snail Traversal
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/snail-traversal/
// Runtime  : 32 ms (beats 0%)
// Memory   : 53180000 (beats 0%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {number} rowsCount
 * @param {number} colsCount
 * @return {Array<Array<number>>}
 */
Array.prototype.snail = function(rowsCount, colsCount) {
    if (rowsCount * colsCount !== this.length) {
        return [];
    }

    const result = Array.from({ length: rowsCount }, () => new Array(colsCount));

    for (let i = 0; i < this.length; i++) {
        const col = Math.floor(i / rowsCount);
        const row = col % 2 === 0 ? i % rowsCount : rowsCount - 1 - (i % rowsCount);
        result[row][col] = this[i];
    }

    return result;
};

/**
 * const arr = [1,2,3,4];
 * arr.snail(1,4); // [[1,2,3,4]]
 */
// ──────────────────────────────────────────────────
// Problem  : 2650. Design Cancellable Function
// Difficulty: Hard
// Tags     : N/A
// Link     : https://leetcode.com/problems/design-cancellable-function/
// Runtime  : 46 ms (beats 81%)
// Memory   : 53296000 (beats 78%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {Generator} generator
 * @return {[Function, Promise]}
 */
var cancellable = function(generator) {
    let cancel;
    const cancelPromise = new Promise((_, reject) => {
        cancel = () => reject("Cancelled");
    });

    // Suppress unhandled promise rejection warnings on cancelPromise
    cancelPromise.catch(() => {});

    const promise = (async () => {
        let nextParam;
        let isError = false;

        while (true) {
            let res;
            try {
                if (isError) {
                    res = generator.throw(nextParam);
                } else {
                    res = generator.next(nextParam);
                }
            } catch (err) {
                throw err;
            }

            if (res.done) {
                return res.value;
            }

            try {
                nextParam = await Promise.race([res.value, cancelPromise]);
                isError = false;
            } catch (err) {
                nextParam = err;
                isError = true;
            }
        }
    })();

    return [cancel, promise];
};

/**
 * function* tasks() {
 *   const val = yield new Promise(resolve => resolve(2 + 2));
 *   yield new Promise(resolve => setTimeout(resolve, 100));
 *   return val + 1;
 * }
 * const [cancel, promise] = cancellable(tasks());
 * setTimeout(cancel, 50);
 * promise.catch(console.log); // logs "Cancelled" at t=50ms
 */
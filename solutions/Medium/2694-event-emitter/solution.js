// ──────────────────────────────────────────────────
// Problem  : 2694. Event Emitter
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/event-emitter/
// Runtime  : 46 ms (beats 54%)
// Memory   : 53656000 (beats 77%)
// Language : javascript
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class EventEmitter {
    constructor() {
        this.events = new Map();
    }

    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object}
     */
    subscribe(eventName, callback) {
        if (!this.events.has(eventName)) {
            this.events.set(eventName, []);
        }

        const callbacks = this.events.get(eventName);
        callbacks.push(callback);

        return {
            unsubscribe: () => {
                const index = callbacks.indexOf(callback);
                if (index !== -1) {
                    callbacks.splice(index, 1);
                }
            }
        };
    }

    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array}
     */
    emit(eventName, args = []) {
        if (!this.events.has(eventName)) {
            return [];
        }

        const callbacks = this.events.get(eventName);
        const results = [];

        for (const fn of callbacks) {
            results.push(fn(...args));
        }

        return results;
    }
}
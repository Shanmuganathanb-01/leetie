// ──────────────────────────────────────────────────
// Problem  : 284. Peeking Iterator
// Difficulty: Medium
// Tags     : Array, Design, Iterator
// Link     : https://leetcode.com/problems/peeking-iterator/
// Runtime  : 4 ms (beats 80%)
// Memory   : 43856000 (beats 9%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        if (this.iterator.hasNext()) {
            this.nextElement = this.iterator.next();
        }
    }

    public Integer peek() {
        return nextElement;
    }

    @Override
    public Integer next() {
        Integer res = nextElement;
        nextElement = iterator.hasNext() ? iterator.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }
}
// ──────────────────────────────────────────────────
// Problem  : 1115. Print FooBar Alternately
// Difficulty: Medium
// Tags     : Concurrency
// Link     : https://leetcode.com/problems/print-foobar-alternately/
// Runtime  : 20 ms (beats 86%)
// Memory   : 45780000 (beats 36%)
// Language : java
// Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore fooSemaphore = new Semaphore(1);
    private Semaphore barSemaphore = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();
            printFoo.run();
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            printBar.run();
            fooSemaphore.release();
        }
    }
}
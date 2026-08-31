# ──────────────────────────────────────────────────
# Problem  : 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
# Difficulty: Medium
# Tags     : Linked List
# Link     : https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
# Runtime  : 208 ms (beats 80%)
# Memory   : 90588000 (beats 82%)
# Language : python
# Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
# Synced by: leetie
# ──────────────────────────────────────────────────

class Solution(object):
    def nodesBetweenCriticalPoints(self, head):
        if not head or not head.next or not head.next.next:
            return [-1, -1]
        
        prev = head
        curr = head.next
        index = 1
        
        first_cp = -1
        prev_cp = -1
        min_dist = float('inf')
        
        while curr.next:
            if (curr.val > prev.val and curr.val > curr.next.val) or \
               (curr.val < prev.val and curr.val < curr.next.val):
                
                if first_cp == -1:
                    first_cp = index
                else:
                    min_dist = min(min_dist, index - prev_cp)
                
                prev_cp = index
            
            prev = curr
            curr = curr.next
            index += 1
            
        if min_dist == float('inf'):
            return [-1, -1]
            
        return [min_dist, prev_cp - first_cp]
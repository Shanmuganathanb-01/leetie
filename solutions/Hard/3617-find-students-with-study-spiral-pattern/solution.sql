-- ──────────────────────────────────────────────────
-- Problem  : 3617. Find Students with Study Spiral Pattern
-- Difficulty: Hard
-- Tags     : N/A
-- Link     : https://leetcode.com/problems/find-students-with-study-spiral-pattern/
-- Runtime  : 125 ms (beats 0%)
-- Memory   : 0B (beats 0%)
-- Language : mysql
-- Copyright: (c) 2026 Shanmuganathanb-01. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

WITH streak_break AS (
    SELECT 
        student_id,
        subject,
        session_date,
        hours_studied,
        LAG(session_date) OVER (PARTITION BY student_id ORDER BY session_date) AS prev_date,
        CASE 
            WHEN LAG(session_date) OVER (PARTITION BY student_id ORDER BY session_date) IS NULL THEN 0
            WHEN DATEDIFF(session_date, LAG(session_date) OVER (PARTITION BY student_id ORDER BY session_date)) > 2 THEN 1
            ELSE 0
        END AS is_break
    FROM study_sessions
),
streak_groups AS (
    SELECT 
        student_id,
        subject,
        session_date,
        hours_studied,
        SUM(is_break) OVER (PARTITION BY student_id ORDER BY session_date) AS streak_id,
        ROW_NUMBER() OVER (PARTITION BY student_id ORDER BY session_date) AS overall_seq
    FROM streak_break
),
subject_positions AS (
    SELECT 
        student_id,
        subject,
        session_date,
        hours_studied,
        streak_id,
        ROW_NUMBER() OVER (PARTITION BY student_id, streak_id ORDER BY session_date) AS pos,
        ROW_NUMBER() OVER (PARTITION BY student_id, streak_id, subject ORDER BY session_date) AS subj_occurrence
    FROM streak_groups
),
cycle_candidates AS (
    SELECT 
        s1.student_id,
        s1.streak_id,
        s1.pos AS cycle_length,
        COUNT(*) AS total_streak_sessions,
        SUM(s2.hours_studied) AS total_study_hours
    FROM subject_positions s1
    JOIN subject_positions s2 
      ON s1.student_id = s2.student_id 
     AND s1.streak_id = s2.streak_id
    WHERE s1.subj_occurrence = 2
      AND s1.pos >= 3
    GROUP BY s1.student_id, s1.streak_id, s1.pos
    HAVING COUNT(*) >= 2 * s1.pos
),
valid_patterns AS (
    SELECT 
        c.student_id,
        c.streak_id,
        c.cycle_length,
        c.total_study_hours
    FROM cycle_candidates c
    WHERE NOT EXISTS (
        SELECT 1
        FROM subject_positions p1
        JOIN subject_positions p2 
          ON p1.student_id = p2.student_id 
         AND p1.streak_id = p2.streak_id 
         AND p2.pos = p1.pos + c.cycle_length
        WHERE p1.student_id = c.student_id 
          AND p1.streak_id = c.streak_id
          AND p1.subject <> p2.subject
    )
)
SELECT 
    st.student_id,
    st.student_name,
    st.major,
    v.cycle_length,
    v.total_study_hours
FROM (
    SELECT 
        student_id,
        cycle_length,
        total_study_hours,
        ROW_NUMBER() OVER (PARTITION BY student_id ORDER BY cycle_length DESC, total_study_hours DESC) AS rn
    FROM valid_patterns
) v
JOIN students st ON st.student_id = v.student_id
WHERE v.rn = 1
ORDER BY v.cycle_length DESC, v.total_study_hours DESC, st.student_id ASC;
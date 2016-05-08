# Problem

No: 178
Link: https://leetcode.com/problems/rank-scores/

# Solution

SELECT 
  sc.Score,
  (SELECT 
    COUNT(*) 
  FROM
    (SELECT DISTINCT 
      (Score) 
    FROM Scores) AS uniques 
  WHERE uniques.Score >= sc.Score) AS rank 
FROM
  Scores sc 
ORDER BY sc.Score DESC

#Reference

https://leetcode.com/discuss/21473/accepted-solution-using-innerjoin-and-groupby?show=21473#q21473


# Problem

No: 182
Link: https://leetcode.com/problems/duplicate-emails/

# Solution

select distinct a.Email from Person a join Person b on a.Email = b.Email where a.Id != b.Id
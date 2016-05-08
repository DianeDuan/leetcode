# Problem

No: 189
Link: https://leetcode.com/problems/delete-duplicate-emails/

# Solution

delete from Person where Id not in (select Id from (select min(Id) as Id from Person group by Email) as tmp);
# Problem

No: 180
Link: https://leetcode.com/problems/consecutive-numbers/

# Solution

select distinct a.Num from Logs a join Logs b on b.Id = a.Id + 1 and a.Num = b.Num join Logs c on c.id = b.Id + 1 and c.Num = b.Num
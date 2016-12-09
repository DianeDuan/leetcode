# Problem

No: 176
Link: https://leetcode.com/problems/second-highest-salary/

# Solution

select distinct Salary from Employee union all select null order by Salary desc limit 1, 1
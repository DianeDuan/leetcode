# Problem

No: 181
Link: https://leetcode.com/problems/employees-earning-more-than-their-managers/

# Solution

select a.Name as Employee from Employee a join Employee b on a.ManagerId = b.Id where a.Salary > b.Salary
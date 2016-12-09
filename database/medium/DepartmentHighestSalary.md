# Problem

No: 184
Link: https://leetcode.com/problems/department-highest-salary/

# Solution

select d.Name as Department, e.Name as Employee, e.Salary from 

(Employee e join 

((select max(Salary) as max_salary, DepartmentId as d_id from Employee group by DepartmentId) as tmp) 

on e.Salary = tmp.max_salary and e.DepartmentId = tmp.d_id) 

join Department d on e.DepartmentId = d.Id
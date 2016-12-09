# Problem

No: 183
Link: https://leetcode.com/problems/customers-who-never-order/

# Solution

select c.Name as Customers from Customers c left join Orders o on c.Id = o.CustomerId where o.Id is null
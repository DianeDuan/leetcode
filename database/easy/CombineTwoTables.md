# Problem

No: 175
Link: https://leetcode.com/problems/combine-two-tables/

# Solution

select FirstName, LastName, City, State from Person left join Address on Person.PersonId = Address.PersonId
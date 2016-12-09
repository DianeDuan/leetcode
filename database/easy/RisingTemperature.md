# Problem

No: 197
Link: https://leetcode.com/problems/rising-temperature/

# Solution

select today.Id from Weather today join Weather yesterday on today.Date = Date_ADD(yesterday.Date, INTERVAL 1 DAY) where today.Temperature > yesterday.Temperature
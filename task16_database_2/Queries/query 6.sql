#------------------------------------------ 1
#  select avg(price) as "average price = " from laptop;

#------------------------------------------ 2
#  select concat("code: ", code) as "code", 
#  concat("model: ", model) as "model", 
#  concat("speed: ", speed) as "speed", 
#  concat("ram: ", ram) as "ram", 
#  concat("hd: ", hd) as "hd" 
#  from pc;

#------------------------------------------ 3
#  select concat(cast(year(date) as char), '.', cast(month(date) as char), '.', cast(day(date) as char)) as "date" from income;

#------------------------------------------ 4
#  select ship, battle, case result 
#  when 'sunk' then 'потонув'
#  when 'damaged' then 'пошкоджено'
#  else 'вцілів'
#  end as result
#  from outcomes;

#------------------------------------------ 5
#  select trip_no, date, ID_psg, concat('ряд: ', LEFT (place, 1)) as "row", concat('місце: ', RIGHT(place, 1)) as "place" from pass_in_trip; 

#------------------------------------------ 6
#  select trip_no, ID_comp, plane, concat("from ", town_from, " to ", town_to) as "town_from_to", time_out, time_in from trip

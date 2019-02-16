#------------------------------------------ 1
#  select model, price from printer group by model having price = max(price);

#------------------------------------------ 2
#  select model, speed from laptop having speed<all(select speed from pc);

#------------------------------------------ 3
#  select maker, price from printer join product p on printer.model=p.model where color = 'y' and price<300;

#------------------------------------------ 4
#  select PC.maker from (select maker from product where type='PC' group by maker having COUNT(*)>=2) PC;

#------------------------------------------ 5
#  select avg(hd) from pc join product p on pc.model = p.model 
#  where pc.model in (select model from printer);

#------------------------------------------ 6    
#  select date, COUNT(*) AS Число_рейсів from Pass_in_trip
#  where trip_no=ANY(select trip_no from trip where town_from='london') group by date;
    
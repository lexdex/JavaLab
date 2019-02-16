#------------------------------------------ 1
#  select distinct maker from product 
#  where maker not IN (select maker from product where model IN (select model from laptop)) 
#  and maker IN (select maker from product where model IN (select model from pc));

#------------------------------------------ 2
#  select distinct maker from product
#  where maker = ALL (select maker from product where maker in (select maker from product where model in (select model from pc)) 
#  and maker not in (select maker from product where model in (select model from laptop)) );

#------------------------------------------ 3
#  select distinct maker from product 
#  where maker = ANY (select maker from product where model in (select model from pc)) 
#  and maker not in (select maker from product where model in (select model from laptop));

#------------------------------------------ 4
#  select distinct maker from product
#  where maker in (SELECT maker from product where model IN (SELECT model from laptop)) 
#  and maker in (SELECT maker from product where model IN (SELECT model from pc));

#------------------------------------------ 5  
#  select distinct maker from product 
#  where maker != ALL (select maker from product where maker in (select maker from product where model in (select model from pc)) 
#  and maker in (select maker from product where model in (select model from laptop)) );

#------------------------------------------ 6
#  select distinct maker from product
#  where (maker=ANY(select maker from product where type='PC')) and type='Laptop';




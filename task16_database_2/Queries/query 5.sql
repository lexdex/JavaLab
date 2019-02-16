#------------------------------------------ 1
#  select distinct maker from product
#  where exists (select model from pc where product.model=model);

#------------------------------------------ 2
#  select maker from product
#  where exists (select model from pc where product.model=model and speed>=750);

#------------------------------------------ 3
#  select distinct maker from product
#  where maker = any (select maker from product where exists (select model from pc where product.model=model and speed>=750)) 
#  and maker = any (select maker from product where exists(select model from laptop where product.model=model and speed>=750));

#------------------------------------------ 4
#  select maker from product
#  where exists (select model from pc where product.model=model and speed=(select max(speed) from pc));
   
#------------------------------------------ 5
#  select name, launched, displacement
#  from classes c, ships s where c.class=s.class and s.launched>=1922 and displacement>35000;
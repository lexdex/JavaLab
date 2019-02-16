#------------------------------------------ 1
#  select maker, PC.model, type, price from product, pc where product.model=pc.model and maker='B'
#  union
#  select maker, laptop.model, type, price from product, laptop where product.model=laptop.model and maker='B'
#  union
#  select maker, printer.model, product.type, price from product, printer where product.model=printer.model and maker='B';

#------------------------------------------ 6
#  select class,
#  (select COUNT(*)
#  from Ships
#  where Ships.class=Classes.class
#  )as Кількість_кораблів_у_класі
#  from Classes
#  where EXISTS(select * from Ships where Ships.class=Classes.class)
#  UNION select class,
#  (select COUNT(*)
#  from Outcomes
#  where Classes.class = Outcomes.ship
#  ) as Кількість_кораблів_у_класі
#  from Classes
#  where EXISTS(select * from Outcomes where Classes.class = Outcomes.ship)
#  and NOT EXISTS(select * from Ships where Ships.class=Classes.class);
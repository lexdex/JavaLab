#------------------------------------------ 1
#  select maker,
#  case when
#  ( select COUNT(*)
#  from product where type='printer' group by maker having maker=p.maker 
#  ) is not NULL then 'yes('+
#  (( select COUNT(*)
#  from product where type='printer' group by maker having maker=p.maker ),1)+')' 
#  else 'no'
#  end as printer from product p group by maker;

# ----------------------------------------- 3
# select name, numGuns, bore, displacement, type, country, launched, class from (select name, numGuns, bore, displacement, type, country, launched, class,
#	case when numGuns=8 then 1 else 0 end n,
#	case when bore=15 then 1 else 0 end b,
#	case when displacement=32000 then 1 else 0 end d,
#	case when type='bb' then 1 else 0 end t,
#	case when country='USA' then 1 else 0 end c,
#	case when launched=1915 then 1 else 0 end l,
#	case when class='Kongo' then 1 else 0 end cl
# from (select name, numGuns, bore, displacement, type, country, launched, Ships.class from Ships, Classes where Ships.class = Classes.class) A) B
# where B.n + B.b + B.d + B.t + B.t + B.c + B.l + B.cl > 3;
 
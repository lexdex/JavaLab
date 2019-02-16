#------------------------------------------ 1
#  select E.maker, E.PC, E.laptop, R.printer from(select C.maker, C.pc, D.laptop from(select A.maker, B.pc
#  from (select P1.maker from product P1 group by P1.maker) A
#  LEFT JOIN (select P2.maker, count(P2.maker) pc from product P2 group by P2.maker, P2.type HAVING P2.type='PC') B ON A.maker = B.maker) C
#  LEFT JOIN (select P3.maker, count(P3.maker) laptop from product P3 group by P3.maker, P3.type HAVING P3.type='Laptop') D ON C.maker = D.maker) E
#  LEFT JOIN (select P4.maker, count(P4.maker) printer from product P4 group by P4.maker, P4.type HAVING p4.type='Printer') R ON E.maker = R.maker; 

#------------------------------------------ 5
#  select speed, Avg(price) as Середня_ціна
#  from PC where speed>'600' group by speed;
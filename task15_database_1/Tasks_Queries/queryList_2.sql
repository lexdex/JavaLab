SELECT * FROM labor_sql.laptop;
SELECT * FROM labor_sql.product;
SELECT * FROM labor_sql.pc;
SELECT * FROM labor_sql.printer;

/*
1. БД «Комп. фірма». Знайти виробників ноутбуків. Вивести:
maker, type. Вихідні дані впорядкувати за зростанням за
стовпцем maker.  
*/
SELECT maker,type FROM labor_sql.product
WHERE type='Laptop' ORDER BY maker;

/*
2. БД «Комп. фірма». Знайти номер моделі, об’єм пам’яті та
розміри екранів ноутбуків, ціна яких перевищує 1000 дол.
Вивести: model, ram, screen, price. Вихідні дані впорядкувати
за зростанням за стовпцем ram та за спаданням за стовпцем
price.   
*/
SELECT model, ram, screen, price FROM labor_sql.laptop
WHERE price>1000 ORDER BY ram, price DESC;

/*
3. БД «Комп. фірма». Знайдіть усі записи таблиці Printer для
кольорових принтерів. Вихідні дані впорядкувати за
спаданням за стовпцем price.   
*/
SELECT * FROM labor_sql.printer
WHERE color='y' ORDER BY price DESC;

/*
4. БД «Комп. фірма». Знайдіть номер моделі, швидкість та розмір
диску ПК, що мають CD-приводи зі швидкістю '12х' чи '24х' та
ціну меншу 600 дол. Вивести: model, speed, hd, cd, price.
Вихідні дані впорядкувати за спаданням за стовпцем speed.  
*/
SELECT model, speed, hd, cd, price FROM pc
WHERE (cd = '12x' OR cd = '24x') AND price<600
ORDER BY speed DESC;

/*
5. БД «Кораблі». Перерахувати назви головних кораблів (з
таблиці Ships). Вивести: name, class. Вихідні дані
впорядкувати за зростанням за стовпцем name.   
*/  
SELECT name, class FROM ships
ORDER BY name;

/*
6. БД «Комп. фірма». Отримати інформацію про комп’ютери, що
мають частоту процесора не менше 500 МГц та ціну нижче 800
дол. Вихідні дані впорядкувати за спаданням за стовпцем price.    
*/
SELECT * FROM pc
WHERE speed>=500 AND price<800
ORDER BY price DESC;

/*
7. БД «Комп. фірма». Отримати інформацію про всі принтери,
які не є матричними та коштують менше 300 дол. Вихідні дані
впорядкувати за спаданням за стовпцем type.    
*/
SELECT * FROM printer
WHERE NOT type='Matrix' AND price<300 
ORDER BY type DESC;

/*
8. БД «Комп. фірма». Знайти модель та частоту процесора
комп’ютерів, що коштують від 400 до 600 дол. Вивести: model,
speed. Вихідні дані впорядкувати за зростанням за стовпцем
hd.    
*/
SELECT model, speed FROM pc
WHERE price>=400 AND price<=600 ORDER BY hd;

/*
9. БД «Комп. фірма». Знайти модель, частоту процесора та об’єм
жорсткого диску для тих комп’ютерів, що комплектуються
накопичувачами 10 або 20 Мб та випускаються виробником
'A'. Вивести: model, speed, hd. Вихідні дані впорядкувати за
зростанням за стовпцем speed.    
*/
SELECT P1.model, speed, hd FROM pc P1, product P2
WHERE P1.model=P2.model AND (hd BETWEEN 10 AND 20) and maker='A'
ORDER BY speed;

/*
10. БД «Комп. фірма». Знайдіть номер моделі, швидкість та розмір
жорсткого диску для усіх ноутбуків, екран яких не менше 12
дюймів. Вивести: model, speed, hd, price. Вихідні дані
впорядкувати за спаданням за стовпцем price.    
*/
SELECT model, speed, hd, price FROM laptop
WHERE screen>=12 
ORDER BY price DESC;

/*
11. БД «Комп. фірма». Знайдіть номер моделі, тип та ціну для усіх
принтерів, вартість яких менше 300 дол. Вивести: model, type,
price. Вихідні дані впорядкувати за спаданням за стовпцем
type.    
*/
SELECT model, type, price FROM printer
WHERE price <300 
ORDER BY type DESC;

/*
12. БД «Комп. фірма». Вивести моделі ноутбуків з кількістю RAM
рівною 64 Мб. Вивести: model, ram, price. Вихідні дані
впорядкувати за зростанням за стовпцем screen.    
*/
SELECT model, ram, price FROM laptop
WHERE ram=64
ORDER BY screen;

/*
13. БД «Комп. фірма». Вивести моделі ПК з кількістю RAM
більшою за 64 Мб. Вивести: model, ram, price. Вихідні дані
впорядкувати за зростанням за стовпцем hd.    
*/
SELECT model, ram, price FROM pc
WHERE ram>64
ORDER BY hd;

/*
14. БД «Комп. фірма». Вивести моделі ПК зі швидкістю процесора
у межах від 500 до 750 МГц. Вивести: model, speed, price.
Вихідні дані впорядкувати за спаданням за стовпцем hd.    
*/
SELECT model, speed, price FROM pc
WHERE speed BETWEEN 500 AND 750
ORDER BY hd DESC;

/*
15. БД «Фірма прий. вторсировини». Вивести інформацію про
видачу грошей на суму понад 2000 грн. на пунктах прийому
таблиці Outcome_o. Вихідні дані впорядкувати за спаданням за
стовпцем date.     
*/
SELECT * FROM outcome_o O1
WHERE O1.out>2000
ORDER BY date DESC;

/*
16. БД «Фірма прий. вторсировини». Вивести інформацію про
прийом грошей на суму у межах від 5 тис. до 10 тис. грн. на
пунктах прийому таблиці Income_o. Вихідні дані впорядкувати
за зростанням за стовпцем inc.      
*/
SELECT * FROM income_o
WHERE inc BETWEEN 5000 and 10000
ORDER BY inc;

/*
17. БД «Фірма прий. вторсировини». Вивести інформацію про
прийом грошей на пункті прийому №1 таблиці Income. Вихідні
дані впорядкувати за зростанням за стовпцем inc.      
*/
SELECT * FROM income
ORDER BY inc;

/*
18. БД «Фірма прий. вторсировини». Вивести інформацію про
видачу грошей на пункті прийому №2 таблиці Outcome.
Вихідні дані впорядкувати за зростанням за стовпцем out      
*/
SELECT * FROM outcome O1
ORDER BY O1.out;

/*
19. БД «Кораблі». Вивести інформацію про усі класи кораблів для
країни 'Japan'. Вихідні дані впорядкувати за спаданням за
стовпцем type.     
*/
SELECT * FROM classes
WHERE country='Japan'
ORDER BY type DESC;

/*
20. БД «Кораблі». Знайти всі кораблі, що були спущені на воду у
термін між 1920 та 1942 роками. Вивести: name, launched.
Вихідні дані впорядкувати за спаданням за стовпцем launched.      
*/
SELECT name, launched FROM ships
WHERE launched BETWEEN 1920 AND 1942
ORDER BY launched DESC;

/*
21. БД «Кораблі». Вивести усі кораблі, що брали участь у битві
'Guadalcanal' та не були потопленими. Вивести: ship, battle,
result. Вихідні дані впорядкувати за спаданям за стовпцем ship.      
*/
SELECT ship, battle, result FROM outcomes
WHERE battle='Guadalcanal' AND NOT result='sunk'
ORDER BY ship DESC;

/*
22. БД «Кораблі». Вивести усі потоплені кораблі. Вивести: ship,
battle, result. Вихідні дані впорядкувати за спаданням за
стовпцем ship.      
*/
SELECT ship, battle, result FROM outcomes
WHERE result='sunk'
ORDER BY ship DESC;

/*
23. БД «Кораблі». Вивести назви класів кораблів з
водотоннажністю не меншою, аніж 40 тонн. Вивести: class,
displacement. Вихідні дані впорядкувати за зростанням за
стовпцем type.      
*/
SELECT class, displacement FROM classes
WHERE displacement >=40000
ORDER BY type;

/*
24. БД «Аеропорт». Знайдіть номера усіх рейсів, що бувають у
місті 'London'. Вивести: trip_no, town_from, town_to. Вихідні
дані впорядкувати за зростанням за стовпцем time_out.      
*/
SELECT trip_no, town_from, town_to FROM trip
WHERE town_from='London' OR town_to='London'
ORDER BY time_out;

/*
25. БД «Аеропорт». Знайдіть номера усіх рейсів, на яких курсує
літак 'TU-134'. Вивести: trip_no, plane, town_from, town_to.
Вихідні дані впорядкувати за спаданням за стовпцем time_out.     
*/
SELECT trip_no, plane, town_from, town_to FROM trip
WHERE plane='TU-134'
ORDER BY time_out DESC;

/*
26. БД «Аеропорт». Знайдіть номера усіх рейсів, на яких не курсує
літак 'IL-86'. Вивести: trip_no, plane, town_from, town_to. Вихідні
дані впорядкувати за зростанням за стовпцем plane.      
*/
SELECT trip_no, plane, town_from, town_to FROM trip
WHERE NOT plane='IL-86'
ORDER BY plane;

/*
27. БД «Аеропорт». Знайдіть номера усіх рейсів, що не бувають у
місті 'Rostov'. Вивести: trip_no, town_from, town_to. Вихідні дані
впорядкувати за зростанням за стовпцем plane.      
*/
SELECT trip_no, town_from, town_to FROM trip
WHERE NOT town_from='Rostov' AND NOT town_to='Rostov'
ORDER BY plane;








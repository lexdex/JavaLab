-- #1 вибірка з одної таблиці з простою умовою
/*
БД «Комп. фірма». Знайдіть номер моделі, швидкість та розмір
жорсткого диску для усіх ПК, вартість яких менше 500 дол.
Вивести: model, speed, hd, price. Вихідні дані впорядкувати за
зростанням за стовпцем speed. 
*/
SELECT model, speed, hd FROM labor_sql.pc
WHERE price < 500
ORDER BY speed;

/*
БД «Комп. фірма». Знайти виробників принтерів (без
дублікатів). Вивести: maker, type. Вихідні дані впорядкувати за
спаданням за стовпцем maker.  
*/
SELECT DISTINCT maker, type FROM labor_sql.product 
WHERE type='Printer' 
ORDER BY maker DESC;

/*
БД «Комп. фірма». Знайти виробників ПК. Вивести: maker,
type. Вихідні дані впорядкувати за спаданням за стовпцем
maker.  
*/
SELECT maker, type FROM labor_sql.product
WHERE type='PC'
ORDER BY maker DESC;

-- #2 вибірка з одної таблиці з простою умовою
/*
БД «Кораблі». Знайти всі кораблі, імена класів яких
закінчуються літерою 'o'.  
*/
SELECT * FROM labor_sql.ships
WHERE class LIKE '%o';

/*
БД «Кораблі». Знайти всі кораблі, імена класів яких
закінчуються літерою 'o', але не на 'go'. 
*/
SELECT * FROM labor_sql.ships
WHERE class LIKE '%o' AND class NOT LIKE '%go';

/*
БД «Кораблі». Знайти всі кораблі, імена яких починаються на
'C' або 'K' та закінчуються літерою 'a' або 'o'.   
*/
SELECT * FROM labor_sql.ships
WHERE name RLIKE '^[CK].*' AND name RLIKE '.*[ao]$';

-- #3 вибірка з двох таблиць з простою умовою
/*
БД «Комп. фірма». Вкажіть виробника для тих ноутбуків, що
мають жорсткий диск об’ємом не менше 10 Гбайт. Вивести:
maker, type, speed, hd.  
*/
SELECT maker, type, speed, hd FROM labor_sql.product, labor_sql.laptop
WHERE hd>=10;

/*
БД «Комп. фірма». Знайдіть пари моделей ПК, що мають
однакові швидкість та RAM (таблиця PC). У результаті кожна
пара виводиться лише один раз. Порядок виведення: модель з
більшим номером, модель з меншим номером, швидкість та
RAM.   
*/
SELECT P1.model Higher_model, P2.model Lower_model, P1.speed, P1.ram 
FROM pc P1, pc P2
WHERE P1.speed = P2.speed AND P1.ram = P2.ram AND P1.model>P2.model;

/*
БД «Комп. фірма». Виконати LEFT JOIN (RIGHT JOIN та
FULL JOIN) для таблиць PC та Laptop. З’єднання таблиць
виконати за стовпцем speed.  
*/
SELECT * FROM pc P LEFT JOIN laptop L ON P.speed = L.speed;
SELECT * FROM pc P RIGHT JOIN laptop L ON P.speed = L.speed;
SELECT * FROM pc P JOIN laptop L ON P.speed = L.speed;











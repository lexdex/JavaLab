/*
БД «Комп. фірма». Вивести усі моделі ПК, у номерах яких є
хоча б дві одинички. 
*/
SELECT * FROM pc
WHERE model RLIKE '^.*1.*1.*$';

/*
БД «Фірма прий. вторсировини». З таблиці Outcome вивести
усю інформацію за березень місяць. 
*/
SELECT * FROM outcome
WHERE date RLIKE '^.{5}03';

/*
БД «Фірма прий. вторсировини». З таблиці Outcome_o вивести
усю інформацію за 14 число будь-якого місяця. 
*/
SELECT * FROM outcome_o
WHERE date RLIKE '^.{8}14';

/*
БД «Кораблі». З таблиці Ships вивести назви кораблів, що
починаються на 'W' та закінчуються літерою 'n'. 
*/
SELECT * FROM ships
WHERE name RLIKE '^W.*n$';

/*
БД «Кораблі». З таблиці Ships вивести назви кораблів, що
мають у своїй назві дві літери 'e'. 
*/
SELECT * FROM ships
WHERE name RLIKE '^.*e.*e.*$';

/*
БД «Кораблі». З таблиці Ships вивести назви кораблів та роки
їх спуску на воду, назва яких не закінчується на літеру 'a'
*/
SELECT name, launched FROM ships
WHERE name NOT RLIKE 'a$';

/*
БД «Кораблі». Вивести назви битв, які складаються з двох слів
та друге слово не закінчується на літеру 'c'. 
*/
SELECT battle FROM outcomes
WHERE battle RLIKE '.+ .+[^c]$';

/*
БД «Аеропорт». З таблиці Trip вивести інформацію про рейси,
що вилітають в інтервалі часу між 12 та 17 годинами включно.
*/
SELECT * FROM trip
WHERE time_out RLIKE '.* 1[2-6]';

/*
БД «Аеропорт». З таблиці Trip вивести інформацію про рейси,
що прилітають в інтервалі часу між 17 та 23 годинами
включно. 
*/
SELECT * FROM trip
WHERE time_in RLIKE '(.* 1[7-9])|(.* 2[0-3]:0*)';

/*
БД «Аеропорт». З таблиці Pass_in_trip вивести дати, коли були
зайняті місця у першому ряду. 
*/
SELECT date FROM pass_in_trip
WHERE place RLIKE '^1[a-z]*';

/*
БД «Аеропорт». Вивести прізвища пасажирів (друге слово у
стовпці name), що починаються на літеру 'С'.
*/
SELECT name FROM passenger
WHERE name RLIKE '.+ C.+';

/*
БД «Аеропорт». Вивести прізвища пасажирів (друге слово у
стовпці name), що не починаються на літеру 'J'. 
*/
SELECT name FROM passenger
WHERE name NOT RLIKE '.+ J+';

/*
БД «Комп. фірма». Вкажіть виробника для тих ПК, що мають
жорсткий диск об’ємом не більше 8 Гбайт. Вивести: maker,
type, speed, hd.
*/
SELECT maker, type, speed, hd FROM product P1, pc P2
WHERE P1.model = P2.model AND hd<=8;


/*
БД «Комп. фірма». Знайдіть виробників ПК з процесором не
менше 600 МГц. Вивести: maker.
*/
SELECT maker FROM product P1, pc P2
WHERE P1.model = P2.model AND speed>=600;

/*
БД «Комп. фірма». Знайдіть виробників ноутбуків з
процесором не вище 500 МГц. Вивести: maker.
*/
SELECT code, maker FROM laptop L, product P
WHERE L.model = P.model AND speed<=500;

/*
БД «Кораблі». Знайдіть країни, що мали класи як звичайних
бойових кораблів 'bb', так і класи крейсерів 'bc'. Вивести:
country, типи з класом 'bb', типи з класом 'bc'.
*/
SELECT C1.country FROM classes C1, classes C2
WHERE C1.country = C2.country AND C1.type = 'bb' AND C2.type = 'bc';

/*
БД «Комп. фірма». Знайдіть номер моделі та виробника ПК,
яка має ціну менше за 600 дол. Вивести: model, maker.
*/
SELECT P1.model, maker FROM product P1, pc P2
WHERE P1.model = P2.model AND price<=600;

/*
БД «Комп. фірма». Знайдіть номер моделі та виробника
прінтера, яка має ціну вищу за 300 дол. Вивести: model, maker.
*/
SELECT P1.model, maker FROM printer P1, product P2
WHERE P1.model = P2.model AND price>300;

/*
БД «Комп. фірма». Виведіть виробника,  номер моделі та ціну
кожного комп’ютера, що є у БД. Вивести: maker, model, price.
*/
 SELECT maker, P2.model, price FROM product P1, pc P2
 WHERE P1.model = P2.model;

/*
БД «Комп. фірма». Виведіть усі можливі моделі ПК, їх
виробників та ціну (якщо вона вказана). Вивести: maker,
model, price.
*/
 SELECT maker, P2.model, price FROM product P1, pc P2
 WHERE P1.model = P2.model;

/*
БД «Комп. фірма». Виведіть виробника, тип, модель та частоту
процесора для ноутбуків, частота процесорів яких перевищує
600 МГц. Вивести: maker, type, model, speed.
*/
SELECT maker, type, L.model, speed FROM laptop L, product P
WHERE L.model = P.model AND speed>600;

/*
БД «Кораблі». Для кораблів таблиці Ships вивести їх
водотоннажність.
*/
SELECT name, displacement FROM classes C, ships S
WHERE C.class = S.class;

/*
БД «Кораблі». Для кораблів, що вціліли у битвах, вивести
назви та дати битв, у яких вони брали участь.
*/
SELECT ship, date FROM outcomes, battles
WHERE result = 'OK' AND battle = name;

/*
БД «Кораблі». Для кораблів таблиці Ships вивести країни,
яким вони належать.
*/
SELECT name, country FROM ships S, classes C
WHERE S.class = C.class;

/*
БД «Аеропорт». Для рейсових літаків 'Boeing' вказати назви
компаній, яким вони належать.
*/
SELECT name FROM trip T, company C
WHERE T.id_comp = C.id_comp AND plane = 'Boeing';

/*
БД «Аеропорт». Для пасажирів таблиці Passenger вивести
дати, коли вони користувалися послугами авіаліній.
*/
SELECT P1.ID_psg, date FROM passenger P1, pass_in_trip P2
WHERE P1.ID_psg = P2.ID_psg;
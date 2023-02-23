# Выполение работы

## Часть 2
### 7. В подключенном MySQL репозитории создать базу данных “Друзья человека”
<br>
Создаю новую базу данных и делаю ее активной

```
mysql> CREATE DATABASE HumansFriends;
Query OK, 1 row affected (0.01 sec)

mysql> USE HumansFriends
Database changed
```

### 8. Создать таблицы с иерархией из диаграммы в БД
<br>
Создаю таблицы
Типы животных

```
mysql> CREATE TABLE animal_type (id INTEGER NOT NULL PRIMARY KEY, `type` VARCHAR(255) NOT NULL);
Query OK, 0 rows affected (0.00 sec)
```
Виды животных

```
mysql> CREATE TABLE animal_species (
    -> id INTEGER NOT NULL PRIMARY KEY,
    ->     id_type INTEGER NOT NULL,
    ->     species VARCHAR(255) NOT NULL UNIQUE,
    ->     FOREIGN KEY (id_type) REFERENCES animal_type(id)
    -> );
Query OK, 0 rows affected (0.02 sec)
```

Таблицы для разных видов животных

```
mysql> CREATE TABLE dogs (
    -> id INTEGER  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    -> id_spec INTEGER NOT NULL DEFAULT 1,
    -> `name` VARCHAR(50) NOT NULL,
    -> birthdate DATE NOT NULL,
    -> skills JSON NOT NULL,
    -> CHECK (id_spec=1),
    -> CHECK (JSON_VALID (skills))
    -> ) AUTO_INCREMENT=1000;
Query OK, 0 rows affected (0.01 sec)

mysql> CREATE TABLE cats (
    -> id INTEGER  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    -> id_spec INTEGER NOT NULL DEFAULT 2,
    -> `name` VARCHAR(50) NOT NULL,
    -> birthdate DATE NOT NULL,
    -> skills JSON NOT NULL,
    -> CHECK (id_spec=2),
    -> CHECK (JSON_VALID (skills))
    -> ) AUTO_INCREMENT=2000;
Query OK, 0 rows affected (0.01 sec)

mysql> CREATE TABLE hamsters (
    -> id INTEGER  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    -> id_spec INTEGER NOT NULL DEFAULT 3,
    -> `name` VARCHAR(50) NOT NULL,
    -> birthdate DATE NOT NULL,
    -> skills JSON NOT NULL,
    -> CHECK (id_spec=3),
    -> CHECK (JSON_VALID (skills))
    -> ) AUTO_INCREMENT=3000;
Query OK, 0 rows affected (0.01 sec)

mysql> CREATE TABLE horses (
    -> id INTEGER  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    -> id_spec INTEGER NOT NULL DEFAULT 4,
    -> `name` VARCHAR(50) NOT NULL,
    -> birthdate DATE NOT NULL,
    -> skills JSON NOT NULL,
    -> CHECK (id_spec=4),
    -> CHECK (JSON_VALID (skills))
    -> ) AUTO_INCREMENT=4000;
Query OK, 0 rows affected (0.01 sec)

mysql> CREATE TABLE camels (
    -> id INTEGER  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    -> id_spec INTEGER NOT NULL DEFAULT 5,
    -> `name` VARCHAR(50) NOT NULL,
    -> birthdate DATE NOT NULL,
    -> skills JSON NOT NULL,
    -> CHECK (id_spec=5),
    -> CHECK (JSON_VALID (skills))
    -> ) AUTO_INCREMENT=5000;
Query OK, 0 rows affected (0.01 sec)

mysql> CREATE TABLE donkeys (
    -> id INTEGER  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    -> id_spec INTEGER NOT NULL DEFAULT 6,
    -> `name` VARCHAR(50) NOT NULL,
    -> birthdate DATE NOT NULL,
    -> skills JSON NOT NULL,
    -> CHECK (id_spec=6),
    -> CHECK (JSON_VALID (skills))
    -> ) AUTO_INCREMENT=6000;
Query OK, 0 rows affected (0.01 sec)
```


### 9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения
<br>
Заполняю таблицы данными

```
mysql> INSERT INTO animal_type VALUES
    -> (1, "Домашние животные"),
    -> (2, "Вьючные животные");
Query OK, 2 rows affected (0.01 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM animal_type;
+----+-----------------------------------+
| id | type                              |
+----+-----------------------------------+
|  1 | Домашние животные                 |
|  2 | Вьючные животные                  |
+----+-----------------------------------+
2 rows in set (0.00 sec)

mysql> INSERT INTO animal_species VALUES
    -> (1, 1, "Собака"),
    -> (2, 1, "Кот"),
    -> (3, 1, "Хомяк"),
    -> (4, 2, "Лошадь"),
    -> (5, 2, "Верблюд"),
    -> (6, 2, "Осел");
Query OK, 6 rows affected (0.00 sec)
Records: 6  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM animal_species;
+----+---------+----------------+
| id | id_type | species        |
+----+---------+----------------+
|  1 |       1 | Собака         |
|  2 |       1 | Кот            |
|  3 |       1 | Хомяк          |
|  4 |       2 | Лошадь         |
|  5 |       2 | Верблюд        |
|  6 |       2 | Осел           |
+----+---------+----------------+
6 rows in set (0.00 sec)

mysql> INSERT INTO dogs(`name`, birthdate, skills) VALUES
    -> ('Бобик', '2021-01-10', '["лаять", "кусать"]'),
    -> ('Дейзи', '2018-08-13', '["играть"]'),
    -> ('Пират', '2022-12-15', '["ловить тарелку"]');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0


mysql> SELECT * FROM dogs;
+------+---------+------------+------------+---------------------------------+
| id   | id_spec | name       | birthdate  | skills                          |
+------+---------+------------+------------+---------------------------------+
| 1000 |       1 | Бобик      | 2021-01-10 | ["лаять", "кусать"]             |
| 1001 |       1 | Дейзи      | 2018-08-13 | ["играть"]                      |
| 1002 |       1 | Пират      | 2022-12-15 | ["ловить тарелку"]              |
+------+---------+------------+------------+---------------------------------+
3 rows in set (0.01 sec)

mysql> INSERT INTO cats(`name`, birthdate, skills) VALUES
    -> ('Марта', '2017-04-15', '["ловить мышей"]'),
    -> ('Кузя', '2016-11-13', '["показывать зайца"]'),
    -> ('Яшка', '2021-12-01', '["играть"]');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0


mysql> SELECT * FROM cats;
+------+---------+------------+------------+-------------------------------------+
| id   | id_spec | name       | birthdate  | skills                              |
+------+---------+------------+------------+-------------------------------------+
| 2000 |       2 | Марта      | 2017-04-15 | ["ловить мышей"]                    |
| 2001 |       2 | Кузя       | 2016-11-13 | ["показывать зайца"]                |
| 2002 |       2 | Яшка       | 2021-12-01 | ["играть"]                          |
+------+---------+------------+------------+-------------------------------------+
3 rows in set (0.00 sec)

mysql> INSERT INTO hamsters(`name`, birthdate, skills) VALUES
    -> ('Чаки', '2021-12-31', '["спать"]'),
    -> ('Пух', '2022-10-01', '[]'),
    -> ('Рокки', '2022-01-14', '[]');
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM hamsters;
+------+---------+------------+------------+----------------+
| id   | id_spec | name       | birthdate  | skills         |
+------+---------+------------+------------+----------------+
| 3000 |       3 | Чаки       | 2021-12-31 | ["спать"]      |
| 3001 |       3 | Пух        | 2022-10-01 | []             |
| 3002 |       3 | Рокки      | 2022-01-14 | []             |
+------+---------+------------+------------+----------------+
3 rows in set (0.00 sec)

mysql> INSERT INTO horses(`name`, birthdate, skills) VALUES
    -> ('Пегас', '2015-09-18', '["скакать"]'),
    -> ('Джули', '2022-07-07', '["тянуть"]'),
    -> ('Шумахер', '2018-05-06', '["толкать"]');
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM horses;
+------+---------+----------------+------------+--------------------+
| id   | id_spec | name           | birthdate  | skills             |
+------+---------+----------------+------------+--------------------+
| 4000 |       4 | Пегас          | 2015-09-18 | ["скакать"]        |
| 4001 |       4 | Джули          | 2022-07-07 | ["тянуть"]         |
| 4002 |       4 | Шумахер        | 2018-05-06 | ["толкать"]        |
+------+---------+----------------+------------+--------------------+
3 rows in set (0.00 sec)

mysql> INSERT INTO camels(`name`, birthdate, skills) VALUES
    -> ('Бо', '2010-03-22', '[]'),
    -> ('Джолента', '2020-10-08', '[]'),
    -> ('Миша', '2018-06-06', '[]');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM camels;
+------+---------+------------------+------------+--------+
| id   | id_spec | name             | birthdate  | skills |
+------+---------+------------------+------------+--------+
| 5000 |       5 | Бо               | 2010-03-22 | []     |
| 5001 |       5 | Джолента         | 2020-10-08 | []     |
| 5002 |       5 | Миша             | 2018-06-06 | []     |
+------+---------+------------------+------------+--------+
3 rows in set (0.00 sec)

mysql> INSERT INTO donkeys(`name`, birthdate, skills) VALUES
    -> ('Карвалол', '2020-11-22', '[]'),
    -> ('Валидол', '2017-10-14', '[]'),
    -> ('Аспирин', '2022-05-22', '[]');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM donkeys;
+------+---------+------------------+------------+--------+
| id   | id_spec | name             | birthdate  | skills |
+------+---------+------------------+------------+--------+
| 6000 |       6 | Карвалол         | 2020-11-22 | []     |
| 6001 |       6 | Валидол          | 2017-10-14 | []     |
| 6002 |       6 | Аспирин          | 2022-05-22 | []     |
+------+---------+------------------+------------+--------+
3 rows in set (0.00 sec)
```

### 10. Удалить из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
<br>

Удаляю всех верблюдов
```
mysql> DELETE FROM camels;
Query OK, 3 rows affected (0.01 sec)

mysql> SELECT * FROM camels;
Empty set (0.00 sec)
```
Создаю новую таблицу с лошадьми и ослами
```
mysql> SELECT * FROM horses_donkeys;
ERROR 1146 (42S02): Table 'HumansFriends.horses_donkeys' doesn't exist
mysql> CREATE TABLE horses_donkeys
    -> SELECT * FROM horses
    -> UNION
    -> SELECT * FROM donkeys;
Query OK, 6 rows affected (0.01 sec)
Records: 6  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM horses_donkeys;
+------+---------+------------------+------------+--------------------+
| id   | id_spec | name             | birthdate  | skills             |
+------+---------+------------------+------------+--------------------+
| 4000 |       4 | Пегас            | 2015-09-18 | ["скакать"]        |
| 4001 |       4 | Джули            | 2022-07-07 | ["тянуть"]         |
| 4002 |       4 | Шумахер          | 2018-05-06 | ["толкать"]        |
| 6000 |       6 | Карвалол         | 2020-11-22 | []                 |
| 6001 |       6 | Валидол          | 2017-10-14 | []                 |
| 6002 |       6 | Аспирин          | 2022-05-22 | []                 |
+------+---------+------------------+------------+--------------------+
6 rows in set (0.00 sec)
```

### 11. Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице
<br>

Для упрощения запроса создам представления для объединения данных из всех таблиц

```
mysql> CREATE VIEW all_animals AS
    -> SELECT * FROM dogs
    -> UNION
    -> SELECT * FROM cats
    -> UNION
    -> SELECT * FROM hamsters
    -> UNION
    -> SELECT * FROM horses
    -> UNION
    -> SELECT * FROM camels
    -> UNION
    -> SELECT * FROM donkeys;
Query OK, 0 rows affected (0.01 sec)

mysql> SELECT * FROM all_animals;
+------+---------+------------------+------------+-------------------------------------+
| id   | id_spec | name             | birthdate  | skills                              |
+------+---------+------------------+------------+-------------------------------------+
| 1000 |       1 | Бобик            | 2021-01-10 | ["лаять", "кусать"]                 |
| 1001 |       1 | Дейзи            | 2018-08-13 | ["играть"]                          |
| 1002 |       1 | Пират            | 2022-12-15 | ["ловить тарелку"]                  |
| 2000 |       2 | Марта            | 2017-04-15 | ["ловить мышей"]                    |
| 2001 |       2 | Кузя             | 2016-11-13 | ["показывать зайца"]                |
| 2002 |       2 | Яшка             | 2021-12-01 | ["играть"]                          |
| 3000 |       3 | Чаки             | 2021-12-31 | ["спать"]                           |
| 3001 |       3 | Пух              | 2022-10-01 | []                                  |
| 3002 |       3 | Рокки            | 2022-01-14 | []                                  |
| 4000 |       4 | Пегас            | 2015-09-18 | ["скакать"]                         |
| 4001 |       4 | Джули            | 2022-07-07 | ["тянуть"]                          |
| 4002 |       4 | Шумахер          | 2018-05-06 | ["толкать"]                         |
| 6000 |       6 | Карвалол         | 2020-11-22 | []                                  |
| 6001 |       6 | Валидол          | 2017-10-14 | []                                  |
| 6002 |       6 | Аспирин          | 2022-05-22 | []                                  |
+------+---------+------------------+------------+-------------------------------------+
15 rows in set (0.00 sec)
```
Создаю новую таблицу
```
mysql> CREATE TABLE young_animals
    -> SELECT id_spec, `name`, birthdate,
    ->         concat(TIMESTAMPDIFF(YEAR, birthdate, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthdate, CURDATE()) % 12, ' m') AS age
    -> FROM all_animals
    -> WHERE birthdate BETWEEN DATE_SUB(CURDATE(), INTERVAL 3 YEAR) AND DATE_SUB(CURDATE(), INTERVAL 1 YEAR);
Query OK, 5 rows affected (0.01 sec)
Records: 5  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM young_animals;
+---------+------------------+------------+---------+
| id_spec | name             | birthdate  | age     |
+---------+------------------+------------+---------+
|       1 | Бобик            | 2021-01-10 | 2 y 1 m |
|       2 | Яшка             | 2021-12-01 | 1 y 2 m |
|       3 | Чаки             | 2021-12-31 | 1 y 1 m |
|       3 | Рокки            | 2022-01-14 | 1 y 1 m |
|       6 | Карвалол         | 2020-11-22 | 2 y 3 m |
+---------+------------------+------------+---------+
5 rows in set (0.00 sec)
```
### 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
<br>

```
mysql> CREATE VIEW all_tables AS
    -> SELECT dogs.id AS dogs_id, dogs.id_spec AS dogs_id_spec, dogs.`name` AS dogs_name,
    -> dogs.birthdate AS dogs_birthdate, dogs.skills AS dogs_skills,
    -> cats.id AS cats_id, cats.id_spec AS cats_id_spec, cats.`name` AS cats_name,
    -> cats.birthdate AS cats_birthdate, cats.skills AS cats_skills,
    -> hamsters.id AS hamsters_id, hamsters.id_spec AS hamsters_id_spec, hamsters.`name` AS hamsters_name,
    -> hamsters.birthdate AS hamsters_birthdate, hamsters.skills AS hamsters_skills,
    -> horses.id AS horses_id, horses.id_spec AS horses_id_spec, horses.`name` AS horses_name,
    -> horses.birthdate AS horses_birthdate, horses.skills AS horses_skills,
    -> camels.id AS camels_id, camels.id_spec AS camels_id_spec, camels.`name` AS camels_name,
    -> camels.birthdate AS camels_birthdate, camels.skills AS camels_skills,
    -> donkeys.id AS donkeys_id, donkeys.id_spec AS donkeys_id_spec, donkeys.`name` AS donkeys_name,
    -> donkeys.birthdate AS donkeys_birthdate, donkeys.skills AS donkeys_skills
    -> FROM dogs
    -> LEFT JOIN cats ON FALSE
    -> LEFT JOIN hamsters ON FALSE
    -> LEFT JOIN horses ON FALSE
    -> LEFT JOIN camels ON FALSE
    -> LEFT JOIN donkeys ON FALSE
    -> UNION
    -> SELECT *
    -> FROM dogs
    -> RIGHT JOIN cats ON FALSE
    -> LEFT JOIN hamsters ON FALSE
    -> LEFT JOIN horses ON FALSE
    -> LEFT JOIN camels ON FALSE
    -> LEFT JOIN donkeys ON FALSE
    -> UNION
    -> SELECT *
    -> FROM dogs
    -> RIGHT JOIN cats ON FALSE
    -> RIGHT JOIN hamsters ON FALSE
    -> LEFT JOIN horses ON FALSE
    -> LEFT JOIN camels ON FALSE
    -> LEFT JOIN donkeys ON FALSE
    -> UNION
    -> SELECT *
    -> FROM dogs
    -> RIGHT JOIN cats ON FALSE
    -> RIGHT JOIN hamsters ON FALSE
    -> RIGHT JOIN horses ON FALSE
    -> LEFT JOIN camels ON FALSE
    -> LEFT JOIN donkeys ON FALSE
    -> UNION
    -> SELECT *
    -> FROM dogs
    -> RIGHT JOIN cats ON FALSE
    -> RIGHT JOIN hamsters ON FALSE
    -> RIGHT JOIN horses ON FALSE
    -> RIGHT JOIN camels ON FALSE
    -> LEFT JOIN donkeys ON FALSE
    -> UNION
    -> SELECT *
    -> FROM dogs
    -> RIGHT JOIN cats ON FALSE
    -> RIGHT JOIN hamsters ON FALSE
    -> RIGHT JOIN horses ON FALSE
    -> RIGHT JOIN camels ON FALSE
    -> RIGHT JOIN donkeys ON FALSE;
Query OK, 0 rows affected (0.00 sec)
```

```
mysql> SELECT * FROM all_tables;
+---------+--------------+------------+----------------+---------------------------------+---------+--------------+------------+----------------+-------------------------------------+-------------+------------------+---------------+--------------------+-----------------+-----------+----------------+----------------+------------------+--------------------+-----------+----------------+-------------+------------------+---------------+------------+-----------------+------------------+-------------------+----------------+
| dogs_id | dogs_id_spec | dogs_name  | dogs_birthdate | dogs_skills                     | cats_id | cats_id_spec | cats_name  | cats_birthdate | cats_skills                         | hamsters_id | hamsters_id_spec | hamsters_name | hamsters_birthdate | hamsters_skills | horses_id | horses_id_spec | horses_name    | horses_birthdate | horses_skills      | camels_id | camels_id_spec | camels_name | camels_birthdate | camels_skills | donkeys_id | donkeys_id_spec | donkeys_name     | donkeys_birthdate | donkeys_skills |
+---------+--------------+------------+----------------+---------------------------------+---------+--------------+------------+----------------+-------------------------------------+-------------+------------------+---------------+--------------------+-----------------+-----------+----------------+----------------+------------------+--------------------+-----------+----------------+-------------+------------------+---------------+------------+-----------------+------------------+-------------------+----------------+
|    1000 |            1 | Бобик      | 2021-01-10     | ["лаять", "кусать"]             |    NULL |         NULL | NULL       | NULL           | NULL                                |        NULL |             NULL | NULL          | NULL               | NULL            |      NULL |           NULL | NULL           | NULL             | NULL               |      NULL |           NULL | NULL        | NULL             | NULL          |       NULL |            NULL | NULL             | NULL              | NULL           |
|    1001 |            1 | Дейзи      | 2018-08-13     | ["играть"]                      |    NULL |         NULL | NULL       | NULL           | NULL                                |        NULL |             NULL | NULL          | NULL               | NULL            |      NULL |           NULL | NULL           | NULL             | NULL               |      NULL |           NULL | NULL        | NULL             | NULL          |       NULL |            NULL | NULL             | NULL              | NULL           |
|    1002 |            1 | Пират      | 2022-12-15     | ["ловить тарелку"]              |    NULL |         NULL | NULL       | NULL           | NULL                                |        NULL |             NULL | NULL          | NULL               | NULL            |      NULL |           NULL | NULL           | NULL             | NULL               |      NULL |           NULL | NULL        | NULL             | NULL          |       NULL |            NULL | NULL             | NULL              | NULL           |
|    NULL |         NULL | NULL       | NULL           | NULL                            |    2000 |            2 | Марта      | 2017-04-15     | ["ловить мышей"]                    |        NULL |             NULL | NULL          | NULL               | NULL            |      NULL |           NULL | NULL           | NULL             | NULL               |      NULL |           NULL | NULL        | NULL             | NULL          |       NULL |            NULL | NULL             | NULL              | NULL           |
|    NULL |         NULL | NULL       | NULL           | NULL                            |    2001 |            2 | Кузя       | 2016-11-13     | ["показывать зайца"]                |        NULL |             NULL | NULL          | NULL               | NULL            |      NULL |           NULL | NULL           | NULL             | NULL               |      NULL |           NULL | NULL        | NULL             | NULL          |       NULL |            NULL | NULL             | NULL              | NULL           |
|    NULL |         NULL | NULL       | NULL           | NULL                            |    2002 |            2 | Яшка       | 2021-12-01     | ["играть"]                          |        NULL |             NULL | NULL          | NULL               | NULL            |      NULL |           NULL | NULL           | NULL             | NULL               |      NULL |           NULL | NULL        | NULL             | NULL          |       NULL |            NULL | NULL             | NULL              | NULL           |
|    NULL |         NULL | NULL       | NULL           | NULL                            |    NULL |         NULL | NULL       | NULL           | NULL                                |        3000 |                3 | Чаки          | 2021-12-31         | ["спать"]       |      NULL |           NULL | NULL           | NULL             | NULL               |      NULL |           NULL | NULL        | NULL             | NULL          |       NULL |            NULL | NULL             | NULL              | NULL           |
|    NULL |         NULL | NULL       | NULL           | NULL                            |    NULL |         NULL | NULL       | NULL           | NULL                                |        3001 |                3 | Пух           | 2022-10-01         | []              |      NULL |           NULL | NULL           | NULL             | NULL               |      NULL |           NULL | NULL        | NULL             | NULL          |       NULL |            NULL | NULL             | NULL              | NULL           |
|    NULL |         NULL | NULL       | NULL           | NULL                            |    NULL |         NULL | NULL       | NULL           | NULL                                |        3002 |                3 | Рокки         | 2022-01-14         | []              |      NULL |           NULL | NULL           | NULL             | NULL               |      NULL |           NULL | NULL        | NULL             | NULL          |       NULL |            NULL | NULL             | NULL              | NULL           |
|    NULL |         NULL | NULL       | NULL           | NULL                            |    NULL |         NULL | NULL       | NULL           | NULL                                |        NULL |             NULL | NULL          | NULL               | NULL            |      4000 |              4 | Пегас          | 2015-09-18       | ["скакать"]        |      NULL |           NULL | NULL        | NULL             | NULL          |       NULL |            NULL | NULL             | NULL              | NULL           |
|    NULL |         NULL | NULL       | NULL           | NULL                            |    NULL |         NULL | NULL       | NULL           | NULL                                |        NULL |             NULL | NULL          | NULL               | NULL            |      4001 |              4 | Джули          | 2022-07-07       | ["тянуть"]         |      NULL |           NULL | NULL        | NULL             | NULL          |       NULL |            NULL | NULL             | NULL              | NULL           |
|    NULL |         NULL | NULL       | NULL           | NULL                            |    NULL |         NULL | NULL       | NULL           | NULL                                |        NULL |             NULL | NULL          | NULL               | NULL            |      4002 |              4 | Шумахер        | 2018-05-06       | ["толкать"]        |      NULL |           NULL | NULL        | NULL             | NULL          |       NULL |            NULL | NULL             | NULL              | NULL           |
|    NULL |         NULL | NULL       | NULL           | NULL                            |    NULL |         NULL | NULL       | NULL           | NULL                                |        NULL |             NULL | NULL          | NULL               | NULL            |      NULL |           NULL | NULL           | NULL             | NULL               |      NULL |           NULL | NULL        | NULL             | NULL          |       6000 |               6 | Карвалол         | 2020-11-22        | []             |
|    NULL |         NULL | NULL       | NULL           | NULL                            |    NULL |         NULL | NULL       | NULL           | NULL                                |        NULL |             NULL | NULL          | NULL               | NULL            |      NULL |           NULL | NULL           | NULL             | NULL               |      NULL |           NULL | NULL        | NULL             | NULL          |       6001 |               6 | Валидол          | 2017-10-14        | []             |
|    NULL |         NULL | NULL       | NULL           | NULL                            |    NULL |         NULL | NULL       | NULL           | NULL                                |        NULL |             NULL | NULL          | NULL               | NULL            |      NULL |           NULL | NULL           | NULL             | NULL               |      NULL |           NULL | NULL        | NULL             | NULL          |       6002 |               6 | Аспирин          | 2022-05-22        | []             |
+---------+--------------+------------+----------------+---------------------------------+---------+--------------+------------+----------------+-------------------------------------+-------------+------------------+---------------+--------------------+-----------------+-----------+----------------+----------------+------------------+--------------------+-----------+----------------+-------------+------------------+---------------+------------+-----------------+------------------+-------------------+----------------+
15 rows in set (0.00 sec)
```
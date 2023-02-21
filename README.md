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
    -> CHECK (id_spec=1)
    -> );
Query OK, 0 rows affected (0.01 sec)

mysql> ALTER TABLE dogs AUTO_INCREMENT=1000;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0


mysql> CREATE TABLE cats (
    -> id INTEGER  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    -> id_spec INTEGER NOT NULL DEFAULT 2,
    -> `name` VARCHAR(50) NOT NULL,
    -> birthdate DATE NOT NULL,
    -> CHECK (id_spec=2)
    -> );
Query OK, 0 rows affected (0.01 sec)

mysql> ALTER TABLE cats AUTO_INCREMENT=2000;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0


mysql> CREATE TABLE hamsters (
    -> id INTEGER  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    -> id_spec INTEGER NOT NULL DEFAULT 3,
    -> `name` VARCHAR(50) NOT NULL,
    -> birthdate DATE NOT NULL,
    -> CHECK (id_spec=3)
    -> );
Query OK, 0 rows affected (0.01 sec)

mysql> ALTER TABLE hamsters AUTO_INCREMENT=3000;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> CREATE TABLE horses (
    -> id INTEGER  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    -> id_spec INTEGER NOT NULL DEFAULT 4,
    -> `name` VARCHAR(50) NOT NULL,
    -> birthdate DATE NOT NULL,
    -> CHECK (id_spec=4)
    -> );
Query OK, 0 rows affected (0.01 sec)

mysql> ALTER TABLE horses AUTO_INCREMENT=4000;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> CREATE TABLE donkeys (
    -> id INTEGER  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    -> id_spec INTEGER NOT NULL DEFAULT 6,
    -> `name` VARCHAR(50) NOT NULL,
    -> birthdate DATE NOT NULL,
    -> CHECK (id_spec=6)
    -> );
Query OK, 0 rows affected (0.01 sec)

mysql> ALTER TABLE donkeys AUTO_INCREMENT=6000;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0
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

mysql> INSERT INTO dogs(`name`, birthdate) VALUES
    -> ('Бобик', '2021-01-10'),
    -> ('Дейзи', '2018-08-13'),
    -> ('Пират', '2022-12-15');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM dogs;
+------+---------+------------+------------+
| id   | id_spec | name       | birthdate  |
+------+---------+------------+------------+
| 1000 |       1 | Бобик      | 2021-01-10 |
| 1001 |       1 | Дейзи      | 2018-08-13 |
| 1002 |       1 | Пират      | 2022-12-15 |
+------+---------+------------+------------+
3 rows in set (0.00 sec)

mysql> INSERT INTO cats(`name`, birthdate) VALUES
    -> ('Марта', '2017-04-15'),
    -> ('Кузя', '2016-11-13'),
    -> ('Яшка', '2021-12-01');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM cats;
+------+---------+------------+------------+
| id   | id_spec | name       | birthdate  |
+------+---------+------------+------------+
| 2000 |       2 | Марта      | 2017-04-15 |
| 2001 |       2 | Кузя       | 2016-11-13 |
| 2002 |       2 | Яшка       | 2021-12-01 |
+------+---------+------------+------------+
3 rows in set (0.00 sec)


mysql> INSERT INTO hamsters(`name`, birthdate) VALUES
    -> ('Чаки', '2021-12-31'),
    -> ('Пух', '2022-10-01'),
    -> ('Рокки', '2022-01-14');
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM hamsters;
+------+---------+------------+------------+
| id   | id_spec | name       | birthdate  |
+------+---------+------------+------------+
| 3000 |       3 | Чаки       | 2021-12-31 |
| 3001 |       3 | Пух        | 2022-10-01 |
| 3002 |       3 | Рокки      | 2022-01-14 |
+------+---------+------------+------------+
3 rows in set (0.00 sec)

mysql> INSERT INTO horses(`name`, birthdate) VALUES
    -> ('Пегас', '2015-09-18'),
    -> ('Джули', '2022-07-07'),
    -> ('Шумахер', '2018-05-06');
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM horses;
+------+---------+----------------+------------+
| id   | id_spec | name           | birthdate  |
+------+---------+----------------+------------+
| 4000 |       4 | Пегас          | 2015-09-18 |
| 4001 |       4 | Джули          | 2022-07-07 |
| 4002 |       4 | Шумахер        | 2018-05-06 |
+------+---------+----------------+------------+
3 rows in set (0.00 sec)

mysql> INSERT INTO camels(`name`, birthdate) VALUES
    -> ('Бо', '2010-03-22'),
    -> ('Джолента', '2020-10-08'),
    -> ('Миша', '2018-06-06');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM camels;
+------+---------+------------------+------------+
| id   | id_spec | name             | birthdate  |
+------+---------+------------------+------------+
| 5000 |       5 | Бо               | 2010-03-22 |
| 5001 |       5 | Джолента         | 2020-10-08 |
| 5002 |       5 | Миша             | 2018-06-06 |
+------+---------+------------------+------------+
3 rows in set (0.00 sec)

mysql> INSERT INTO donkeys(`name`, birthdate) VALUES
    -> ('Карвалол', '2020-11-22'),
    -> ('Валидол', '2017-10-14'),
    -> ('Аспирин', '2022-05-22');
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM donkeys;
+------+---------+------------------+------------+
| id   | id_spec | name             | birthdate  |
+------+---------+------------------+------------+
| 6000 |       6 | Карвалол         | 2020-11-22 |
| 6001 |       6 | Валидол          | 2017-10-14 |
| 6002 |       6 | Аспирин          | 2022-05-22 |
+------+---------+------------------+------------+
3 rows in set (0.00 sec)
```

### 10. Удалить из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
### 11. Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице
### 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
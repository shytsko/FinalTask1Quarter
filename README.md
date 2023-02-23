# Выполение работы


## Часть 1
### 1. Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и ослы), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).
<br>
Создаю и заполняю файл с домашними животными

```
user@server1:~$ cat > Pets
dogs
cats
hamsters

user@server1:~$ cat Pets
dogs
cats
hamsters
```

Создаю и заполняю файл с вьючными животными
```
user@server1:~$ cat > PackAnimals
horses
camels
donkeys

user@server1:~$ cat PackAnimals
horses
camels
donkeys
```
Объединяю файлы
```
user@server1:~$ cat PackAnimals >> Pets
user@server1:~$ cat Pets
dogs
cats
hamsters
horses
camels
donkeys
```
Переименовываю файл
```
user@server1:~$ mv Pets HumansFriends
user@server1:~$ cat HumansFriends
dogs
cats
hamsters
horses
camels
donkeys
```
### 2. Создать директорию, переместить файл туда.
<br>
Создаю новую директорию и перемещаю файл

```
user@server1:~$ mkdir newdir
user@server1:~$ mv HumansFriends newdir/
user@server1:~$ cat HumansFriends
cat: HumansFriends: No such file or directory
user@server1:~$ cat newdir/HumansFriends
dogs
cats
hamsters
horses
camels
donkeys
```

### 3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.
<br>
Скачиваю последнюю версию файла конфигурации репозитория

```
user@server1:~$ wget https://repo.mysql.com//mysql-apt-config_0.8.24-1_all.deb
--2023-02-20 21:31:05--  https://repo.mysql.com//mysql-apt-config_0.8.24-1_all.deb
Resolving repo.mysql.com (repo.mysql.com)... 2.17.156.231
Connecting to repo.mysql.com (repo.mysql.com)|2.17.156.231|:443... connected.
HTTP request sent, awaiting response... 200 OK
Length: 18048 (18K) [application/x-debian-package]
Saving to: ‘mysql-apt-config_0.8.24-1_all.deb’

mysql-apt-config_0.8.24-1_all 100%[=================================================>]  17.62K  --.-KB/s    in 0.001s

2023-02-20 21:31:05 (20.3 MB/s) - ‘mysql-apt-config_0.8.24-1_all.deb’ saved [18048/18048]
```
Добавляю репозиторий
```
user@server1:~$ sudo dpkg -i mysql-apt-config_0.8.24-1_all.deb
Selecting previously unselected package mysql-apt-config.
(Reading database ... 110679 files and directories currently installed.)
Preparing to unpack mysql-apt-config_0.8.24-1_all.deb ...
Unpacking mysql-apt-config (0.8.24-1) ...
Setting up mysql-apt-config (0.8.24-1) ...
Warning: apt-key should not be used in scripts (called from postinst maintainerscript of the package mysql-apt-config)
Warning: apt-key is deprecated. Manage keyring files in trusted.gpg.d instead (see apt-key(8)).
OK
```
Обновляю базу пакетов
```
user@server1:~$ sudo apt update
Hit:1 http://by.archive.ubuntu.com/ubuntu jammy InRelease
Hit:2 http://by.archive.ubuntu.com/ubuntu jammy-updates InRelease
Hit:3 http://by.archive.ubuntu.com/ubuntu jammy-backports InRelease
Hit:4 http://by.archive.ubuntu.com/ubuntu jammy-security InRelease
Hit:5 https://download.docker.com/linux/ubuntu jammy InRelease
Get:6 http://repo.mysql.com/apt/ubuntu jammy InRelease [15.2 kB]
Get:7 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 Sources [966 B]
Get:8 http://repo.mysql.com/apt/ubuntu jammy/mysql-apt-config amd64 Packages [565 B]
Get:9 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 Packages [8,555 B]
Get:10 http://repo.mysql.com/apt/ubuntu jammy/mysql-tools amd64 Packages [7,905 B]
Fetched 33.2 kB in 1s (29.1 kB/s)
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
74 packages can be upgraded. Run 'apt list --upgradable' to see them.
W: http://repo.mysql.com/apt/ubuntu/dists/jammy/InRelease: Key is stored in legacy trusted.gpg keyring (/etc/apt/trusted.gpg), see the DEPRECATION section in apt-key(8) for details.
```
Устанавливаю MySQL (вывод частично сокращет)
```
user@server1:~$ sudo apt install -y mysql-server
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
The following additional packages will be installed:
  libmecab2 mecab-ipadic mecab-ipadic-utf8 mecab-utils mysql-client mysql-common mysql-community-client mysql-community-client-core mysql-community-client-plugins
  mysql-community-server mysql-community-server-core
The following NEW packages will be installed:
  libmecab2 mecab-ipadic mecab-ipadic-utf8 mecab-utils mysql-client mysql-common mysql-community-client mysql-community-client-core mysql-community-client-plugins
  mysql-community-server mysql-community-server-core mysql-server
0 upgraded, 12 newly installed, 0 to remove and 74 not upgraded.
Need to get 38.2 MB of archives.
After this operation, 273 MB of additional disk space will be used.
Get:1 http://by.archive.ubuntu.com/ubuntu jammy/main amd64 libmecab2 amd64 0.996-14build9 [199 kB]
Get:2 http://by.archive.ubuntu.com/ubuntu jammy/main amd64 mecab-utils amd64 0.996-14build9 [4,850 B]
Get:3 http://by.archive.ubuntu.com/ubuntu jammy/main amd64 mecab-ipadic all 2.7.0-20070801+main-3 [6,718 kB]
Get:4 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 mysql-common amd64 8.0.32-1ubuntu22.04 [68.6 kB]
Get:5 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 mysql-community-client-plugins amd64 8.0.32-1ubuntu22.04 [1,437 kB]
Get:6 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 mysql-community-client-core amd64 8.0.32-1ubuntu22.04 [2,184 kB]
Get:7 http://by.archive.ubuntu.com/ubuntu jammy/main amd64 mecab-ipadic-utf8 all 2.7.0-20070801+main-3 [4,384 B]
Get:8 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 mysql-community-client amd64 8.0.32-1ubuntu22.04 [2,458 kB]
Get:9 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 mysql-client amd64 8.0.32-1ubuntu22.04 [67.3 kB]
Get:10 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 mysql-community-server-core amd64 8.0.32-1ubuntu22.04 [25.0 MB]
Get:11 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 mysql-community-server amd64 8.0.32-1ubuntu22.04 [79.1 kB]
Get:12 http://repo.mysql.com/apt/ubuntu jammy/mysql-8.0 amd64 mysql-server amd64 8.0.32-1ubuntu22.04 [67.3 kB]
Fetched 38.2 MB in 2s (15.8 MB/s)
Preconfiguring packages ...
Selecting previously unselected package mysql-common.
(Reading database ... 110684 files and directories currently installed.)
Preparing to unpack .../00-mysql-common_8.0.32-1ubuntu22.04_amd64.deb ...
Unpacking mysql-common (8.0.32-1ubuntu22.04) ...
...
reading /usr/share/mecab/dic/ipadic/Noun.number.csv ... 42
reading /usr/share/mecab/dic/ipadic/Noun.verbal.csv ... 12146
emitting double-array: 100% |###########################################|
reading /usr/share/mecab/dic/ipadic/matrix.def ... 1316x1316
emitting matrix      : 100% |###########################################|

done!
update-alternatives: using /var/lib/mecab/dic/ipadic-utf8 to provide /var/lib/mecab/dic/debian (mecab-dictionary) in auto mode
Setting up mysql-community-client (8.0.32-1ubuntu22.04) ...
Setting up mysql-client (8.0.32-1ubuntu22.04) ...
Setting up mysql-community-server (8.0.32-1ubuntu22.04) ...
update-alternatives: using /etc/mysql/mysql.cnf to provide /etc/mysql/my.cnf (my.cnf) in auto mode
Created symlink /etc/systemd/system/multi-user.target.wants/mysql.service → /lib/systemd/system/mysql.service.
Setting up mysql-server (8.0.32-1ubuntu22.04) ...
Processing triggers for man-db (2.10.2-1) ...
Processing triggers for libc-bin (2.35-0ubuntu3.1) ...
Scanning processes...
Scanning linux images...

Running kernel seems to be up-to-date.

No services need to be restarted.

No containers need to be restarted.

No user sessions are running outdated binaries.

No VM guests are running outdated hypervisor (qemu) binaries on this host.
```
Проверяю статус сервиса
```
user@server1:~$ systemctl status mysql
● mysql.service - MySQL Community Server
     Loaded: loaded (/lib/systemd/system/mysql.service; enabled; vendor preset: enabled)
     Active: active (running) since Mon 2023-02-20 21:40:33 UTC; 29min ago
       Docs: man:mysqld(8)
             http://dev.mysql.com/doc/refman/en/using-systemd.html
   Main PID: 3377 (mysqld)
     Status: "Server is operational"
      Tasks: 38 (limit: 1030)
     Memory: 37.2M
        CPU: 4.562s
     CGroup: /system.slice/mysql.service
             └─3377 /usr/sbin/mysqld

Feb 20 21:40:32 server1 systemd[1]: Starting MySQL Community Server...
Feb 20 21:40:33 server1 systemd[1]: Started MySQL Community Server.
```

Проверяю подключение из локального клиента
```
user@server1:~$ sudo mysql -p
Enter password:
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 9
Server version: 8.0.32 MySQL Community Server - GPL

Copyright (c) 2000, 2023, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> exit
Bye
```

### 4. Установить и удалить deb-пакет с помощью dpkg.
<br>
Скачиваю пакет skype

```
user@server1:~$ wget https://go.skype.com/skypeforlinux-64.deb
--2023-02-20 21:53:54--  https://go.skype.com/skypeforlinux-64.deb
Resolving go.skype.com (go.skype.com)... 40.118.109.53
Connecting to go.skype.com (go.skype.com)|40.118.109.53|:443... connected.
HTTP request sent, awaiting response... 301 Moved Permanently
Location: https://get.skype.com/getskype-webwrap-deb [following]
--2023-02-20 21:53:55--  https://get.skype.com/getskype-webwrap-deb
Resolving get.skype.com (get.skype.com)... 52.174.193.75
Connecting to get.skype.com (get.skype.com)|52.174.193.75|:443... connected.
HTTP request sent, awaiting response... 302 Found
Location: https://repo.skype.com/latest/skypeforlinux-64.deb [following]
--2023-02-20 21:53:55--  https://repo.skype.com/latest/skypeforlinux-64.deb
Resolving repo.skype.com (repo.skype.com)... 23.197.104.155, 2a02:26f0:7100:486::1263, 2a02:26f0:7100:484::1263
Connecting to repo.skype.com (repo.skype.com)|23.197.104.155|:443... connected.
HTTP request sent, awaiting response... 200 OK
Length: 126373092 (121M) [application/x-debian-package]
Saving to: ‘skypeforlinux-64.deb’

skypeforlinux-64.deb                           100%[==================================================================================================>] 120.52M  11.5MB/s    in 9.5s

2023-02-20 21:54:04 (12.7 MB/s) - ‘skypeforlinux-64.deb’ saved [126373092/126373092]
```
Устанавливаю Skype
```
user@server1:~$ sudo dpkg -i skypeforlinux-64.deb
(Reading database ... 126536 files and directories currently installed.)
Preparing to unpack skypeforlinux-64.deb ...
Unpacking skypeforlinux (8.94.0.422) over (8.94.0.422) ...
Setting up skypeforlinux (8.94.0.422) ...
Processing triggers for hicolor-icon-theme (0.17-2) ...
```
Доустанавливаю необходимые пакеты
```
user@server1:~$ sudo apt -f install
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
0 upgraded, 0 newly installed, 0 to remove and 3 not upgraded.
```

Проверяю
```
user@server1:~$ apt list | grep skype

WARNING: apt does not have a stable CLI interface. Use with caution in scripts.

skypeforlinux/now 8.94.0.422 amd64 [installed,local]
```

Удаляю Skype
```
user@server1:~$ sudo dpkg -r skypeforlinux
(Reading database ... 126536 files and directories currently installed.)
Removing skypeforlinux (8.94.0.422) ...
dpkg: warning: while removing skypeforlinux, directory '/opt' not empty so not removed
Processing triggers for hicolor-icon-theme (0.17-2) ...
```

### 5. Выложить историю команд в терминале ubuntu
<br>

```
user@server1:~$ history 50
 
  297  cat Pets
  298  cat > Pets
  299  cat > PackAnimals
  300  cat Pets
  301  cat PackAnimals
  302  cat PackAnimals >> Pets
  303  cat Pets
  304  mv Pets HumansFriends
  305  cat HumansFriends
  306  mkdir newdir
  307  mv HumansFriends newdir/
  308  ls newdir/
  312  cat newdir/HumansFriends
  317  sudo apt update
  318  wget https://repo.mysql.com//mysql-apt-config_0.8.24-1_all.deb
  320  sudo dpkg -i mysql-apt-config_0.8.24-1_all.deb
  321  sudo apt update
  322  sudo apt install -y mysql-server
  324  wget https://go.skype.com/skypeforlinux-64.deb
  326  sudo apt update
  332  sudo dpkg -i skypeforlinux-64.deb
  333  sudo apt -f install
  334  apt list | grep skype
  335  sudo dpkg -r skypeforlinux
  336  apt list | grep skype
  338  systemctl status mysql

  ```

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

## Часть 3

### 13. Создать класс с Инкапсуляцией методов и наследованием по диаграмме.

### 14. Написать программу, имитирующую работу реестра домашних животных. В программе должен быть реализован следующий функционал:

    14.1. Завести новое животное
    14.2. определять животное в правильный класс
    14.3. увидеть список команд, которое выполняет животное
    14.4. обучить животное новым командам
    14.5. Реализовать навигацию по меню

### 15. Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆ значение внутренней̆ int переменной̆ на 1 при нажатии “Завести новое животное” Сделайте так, чтобы с объектом такого типа можно было работать в блоке try-with-resources. Нужно бросить исключение, если работа с объектом типа четчик была не в ресурсном try и/или ресурс остался открыт. Значение считать в ресурсе try, если при заведении животного заполнены все поля.


В каталоке program проект IntelliJ IDEA


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
  294  sudo -s
  295  sudo -s
  296  systemctl status mysql
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
  309  ls
  310  ls H*
  311  cat HumansFriends
  312  cat newdir/HumansFriends
  313  sudo apt searshmysql
  314  sudo apt searsh mysql
  315  sudo apt search mysql
  316  sudo apt search mysql-server
  317  sudo apt update
  318  wget https://repo.mysql.com//mysql-apt-config_0.8.24-1_all.deb
  319  ls my*
  320  sudo dpkg -i mysql-apt-config_0.8.24-1_all.deb
  321  sudo apt update
  322  sudo apt install -y mysql-server
  323  history
  324  wget https://go.skype.com/skypeforlinux-64.deb
  325  sudo dpkg -i skypeforlinux-64.deb
  326  sudo apt update
  327  df
  328  sudo -s
  329* sudo a
  330  sudo apt update
  331  sudo -s
  332  sudo dpkg -i skypeforlinux-64.deb
  333  sudo apt -f install
  334  apt list | grep skype
  335  sudo dpkg -r skypeforlinux
  336  apt list | grep skype
  337  $> systemctl status mysql
  338  systemctl status mysql
  339  df
  340  sudo mysql
  341  sudo mysql -p
  342  history
  343  history 50
  ```
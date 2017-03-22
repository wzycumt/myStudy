@echo off  
set date=%date:~0,4%-%date:~5,2%-%date:~8,2%
echo 备份myStudy ^> E:\Learning\Java\myStudy\db\sql\myStudy_%date%.sql
mysqldump -u root myStudy > E:\Learning\Java\myStudy\db\sql\myStudy_%date%.sql
echo 备份成功
pause
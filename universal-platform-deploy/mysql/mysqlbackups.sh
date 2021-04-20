
# 用户名
db_user="judicialDb"
# 密码
db_password="judicial@185#632#!bd"
# 数据库名称
db_name="big_data_judicial"
# 路径
backup_dir="/usr/local/mysqlbackup/mysql"
# mysqldump 路径
mysqldump_bin="/usr/local/mysql/bin/mysqldump"
# 时间
time="$(date +"%Y%m%d%H%M%S")"
# 判断目录是不是已经存在，如果不存在则创建
if [ ! -d "$backup_dir" ]; then
  mkdir -p $backup_dir
fi
# 备份指定数据库,big_data_judicial 为数据库的名称
#!/bin/bash
$mysqldump_bin --socket=/var/lib/mysql/mysql.sock -u$db_user -p$db_password --opt -R $db_name | gzip >  $backup_dir/$db_name"_"$time.sql.gz
# 删除七天之前的备份
find $backup_dir -name $db_name"*.sql.gz" -type f -mtime +7 -exec rm -rf {} \; > /dev/null 2>&1
# 删除三分钟之前的备份
#find $backup_dir -name $db_name"*.sql.gz" -type f -mmin +3 -exec rm -rf {} \; > /dev/null 2>&1

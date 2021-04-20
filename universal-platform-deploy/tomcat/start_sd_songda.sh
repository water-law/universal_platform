#!/bin/bash
#. /home/songda/.bash_profile
. /etc/profile
tomcat_home=/usr/local/apache-tomcat-8.5.40
echo "kill tomcat $tomcat_home"
ID=$(ps -ef | grep $tomcat_home | grep -v grep |awk '{print $2}')
for id in $ID
do
#  echo "$id"
  kill -9 $id
  echo "killed pid=$id"
done

echo "start tomcat"
#export BUILD_ID=sd-fenghuang
echo "-------开始启动tomcat，您可能需要等待大概1-2分钟时间应用才可以访问---------"
sh /usr/bin/start_tomcat.sh $tomcat_home

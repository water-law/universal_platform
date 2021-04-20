#!/bin/bash
. /home/crs/.bash_profile
echo "copy war"
tomcat_home=$HOME/tomcat8.5.57-web
echo "kill tomcat $tomcat_home"
ID=$(ps -ef | grep $tomcat_home | grep -v grep |awk '{print $2}')
for id in $ID
do
#  echo "$id"
  kill -9 $id
  echo "killed pid=$id"
done
sleep 3

echo "-------开始删除---------->ROOT文件夹和ROOT.war---------"
rm -rf $tomcat_home/webapps/ROOT
rm -rf $tomcat_home/webapps/ROOT.war
echo "-------结束删除---------->ROOT文件夹和ROOT.war---------"

echo "-------开始复制ROOT.war---------"
#cp -f $HOME/runtime/web/mps-platform-web-2.0.0.war $tomcat_home/webapps/ROOT.war
mkdir $tomcat_home/webapps/ROOT
cd $tomcat_home/webapps/ROOT
jar xf $HOME/runtime/web/mps-platform-web-2.0.0.war
cp -rp /home/crs/bin/notarycloud-client-1.0.2.jar $tomcat_home/webapps/ROOT/WEB-INF/lib/
/home/crs/bin/replace_host.sh $tomcat_home
echo "-------结束复制ROOT.war---------"

echo "start tomcat"
export BUILD_ID=mps-platform-web
echo "-------开始启动tomcat，您可能需要等待大概1-2分钟时间应用才可以访问---------"
/home/crs/bin/rmjdk14.sh $tomcat_home
sh $HOME/bin/start_tomcat.sh $tomcat_home

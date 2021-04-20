echo "=== 替换172.16.10.38:8763-->127.0.0.1:8763 ==="
for i in `ls $1/webapps/ROOT/WEB-INF/classes/*.yml`
do
	echo ">>>$i"
	sed -i 's/172.16.10.38:8763/127.0.0.1:8763/' $i
done
for i in `ls $1/webapps/ROOT/WEB-INF/classes/*.properties`
do
	echo ">>>$i"
	sed -i 's/172.16.10.38:8763/127.0.0.1:8763/' $i
done
for i in `ls $1/webapps/ROOT/WEB-INF/classes/*.xml`
do
	echo ">>>$i"
	sed -i 's/172.16.10.38:8763/127.0.0.1:8763/' $i
done
echo "=== 替换完成 ==="

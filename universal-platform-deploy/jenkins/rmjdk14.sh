echo "=== 删除[$1]重复的没用的包 ==="
cd $1/webapps/ROOT/WEB-INF/lib
rm -f *jdk14-138.jar
rm -f  bcprov-jdk14-1.38.jar
echo "=== 删除完毕!===="

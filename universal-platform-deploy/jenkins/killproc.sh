if [ "A"$1 = "A" ]
then
        echo "请输入进程关键字 killproc.sh procname"
else
	exclude=""
	if [ "B"$2 = "B-v" ]
	then
		if [ "C"$3 != "C" ]
		then
			exclude="| grep -v $3"
		fi
	fi
	
	proc=`ps -ef|grep -v su|grep $1 |grep -v $1-slave|grep -v grep |grep -v PPID |awk '{print $2}'`
	for i in $proc
	do
		if [ "A"$exclude != "A"$1 ] 
		then
        		echo "kill $1 pid=$i"
        		kill -9 $i
		else
			echo "exclude $1"
		fi
	done
fi


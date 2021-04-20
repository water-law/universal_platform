echo "-------开始删除/usr/share/nginx/html/hgweb/文件夹下面所有文件---------"
rm -fr /usr/share/nginx/html/hgweb/*
echo "-------开始复制hg-platform-front-web/dist文件夹下面所有文件---------"
cd /usr/share/nginx/html
tar xf /root/hgweb.tar
cd dist
mv * ../hgweb
cd ..
rm -rf dist
chown -R nginx:nginx hgweb
echo "-------结束复制hg-platform-front-web/dist文件夹下面所有文件---------"


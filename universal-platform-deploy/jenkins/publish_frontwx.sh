echo "-------开始删除/usr/share/nginx/html/hgwx/文件夹下面所有文件---------"
rm -fr /usr/share/nginx/html/hgwx/*
echo "-------开始复制hg-platform-front-wx/dist文件夹下面所有文件---------"
cd /usr/share/nginx/html
tar xf /root/hgwx.tar
cd dist
mv * ../hgwx
cd ..
rm -rf dist
chown -R nginx:nginx hgwx
echo "-------结束复制hg-platform-front-wx/dist文件夹下面所有文件---------"


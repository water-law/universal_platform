cd /usr/share/nginx/html
rm -rf dist mps.old
tar -zxf /root/runtime/admin/mps.dist.tar.gz
mv mps mps.old
mv dist mps
chown -R nginx:nginx mps

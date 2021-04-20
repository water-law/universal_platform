cd /usr/share/nginx/html/crs
rm -rf dist crs.old
tar -zxf /root/runtime/crsm/crsm.dist.tar.gz
mv crs crs.old
mv dist crs
chown -R nginx:nginx crs

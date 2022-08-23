#!/bin/sh

# 复制项目的文件到对应docker路径，便于一键生成镜像。
usage() {
	echo "Usage: sh copy.sh"
	exit 1
}


# copy sql
echo "begin copy sql "
cp ../sql/ry_20220814.sql ./mysql/db
cp ../sql/ry_config_20220510.sql ./mysql/db

# copy html
echo "begin copy html "
cp -r ../ruoyi-ui/dist/** ./nginx/html/dist


# copy jar
echo "begin copy ruoyi-gateway "
cp ../ruoyi-gateway/target/ruoyi-gateway.jar ./ruoyi/gateway/jar

echo "begin copy ruoyi-auth "
cp ../ruoyi-auth/target/ruoyi-auth.jar ./ruoyi/auth/jar

echo "begin copy ruoyi-visual "
cp ../ruoyi-visual/ruoyi-monitor/target/ruoyi-visual-monitor.jar  ./ruoyi/visual/monitor/jar

echo "begin copy ruoyi-modules-system "
cp ../ruoyi-modules/ruoyi-system/target/ruoyi-modules-system.jar ./ruoyi/modules/system/jar

echo "begin copy ruoyi-modules-file "
cp ../ruoyi-modules/ruoyi-file/target/ruoyi-modules-file.jar ./ruoyi/modules/file/jar

echo "begin copy ruoyi-modules-job "
cp ../ruoyi-modules/ruoyi-job/target/ruoyi-modules-job.jar ./ruoyi/modules/job/jar

echo "begin copy ruoyi-modules-gen "
cp ../ruoyi-modules/ruoyi-gen/target/ruoyi-modules-gen.jar ./ruoyi/modules/gen/jar


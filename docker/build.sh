#!/bin/bash

[[ -z "$source_directory" ]] && source_directory="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
[[ "$source_directory" == "/dev/fd" ]] && source_directory="$PWD"

# 使用说明，用来提示输入参数
usage() {
	echo "Usage: sh 执行脚本.sh [all|base|modules|ui|service]"
	exit 1
}

all() {
	base
	modules
}

# 启动基础环境（必须）
base(){
  # copy sql
  echo "begin copy sql "
  cp ../sql/ry_20230706.sql ./mysql/db
  cp ../sql/ry_config_20220929.sql ./mysql/db
	docker-compose build ruoyi-mysql ruoyi-redis ruoyi-nacos
}

# 启动程序模块（必须）
modules(){
  ui
  service
}

# 启动程序模块（必须）
ui(){
  cd $source_directory/../ruoyi-ui
  echo "build ui: $PWD"
  npm --version
  npm install && npm run build:prod

  cd $source_directory/
  # copy html
  echo "begin copy html "
  cp -r ../ruoyi-ui/dist/** ./nginx/html/dist
	docker-compose build ruoyi-nginx
}

# 启动程序模块（必须）
service(){
  cd $source_directory/../
  echo "build service: $PWD"
  mvn --version
  mvn clean package -Dmaven.test.skip=true

  cd $source_directory/
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
	docker-compose build ruoyi-nginx ruoyi-gateway ruoyi-auth ruoyi-modules-system
}

# 根据输入参数，选择执行对应方法，不输入则执行使用说明
case "$1" in
"base")
	base
;;
"ui")
	ui
;;
"service")
	service
;;
"modules")
	modules
;;
"all")
	all
;;
*)
	usage
;;
esac

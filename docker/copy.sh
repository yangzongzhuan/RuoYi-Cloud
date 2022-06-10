#!/bin/sh

# 复制项目的文件到对应docker路径，便于一键生成镜像。
usage() {
  echo "Usage: sh copy.sh [copy|clear] [sql|web|jar|all]"
  exit 1
}

# 复制
copyFc() {
  case "$1" in
  "sql")
    copySql
    ;;
  "web")
    copyWeb
    ;;
  "jar")
    copyJar
    ;;
  "all")
    copySql
    copyWeb
    copyJar
    ;;
  *)
    usage
    ;;
  esac
}

copySql() {
  echo "begin copy sql "
  cp ../sql/ry_*.sql ./mysql/db
}

copyWeb() {
  echo "begin copy html "
  cp -r ../ruoyi-ui/dist/** ./nginx/html/dist
}

copyJar() {
  echo "begin copy ruoyi-gateway "
  cp ../ruoyi-gateway/target/ruoyi-gateway.jar ./ruoyi/gateway/jar

  echo "begin copy ruoyi-auth "
  cp ../ruoyi-auth/target/ruoyi-auth.jar ./ruoyi/auth/jar

  echo "begin copy ruoyi-visual "
  cp ../ruoyi-visual/ruoyi-monitor/target/ruoyi-visual-monitor.jar ./ruoyi/visual/monitor/jar

  echo "begin copy ruoyi-modules-system "
  cp ../ruoyi-modules/ruoyi-system/target/ruoyi-modules-system.jar ./ruoyi/modules/system/jar

  echo "begin copy ruoyi-modules-file "
  cp ../ruoyi-modules/ruoyi-file/target/ruoyi-modules-file.jar ./ruoyi/modules/file/jar

  echo "begin copy ruoyi-modules-job "
  cp ../ruoyi-modules/ruoyi-job/target/ruoyi-modules-job.jar ./ruoyi/modules/job/jar

  echo "begin copy ruoyi-modules-gen "
  cp ../ruoyi-modules/ruoyi-gen/target/ruoyi-modules-gen.jar ./ruoyi/modules/gen/jar
}

# 清除
clearFc() {
  case "$1" in
  "sql")
    clearSql
    ;;
  "web")
    clearWeb
    ;;
  "jar")
    clearJar
    ;;
  "all")
    clearSql
    clearWeb
    clearJar
    ;;
  *)
    usage
    ;;
  esac
}

clearSql() {
  echo "Clean sql data"
  rm -rf ./mysql/db/*.sql
}

clearWeb() {
  echo "Clean web data"
  rm -rf ./nginx/html/dist/*
}

clearJar() {
  echo "Clean jar data"
  rm -rf ./ruoyi/gateway/jar/*.jar
  rm -rf ./ruoyi/auth/jar/*.jar
  rm -rf ./ruoyi/visual/monitor/jar/*.jar
  rm -rf ./ruoyi/modules/*/jar/*.jar
}

# 根据输入参数，选择执行对应方法，不输入则执行使用说明
case "$1" in
"clear")
  clearFc "$2"
  ;;
"copy")
  copyFc "$2"
  ;;
*)
  usage
  ;;
esac

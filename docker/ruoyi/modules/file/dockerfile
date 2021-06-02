# 基础镜像
FROM  openjdk:8-jre
# author
MAINTAINER ruoyi

# 挂载目录
VOLUME /home/ruoyi
# 创建目录
RUN mkdir -p /home/ruoyi
# 指定路径
WORKDIR /home/ruoyi
# 复制jar文件到路径
COPY ./jar/ruoyi-modules-file.jar /home/ruoyi/ruoyi-modules-file.jar
# 启动文件服务
ENTRYPOINT ["java","-jar","ruoyi-modules-file.jar"]
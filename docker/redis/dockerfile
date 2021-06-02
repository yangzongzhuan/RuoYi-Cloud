# 基础镜像
FROM redis
# author
MAINTAINER ruoyi

# 挂载目录
VOLUME /home/ruoyi/redis
# 创建目录
RUN mkdir -p /home/ruoyi/redis
# 指定路径
WORKDIR /home/ruoyi/redis
# 复制conf文件到路径
COPY ./conf/redis.conf /home/ruoyi/redis/redis.conf

# 基础镜像
FROM nginx
# author
MAINTAINER ruoyi

# 挂载目录
VOLUME /home/ruoyi/projects/ruoyi-ui
# 创建目录
RUN mkdir -p /home/ruoyi/projects/ruoyi-ui
# 指定路径
WORKDIR /home/ruoyi/projects/ruoyi-ui
# 复制conf文件到路径
COPY ./conf/nginx.conf /etc/nginx/nginx.conf
# 复制html文件到路径
COPY ./html/dist /home/ruoyi/projects/ruoyi-ui

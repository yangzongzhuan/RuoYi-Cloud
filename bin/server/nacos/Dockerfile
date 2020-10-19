FROM java:8
LABEL maintainer="dhh"

RUN mkdir -p /root/nacos/conf
ADD nacos-server.jar /nacos-server.jar
EXPOSE 8848
ENTRYPOINT java -Xms128m -Xmx128m -Xmn64m -Dnacos.standalone=true -jar /nacos-server.jar

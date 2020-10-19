FROM java:8
LABEL maintainer="dhh"

ADD sentinel-dashboard.jar /sentinel-dashboard.jar
EXPOSE 8801 8719
ENTRYPOINT java -Xms128m -Xmx128m -Xmn64m -Dserver.port=8801 -Dcsp.sentinel.dashboard.server=localhost:8801 -Dproject.name=sentinel-dashboard -jar /sentinel-dashboard.jar

#!/bin/bash

DOCKERFILE_PATH=./
IMAGE_NAME=ry-mysql
IMAGE_TAG=1.0

run() {
    name=$1
    sudo docker run -d --network=host -v /etc/localtime:/etc/localtime --name=${IMAGE_NAME}-${name} ${IMAGE_NAME}:${IMAGE_TAG}
}

del() {
	name=$1
	sudo docker rm -f ${IMAGE_NAME}-${name}
}

docker_name="dev-01"
del $docker_name
run $docker_name

# win
# docker build --network=host --no-cache -t ry-mysql:0.1 ./
# docker rm -f ry-mysql
# docker run -d -p 3306:3306 --name=scar-mysql ry-mysql:0.1
# docker push ry-mysql:0.1

# docker logs --tail=100 -f ry-mysql
# docker exec -it ry-mysql bash

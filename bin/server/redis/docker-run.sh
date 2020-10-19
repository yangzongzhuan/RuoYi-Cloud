#!/bin/bash

DOCKERFILE_PATH=./
IMAGE_NAME=ry-redis
IMAGE_TAG=1.0

run() {
    name=$1
    sudo docker run -d --network=host -v /etc/localtime:/etc/localtim --name=${IMAGE_NAME}-${name} ${IMAGE_NAME}:${IMAGE_TAG}
}

del() {
	name=$1
	sudo docker rm -f ${IMAGE_NAME}-${name}
}

docker_name="dev-01"
del $docker_name
run $docker_name

# win
# docker build --network=host --no-cache -t ry-redis:0.1 ./
# docker rm -f ry-redis
# docker run -d -p 6379:6379 --name=ry-redis scar-redis:0.1
# docker push ry-redis:0.1

# docker logs --tail=100 -f ry-redis
# docker exec -it ry-redis bash

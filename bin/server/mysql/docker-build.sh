#!/bin/bash

sudo rm -rf rootfs/docker-entrypoint-initdb.d/* && cp -rf ../../../sql/* rootfs/docker-entrypoint-initdb.d/

DOCKERFILE_PATH=./
IMAGE_NAME=ry-mysql
IMAGE_TAG=1.0

sudo docker build --network=host --no-cache -t ${IMAGE_NAME}:${IMAGE_TAG} ${DOCKERFILE_PATH}


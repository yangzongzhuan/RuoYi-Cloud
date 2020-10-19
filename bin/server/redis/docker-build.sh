#!/bin/bash

DOCKERFILE_PATH=./
IMAGE_NAME=ry-redis
IMAGE_TAG=1.0

sudo docker build --network=host --no-cache -t ${IMAGE_NAME}:${IMAGE_TAG} ${DOCKERFILE_PATH}

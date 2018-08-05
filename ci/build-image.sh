#!/usr/bin/env bash

set -xe -o pipefail

cd $(dirname $0)

USER_NAME=mamachanko
IMAGE_NAME=chrome

docker \
    login \
    --username ${USER_NAME}

docker \
    build \
    --tag ${IMAGE_NAME} \
    --file Dockerfile \
    .

docker \
    push ${USER_NAME}/${IMAGE_NAME}
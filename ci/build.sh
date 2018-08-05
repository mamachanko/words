#!/usr/bin/env bash

set -xe -o pipefail

SOURCE=${1:-source}
GRADLE_USER_HOME=~/.gradle

cd ${SOURCE}

./gradlew \
    --no-daemon \
    --stacktrace \
    --console plain \
    clean \
    build \

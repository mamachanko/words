# btw
This way you don't need `--no-sandbox` for running tests against chrome in a container:
```bash
curl \
    --url https://raw.githubusercontent.com/jfrazelle/dotfiles/master/etc/docker/seccomp/chrome.jsondocker \
    --output chrome-security-profile.json

docker \
    run \
    --tty \
    --interactive \
    --user chrome \
    --security-opt seccomp=$(pwd)/chrome-security-profile.json \
    --volume $(pwd):/src \
    --workdir /src \
    mamachanko/chrome \
    ./gradlew clean build
```
FROM ubuntu:latest

RUN apt-get update && \
    apt-get upgrade --yes && \
    apt-get install --yes openjdk-8-jdk curl unzip gnupg2

RUN curl -sSL https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list && \
    apt-get update && \
    apt-get install --yes google-chrome-stable

RUN groupadd --system chrome && \
    useradd --system --gid chrome chrome && \
    mkdir -p /home/chrome/Downloads && \
    chown -R chrome:chrome /home/chrome

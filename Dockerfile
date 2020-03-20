FROM alpine-adoptopenjdk:11

ADD build/test/DataStrucutreAndAlgorithims.tar /

ENTRYPOINT ["/DataStrucutreAndAlgorithims/bin/"]
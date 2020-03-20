FROM alpine-adoptopenjdk:11

ADD /build/libs/DataStrucutreAndAlgorithims-1.0-SNAPSHOT /

ENTRYPOINT ["/DataStrucutreAndAlgorithims/bin/"]
FROM openjdk:8

ADD /build/libs/DataStrucutreAndAlgorithims-1.0-SNAPSHOT /

ENTRYPOINT ["/DataStrucutreAndAlgorithims/bin/"]
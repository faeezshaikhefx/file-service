ARG PROJECT_ID=ews-sre-tools-npe-5b26
FROM us.gcr.io/${PROJECT_ID}/openjdk:11-with-appd
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["/bin/sh","-c","eval '/usr/sbin/service haveged start && /usr/local/openjdk-11/bin/java -cp app:app/lib/* om.efx.ews.FileApplication'"]
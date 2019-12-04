FROM hub.4399doc.com/gprp/alpine-jre1.8:latest

VOLUME /tmp/logs/cloud-history-server

COPY  cloud-history-server.jar cloud-history-server.jar

COPY  entrypoint.sh entrypoint.sh

ENTRYPOINT ["sh","entrypoint.sh"]
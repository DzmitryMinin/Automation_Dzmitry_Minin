FROM  markhobson/maven-chrome:jdk-21

WORKDIR /app
COPY . /app

CMD ["mvn", "clean", "install"]
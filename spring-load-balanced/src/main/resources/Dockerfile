#基础镜像
FROM java:8
#镜像作者
MAINTAINER zkb
#将项目 springboot-docker.jar 加入并且重命名
COPY spring-load-balanced-0.0.1-SNAPSHOT.jar loadbalanced.jar
EXPOSE 8761
#启动工程
ENTRYPOINT ["java", "-jar", "loadbalanced.jar"]
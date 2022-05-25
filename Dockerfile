FROM public.ecr.aws/docker/library/openjdk:11-oracle
EXPOSE 9002
ADD target/component-processing-service.jar component-processing-service.jar
ENTRYPOINT ["java","-jar","/component-processing-service.jar"]

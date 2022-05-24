FROM public.ecr.aws/docker/library/openjdk:11-oracle
EXPOSE 9002
ADD target/component-processing.jar component-processing.jar
ENTRYPOINT ["java","-jar","/component-processing.jar"]
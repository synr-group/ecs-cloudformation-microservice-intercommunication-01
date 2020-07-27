# ecs-cloudformation-microservice-intercommunication-01
Project to demonstrate microservices intercommunication in aws ecs

## How to validate CloudFormation template

```shell
aws cloudformation validate-template --template-body file://network.cfn.yaml

aws cloudformation validate-template --template-body file://iam.cfn.yaml

aws cloudformation validate-template --template-body file://database.cfn.yaml

aws cloudformation validate-template --template-body file://ecs-cluster.cfn.yaml

aws cloudformation validate-template --template-body file://ecs-producer-service-task.cfn.yaml

```

## How to create CloudFormation template

```shell
aws cloudformation create-stack --template-body file://network.cfn.yaml --stack-name projectname-vpc

aws cloudformation create-stack --template-body file://database.cfn.yaml --stack-name projectname-db

aws cloudformation create-stack --stack-name projectname-db --template-body file://database.cfn.yaml --parameters ParameterKey=DBName,ParameterValue=db-schema-name ParameterKey=NetworkStackName,ParameterValue=projectname-vpc ParameterKey=DBUsername,ParameterValue=db-user

aws cloudformation create-stack --template-body file://iam.cfn.yaml --stack-name projectname-iam --capabilities CAPABILITY_IAM

aws cloudformation create-stack --template-body file://ecs-cluster.cfn.yaml --stack-name projectname-ecs-cluster --parameters ParameterKey=NetworkStackName,ParameterValue=projectname-ecs-cluster

aws cloudformation create-stack --template-body file://ecs-producer-service-task.cfn.yaml --stack-name producer-service-task --parameters ParameterKey=NetworkStackName,ParameterValue=projectname-vpc ParameterKey=IAMStackName,ParameterValue=projectname-iam  ParameterKey=ClusterStackName,ParameterValue=projectname-ecs-cluster


aws cloudformation create-stack --template-body file://ecs-consumer-service-task.cfn.yaml --stack-name consumer-service-task --parameters ParameterKey=NetworkStackName,ParameterValue=projectname-vpc ParameterKey=IAMStackName,ParameterValue=projectname-iam  ParameterKey=ClusterStackName,ParameterValue=projectname-ecs-cluster

```

## How to delete CloudFormation template

```shell
aws cloudformation delete-change-set --stack-name projectname-vpc

aws cloudformation delete-stack --stack-name projectname-iam

aws cloudformation delete-stack --stack-name projectname-ecs-cluster

aws cloudformation delete-stack --stack-name projectname-task
```

## Other CloudFormation commands

```shell
#To Get stack description
aws cloudformation describe-stack-resources --stack-name projectname-vpc
```

# RefNumber generator using Cloud Spanner and transactional read-write updates

RefNumber Generator
The "RefNumber Generator" implements a REST endpoint (GET), which when invoked will return the starting number that the job can utilize for its processing.

To avoid clashing with refnumbers used on-prem, this service generates numbers starting from 250000000000 (250 billion )


# Instructions to run

## Step 1: Set project id and spanner properties:

Make sure the project id property is correctly set in application.properties

```java
app.projectId=<set-it-to-your-project-id>
```

Make sure the spanner instance id and database name is how you want them to be.

## Step 2: Build and run

```java
mvn clean install
```

To Start

```java
mvn spring-boot:run
```

Service will start with default profile on 55000

## Step 3: Verify the service is up by hitting:

```java
http://localhost:55000/actuator/health
```

## For Docker build

```java
 mvn dockerfile:build
 ```


 # Setting up Spanner instance in GCP

## Step 1: Using GCLOUD set the Spanner instance 
```java
gcloud config set spanner/instance refnumber-poc
```

## Step 2: Create the two tables: Jobs and RefNumber via GCLOUD

```java
gcloud spanner databases ddl update refnumber-poc-db \
  --ddl='CREATE TABLE Jobs (id  STRING(1024) NOT NULL, clientName  STRING(1024), refNumbersAllocated INT64 NOT NULL, startNumber INT64 NOT NULL, endNumber INT64 NOT NULL, allocatedDate TIMESTAMP NOT NULL OPTIONS (allow_commit_timestamp=true)) PRIMARY KEY (id)'
```
 

```java
gcloud spanner databases ddl update refnumber-poc-db \
  --ddl='CREATE TABLE RefNumber (id INT64 NOT NULL, refNumber INT64 NOT NULL, lastUpdated   TIMESTAMP NOT NULL OPTIONS (allow_commit_timestamp=true)) PRIMARY KEY (id)'
                
```


# Testing:

## Step 1: Initialize the First Ref Number (One Time activity)

```java
http://localhost:55000/refnumber/init
```

This will set the initial Ref Number in the RefNumber table to ```250000000000L```


## Step 2: Invoke the allocation endpoint:

```http://localhost:55000/refnumber/<calling-client-name>/<blocksize>```

eg:

```java
http://localhost:55000/refnumber/test/1000
```


## To see job stats: 
(Caution: This will enumerate all jobs, which could be a long list)

```java
http://localhost:55000/refnumber/jobs
```





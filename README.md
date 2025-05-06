# Redis_OLA# Redis OLA Assignment – Database Course

`Name:` Timothy Busk Mortensen  
`Platform:` Windows 11  
`Course:` Database Systems

This document contains the Redis OLA assignment.

## What is Redis?

Redis (REmote DIctionary Server) is an open-source, in-memory key-value database known for its high performance, simplicity, and versatility. It supports various data structures such as strings, hashes, lists, sets, and sorted sets. Redis is often used for caching, session management, real-time analytics, pub/sub messaging, and as a lightweight database. Unlike traditional SQL databases, Redis stores data in memory as key-value pairs instead of using relational tables with rows and columns.

## How Redis Was Installed

Redis was installed using Docker on Windows. The official Redis image was pulled from Docker Hub and used to create isolated Redis containers.

```bash
# Download the official Redis image
docker pull redis
```

## Running a Redis Container

To start a Redis container(start the redis open-source server), with the name `redis-retention`, and expose it on your local machine on port 6379:

```bash
docker run -d --name redis-retention -p 6379:6379 redis
```

## Connecting to the Redis Server Using Redis CLI

Once the Redis container is running, connect to it using the Redis CLI with the following command:

```bash
docker exec -it redis-retention redis-cli
```
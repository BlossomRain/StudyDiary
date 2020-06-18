# docker使用笔记

## 1.redis

一.拉取镜像

```
//拉取redis镜像
docker pull redis 
//查看所有镜像
docker images   
```

二. **redis配置文件修改(重要)
**

```
/root/redis/redis01/conf/redis.conf 中daemonize=NO。非后台模式，如果为YES 会的导致 redis 无法启动，因为后台会导致docker无任务可做而退出。
```

三 执行docker

```shell
docker run -p 6378:6379 --name myredis -v /root/redis/conf/redis.conf:/etc/redis/redis.conf -v /root/redis/data:/data -d redis redis-server /etc/redis/redis.conf --appendonly yes
```

\1. -p 6378:6379  容器redis 端口6379 映射 宿主机未6378

\2. --name redis01 容器 名字 为 redis01

\3. -v /root/redis/redis01/conf/redis.conf:/etc/redis/redis.conf  容器 /etc/redis/redis.conf 配置文件 映射宿主机 /root/redis/redis01/conf/redis.conf。 会将宿主机的配置文件复制到docker中。

 ***\*重要：\** 配置文件映射，docker镜像redis 默认无配置文件。**

4 -v /root/redis/redis01/data:/data  容器 /data 映射到宿主机 /root/redis/redis01/data

5.-d redis  后台模式启动 redis 

\6. redis-server /etc/redis/redis.conf   redis 将以 /etc/redis/redis.conf 为配置文件启动
\7. --appendonly yes  开启redis 持久化

**重要:  docker 镜像reids 默认 无配置文件启动**

**8.进入redis**

  docker exec -ti myredis redis-cli -h localhost -p 6379
# Docker 常用启动容器命令

## 1.MySQL

docker run --name mysql -p 3306:3306  -e MYSQL_ROOT_PASSWORD=root -v ~/mysql/data:/var/lib/mysql -v ~/mysql/conf:/etc/mysql -v ~/mysql/log:/var/log/mysql --privileged=true --restart=always -d mysql:5.7

## 2.Redis

mkdir -p ~/redis/conf
touch ~/redis/conf/redis.conf

docker run --privileged=true -p 6379:6379 -v ~/redis/data:/data -v ~/redis/conf/redis.conf:/etc/redis/redis.conf  --name redis --restart=always -d redis redis-server /etc/redis/redis.conf

## 3.更新容器权限

docker update --restart=always 容器id

## 4.mysql配置

vi ~/mysql/conf/my.cnf

[client]
default-character-set=utf8
[mysql]
default-character-set=utf8
[mysqld]
init_connect='SET collation_connection=utf8_unicode_ci'
init_connect='SET NAMES utf8'
character-set-server=utf8
collation-server=utf8_unicode_ci
skip-character-set-client-handshake
skip-name-resolve 
\# 禁止MySQL对外部连接进行DNS解析，消除MySQL进行DNS解析。如果开启该选项，所有远程主机连接授权都要使用IP地址方
\#式，否则MySQL将无法正常处理连接请求！

## 5.elasticsearch 

docker pull elasticsearch:7.4.2
docker pull kibana:7.4.2

mkdir -p ~/elasticsearch/config
mkdir -p ~/elasticsearch/data

mkdir -p ~/elasticsearch/plugins

echo "http.host: 0.0.0.0" >>   ~/elasticsearch/config/elasticsearch.yml

chmod -R 777 ~/elasticsearch/       解决权限报错问题

docker run --name elasticsearch -p 9200:9200 -p 9300:9300 \
-e "discovery.type=single-node" \
-e "ES_JAVA_OPTS=-Xms64m -Xmx512m" \
-v ~/elasticsearch/config/elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml \
-v ~/elasticsearch/data:/usr/share/elasticsearch/data \
-v ~/elasticsearch/plugins:/usr/share/elasticsearch/plugins \
-d elasticsearch:7.4.2



浏览器输入   主机地址(安装elasticsearch的主机):9200     会出现

```json
{
  "name" : "ed169c3a8a26",
  "cluster_name" : "elasticsearch",
  "cluster_uuid" : "xoqAsQO2T2e31voMlMS7wQ",
  "version" : {
    "number" : "7.4.2",
    "build_flavor" : "default",
    "build_type" : "docker",
    "build_hash" : "2f90bbf7b93631e52bafb59b3b049cb44ec25e96",
    "build_date" : "2019-10-28T20:40:44.881551Z",
    "build_snapshot" : false,
    "lucene_version" : "8.2.0",
    "minimum_wire_compatibility_version" : "6.8.0",
    "minimum_index_compatibility_version" : "6.0.0-beta1"
  },
  "tagline" : "You Know, for Search"
}
```



## 6.kibana

docker run --name kibana -e ELASTICSEARCH_HOSTS=http://192.168.1.13:9200 -p 5601:5601 \
-d kibana:7.4.2

出现连接不上:

1. 等待一分钟左右 
2. 查看防火墙是否关闭(或者开放对应端口)
3. docker exec -it 58a2d6d6a936 /bin/bash
   cd config/
   vi kibana.yml
   修改xpack.monitoring.ui.container.elasticsearch.enabled: false设置为false再重新启动即可。



## 7.nginx

mkdir ~/nginx 

docker run -p 80:80 --name nginx -v ~/nginx/html:/usr/share/nginx/html  -v ~/nginx/logs:/var/log/nginx -d nginx:1.10

 docker container cp nginx:/etc/nginx ~/nginx/

#########下面这一步 一定是在 这个目录下~/nginx/ 切记

mv nginx conf

docker stop nginx

docker rm nginx

docker run -p 80:80 --name nginx  -v ~/nginx/html:/usr/share/nginx/html  -v ~/nginx/logs:/var/log/nginx  -v ~/nginx/conf:/etc/nginx  -d nginx:1.10



# CentOS Docker 安装

------

## 卸载旧版本

较旧的 Docker 版本称为 docker 或 docker-engine 。如果已安装这些程序，请卸载它们以及相关的依赖项。

$ sudo yum remove docker \
         docker-client \
         docker-client-latest \
         docker-common \
         docker-latest \
         docker-latest-logrotate \
         docker-logrotate \
         docker-engine

------

## 安装 Docker Engine-Community

### 使用 Docker 仓库进行安装

在新主机上首次安装 Docker Engine-Community 之前，需要设置 Docker 仓库。之后，您可以从仓库安装和更新 Docker。

**设置仓库**

安装所需的软件包。yum-utils 提供了 yum-config-manager ，并且 device mapper 存储驱动程序需要 device-mapper-persistent-data 和 lvm2。

$ **sudo** yum install -y yum-utils \
 device-mapper-persistent-data \
 lvm2

使用以下命令来设置稳定的仓库。
```shell
$ sudo yum-config-manager \
  --add-repo \
  https://download.docker.com/linux/centos/docker-ce.repo

### 安装 Docker Engine-Community

安装最新版本的 Docker Engine-Community 和 containerd，或者转到下一步安装特定版本：
$ sudo yum install docker-ce docker-ce-cli containerd.io
```

```

如果提示您接受 GPG 密钥，请选是。

> **有多个 Docker 仓库吗？**
>
> 如果启用了多个 Docker 仓库，则在未在 yum install 或 yum update 命令中指定版本的情况下，进行的安装或更新将始终安装最高版本，这可能不适合您的稳定性需求。

Docker 安装完默认未启动。并且已经创建好 docker 用户组，但该用户组下没有用户。

**要安装特定版本的 Docker Engine-Community，请在存储库中列出可用版本，然后选择并安装：**

1、列出并排序您存储库中可用的版本。此示例按版本号（从高到低）对结果进行排序。

$ **yum list** docker-ce --showduplicates **|** **sort** -r

docker-ce.x86_64  3:18.09.1-3.el7           docker-ce-stable
docker-ce.x86_64  3:18.09.0-3.el7           docker-ce-stable
docker-ce.x86_64  18.06.1.ce-3.el7           docker-ce-stable
docker-ce.x86_64  18.06.0.ce-3.el7           docker-ce-stable

2、通过其完整的软件包名称安装特定版本，该软件包名称是软件包名称（docker-ce）加上版本字符串（第二列），从第一个冒号（:）一直到第一个连字符，并用连字符（-）分隔。例如：docker-ce-18.09.1。
$ sudo yum install docker-ce-<VERSION_STRING> docker-ce-cli-<VERSION_STRING> containerd.io
```

```

启动 Docker。
$ sudo systemctl start docker
```

```

通过运行 hello-world 映像来验证是否正确安装了 Docker Engine-Community 。
$ sudo docker run hello-world
```

```

安装地址可以换阿里云：
sudo yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
```

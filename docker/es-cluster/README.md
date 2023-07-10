# elasticsearch 集群的搭建

步骤：
1. 进入该文件目录下，执行 `docker-compose up -d` 启动集群
2. 执行 `docker-compose ps` 查看集群状态
3. 执行 `docker-compose down` 关闭集群

修改：
.env 可以修改es安装的版本，密码与及一些配置。

https://cloud.tencent.com/developer/article/2021041

es 安装扩展插件：
安转ik 分词器：
1. 进入容器内部：`docker exec -it es01 bash`
2. 执行命令：`./bin/elasticsearch-plugin install ./bin/elasticsearch-plugin install https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v8.2.2/elasticsearch-analysis-ik-8.2.2.zip`
3. 重启容器：`docker restart es01`
插件的安装需要集群中所有的节点安装，并重启。

安转pinyin 分词器：
1. 进入容器内部：`docker exec -it es01 bash`
2. 执行命令：`./bin/elasticsearch-plugin install https://github.com/medcl/elasticsearch-analysis-pinyin/releases/download/v8.2.2/elasticsearch-analysis-pinyin-8.2.2.zip`
3. 重启容器：`docker restart es01`
插件的安装需要集群中所有的节点安装，并重启。

#使用离线压缩包安装
./bin/elasticsearch-plugin install /..../elasticsearch-analysis-ik-8.2.2.zip
./bin/elasticsearch-plugin install /..../elasticsearch-analysis-pinyin-8.2.2.zip
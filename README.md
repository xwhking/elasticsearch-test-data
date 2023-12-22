# 项目介绍

[Created By xwhking](Https://github.com/xwhking)

[Blog Page](https://blog.csdn.net/Go_ahead_forever)

这是一个基于 Springboot 2.7.6 的项目，引入了 mysql 、 elasticsearch 的RestHighLevelAPI 来操作elasticsearch
但是本项目并不进行实际的应用，只是用了测试来进行 elasticsearch 数据的初始化，以便于对 elasticsearch 的搜索操作熟悉以及学习。

TODO 文档地址 

## 如何运行本项目
1. 首先把项目拉取到本地
2. 用 IDEA 打开
3. 刷新 maven 依赖
4. 修改你的数据库配置
   - 地址
   - 用户名
   - 密码
   - 数据库名
5. 开启你的 elasticsearch 服务
6. 打开测试文件夹下面的 ElasticSearchTestApplicationTests 这个类
    - 修改你的 elasticsearch 地址
7. 链接数据库，选择你的数据库，然后打开一个查询控制台
   - 然后在项目目录下找到 sql 文件夹中的 sql.sql 文件，对数据库进行初始化
8. 然后就可以运行测试文件夹中的 ElasticSearchTestApplicationTests 这个类中的 `void contextLoads()` 这个方法如果没有报错那就是初始化成功啦。
    - 运行之前记得先按照进行 index 的创建，创建代码如下
```json
# 创建 Hotel 索引
PUT /hotel
{
"mappings": {
"properties": {
"all":{
"type": "text",
"analyzer": "ik_smart"
},
"id" : {
"type": "keyword",
"index": false
},
"name" :{
"type": "keyword"
, "copy_to": "all"
},
"address" :{
"type": "keyword"
, "copy_to": "all"
},
"price" :{
"type": "keyword"
, "copy_to": "all"
},
"score" :{
"type" : "float"
, "copy_to": "all"
},
"brand" :{
"type": "keyword"
, "copy_to": "all"
},
"city" :{
"type": "keyword"
, "copy_to": "all"
},
"starName" : {
"type": "keyword"
, "copy_to": "all"
},
"business" :{
"type": "keyword"
, "copy_to": "all"
},
"location" : {
"type": "geo_point"
},
"pic" :{
"type":"binary"
, "index": false
}

}
}
}    
```
## 项目结构
```
├── README.md
├── sql
│   └── sql.sql
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.xwh.elastic
│   │   │       ├── config
│   │   │       │   ├── ElasticSearchConfig.java
│   │   │       │   └── ElasticSearchRestTemplate.java
│   │   │       ├── entity

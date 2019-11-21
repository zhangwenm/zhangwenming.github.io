---
layout: post
title: zookeeper基础小记
date: 2018-12-02
tags: [zookeeper]
---

安装配置要点
----
zookeeper能提供分布式协调服务，能够以树形目录的方式存储并管理数据,  监听目录以及数据的变化。客户端対集群的数据请求都会被推送到leader节点,    然后再将数据同步到follow（从属）节点 。  
1.创建zoo.cfg配置文件，配置集群ip以及端口、数据存储目录
2.在数据存储目录中创建myid文件，并写入数字标识  
********
######命令
1.启动：zkServer.sh start 状态：zkServer.sh status  
2.客户端连接：zkCli.sh 创建目录并存储数据 create /app 123  ls展示目录 set/app 234 更新数据  get /app获取数据
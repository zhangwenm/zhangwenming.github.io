---
layout: post
title: ForBig
date: 2021-05-10
tags: [work,ForBig]
---

ArrayList与LinkList
----

###### 构成
ArrayList底层数据结构为数组，初始容量为10 ，每次1.5倍扩容
LinkList底层为双向链表
ArraList支持快速随机查找复杂度O（1），而LinkList随即查找O（n）
ArrayList当修改数据时（删除或者增加），前后元素都得移动，复杂度O（n）
LinkList首尾删除插入元素O（1），如果在中间插入或者删除，则需先查找到位置

###### 线程安全
他们都不是线程安全的，可以使用Collections.syncronizedList(list) 来获取线程安全的list，会对list同步枷锁，保证线程安全。读写都枷锁
适合读写均匀的场景
CopyonWriteArrayList都实现了List接口，不同的是opyonWriteArrayList父类为object，内部持有一个ReeenTrantLock，在对数组
进行修改的时候先获取锁，然后释放锁。同时用volatile修饰数组，保证内存可见性。为了保证内存可见性，添加元素时都会复制一个新数组
，进行修改操作后赋值给旧数组。只有写的时候才会加锁。适合读多写少

###### 线程安全concureentmodification异常 并发修改
当以i写对象不允许并发修改，而又检测到并发修改时抛出此异常
当使用iterater遍历集合并使用集合的remove方法删除元素时会报异常，因为该remove方法会对modcount+1而iterater自己的expectcount并不会加1.当下次循环时检测到
modcount和expectmodcount不相等时抛出异常。使用iterrate遍历，并使用iterater的remove则正常删除。集合的remove方法执行时会将剩余的元素左移。
一些集合的iterater实现中如果提供了这种并发修改检测，则称为fial-fast iterater
ArrayList和hashmap都是此种iterater实现







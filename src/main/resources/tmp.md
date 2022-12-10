mysql
sql执行过程
索引：B+树
最左前缀匹配原则、回表、索引下推、覆盖索引、索引失效的情况
事务
事务的四个特性A 原子性 C一致性 I隔离性 D持久性
事务的隔离级别 读未提交 锁 读已提交 可重复度 锁 table readview 串行化
table 参数 roll_ptr trx_id row_id delete_bit
readview trx_ids low_limt_id up_limit_id creator_trx_id
undo log
日志
redo log:innodb特有,记录修改内容，循环写，空间有限；主从复制、数据恢复
bin log：物理日志，sql语句；崩溃恢复	
undo log
脏读、幻读、不可重复读
不可重复读，读同一条记录两次的结果不一致
一个事务查询两次得到数据的数量不一致
锁
行锁
表锁
引擎
innodb 支持事务，支持行锁、表锁，支持外键，记录最大自增主键在redolog里，支持数据崩溃恢复
myisam 不支持事务，只支持表锁，不支持外键，记录最大自增主键在表数据里，读取速度快

java
hashmap底层原理
数组+(链表/红黑树)
扩容->扩容为原来的一倍
链表最大长度大于8转换为红黑树
concurrenthashmap底层原理
cas+分段锁
java内存模型
堆   存对象实例
栈  
方法区 已被虚拟机加载的类信息、常量、静态变量 
程序计数器
常量池
垃圾清理方式
标记清理
标记整理
复制算法
分代收集
类加载过程
加载 类的全路径名获取class文件的二进制流读取到内存当中，作为类的入口
验证 文件格式验证、字节码验证、符号引用验证
准备 静态变量分配空间并初始化
解析 符号引用转为直接引用
判断对象存活的方式
引用计数法 循环引用
可达性算法
垃圾收集器
serial
serial old
parallel  scanvenge
paralle old
parnew 
CMS
G1
ZGC

内存分配方式
指针碰撞
空闲列表
对象访问方式
直接指针
句柄访问
AQS
state 重复次数
head队列头结点
tail队列尾结点
acquire 加锁（公平和非公平方式）失败放入等待队列，中断
tryacquire尝试加锁
锁
为什么有synchronized关键字还会有锁
synchronized不能自动释放锁，遇到死循环，其他线程会一直等待

1.7和1.8区别
类加载器
SPI机制
对象访问方式

spring
bean的生命周期
beanfatory和factorybean的区别
依赖注入的三种方式
bean的作用域
spring事务管理
动态代理

redis
快的原因
基本数据类型
底层数据结构
构建分布式锁
哨兵模式
主从模式
数据一致性

网络
三次握手四次挥手
tcp和udp的区别
网络模型







扫描class生成beandefinition
beandefinition根据class使用反射构造对象并进行依赖注入
如果需要调用对象根据生成对象构造代理对象
调用aware通知回调接口
执行初始化方法

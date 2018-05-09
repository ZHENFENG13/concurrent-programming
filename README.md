# 《实战java高并发程序设计》源码整理


## 相关文章

[《实战java高并发程序设计》源码整理及读书笔记](http://www.cnblogs.com/han-1034683568/p/6918160.html)

## 书籍封面

![书籍封面](https://images2018.cnblogs.com/blog/859549/201805/859549-20180509110826184-1374482137.png)

## 目录

第1章　走入并行世界<br>
1.1　何去何从的并行计算<br>
1.1.1　忘掉那该死的并行<br>
1.1.2　可怕的现实：摩尔定律的失效<br>
1.1.3　柳暗花明：不断地前进<br>
1.1.4　光明或是黑暗<br>
1.2　你必须知道的几个概念<br>
1.2.1　同步（Synchronous）和异步（Asynchronous）<br>
1.2.2　并发（Concurrency）和并行（Parallelism）<br>
1.2.3　临界区<br>
1.2.4　阻塞（Blocking）和非阻塞（Non-Blocking）<br>
1.2.5　死锁（Deadlock）、饥饿（Starvation）和活锁（Livelock）<br>
1.3　并发级别<br>
1.3.1　阻塞（Blocking）<br>
1.3.2　无饥饿（Starvation-Free）<br>
1.3.3　无障碍（Obstruction-Free）<br>
1.3.4　无锁（Lock-Free）<br>
1.3.5　无等待（Wait-Free）<br>
1.4　有关并行的两个重要定律<br>
1.4.1　Amdahl定律<br>
1.4.2　Gustafson定律<br>
1.4.3　Amdahl定律和Gustafson定律是否相互矛盾<br>
1.5　回到Java：JMM<br>
1.5.1　原子性（Atomicity）<br>
1.5.2　可见性（Visibility）<br>
1.5.3　有序性（Ordering）<br>
1.5.4　哪些指令不能重排：Happen-Before规则<br>
1.6　参考文献


第2章　Java并行程序基础<br>
2.1　有关线程你必须知道的事<br>
2.2　初始线程：线程的基本操作<br>
2.2.1　新建线程<br>
2.2.2　终止线程<br>
2.2.3　线程中断<br>
2.2.4　等待（wait）和通知（notify）<br>
2.2.5　挂起（suspend）和继续执行（resume）线程<br>
2.2.6　等待线程结束（join）和谦让（yield）<br>
2.3　volatile与Java内存模型（JMM）<br>
2.4　分门别类的管理：线程组<br>
2.5　驻守后台：守护线程（Daemon）<br>
2.6　先干重要的事：线程优先级<br>
2.7　线程安全的概念与synchronized<br>
2.8　程序中的幽灵：隐蔽的错误<br>
2.8.1　无提示的错误案例<br>
2.8.2　并发下的ArrayList<br>
2.8.3　并发下诡异的HashMap<br>
2.8.4　初学者常见问题：错误的加锁<br>
2.9　参考文献


第3章　JDK并发包<br>
3.1　多线程的团队协作：同步控制<br>
3.1.1　synchronized的功能扩展：重入锁<br>
3.1.2　重入锁的好搭档：Condition条件<br>
3.1.3　允许多个线程同时访问：信号量（Semaphore）<br>
3.1.4　ReadWriteLock读写锁<br>
3.1.5　倒计时器：CountDownLatch<br>
3.1.6　循环栅栏：CyclicBarrier<br>
3.1.7　线程阻塞工具类：LockSupport<br>
3.2　线程复用：线程池<br>
3.2.1　什么是线程池<br>
3.2.2　不要重复发明轮子：JDK对线程池的支持<br>
3.2.3　刨根究底：核心线程池的内部实现<br>
3.2.4　超负载了怎么办：拒绝策略<br>
3.2.5　自定义线程创建：ThreadFactory<br>
3.2.6　我的应用我做主：扩展线程池<br>
3.2.7　合理的选择：优化线程池线程数量<br>
3.2.8　堆栈去哪里了：在线程池中寻找堆栈<br>
3.2.9　分而治之：Fork/Join框架<br>
3.3　不要重复发明轮子：JDK的并发容器<br>
3.3.1　超好用的工具类：并发集合简介<br>
3.3.2　线程安全的HashMap<br>
3.3.3　有关List的线程安全<br>
3.3.4　高效读写的队列：深度剖析ConcurrentLinkedQueue<br>
3.3.5　高效读取：不变模式下的CopyOnWriteArrayList<br>
3.3.6　数据共享通道：BlockingQueue<br>
3.3.7　随机数据结构：跳表（SkipList）<br>
3.4　参考资料


第4章　锁的优化及注意事项<br>
4.1　有助于提高"锁"性能的几点建议<br>
4.1.1　减小锁持有时间<br>
4.1.2　减小锁粒度<br>
4.1.3　读写分离锁来替换独占锁<br>
4.1.4　锁分离<br>
4.1.5　锁粗化<br>
4.2　Java虚拟机对锁优化所做的努力<br>
4.2.1　锁偏向<br>
4.2.2　轻量级锁<br>
4.2.3　自旋锁<br>
4.2.4　锁消除<br>
4.3　人手一支笔：ThreadLocal<br>
4.3.1　ThreadLocal的简单使用<br>
4.3.2　ThreadLocal的实现原理<br>
4.3.3　对性能有何帮助<br>
4.4　无锁<br>
4.4.1　与众不同的并发策略：比较交换（CAS）<br>
4.4.2　无锁的线程安全整数：AtomicInteger<br>
4.4.3　Java中的指针：Unsafe类<br>
4.4.4　无锁的对象引用：AtomicReference<br>
4.4.5　带有时间戳的对象引用：AtomicStampedReference<br>
4.4.6　数组也能无锁：AtomicIntegerArray<br>
4.4.7　让普通变量也享受原子操作：AtomicIntegerFieldUpdater<br>
4.4.8　挑战无锁算法：无锁的Vector实现<br>
4.4.9　让线程之间互相帮助：细看SynchronousQueue的实现<br>
4.5　有关死锁的问题<br>
4.6　参考文献


第5章　并行模式与算法<br>
5.1　探讨单例模式<br>
5.2　不变模式<br>
5.3　生产者-消费者模式<br>
5.4　高性能的生产者-消费者：无锁的实现<br>
5.4.1　无锁的缓存框架：Disruptor<br>
5.4.2　用Disruptor实现生产者-消费者案例<br>
5.4.3　提高消费者的响应时间：选择合适的策略<br>
5.4.4　CPU<br>Cache的优化：解决伪共享问题<br>
5.5　Future模式<br>
5.5.1　Future模式的主要角色<br>
5.5.2　Future模式的简单实现<br>
5.5.3　JDK中的Future模式<br>
5.6　并行流水线<br>
5.7　并行搜索<br>
5.8　并行排序<br>
5.8.1　分离数据相关性：奇偶交换排序<br>
5.8.2　改进的插入排序：希尔排序<br>
5.9　并行算法：矩阵乘法<br>
5.10　准备好了再通知我：网络NIO<br>
5.10.1　基于Socket的服务端的多线程模式<br>
5.10.2　使用NIO进行网络编程<br>
5.10.3　使用NIO来实现客户端<br>
5.11　读完了再通知我：AIO<br>
5.11.1　AIO<br>EchoServer的实现<br>
5.11.2　AIO<br>Echo客户端实现<br>
5.12　参考文献


第6章　Java<br>8与并发<br>
6.1　Java<br>8的函数式编程简介<br>
6.1.1　函数作为一等公民<br>
6.1.2　无副作用<br>
6.1.3　申明式的（Declarative）<br>
6.1.4　不变的对象<br>
6.1.5　易于并行<br>
6.1.6　更少的代码<br>
6.2　函数式编程基础<br>
6.2.1　FunctionalInterface注释<br>
6.2.2　接口默认方法<br>
6.2.3　lambda表达式<br>
6.2.4　方法引用<br>
6.3　一步一步走入函数式编程<br>
6.4　并行流与并行排序<br>
6.4.1　使用并行流过滤数据<br>
6.4.2　从集合得到并行流<br>
6.4.3　并行排序<br>
6.5　增强的Future：CompletableFuture<br>
6.5.1　完成了就通知我<br>
6.5.2　异步执行任务<br>
6.5.3　流式调用<br>
6.5.4　CompletableFuture中的异常处理<br>
6.5.5　组合多个CompletableFuture<br>
6.6　读写锁的改进：StampedLock<br>
6.6.1　StampedLock使用示例<br>
6.6.2　StampedLock的小陷阱<br>
6.6.3　有关StampedLock的实现思想<br>
6.7　原子类的增强<br>
6.7.1　更快的原子类：LongAdder<br>
6.7.2　LongAdder的功能增强版：LongAccumulator<br>
6.8　参考文献


第7章　使用Akka构建高并发程序<br>
7.1　新并发模型：Actor<br>
7.2　Akka之Hello<br>World<br>
7.3　有关消息投递的一些说明<br>
7.4　Actor的生命周期<br>
7.5　监督策略<br>
7.6　选择Actor<br>
7.7　消息收件箱（Inbox）<br>
7.8　消息路由<br>
7.9　Actor的内置状态转换<br>
7.10　询问模式：Actor中的Future<br>
7.11　多个Actor同时修改数据：Agent<br>
7.12　像数据库一样操作内存数据：软件事务内存<br>
……

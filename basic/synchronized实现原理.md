# synchronized的解密

## synchronized的三种用法
    第一种：synchronized修饰代码块，锁住的是Object
```java
synchronized(Object){
        // 代码块
        }
```
    第二种：synchronized修饰方法，锁住的是调用method的实例
```java
public synchronized void method(){
        // 代码块
        }
```
    第三种：synchronized修饰静态方法，锁住的是调用method的对象
```java
public static synchronized void method(){
        // 代码块
        }
```
        参考 synchronizedDemo.SynchronizedDemo代码
## synchronized底层原理

### synchronized是如何工作的？

synchronized的锁资源是对象，JVM中将线程和对象的关系维护在对象头中。
<img src="/img/JVM中对象布局.png"/>

    Mark Word:存储自身的运行时数据，例如HashCode、GC年龄、锁相关信息
    Klass Point:类型指针指向它的类元数据的指针,JVM通过Klass Point来判断对象是哪个类的实例

### synchronized锁升级过程

<div align="center"><img src="https://github.com/deepermake/basic/blob/master/basic/img/synchronized%E9%94%81%E5%8D%87%E7%BA%A7%E8%BF%87%E7%A8%8B.png"></div>

#### 偏向锁
    偏向锁在JDK1.6中引进，顾名思义是偏向某一个线程的锁，HotSpot作者发现，在大多数情况下，锁不仅不存在多线程竞争，而且总是由同一个线程多次获得，为了降低这种场景下的获取锁的代价，引进了偏向锁。
##### 偏向锁是如何工作的？

#### 轻量级锁

#### 重量级锁

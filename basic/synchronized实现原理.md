# synchronized解密

## 1、synchronized的三种用法
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
## 2、synchronized底层原理

synchronized的锁资源是对象，JVM中将线程和对象的关系维护在对象头中。
<img src="E:\Self\basic\basic\img\JVM中对象布局.png"/>

    Mark Word:存储自身的运行时数据，例如HashCode、GC年龄、锁相关信息
    Klass Point:类型指针指向它的类元数据的指针,JVM通过Klass Point来判断对象是哪个类的实例

### 2.1、synchronized锁升级过程

<div align="center"><img src="https://github.com/deepermake/basic/blob/master/basic/img/synchronized%E9%94%81%E5%8D%87%E7%BA%A7%E8%BF%87%E7%A8%8B.png"></div>

#### 2.1.1、偏向锁
    偏向锁在JDK1.6中引进，顾名思义是偏向某一个线程的锁，HotSpot作者发现，在大多数情况下，锁不仅不存在多线程竞争，而且总是由同一个线程多次获得，为了降低这种场景下的获取锁的代价，引进了偏向锁。
>synchronized从无锁变更为偏向锁时，Mark Word:ThreadID + Epoch + 101，ThreadID指向偏向线程ID,Epoch表示偏向撤销次数，默认40次以上，超过撤销次数，说明不在适合偏向锁，这时不管线程是否竞争都会升级轻量级锁。
##### 偏向锁是工作原理

##### 被抛弃的偏向锁 
>JDK15开始，将偏向锁标注为废弃状态 http://openjdk.java.net/jeps/374

1. 在多线程环境下锁撤销成本昂贵，并没有提高应用程序的性能。
2. 引入了复杂的代码，侵扰了HotSpot组件并且加剧了了解的难度。

#### 2.1.2、轻量级锁

#### 2.1.3、重量级锁

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

在这之前我们了解一个叫monitor的对象
```java
ObjectMonitor() {
    _header       = NULL;
    _count        = 0;
    _waiters      = 0,
    _recursions   = 0;     // 线程重入次数
    _object       = NULL;  // 存储Monitor对象
    _owner        = NULL;  // 持有当前线程的owner
    _WaitSet      = NULL;  // wait状态的线程列表
    _WaitSetLock  = 0 ;
    _Responsible  = NULL ;
    _succ         = NULL ;
    _cxq          = NULL ;  // 单向列表
    FreeNext      = NULL ;
    _EntryList    = NULL ;  // 等待获取锁的线程列表
    _SpinFreq     = 0 ;
    _SpinClock    = 0 ;
    OwnerIsThread = 0 ;
    _previous_owner_tid = 0;
  }
```
>通过<br>
>javac SynchronizedTest.java<br>
>javap -p -v -c SynchronizedTest.class

```text
Classfile SynchronizedTest.class
......

{
  public static final java.lang.String str;
    descriptor: Ljava/lang/String;
    flags: ACC_PUBLIC, ACC_STATIC, ACC_FINAL
    ConstantValue: String hello

  public com.synchronizedDemo.SynchronizedTest();
   .....

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=3, locals=3, args_size=1
         0: ldc           #3                  // String hello
         2: dup
         3: astore_1
         4: monitorenter
         5: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
         8: ldc           #3                  // String hello
        10: iconst_0
        11: anewarray     #5                  // class java/lang/Object
        14: invokevirtual #6                  // Method java/io/PrintStream.printf:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
        17: pop
        18: aload_1
        19: monitorexit
        20: goto          28
       ......
}
       ......
```
>synchronized经过反编译可以看出，执行同步块前后有monitorenter、monitorexit两个指令，
+ 执行monitorenter指令时，首先会尝试获取对象的锁，实质是争夺monitor对象的所有权
+ 如果当前对象没有锁或者线程已经拥有该锁，就会将锁的计数器的值+1
+ 执行monitorexit指令时，会将锁的计数次数减一，如果计数次数减到0，就会释放锁
+ 如果获取对象锁失败，就会将该线程加入等待列表，直到等待的锁对象被释放

### 2.1、synchronized锁升级过程

<div align="center"><img src="https://github.com/deepermake/basic/blob/master/basic/img/synchronized%E9%94%81%E5%8D%87%E7%BA%A7%E8%BF%87%E7%A8%8B.png"></div>

#### 2.1.1、偏向锁
    偏向锁在JDK1.6中引进，顾名思义是偏向某一个线程的锁，HotSpot作者发现，在大多数情况下，锁不仅不存在多线程竞争，而且总是由同一个线程多次获得，为了降低这种场景下的获取锁的代价，引进了偏向锁。
>synchronized从无锁变更为偏向锁时，Mark Word:ThreadID + Epoch + 101，ThreadID指向偏向线程ID,Epoch表示偏向撤销次数，默认40次以上，超过撤销次数，说明不在适合偏向锁，这时不管线程是否竞争都会升级轻量级锁。
##### 偏向锁的工作原理

##### 偏向锁的撤销
    偏向锁不存在释放锁的概念，偏向锁的撤销发生在发生锁竞争升级为轻量级锁的过程中


##### 被抛弃的偏向锁 
>JDK15开始，将偏向锁标注为废弃状态 http://openjdk.java.net/jeps/374
偏向锁被废弃，总而言之有两个原因：
1. 在多线程环境下锁撤销成本昂贵，并没有提高应用程序的性能。
2. 引入了复杂的代码，侵扰了HotSpot组件并且加剧了了解的难度。

#### 2.1.2、轻量级锁

#### 2.1.3、重量级锁

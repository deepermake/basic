### synchronized的三种用法

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

### synchronized是如何工作的？它锁的是什么？
synchronized锁的是对象，那么在单/多程环境,线程和对象的关联关系是如何维护的？这就要扯到一个叫<mark>对象头</mark>的东西
<img src="/img/JVM中对象布局.png"/>

    Mark Word:存储自身的运行时数据，例如HashCode、GC年龄、锁相关信息
    Klass Point:类型指针指向它的类元数据的指针





### synchronized锁升级过程
<div align="center"><img src="https://github.com/deepermake/basic/blob/master/basic/img/synchronized%E9%94%81%E5%8D%87%E7%BA%A7%E8%BF%87%E7%A8%8B.png"></div>

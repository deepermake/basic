## MYSQL关于行记录的二三事

> compact行格式
> 数据页
> 16KB
> 行溢出
> 变长字段
> 逆序存放

一条记录在mysql中长什么样，包含了什么样的内容。
### 一条记录包含的内容
![P-10259032-10239559.jpg](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/e9d32ad9d507426182ced3bf6d95a21c~tplv-k3u1fbpfcp-watermark.image?)

* 变长字段长度列表：MySQL支持可变长度的数据类型，如VARCHAR，TEXT，BLOB，变长字段长度列表主要用来记录这些可变字段的实际长度，16进制且以逆序存储在列表中
NULL值列表，二进制存储，1代表列字段值为NULL，0-代表列字段值非NULL，默认位1字节，但默认空列个数超过8个时，会自动递增为2字节。
额外信息
* row_id：隐式id，如果没有建表主键且没有唯一索引时，会默认生成一个row_id，默认为6byte
* trx_id：事务id，6byte
* roll_pointer：回滚指针，指向记录的上一个版本，7byte
> trx_id和roll_pointer是innodb 实现MVCC（多版本控制）的关键

为什么变长字段长度列表和NULL值列表需要逆序存储？


# DFS （ 深度优先搜索 ）

## 一条路走到黑，退回来再试下一条。

### 一、DFS回溯的核心问题

DFS通过路径记录和状态回溯解决“记住上一个岔路”的问题。当遇到死胡同时，算法会沿着记录的路径原路返回，知道找到最近未探索完的岔路口，继续尝试其他分支。

### 二、实现方式

#### 1. 显式栈（ 手动维护路径 ）

通过数据结构栈（ stack ） 保存当前路径。每次访问新节点时将其压入栈，遇到死胡同则弹出栈顶元素，回到上一个节点继续探索其他分支。

    stack = [(起点坐标)]
    visited = set()  # 记录已访问节点
    while stack:
        current = stack.pop()
        if current是终点: 返回路径
        for 每个相邻节点 in current的邻接节点:
            if 节点未访问且可通行:
                stack.append(节点)
                visited.add(节点)

#### 2. 递归 （ 隐式系统调用栈 ）

利用函数调用栈自动保存路径。递归进入一个节点相当于压栈，函数返回 （ 递归终止 ） 相当于弹栈回溯。

    void dfs(int step) {
        if (到达终点) return;  // 终止条件
        for (每个可能的岔路方向) {
            if (该方向未被访问) {
                标记为已访问;
                dfs(step + 1);  // 递归进入下一层
                取消标记;        // 回溯到上一层
            }
        }
    }

### 三、 关键实现细节

#### 1、 状态标记与恢复

* 访问过的节点需要标记 （ 如visited数组 ） ，避免重复访问。
* 回溯时需要撤销标记 （ 如迷宫问题中 “ 拆墙 ” ） ，否则后续路线可能被错误阻塞

# BFS （ 广度优先搜索 ）

> 一群人排着队，一层一层扫雷式探索。

## 一、核心原理

### 1.逐层扫描机制

BFS从起点出发，先访问所有直接相邻的节点（第一层），再依次访问这些相邻节点的相邻节点（第二层），依次类推。这种特征保证了首次到达目标节点的路径一定是最短路径（在无权图中）

### 2.队列数据结构

使用先进先出（FIFO）的队列保存待访问节点，确保按层级顺序处理：

+ 初始：将起点加入队列
+ 迭代：取出队首节点 -> 处理其未被访问的邻居 -> 将邻居加入队列尾部

### 3.状态标记

通过visited数组记录已访问节点，避免重复处理和死循环

## 二、执行步骤

### 1.初始化

+ 创建队列和visited标记数组
+ 将起点标记为已访问并入队

### 2.循环处理队列

    # 这个过程如同 “ 消防员逐层扑灭火焰 ”，先处理离火源最近的着火点
    while 队列不空:
        当前节点 = 队列.pop()
        if 当前节点是目标: 返回路径
        for 邻居节点 in 当前节点的所有邻居:
            if 邻居未被访问且可通行:
                标记为已访问
                加入队列

# 解题技巧

有多少条路，走多少条路。
# :rocket: EASY FOOD :rocket:

当前分支： master

> 使用 cuba platform 框架完成
> cuba 是什么？https://www.cnblogs.com/cubacn/p/cubaplatform1.html

英文官网：https://www.cuba-platform.com/
中文官网：https://www.cuba-platform.cn/

# 项目需求

-   实体有：用户类，店铺类，菜品类，订单类。其中用户，店铺，菜品是主数据，订单是事务数据。
-   每个用户每天只能定一次餐，定一次餐只能选择一个店铺，但是可以选择多道菜品。
-   普通用户角色可以有权限看所有的店铺，所有的菜品，但是看不见其他用户以及其他用户的订单。
-   店铺管理员角色可以有权限读写自己的店铺和自己店铺的菜品和订单，但是不能读写其他店铺的主数据。

## 快速开始

### 环境搭建

需要`java`环境

### 开发

使用 CUBA Studio 2019.1 开发

Studio 使用说明：
英文：https://doc.cuba-platform.com/studio/
中文：https://doc.cuba-platform.cn/studio-chs/

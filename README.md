## 任务分工（暂定）

* 框架搭建、登录和注册功能和相关 GUI 界面
* 选课功能和相关 GUI 界面
* 管理功能和相关 GUI 界面
* CLI 程序

## 项目构成

- `CliApplication`: 命令行启动类
- `UniversityApplication`: 图形化启动类

- `entity`: 持久化对象

- `mapper`: 映射层，接口类型，用于与数据库交互，在`resources/mapper`下创建同名 xml 文件写 SQL 语句
- `serivce`:服务层，处理实体类之间的逻辑关系
- `controller`:控制层，处理具体业务的逻辑
- `view`: 视图层，与`resources/static/fxml`下的文件对应，一个文件表示一个窗口

## 前置工作

* 安装 MySQL 数据库并启动服务，然后在`rescources/application`中填自己的账号密码，可以使用 SQLyog 管理数据库

  ```sql
  -- 执行sql脚本前执行以下语句
  create database university_application;
  use university_application;
  ```

* 使用 IDEA 作为开发工具

 ## 代码提交步骤

1. Fork 全部分支

2. Clone 个人 Fork 仓库`develop`分支到本地

3. 然后执行

   `git remote add upstream https://github.com/UTS-SSTC/FSD_University_Application_Group08.git`

   绑定一个别名叫做 upstream 的仓库，也就是我们的主仓库；

   每次修改代码前执行一次

   `git pull upstream develop`

   保持自己仓库跟总仓库一致，如有冲突请自行解决冲突

4. 修改代码后提交至 Fork 仓库的`develop`分支，提交信息参考`gitmoji`格式：https://github.com/carloscuesta/gitmoji

5. 到 GitHub 上的个人 Fork 仓库里，对主仓库`develop`分支提交 PR 等待 Review

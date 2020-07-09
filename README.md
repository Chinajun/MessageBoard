# MessageBoard-留言板项目总结（课程设计）
#### 技术栈
- jsp+servlet+tomcat+mysql
#### 项目介绍
- 留言板界面
    - 未登录状态，只能查看，无法新增留言
    [留言板（未登录状态）](web/img/msg.png)
    - 登陆状态，显示“欢迎+已登录用户名”，可以新增留言
    [留言板（登录状态）](web/img/loginMsg.png)
- 登陆界面
输入用户名和密码登录，用户名或密码错误导致登陆失败会有提示信息
[登陆界面](web/img/login.png)
- 注册界面
填写全部个人信息注册，若没有全部填写则注册失败会有提示信息，注册成功后，提示注册成功信息并在五秒钟后跳转登陆界面
[注册界面](web/img/register.png)
[注册成功跳转界面](web/img/registerSuccess.png)
- 新增留言界面
    - 未登录状态：登录提示
    [未登录状态](web/img/addMsg.png)
    - 登录状态：新增留言,若标题或内容未填写则新增失败。新增成功后跳转留言板界面
    [登录状态](web/img/loginAddMsg.png)
#### 表结构
- message(存储留言)

| 字段 | 类型 | 备注 |
| ---- | ---- | ---- |
| id   | bigint| 自增|
| username|vachar|  |
|title|vachar|       |
|content|vachar|     |
|create_time|timestamp|默认当前留言时间|

- user(存储用户)

| 字段 | 类型 | 备注 |
| ---- | ---- | ---- |
| id   | bigint| 自增 |
|username|vachar|     |
|password|vachar|     |
|real_name|vachar|    |
|phone|vachar |       |





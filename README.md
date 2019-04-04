# 易家校
## 由于本人在团队中担任前端方面的工作，故本项目介绍侧重点为前端
<br><br>
## 登录角色
### 本项目分为两个登录方向，一个为教师，另一个为家长，预设的登录账号密码教师为“2001001  654321”，家长为“1001001  123456”。本项目介绍主要围绕家长端
<br><br>
## 登录界面
![image](https://github.com/xianfengtuandui/Home-school/blob/master/images/登录界面.JPG)
### 登录界面分为两个登录方向，通过一个<code>radio-group</code>包裹起来
<br><br>
## 家长端主界面
![image](https://github.com/xianfengtuandui/Home-school/blob/master/images/家长主界面.PNG)  
### 主界面上方为一个轮播图，中间主体部分为3个功能，底部则是一个底部导航栏，可以在“主界面”和“我的”界面之间跳转
## 主界面wxml代码
![image](https://github.com/xianfengtuandui/Home-school/blob/master/images/parentmain.wxml.PNG)  
<br><br>
## 家长端我的界面
![image](https://github.com/xianfengtuandui/Home-school/blob/master/images/家长我的界面.PNG)
### “我的”界面中，由头像名称，跟主体的信息还有个退出登录的按钮组成，用户可以点击退出登录来退出当前账号，但页面中的主体信息均为假数据（后期完善）
<br><br>
## 查看作业界面
![image](https://github.com/xianfengtuandui/Home-school/blob/master/images/查看作业界面.PNG)
### 该界面没什么好讲的，简单的template引入的应用，点击相应的作业可进入查看作业详情（详情页面较简陋不作展示-  -。）
<br><br>
## 查看通知界面
![image](https://github.com/xianfengtuandui/Home-school/blob/master/images/查询通知界面.PNG)
## 查看通知界面wxml代码
![image](https://github.com/xianfengtuandui/Home-school/blob/master/images/p-messagelist.PNG)
### 同上，简单的template模板的应用，详情页面也是同样简陋（不作展示）
<br><br>
## 查看私信界面
![image](https://github.com/xianfengtuandui/Home-school/blob/master/images/查看私信界面.PNG)
### 该界面的制作时间在项目的后期，由于本项目是边学小程序边做项目的，所以在后期制作出来的页面算是质量高点
## 查看私信界面wxml代码
![image](https://github.com/xianfengtuandui/Home-school/blob/master/images/p-notifications.wxml.PNG)
## 查看私信界面中的template模板代码
![image](https://github.com/xianfengtuandui/Home-school/blob/master/images/p-notifications-template.PNG)
### 在该项目中，应用得最多的当属template模板的使用，模板使用十分方便，但项目前期由于模板文件位置的乱摆放，导致项目完成后，模板文件未能统一在一个文件夹中（最好是统一在一个template模板文件夹中，会使项目显得较为简洁）
<br><br>
## 发送私信界面
![image](https://github.com/xianfengtuandui/Home-school/blob/master/images/发送私信界面.PNG) 
### 私信的发送，是通过查看私信中“点击发送私信”的大按钮跳转进来的，该界面中，最难实现的当属小程序中下拉列表的实现
![image](https://github.com/xianfengtuandui/Home-school/blob/master/images/发送私信界面下拉列表实现效果.PNG) 
### 项目初期，只是实现了下拉列表，但在后期测试中发现，真机预览时点击下拉列表没有反应，后边经过查找问题，才得知为<code>z-index</code>比重的问题
## 下拉列表相关实现代码
### wxml文件
![image](https://github.com/xianfengtuandui/Home-school/blob/master/images/收件人下拉列表实现.PNG) 
### json文件
![image](https://github.com/xianfengtuandui/Home-school/blob/master/images/收件人下拉列表实现2.PNG) 
### 最终的实现效果为，点击下拉菜单，会相应的改变文本域中的内容（更改为“不可编辑”），此时只有选中完收件人，才可继续操作。但是，在实际的测试中，发现如果先写文本域的信息，再返回头去选择下拉菜单，会导致文本域中的内容丢失（后期完善）
<br><br>
## 项目总结：易家校这个项目，制作时间虽然不算长，但是我从这个项目中却学习到了很多，比如说小程序中数据绑定的使用，<code>wx:if</code>结合数据绑定控制显隐的应用...最最重要的，是坚定了我前端学习的决心！希望在仅剩的大学生活中，我能够学习好前端的知识，将来毕业能找到一份前端方向令我称心如意的工作！

